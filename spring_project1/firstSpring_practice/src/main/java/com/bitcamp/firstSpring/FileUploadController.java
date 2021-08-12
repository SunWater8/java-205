package com.bitcamp.firstSpring;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitcamp.firstSpring.domain.Report;

@Controller
public class FileUploadController {
	//순서7
	@Autowired
	private FileUpoadService uploadService;
	//순서3.
	final String UPLOAD_URI = "/uploadfile";
	
	//순서1
	@RequestMapping("/upload/uploadForm")
	public String getUploadForm() {
		return "upload/uploadForm"; 
	}
	//순서2.
	@RequestMapping(value="upload/upload1")
	public String upload1(
			@RequestParam("sno") String sno, 
			@RequestParam("sname")String sname, 
			@RequestParam("report")MultipartFile report,
			Model model,
			
			//경로를 위해  필요
			HttpServletRequest  request
			) throws IllegalStateException, IOException {
		System.out.println("학번 : " + sno);
		System.out.println("이름 : " + sname);
		System.out.println("파일 : " + report.getOriginalFilename());
		
		model.addAttribute("sno", sno);
		model.addAttribute("sname", sname);
		model.addAttribute("reportfile", report.getOriginalFilename());
		
		//String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		
		//저장하려고 하는 새로운 파일을 만들기
		//File newFile= new File(saveDir, report.getOriginalFilename());
		
		//report에 있는 메소드를 저장
		//report.transferTo(newFile);
		saveFile(request, report);
		
		uploadService.fileUpload();
		return "upload/upload";
	}
	//순서5.
	@RequestMapping(value="upload/upload2")
	public String upload2(
			MultipartHttpServletRequest request,
			Model model
			
			) throws IllegalStateException, IOException {
		
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		MultipartFile report = request.getFile("report");

		System.out.println("학번 : " + sno);
		System.out.println("이름 : " + sname);
		System.out.println("파일 : " + report.getOriginalFilename());
		
		model.addAttribute("sno", sno);
		model.addAttribute("sname", sname);
		model.addAttribute("reportfile", report.getOriginalFilename());
		
		saveFile(request, report);
		
		return "upload/upload";
	}
	//순서6.
	public String upload3(
			
			Report report,
			Model model,
			HttpServletRequest request
			) {
		System.out.println("3. 학번 : " + report.getSno());
		System.out.println("3. 이름 : " + report.getSname());
		System.out.println("3. 파일 : " + report.getReport().getOriginalFilename());
		
		model.addAttribute("sno",  report.getSno());
		model.addAttribute("sname", report.getSname());
		model.addAttribute("reportfile", report.getReport().getOriginalFilename());
		
		
		return "upload/upload";
	}
	//순서4
	// 사용자 업로드한 파일을 저장하는 메소드
	private void saveFile(HttpServletRequest request, MultipartFile file) throws IllegalStateException, IOException {
		//저장 경로: 시스템 경로
		String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		
		File newFile= new File(saveDir, file.getOriginalFilename());
		file.transferTo(newFile);
	}
}
