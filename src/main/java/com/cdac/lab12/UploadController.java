package com.cdac.lab12;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping(value = "/upload-image", method = RequestMethod.POST)
	String uploadImage(@RequestParam("username") String userName, @RequestParam("image") MultipartFile file, Model m){
		File filePath = new File("/Users/abhisheksharma/Desktop/CDAC",file.getOriginalFilename());
		try {
			file.transferTo(filePath);
			m.addAttribute("filename", file.getOriginalFilename());
			m.addAttribute("username", userName);
			return "lab12-home";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "lab12-error";
	}
}
