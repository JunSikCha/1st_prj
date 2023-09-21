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
		String userCarName;
		String userCarNo;
		String carImage;

		try {
			ClientMainDAO cmDAO = ClientMainDAO.getInstance();
			ClientMainVO cmVO = cmDAO.selectCarInfo(UserData.id);

			if (cmVO != null) { //cmVO가 null일 경우 예외 처리
				userCarName = cmVO.getUserCarName();
				userCarNo = cmVO.getUserCarNo();
				carImage = cmVO.getMimage();
				
				cmd.getJlCarname().setText(userCarName); 
				cmd.getJlCarNo().setText(userCarNo); //유저의 차량명, 차량번호가 메인화면에 나타난다.
				cmd.getJlDefaultimg().setIcon(new ImageIcon(carImage)); //유저의 차량의 이미지가 메인화면에 나타난다.
				
			} else { //차량을 등록하지 않았을 시 "차량을 등록해주세요"라는 문구가 나타난다.
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
			new RegistCarDesign(cmd);
		} // end if
		
		//정보 수정 창 실행
		if (ae.getSource() == cmd.getJbtModify()) {
			new ModifyDesign(cmd);
		}
		
		//정비 내역 창 실행
		if (ae.getSource() == cmd.getJbtHistory()) {
			new HistoryDesign(cmd);
		}
		
		//정비 예약 창 실행
		if(ae.getSource() == cmd.getJbtBook()) {
			new BookingDesign(cmd);
		}
		
		//예약 내역 창 실행
		if(ae.getSource() == cmd.getJbtBookCheck()) {
			new BookingCheckDesign(cmd);
		}
		
		//리콜 여부 확인 창 실행
		if(ae.getSource() == cmd.getJbtRecall()) {
			new RecallDesign(cmd);
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
