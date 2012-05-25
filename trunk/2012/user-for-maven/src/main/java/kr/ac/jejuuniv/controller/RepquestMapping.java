package kr.ac.jejuuniv.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/requestMapping")
public class RepquestMapping {

	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public void method() {

	}

	@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	public String fileUpload(String name, @RequestParam("file") MultipartFile file) throws IOException {
		byte[] byteFile = file.getBytes();
		File uploadedFile = new File("/daum/temp/" + name);
		FileOutputStream fos;
		fos = new FileOutputStream(uploadedFile);
		fos.write(byteFile);
		fos.close();
		return "redirect:/result.jeju";
	}
}
