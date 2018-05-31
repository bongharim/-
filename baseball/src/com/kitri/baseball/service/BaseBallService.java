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

		System.out.println("�� ���� : " + com[0] + com[1] + com[2]);
		

	}
	
	public void clear() { 
		bbv.area.setText("");
		bbv.tf.setText("");
		bbv.tf.requestFocus();
	}

	public void viewAnswer() {
		// TODO Auto-generated method stub
		bbv.area.append("������ " + com[0] + com[1] + com[2]+ "�Դϴ�.\n");
		newGame();
	}
	
	public void changeColor() {
		r = bbv.cc.sbR.getValue(); // ��ũ�ѹ��� ���� ������
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
		
		
//		myNum�� my�迭�� �ֱ�
		String myNum =bbv.tf.getText().trim(); //bb.vv.tf.getText() ���ϰ��� String
		                                // String.trim() ����� ����
		bbv.tf.setText("");
		
		int len = my.length;
		
		if(myNum.length() !=3) {
			bbv.area.append("3�ڸ� ���ڸ� ���ڸ� �Է��ϼ���.\n");
			return;
		}
		
//		myNum�� ���ڰ� �ƴ϶�� return;
		if(!isNumber(myNum)) {
			bbv.area.append("���ڸ� �Է��ϼ���.\n");
			return;
		}
		
//		for(int i = 0 ; i < my.length ; i++) {
//			my[i] = myNum.charAt(i) - 48 ;
//		}
		
		
		int result = Integer.parseInt(myNum);
		
		my[0] = result / 100 ;
		my[1] = result %100 / 10; 
		my[2] = result  % 10;
		System.out.println("�� ���� : " + my[0] + my[1] + my[2]);
		
		int strike = 0;
		int ball = 0;
		
		for(int a =0; a < len ; a++) {
			for(int b =0; b < len ; b++) {
				if(my[a]==com[b]) { //���ڰ� ���ٸ�
					if(a==b) { //�ڸ����� ���ٸ�
						strike++;
						
					}
					else {  //�ڸ����� �ٸ���
						ball++;
						
					}
				}
			}
		}
		
		count++;
		
		if(strike == 3) {
			bbv.area.append(myNum+"�� �����Դϴ�.\n " + count + "������ �����.");
		}else {
			bbv.area.append(myNum+"�� " + strike + "��Ʈ����ũ " + ball + "���Դϴ�.\n");
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
