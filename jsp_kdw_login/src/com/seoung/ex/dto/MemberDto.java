package com.seoung.ex.dto;

/*이름      널?       유형            
------- -------- ------------- 
ID      NOT NULL VARCHAR2(20)  
PW      NOT NULL VARCHAR2(20)  
EMAIL            VARCHAR2(100) 
ADDRESS          VARCHAR2(200)
*/

public class MemberDto {
	private String id;
	private String pw;
	private String email;
	private String address;
	
	public MemberDto() {}
	
	public MemberDto(String id, String pw, String email, String address) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
