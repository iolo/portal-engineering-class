package kr.ac.jejuuniv.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping
public class fileUploadController{

	@RequestMapping("/fileupload")
	public void aaaa(){
	}
	
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public void fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		byte[] byteFile = file.getBytes();
		String name = file.getOriginalFilename();
		
		String path = "/Users/HSY/Documents/workspace-sts-2.9.0.RELEASE/workspace/PortalService/twitter/src/main/webapp/resources" + "/img/";
		System.out.println(path);
		
		File dirPaht = new File(path);
		if(!dirPaht.exists()){
			dirPaht.mkdir();
		}
		
		File uploadedFile = new File(path + name);
		FileOutputStream fos;
		fos = new FileOutputStream(uploadedFile);
		fos.write(byteFile);
		fos.close();
		
	}
}
