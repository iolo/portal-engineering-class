package kr.ac.jejunu;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.UserInfo;
import kr.ac.jejunu.repositry.CommentService;
import kr.ac.jejunu.repositry.SqlMapper;

import org.mockito.internal.configuration.ClassPathLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class GusetUseViewsController {
	@Autowired
	private CommentService service;

	@RequestMapping("/list")
	public String requestList(HttpServletRequest request,
			HttpServletResponse response) {
		// get parameter 확인
		String pageParameter = request.getParameter("page");
		Cookie[] cookies = request.getCookies();
		String user = "";
		try {
			for (int check = 0; check < cookies.length; check++) {
				if (cookies[check].getName() == "user") {
					user = cookies[check].getValue();
					break;
				}
				user = null;
			}
		} catch (NullPointerException e) {
			request.setAttribute("user", "guset");
		}

		int nowPage;
		try {
			nowPage = Integer.parseInt(pageParameter);
		} catch (NumberFormatException e) {
			nowPage = 1;
		}
		// 페이지 수 확인
		int pageCount = service.pageCount();

		// 페이지에 따라 코멘트 호출
		List<Comment> list = service.showPageOne(nowPage);
		// 데이터 저장
		Collections.reverse(list);
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageCount);
		// 로그인 구별
		if (user == null || user == "guset") {
			response.addCookie(new Cookie("user", "guset"));
			request.setAttribute("user", "guset");
		} else {
			request.setAttribute("user", user);
		}
		return "list";
	}

	@RequestMapping("/join.write")
	public String requsetJoinFrom() {
		return "join";
	}

	@RequestMapping("/join.save")
	public String requestJoinSave(@RequestParam("file") MultipartFile file,
			@ModelAttribute("joinUserInfo") UserInfo user) {
		Random random = new Random();
		String fileName = String.valueOf(random.nextInt(1000));
		File url = new File("D:/tmpImage/" + fileName + ".jpg");
		try {
			file.transferTo(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		user.setProflie_url("http://localhost:8080/jejunu/image?id=" + fileName);
		service.joinUser(user);
		return "redirect:/list";
	}

	@RequestMapping(value = "/image", produces = {"image/jpeg"})
	public @ResponseBody HttpEntity<byte[]> getImage(HttpServletRequest request,
			HttpServletResponse response) {
		String getImageId = request.getParameter("id");
		String path = "D:/tmpImage/" + getImageId + ".jpg";
		File file = new File(path);
		try {
			BufferedImage image = ImageIO.read(file);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", output);
			output.flush();
			byte[] imagebyte = output.toByteArray();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			headers.setContentLength(imagebyte.length);
			return new HttpEntity<byte[]>(imagebyte, headers);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
