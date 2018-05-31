package com.kitri.baseball.controller;


import java.awt.event.*;

import com.kitri.baseball.service.BaseBallService;
import com.kitri.baseball.view.BaseBallView;

public class BaseBallController implements ActionListener, AdjustmentListener{

	BaseBallView bbv;
	BaseBallService service;
	
	public BaseBallController(BaseBallView bbv) {
		this.bbv = bbv;
		service = new BaseBallService(bbv);
		service.newGame();
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub
		service.changeColor();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob =e.getSource();
		if(ob == bbv.newG) {
			service.newGame();
			service.clear();
			bbv.area.setText("---새로운 게임을 시작합니다.---\n");
		}else if(ob == bbv.clear) {
			service.clear();
		}else if(ob == bbv.answer) {
			service.viewAnswer();
		}else if(ob == bbv.fontC) {
			bbv.cc.setVisible(true);
			service.changeColor();
		}else if(ob == bbv.exit) {
			System.exit(0); // 종료
		}else if(ob == bbv.tf) {
			service.game();
		}else if(ob == bbv.cc.change) {
			service.setAreaFontColor();
		}
	
	}

}
