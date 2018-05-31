package com.kitri.baseball.service;

import java.awt.Color;

import com.kitri.baseball.view.BaseBallView;

public class BaseBallService {

	int com[] = new int[3];
	int my[] = new int[3];
	
	int r;
	int g;
	int b;
	int count;
	
	BaseBallView bbv;

	public BaseBallService(BaseBallView bbv) {
		
		this.bbv = bbv;
		

	}

	public void newGame() {
		com[0] = (int) (Math.random() * 9) + 1; // 1 <= x < 10

		do {
			com[1] = (int) (Math.random() * 10);
		} while (com[0] == com[1]);

		do {
			com[2] = (int) (Math.random() * 10);
		} while (com[0] == com[2] || com[1] == com[2]);

		System.out.println("컴 숫자 : " + com[0] + com[1] + com[2]);
		

	}
	
	public void clear() { 
		bbv.area.setText("");
		bbv.tf.setText("");
		bbv.tf.requestFocus();
	}

	public void viewAnswer() {
		// TODO Auto-generated method stub
		bbv.area.append("정답은 " + com[0] + com[1] + com[2]+ "입니다.\n");
		newGame();
	}
	
	public void changeColor() {
		r = bbv.cc.sbR.getValue(); // 스크롤바의 값을 얻어오기
		g = bbv.cc.sbG.getValue(); 
		b = bbv.cc.sbB.getValue();
		bbv.cc.colorP.setBackground(new Color(r, g, b));
		bbv.cc.colorL.setText(" r = " + r + " g = " + g + " b = " + b);
	}

	public void setAreaFontColor() {
		// TODO Auto-generated method stub
		bbv.area.setForeground(new Color(r, g , b));
		bbv.cc.sbR.setValue(127);
		bbv.cc.sbG.setValue(127);
		bbv.cc.sbB.setValue(127);
		bbv.cc.setVisible(false);
		
	}
	
	public void game() {
		
		
//		myNum을 my배열에 넣기
		String myNum =bbv.tf.getText().trim(); //bb.vv.tf.getText() 리턴값이 String
		                                // String.trim() 빈공간 제거
		bbv.tf.setText("");
		
		int len = my.length;
		
		if(myNum.length() !=3) {
			bbv.area.append("3자리 숫자만 숫자만 입력하세요.\n");
			return;
		}
		
//		myNum이 숫자가 아니라면 return;
		if(!isNumber(myNum)) {
			bbv.area.append("숫자만 입력하세요.\n");
			return;
		}
		
//		for(int i = 0 ; i < my.length ; i++) {
//			my[i] = myNum.charAt(i) - 48 ;
//		}
		
		
		int result = Integer.parseInt(myNum);
		
		my[0] = result / 100 ;
		my[1] = result %100 / 10; 
		my[2] = result  % 10;
		System.out.println("내 숫자 : " + my[0] + my[1] + my[2]);
		
		int strike = 0;
		int ball = 0;
		
		for(int a =0; a < len ; a++) {
			for(int b =0; b < len ; b++) {
				if(my[a]==com[b]) { //숫자가 같다면
					if(a==b) { //자리수가 같다면
						strike++;
						
					}
					else {  //자리수가 다르면
						ball++;
						
					}
				}
			}
		}
		
		count++;
		
		if(strike == 3) {
			bbv.area.append(myNum+"은 정답입니다.\n " + count + "번만에 맞췄다.");
		}else {
			bbv.area.append(myNum+"은 " + strike + "스트라이크 " + ball + "볼입니다.\n");
		}
		
	}
	
	private boolean isNumber(String str) {
		
		boolean b = true;
		
		int len = str.length();
		for (int i = 0; i < len; i++) {
			int num = str.charAt(i)-48;
			if(num < 0 || num > 9) {
				b = false;
				break;
			}

		}
			
		
		return b;
	}

}
