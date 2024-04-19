package edu.sejong.game.vo;

import java.util.Arrays;

public class RspVO {	
	private String rsp = null;
	private static String[] arrRsp = {"가위", "바위", "보"};	
	private static String[] arrImages=  {
		"http://49.247.158.208:9999/hjs/img/scissor.f9ef898c.jpg",
		"http://49.247.158.208:9999/hjs/img/rock.8b39a13f.jpg",
		"http://49.247.158.208:9999/hjs/img/paper.0b032424.jpg",
		"https://taegon.kim/wp-content/uploads/2018/05/image-5.png",	
	};
	private String image = null;
	
	//이미지
	public String getImage(){
		if(rsp == null) {
			image = arrImages[3];
		}else {
			int num = Arrays.asList(arrRsp).indexOf(rsp); 
			image = arrImages[num];
		}
		return image;
	}
	
	//컴퓨터 객체 생성
	public RspVO() {
		rsp = arrRsp[(int)(Math.random() * 3)]; //0~2번호 생성
	}
	
	//컴퓨터 객체 생성
	public RspVO(RspVO you) {
		if(you.getRsp() == null)
			rsp = null;
		else {	
			rsp = arrRsp[(int)(Math.random() * 3)]; //0~2번호 생성
		}
	}
	
	//user  객체 생성
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
			return  "가위 바위 보 버튼을 누르세요";
		}
		
		String result = "비겼습니다.";
		
		if(this.rsp.equals(you.getRsp())) {
			return result;
		}
		
		if(this.rsp.equals("가위") && you.getRsp().equals("바위")) {
			result = "당신이 이겼습니다.";
		}else if(this.rsp.equals("가위") && you.getRsp().equals("보")) {
			result = "당신이 졌습니다.";
		}else if(this.rsp.equals("바위") && you.getRsp().equals("보")) {
			result = "당신이 이겼습니다.";
		}else if(this.rsp.equals("바위") && you.getRsp().equals("가위")) {
			result = "당신이 졌습니다";
		}else if(this.rsp.equals("보") && you.getRsp().equals("가위")) {
			result = "당신이 이겼습니다.";
		}else if(this.rsp.equals("보") && you.getRsp().equals("바위")) {
			result = "당신이 졌습니다";
		}	
			
		return result;
	}
}



//public String getImagePath(String rsp) {
//	String imgName = "https://taegon.kim/wp-content/uploads/2018/05/image-5.png";	//심판
//	
//	if(rsp.equals("가위")) {
//		imgName = "http://49.247.158.208:9999/hjs/img/scissor.f9ef898c.jpg";
//	}else if(rsp.equals("바위")) {
//		imgName = "http://49.247.158.208:9999/hjs/img/rock.8b39a13f.jpg";
//	}if(rsp.equals("보")) {
//		imgName = "http://49.247.158.208:9999/hjs/img/paper.0b032424.jpg";
//	}
//	
//	System.out.println("getImagePath = " + rsp);
//	
//	return imgName;
//}
