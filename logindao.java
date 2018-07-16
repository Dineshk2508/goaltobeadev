package com.exceltest.jsp;

public class logindao {
	
	String firstName;
	String LastName;
	String userName;
	String passWord;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public logindao(String firstName, String lastName, String userName, String passWord) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
	}
	public logindao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public logindao(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	

}
