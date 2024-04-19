package edu.sejong.game.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoVO {
	private final static int LOTTO_COUNT = 7;
	private Set<Integer> numbers = new HashSet<Integer>();	//7�� ��ȣ

	private List<Integer> arrList = new ArrayList<Integer>();	//6�� ��ȣ
	private int bonusNum;	//���ʽ���ȣ

	public List<Integer> getArrList() {
		return arrList;
	}

	public void setArrList(List<Integer> arrList) {
		this.arrList = arrList;
	}

	public LottoVO() {
		while (numbers.size() < LOTTO_COUNT) {
			numbers.add((int)(Math.random() * 45) + 1);
		}
		
		List<Integer> lottoList = new ArrayList<>(numbers);
		
		for(int i=0; i < lottoList.size() - 1; i++) {
			int num = lottoList.get(i);
			arrList.add(num);
		}

		//���ʽ���ȣ = ������ ��ȣ
		bonusNum = lottoList.get(lottoList.size() - 1);

		System.out.println(numbers);
	}
	
	public Set<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public String getBackground(int num) {
		String bColor = "magenta";
		
		if(num < 10) {
			bColor = "green";
		}else if(num < 20) {
			bColor = "blue";
		}else if(num < 30) {
			bColor = "gold";
		}else if(num < 40) {
			bColor = "orange";
		}
		return bColor;
	}

	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}
	
}
