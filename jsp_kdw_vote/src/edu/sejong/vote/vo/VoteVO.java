package edu.sejong.vote.vo;


//이름       널?       유형           
//-------- -------- ------------ 
//V_JUMIN   NOT NULL CHAR(13)     
//V_NAME             VARCHAR2(20) 
//M_NO               CHAR(1)      
//V_TIME             CHAR(4)      
//V_AREA             VARCHAR2(20) 
//V_CONFIRM          CHAR(1)      

public class VoteVO {
	private String v_jumin;
	private String v_name;
	private String m_no;
	private String v_time;
	private String v_area;
	private String v_confirm;
	private String v_age;
	private String v_sex;
	private String u_jumin;
	private String v_count;
	
	public VoteVO() {}

	public VoteVO(String v_jumin, String v_name, String m_no, String v_time, String v_area, String v_confirm) {
		this.v_jumin = v_jumin;
		this.v_name = v_name;
		this.m_no = m_no;
		this.v_time = v_time;
		this.v_area = v_area;
		this.v_confirm = v_confirm;
	}

	public VoteVO(String v_name, String v_jumin, String v_age, String v_sex, String m_no, String v_time, String v_confirm, String u_jumin) {
		this.v_name = v_name;
		this.v_jumin = v_jumin;
		this.v_age = v_age;
		this.v_sex = v_sex;
		this.m_no = m_no;
		this.v_time = v_time;
		this.v_confirm = v_confirm;
		this.u_jumin = u_jumin;
	}

	public VoteVO(String m_no, String v_name, String v_count) {
		this.m_no = m_no;
		this.v_name = v_name;
		this.v_count = v_count;
	}

	public String getV_jumin() {
		return v_jumin;
	}

	public void setV_jumin(String v_jumin) {
		this.v_jumin = v_jumin;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getV_time() {
		return v_time;
	}

	public void setV_time(String v_time) {
		this.v_time = v_time;
	}

	public String getV_area() {
		return v_area;
	}

	public void setV_area(String v_area) {
		this.v_area = v_area;
	}

	public String getV_confirm() {
		return v_confirm;
	}

	public void setV_confirm(String v_confirm) {
		this.v_confirm = v_confirm;
	}

	public String getV_age() {
		return v_age;
	}

	public void setV_age(String v_age) {
		this.v_age = v_age;
	}

	public String getV_sex() {
		return v_sex;
	}

	public void setV_sex(String v_sex) {
		this.v_sex = v_sex;
	}
	
	public String getV_count() {
		return v_count;
	}

	public void setV_count(String v_count) {
		this.v_count = v_count;
	}

	public String getU_jumin() {
		return u_jumin;
	}

	public void setU_jumin(String u_jumin) {
		this.u_jumin = u_jumin;
	}
}