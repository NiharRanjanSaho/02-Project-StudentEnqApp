package in.nihar.service;

import in.nihar.dto.LoginForm;
import in.nihar.dto.SignUpForm;
import in.nihar.dto.UnlockForm;

public interface UserService {

	public String login(LoginForm form);

	public boolean signUp(SignUpForm form);

	// public String unlockAccount(UnlockForm form);

	public boolean unlockAccount(UnlockForm form);

	public String forgotPwd(String email);

}