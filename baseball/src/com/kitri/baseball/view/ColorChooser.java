package com.kitri.baseball.view;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;


public class ColorChooser extends Frame {
	
	Panel pL = new Panel();
	Panel pR = new Panel();
	Panel pRS = new Panel();
	Panel SC1 = new Panel();
	Panel SC2 = new Panel();
	Panel SC3 = new Panel();
	
	public Panel colorP = new Panel();
	
	
	Label lR = new Label("빨강",Label.CENTER);
	Label lG = new Label("초록",Label.CENTER);
	Label lB = new Label("파랑",Label.CENTER);
	
	public Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL,127,10,0,265); // 막대기 길이가 10이라서 265로 해야 최댓값이 255가 된다.
	public Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL,127,10,0,265);
	public Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL,127,10,0,265);
	
	public Label colorL = new Label();
	
	public Button change = new Button("변경");
	
	public ColorChooser() {
		
		//작은거 부터 배치하라!
		
		SC1.setLayout(new BorderLayout());
		lR.setBackground(Color.RED);
		SC1.add("West",lR );
		SC1.add("Center", sbR);
		
		SC2.setLayout(new BorderLayout());
		lG.setBackground(Color.GREEN);
		SC2.add("West",lG );
		SC2.add("Center", sbG);
		
		SC3.setLayout(new BorderLayout());
		lB.setBackground(Color.BLUE);
		lB.setForeground(Color.WHITE);
		SC3.add("West",lB );
		SC3.add("Center", sbB);
		
		pL.setLayout(new GridLayout(5,1,0,10));
		pL.add(new Label()); // 라벨을 만들고 아무것도 안하면 아무것도 안보인다.
		pL.add(SC1);
		pL.add(SC2);
		pL.add(SC3);
		pL.add(new Label());
		
		pRS.setLayout(new BorderLayout(0,10));
		pRS.add("Center", colorL);
		pRS.add("East", change);
		colorL.setBackground(Color.CYAN);
		
		pR.setLayout(new BorderLayout());
		pR.add("Center", colorP);
		pR.add("South", pRS);
		
	
		
		setLayout(new GridLayout(1, 2,10,0));
		add(pL);
		add(pR);
		
//		setSize(300,400);
//		setLocation(300,200);
		
		setBounds(200, 300, 500, 400);
		
	}

}
