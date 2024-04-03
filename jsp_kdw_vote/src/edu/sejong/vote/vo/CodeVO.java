package edu.sejong.vote.vo;


//이름       널?       유형           
//-------- -------- ------------ 
//party
//P_CODE   NOT NULL CHAR(2)      
//P_NAME            VARCHAR2(20) 
//P_READER          VARCHAR2(20)

//school
//P_SCHOOL NOT NULL CHAR(1)     
//T_SCHOOL          VARCHAR2(8)


public class CodeVO {
	private String p_code;
	private String p_name;
	private String p_reader;
	private String p_school;
	private String t_school;
	private String v_area;

	public CodeVO() {}

	//party
	public CodeVO(String p_code, String p_name, String p_reader) {
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_reader = p_reader;
	}

	//school
	public CodeVO(String p_school, String t_school) {
		this.p_school = p_school;
		this.t_school = t_school;
	}

	//area
	public CodeVO(String v_area) {
		this.v_area = v_area;
	}


	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_reader() {
		return p_reader;
	}

	public void setP_reader(String p_reader) {
		this.p_reader = p_reader;
	}

	public String getP_school() {
		return p_school;
	}

	public void setP_school(String p_school) {
		this.p_school = p_school;
	}

	public String getT_school() {
		return t_school;
	}

	public void setT_school(String t_school) {
		this.t_school = t_school;
	}

	public String getV_area() {
		return v_area;
	}

	public void setV_area(String v_area) {
		this.v_area = v_area;
	}

}