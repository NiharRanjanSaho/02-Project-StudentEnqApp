package in.nihar.dto;

import lombok.Data;

@Data
public class EnquiryForm {

	private String studentName;
	private String courseName;
	private Integer studentPhone;

	private String classMode;

	private String enquiryStatus;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(Integer studentPhone) {
		this.studentPhone = studentPhone;
	}

	public String getClassMode() {
		return classMode;
	}

	public void setClassMode(String classMode) {
		this.classMode = classMode;
	}

	public String getEnquiryStatus() {
		return enquiryStatus;
	}

	public void setEnquiryStatus(String enquiryStatus) {
		this.enquiryStatus = enquiryStatus;
	}

}