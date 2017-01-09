package com.gc.train.struts2.login;

public class LoginAction3 {
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String username;
	private String password;
	
	public String execute()throws Exception{
		if (this.getUsername().equals("admin")&&this.getPassword().equals("password")) {
			return "success";
		}
		return "error";
		
	}
	
}
