package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import kr.co.sist.user.design.HistoryDesign;

public class HistoryEvt extends WindowAdapter implements ActionListener {
	
	private HistoryDesign hd;
	
	public HistoryEvt(HistoryDesign hd) {
		this.hd=hd;
		test();
	}
	
	public void test() {
		String[] col = {"번호","날짜","정비내역","비용"};
		for(int i=0;i<col.length;i++) {
		hd.getDtmHistoryDesign().addColumn(col[i]);
	
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==hd.getJbtDetail());{
			
		}
		if(ae.getSource()==hd.getJbtMain());{
			hd.dispose();
		}
		

	}

}
