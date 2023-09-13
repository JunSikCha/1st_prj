package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.user.design.RecallDesign;

public class RecallEvt extends WindowAdapter implements ActionListener {

	private RecallDesign rd;
	
	public RecallEvt(RecallDesign rd) {
		this.rd=rd;
		test();
	}
	
	public void test() {
		String[]col= {"차명","리콜사유","리콜날짜"};
		for(int i=0; i<col.length;i++) {
			rd.getDtmRecallDesign().addColumn(col);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==rd.getJbtCancel()) {
			rd.dispose();
		}
		

	}
	public void windowClosing(WindowEvent we) {
		rd.dispose();

	}
}
