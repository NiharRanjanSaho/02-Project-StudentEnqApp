package in.nihar.dto;

import lombok.Data;

@Data
public class ForgotPwd {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}