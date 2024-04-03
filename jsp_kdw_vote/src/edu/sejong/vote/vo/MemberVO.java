package edu.sejong.vote.vo;


//이름       널?       유형           
//-------- -------- ------------ 
//M_NO     NOT NULL CHAR(1)      
//M_NAME            VARCHAR2(20) 
//P_CODE            CHAR(2)      
//P_SCHOOL          CHAR(1)      
//M_JUMIN           CHAR(13)     
//M_CITY            VARCHAR2(20) 

public class MemberVO {
	private String m_no;
	private String m_name;
	private String p_code;
	private String p_school;
	private String m_jumin;
	private String m_city;
	private String p_name;
	private String t_school;
	private String p_tel;
	
	public MemberVO() {}

	public MemberVO(String m_no, String m_name, String p_code, String p_school, String m_jumin, String m_city) {
		this.m_no = m_no;
		this.m_name = m_name;
		this.p_code = p_code;
		this.p_school = p_school;
		this.m_jumin = m_jumin;
		this.m_city = m_city;
	}

	public MemberVO(String m_no, String m_name, String p_code, String p_school, String m_jumin, String m_city, String p_name, String t_school, String p_tel) {
		this.m_no = m_no;
		this.m_name = m_name;
		this.p_code = p_code;
		this.p_school = p_school;
		this.m_jumin = m_jumin;
		this.m_city = m_city;
		this.p_name = p_name;
		this.t_school = t_school;
		this.p_tel = p_tel;
	}

	public MemberVO(String p_school, String t_school) {
		this.p_school = p_school;
		this.t_school = t_school;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_school() {
		return p_school;
	}

	public void setP_school(String p_school) {
		this.p_school = p_school;
	}

	public String getM_jumin() {
		return m_jumin;
	}

	public void setM_jumin(String m_jumin) {
		this.m_jumin = m_jumin;
	}

	public String getM_city() {
		return m_city;
	}

	public void setM_city(String m_city) {
		this.m_city = m_city;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getT_school() {
		return t_school;
	}

	public void setT_school(String t_school) {
		this.t_school = t_school;
	}
	public String getP_tel() {
		return p_tel;
	}

	public void setP_tel(String p_tel) {
		this.p_tel = p_tel;
	}
	
}