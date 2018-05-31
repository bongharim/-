package com.kitri.baseball.view;

import java.awt.*;

import javax.swing.*;

import com.kitri.baseball.controller.BaseBallController;


public class BaseBallView extends JFrame{
	
	public ColorChooser cc = new ColorChooser();
	
	public JPanel pC = new JPanel();
	public JPanel pCS = new JPanel();
	public JPanel pE = new JPanel();
	
	
	public JButton newG = new JButton("������");
	public JButton answer = new JButton("����");
	public JButton clear = new JButton("�����");
	public JButton fontC = new JButton("���ڻ�");
	public JButton exit = new JButton("����");
	
	public Label l = new Label("�Է�");
	public TextField tf = new TextField();
	public TextArea area = new TextArea();
	
	public BaseBallView() {
		super("���ھ߱�����!!");
		
		Font f  = new Font("����",Font.BOLD,15);
		
		pCS.setLayout(new BorderLayout(10,0));
		pCS.add("West", l);
		pCS.add("Center", tf);
		
		pC.setLayout(new BorderLayout(0,10));
		area.setFocusable(false);           //area�� ��Ŀ���� �ȵȴ�. 
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
		
		tf.requestFocus(); // Ŀ���� tf������ 
		
		
		BaseBallController control = new BaseBallController(this);
//		�̺�Ʈ���
//		BaseBallViewâ ���
		tf.addActionListener(control);
		newG.addActionListener(control);
		clear.addActionListener(control);
		answer.addActionListener(control);
		fontC.addActionListener(control);
		exit.addActionListener(control);
//		ColorChooserâ ���
		
		cc.sbR.addAdjustmentListener(control);
		cc.sbG.addAdjustmentListener(control);
		cc.sbB.addAdjustmentListener(control);
		cc.sbR.addAdjustmentListener(control);
		cc.change.addActionListener(control);
		
		
	}	

}
