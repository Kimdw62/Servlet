package edu.sejong.game.vo;

import java.util.Arrays;

public class RspVO {	
	private String rsp = null;
	private static String[] arrRsp = {"����", "����", "��"};	
	private static String[] arrImages=  {
		"http://49.247.158.208:9999/hjs/img/scissor.f9ef898c.jpg",
		"http://49.247.158.208:9999/hjs/img/rock.8b39a13f.jpg",
		"http://49.247.158.208:9999/hjs/img/paper.0b032424.jpg",
		"https://taegon.kim/wp-content/uploads/2018/05/image-5.png",	
	};
	private String image = null;
	
	//�̹���
	public String getImage(){
		if(rsp == null) {
			image = arrImages[3];
		}else {
			int num = Arrays.asList(arrRsp).indexOf(rsp); 
			image = arrImages[num];
		}
		return image;
	}
	
	//��ǻ�� ��ü ����
	public RspVO() {
		rsp = arrRsp[(int)(Math.random() * 3)]; //0~2��ȣ ����
	}
	
	//��ǻ�� ��ü ����
	public RspVO(RspVO you) {
		if(you.getRsp() == null)
			rsp = null;
		else {	
			rsp = arrRsp[(int)(Math.random() * 3)]; //0~2��ȣ ����
		}
	}
	
	//user  ��ü ����
	public RspVO(String rsp) {
		this.rsp = rsp;
	}
	
	public String getRsp() {
		return rsp;
	}

	public void setRsp(String rsp) {
		this.rsp = rsp;
	}
	
	public String getResult(RspVO you) {
		if(you.getRsp() == null) {
			return  "���� ���� �� ��ư�� ��������";
		}
		
		String result = "�����ϴ�.";
		
		if(this.rsp.equals(you.getRsp())) {
			return result;
		}
		
		if(this.rsp.equals("����") && you.getRsp().equals("����")) {
			result = "����� �̰���ϴ�.";
		}else if(this.rsp.equals("����") && you.getRsp().equals("��")) {
			result = "����� �����ϴ�.";
		}else if(this.rsp.equals("����") && you.getRsp().equals("��")) {
			result = "����� �̰���ϴ�.";
		}else if(this.rsp.equals("����") && you.getRsp().equals("����")) {
			result = "����� �����ϴ�";
		}else if(this.rsp.equals("��") && you.getRsp().equals("����")) {
			result = "����� �̰���ϴ�.";
		}else if(this.rsp.equals("��") && you.getRsp().equals("����")) {
			result = "����� �����ϴ�";
		}	
			
		return result;
	}
}



//public String getImagePath(String rsp) {
//	String imgName = "https://taegon.kim/wp-content/uploads/2018/05/image-5.png";	//����
//	
//	if(rsp.equals("����")) {
//		imgName = "http://49.247.158.208:9999/hjs/img/scissor.f9ef898c.jpg";
//	}else if(rsp.equals("����")) {
//		imgName = "http://49.247.158.208:9999/hjs/img/rock.8b39a13f.jpg";
//	}if(rsp.equals("��")) {
//		imgName = "http://49.247.158.208:9999/hjs/img/paper.0b032424.jpg";
//	}
//	
//	System.out.println("getImagePath = " + rsp);
//	
//	return imgName;
//}
