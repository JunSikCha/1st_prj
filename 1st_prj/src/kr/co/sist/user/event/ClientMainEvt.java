package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.user.design.BookingCheckDesign;
import kr.co.sist.user.design.BookingDesign;
import kr.co.sist.user.design.ClientMainDesign;
import kr.co.sist.user.design.HistoryDesign;
import kr.co.sist.user.design.ModifyDesign;
import kr.co.sist.user.design.NotificateDesign;
import kr.co.sist.user.design.RecallDesign;
import kr.co.sist.user.design.RegistCarDesign;

public class ClientMainEvt extends WindowAdapter implements ActionListener {

	private ClientMainDesign cmd;

	public ClientMainEvt(ClientMainDesign cmd) {
		this.cmd = cmd;
	}// ClientMainEvt

	@Override
	public void actionPerformed(ActionEvent ae) {

		//차량 정보 등록 창 실행
		if (ae.getSource() == cmd.getJbtRegist()) {
			RegistCarDesign rcd = new RegistCarDesign();
			rcd.setVisible(true);
		} // end if
		
		//정보 수정 창 실행
		if (ae.getSource() == cmd.getJbtModify()) {
			ModifyDesign md = new ModifyDesign();
			md.setVisible(true);
		}
		
		//정비 내역 창 실행
		if (ae.getSource() == cmd.getJbtHistory()) {
			HistoryDesign hd = new HistoryDesign();
			hd.setVisible(true);
		}
		
		//정비 예약 창 실행
		if(ae.getSource() == cmd.getJbtBook()) {
			BookingDesign bd = new BookingDesign();
			bd.setVisible(true);
		}
		
		//예약 내역 창 실행
		if(ae.getSource() == cmd.getJbtBookCheck()) {
			BookingCheckDesign bcd = new BookingCheckDesign();
			bcd.setVisible(true);
		}
		
		//리콜 여부 확인 창 실행
		if(ae.getSource() == cmd.getJbtRecall()) {
			RecallDesign rd = new RecallDesign();
			rd.setVisible(true);
		}
		
		//알림 창 실행
		if(ae.getSource() == cmd.getJbtNotify()) {
			NotificateDesign nd = new NotificateDesign();
			nd.setVisible(true);
		}

	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent we) {
		cmd.dispose();
	}// windowClosing

}
