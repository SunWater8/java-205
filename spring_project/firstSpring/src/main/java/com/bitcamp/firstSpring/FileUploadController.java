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
	private FileUploadService uploadService;
	//순서3.
	final String UPLOAD_URI = "/uploadfile";
	
	//순서1
	@RequestMapping("/upload/uploadForm")
	public String getUploadForm() {
		return "upload/uploadForm"; 
	}
	//순서2.업로드한 파일 처리하는 메소드
	@RequestMapping(value="upload/upload1")//uploadForm.jsp에서 form 의 action을 upload1로 정했기 때문에 이와 일치시켜야한다.
	public String upload1( // uploadForm.jsp에서 작성한 form의 형식을 매개변수로 받기
			@RequestParam("sno") String sno, 
			@RequestParam("sname")String sname, 
			@RequestParam("report")MultipartFile report,
			Model model,
			
			//절대경로를 얻기 위해  필요
			HttpServletRequest  request
			) throws IllegalStateException, IOException {
		
		//확인하기 위해 콘솔에 출력해보기
		System.out.println("학번 : " + sno);
		System.out.println("이름 : " + sname);
		System.out.println("파일 : " + report.getOriginalFilename());
		
		//modle에 입력받은 데이터 넣기
		model.addAttribute("sno", sno);
		model.addAttribute("sname", sname);
		model.addAttribute("reportfile", report.getOriginalFilename());
		
		saveFile(request, report);
		
		uploadService.fileUpload();
		return "upload/upload";
	}
	//순서5.
	@RequestMapping(value="upload/upload2")
	public String upload2(
			//개별적으로 첨부된 파일을 다 받아서 처리하기
			MultipartHttpServletRequest request,
			Model model
			
			) throws IllegalStateException, IOException {
		
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		MultipartFile report = request.getFile("report"); //여러개의 파일을 받을 수 있는 메소드:getFile

		System.out.println("2. 학번 : " + sno);
		System.out.println("2. 이름 : " + sname);
		System.out.println("2. 파일 : " + report.getOriginalFilename());
		
		model.addAttribute("sno", sno);
		model.addAttribute("sname", sname);
		model.addAttribute("reportfile", report.getOriginalFilename());
		
		saveFile(request, report);
		
		return "upload/upload";
	}
	//순서6. 
	@RequestMapping(value="upload/upload3")
	public String upload3(
			Report report, //Report 타입을 매개변수로 받기
			Model model,
			HttpServletRequest request
			) throws IllegalStateException, IOException {
		System.out.println("3. 학번 : " + report.getSno());
		System.out.println("3. 이름 : " + report.getSname());
		System.out.println("3. 파일 : " + report.getReport().getOriginalFilename());
		
		model.addAttribute("sno",  report.getSno());
		model.addAttribute("sname", report.getSname());
		model.addAttribute("reportfile", report.getReport().getOriginalFilename());
		
		saveFile(request, report.getReport());
		return "upload/upload";
	}
	//순서4
	// 사용자 업로드한 파일을 저장하는 메소드
	private void saveFile(HttpServletRequest request,  MultipartFile file) throws IllegalStateException, IOException {
		//새로운 파일 만들기
		//저장경로 만들기 ( 시스템 경로)
		String saveDir = request.getSession().getServletContext().getRealPath(UPLOAD_URI);
		//  경로 : .metadata>.plugins>org.eclipse.wst.server.core>tmp0>wtpwebapps>First_Web>upload*/
		//새롭게 저장하려고 하는 파일을 만들기
		File newFile= new File(saveDir, file.getOriginalFilename());
		
		//파일 저장하기
		//report에 있는 메소드를 가지고 파일을 저장
		file.transferTo(newFile);
	}
}
