package kr.ac.jejuuniv.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class RepquestMapping {
	@RequestMapping(value="fileupload", method=RequestMethod.POST)
	public ModelAndView fileUpload(String name, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		byte[] byteFile = file.getBytes();
		File uploadedFile = new File(request.getSession().getServletContext().getRealPath("/") + "images/userprofile/" + name);
		FileOutputStream fos;
		fos = new FileOutputStream(uploadedFile);
		fos.write(byteFile);
		fos.close();
		return new ModelAndView("redirect:Individual");
	}
}
