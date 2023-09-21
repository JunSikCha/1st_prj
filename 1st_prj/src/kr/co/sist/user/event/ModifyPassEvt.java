package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.ModifyPassDAO;
import kr.co.sist.user.design.ModifyPassDesign;
import kr.co.sist.user.vo.ModifyPassVO;

public class ModifyPassEvt extends WindowAdapter implements ActionListener {

	private ModifyPassDesign mpd;

	public ModifyPassEvt(ModifyPassDesign mpd) {
		this.mpd = mpd;
	}//ModifyPassEvt

	//비밀번호 수정 메소드
	public void modifyPass() {
		ModifyPassVO mpVO = new ModifyPassVO();

		try {

			//vo 값 할당
			mpVO.setNewPass(mpd.getJtfnewPwdField().getText());
			mpVO.setId(UserData.id);

			//dao 메소드 호출
			ModifyPassDAO mpDAO = ModifyPassDAO.getInstance();
			int cnt = mpDAO.updatePass(mpVO);
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch

	}//modifyPass

	//비밀번호 확인 메소드
	public void pwCheck() {

		if (!(mpd.getJtfcurPwdField().getText().equals(""))) { //현재 비밀번호 공백 여부
			if (mpd.getJtfnewPwdField().getText().equals(mpd.getJtfconfirmPwd().getText())) { //비밀번호 확인 검증
				modifyPass(); //비밀번호 수정 메소드 호출
				JOptionPane.showMessageDialog(mpd, "변경이 완료되었습니다.");
				System.out.println(mpd.getJtfcurPwdField().getText());
			}else {
				JOptionPane.showMessageDialog(mpd, "비밀번호 확인이 잘못되었습니다.");
			}
		}else {
			JOptionPane.showMessageDialog(mpd, "기존 비밀번호를 입력해주세요.");			
		}

	}
	
	public boolean passValidate() {
		
		//기존 비밀번호가 로그인 정보와 일치한지 검증
		String curPw = mpd.getJtfcurPwdField().getText().trim();
		if(!curPw.equals(UserData.pass)) {
			JOptionPane.showMessageDialog(mpd, "기존 비밀번호가 틀렸습니다.");
			return false;
		}
		
		//새 비밀번호가 비밀번호 형식에 맞는지 검증
		String newPw = mpd.getJtfnewPwdField().getText().trim();
		if( "".equals(newPw)) {
			JOptionPane.showMessageDialog(mpd, "새로운 비밀번호를 입력해주세요.");
			return false;
		}
		if(newPw.length()>=30) {
			JOptionPane.showMessageDialog(mpd, "비밀번호가 너무 깁니다.(최대 30자)");
			return false;
		}
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mpd.getJbtComplete()) {
			if(passValidate()) { //유효성 검증 통과시			
				pwCheck(); //비밀번호 변경
			}
		}

	}

	@Override
	public void windowClosing(WindowEvent we) {

	}

}
