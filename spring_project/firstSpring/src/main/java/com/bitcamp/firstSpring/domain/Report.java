package com.bitcamp.firstSpring.domain;

import org.springframework.web.multipart.MultipartFile;

public class Report {

	private String sno;
	private String sname;
	private MultipartFile report;
	
	public Report(String sno, String sname, MultipartFile report) {
		this.sno = sno;
		this.sname = sname;
		this.report = report;
	}

	//mvc 를 이용해서 값을 넣을 것이기 때문에 기본 생성자가 필요하다.
	public Report() {
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public MultipartFile getReport() {
		return report;
	}

	public void setReport(MultipartFile report) {
		this.report = report;
	}

	
	
	
}
