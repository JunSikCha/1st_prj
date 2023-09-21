package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import kr.co.sist.user.dao.ClientMainDAO;
import kr.co.sist.user.design.BookingCheckDesign;
import kr.co.sist.user.design.BookingDesign;
import kr.co.sist.user.design.ClientMainDesign;
import kr.co.sist.user.design.HistoryDesign;
import kr.co.sist.user.design.ModifyDesign;
import kr.co.sist.user.design.NotificateDesign;
import kr.co.sist.user.design.RecallDesign;
import kr.co.sist.user.design.RegistCarDesign;
import kr.co.sist.user.vo.ClientMainVO;

public class ClientMainEvt extends WindowAdapter implements ActionListener {

	private ClientMainDesign cmd;

	public ClientMainEvt(ClientMainDesign cmd) {
		this.cmd = cmd;
		setMainInfo();
	}// ClientMainEvt
	
	public void setMainInfo() {
		String userCarName = null;
		String userCarNo = null;
		String carImage = null;

		try {
			ClientMainDAO cmDAO = ClientMainDAO.getInstance();
			ClientMainVO cmVO = cmDAO.selectCarInfo(UserData.id);

			if (cmVO != null) {
				userCarName = cmVO.getUserCarName();
				userCarNo = cmVO.getUserCarNo();
				carImage = cmVO.getMimage();
				System.out.println(userCarName);
				cmd.getJlCarname().setText(userCarName); 
				cmd.getJlCarNo().setText(userCarNo);
				cmd.getJlDefaultimg().setIcon(new ImageIcon(carImage));
				
				UserData.carno = cmVO.getUserCarNo();
				UserData.modelno = cmVO.getUserModelNo();
			} else {
				userCarName = "차량을 등록해주세요";
				userCarNo = "";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		//차량 정보 등록 창 실행
		if (ae.getSource() == cmd.getJbtRegist()) {
			new RegistCarDesign();
		} // end if
		
		//정보 수정 창 실행
		if (ae.getSource() == cmd.getJbtModify()) {
			new ModifyDesign();
		}
		
		//정비 내역 창 실행
		if (ae.getSource() == cmd.getJbtHistory()) {
			new HistoryDesign();
		}
		
		//정비 예약 창 실행
		if(ae.getSource() == cmd.getJbtBook()) {
			new BookingDesign();
		}
		
		//예약 내역 창 실행
		if(ae.getSource() == cmd.getJbtBookCheck()) {
			new BookingCheckDesign();
		}
		
		//리콜 여부 확인 창 실행
		if(ae.getSource() == cmd.getJbtRecall()) {
			new RecallDesign();
		}
		
		//알림 창 실행
		if(ae.getSource() == cmd.getJbtNotify()) {
			new NotificateDesign(cmd);
		}

	}// actionPerformed

	@Override
	public void windowClosing(WindowEvent we) {
		cmd.dispose();
	}// windowClosing

}
