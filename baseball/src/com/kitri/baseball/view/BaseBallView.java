package com.kitri.baseball.view;

import java.awt.*;

import javax.swing.*;

import com.kitri.baseball.controller.BaseBallController;


public class BaseBallView extends JFrame{
	
	public ColorChooser cc = new ColorChooser();
	
	public JPanel pC = new JPanel();
	public JPanel pCS = new JPanel();
	public JPanel pE = new JPanel();
	
	
	public JButton newG = new JButton("새게임");
	public JButton answer = new JButton("정답");
	public JButton clear = new JButton("지우기");
	public JButton fontC = new JButton("글자색");
	public JButton exit = new JButton("종료");
	
	public Label l = new Label("입력");
	public TextField tf = new TextField();
	public TextArea area = new TextArea();
	
	public BaseBallView() {
		super("숫자야구게임!!");
		
		Font f  = new Font("굴림",Font.BOLD,15);
		
		pCS.setLayout(new BorderLayout(10,0));
		pCS.add("West", l);
		pCS.add("Center", tf);
		
		pC.setLayout(new BorderLayout(0,10));
		area.setFocusable(false);           //area에 포커스가 안된다. 
		area.setFont(f); 
		pC.add("Center", area);
		pC.add("South", pCS);
		
		newG.setFont(f); 
		answer.setFont(f); 
		clear.setFont(f); 
		fontC.setFont(f); 
		exit.setFont(f); 
		
		pE.setLayout(new GridLayout(5,1,0,10));
		pE.add(newG);
		pE.add(answer);
		pE.add(clear);
		pE.add(fontC);
		pE.add(exit);
		
		
		
		
		
		setLayout(new BorderLayout(10,0));
		add("Center",pC);
		add("East",pE);
		
		
		setSize(500,400);
		setLocation(400,300);
		setVisible(true);	
		
		tf.requestFocus(); // 커서를 tf쪽으로 
		
		
		BaseBallController control = new BaseBallController(this);
//		이벤트등록
//		BaseBallView창 등록
		tf.addActionListener(control);
		newG.addActionListener(control);
		clear.addActionListener(control);
		answer.addActionListener(control);
		fontC.addActionListener(control);
		exit.addActionListener(control);
//		ColorChooser창 등록
		
		cc.sbR.addAdjustmentListener(control);
		cc.sbG.addAdjustmentListener(control);
		cc.sbB.addAdjustmentListener(control);
		cc.sbR.addAdjustmentListener(control);
		cc.change.addActionListener(control);
		
		
	}	

}
