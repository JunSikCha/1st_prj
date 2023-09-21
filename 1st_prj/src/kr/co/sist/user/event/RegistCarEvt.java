package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.RegistCarDAO;
import kr.co.sist.user.design.RegistCarDesign;
import kr.co.sist.user.vo.RegistCarVO;

public class RegistCarEvt extends WindowAdapter implements ActionListener {

	private RegistCarVO rcVO;
	private RegistCarDesign rcd;

	public RegistCarEvt(RegistCarDesign rcd) {
		this.rcd = rcd;
		setModelNo();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// 확인버튼을 눌렀을 때
		if (ae.getSource() == rcd.getJbtComplete()) {

			// 유효성 검증
			if (rcValidate() == true) {
				// 정보 등록 실행
				addCarInfo();
				modifyUserCar();
				rcd.dispose();
			}
		}

		//취소 버튼
		if (ae.getSource() == rcd.getJbtCancel()) {
			rcd.dispose();
		}

	}

	@Override
	public void windowClosing(WindowEvent e) {
		rcd.dispose();
	}

	// 모델명 Jcombobox 목록 조회
	public void setModelNo() {
		RegistCarDAO rcDAO = new RegistCarDAO();

		try {
			List<String> listModelNo = rcDAO.selectModel();
			for (String mno : listModelNo) {
				rcd.getDcbmModel().addElement(mno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// setModelNo

	// 사용자 차량 등록
	public void addCarInfo() {
		RegistCarDAO rcDAO = new RegistCarDAO();
		try {

			rcVO = new RegistCarVO();
			rcVO.setCarModel(rcDAO.selectModelno(rcd.getJcbModel().getSelectedItem().toString()));
			rcVO.setCarNo(rcd.getJtfCarnum().getText());
			rcVO.setDistance(Integer.parseInt(rcd.getJtfDistance().getText()));

			RegistCarDAO rDAO = RegistCarDAO.getInstance();
			rDAO.insertCarinfo(rcVO);

			System.out.println(rcVO.getCarModel() + " 차량 추가 완료");
			JOptionPane.showMessageDialog(rcd, "차량등록이 완료되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 사용자 정보에 차량 정보 반영
	public void modifyUserCar() {

		RegistCarDAO rcDAO = new RegistCarDAO();
		rcVO = new RegistCarVO();

		try {

			rcVO.setCarNo(rcd.getJtfCarnum().getText().trim());
			rcVO.setModelNo(rcDAO.selectModelno(rcd.getJcbModel().getSelectedItem().toString()));
			rcVO.setId(UserData.id);

			rcDAO = RegistCarDAO.getInstance();
			int cnt = rcDAO.updateUserCarInfo(rcVO);
			System.out.println(cnt);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 유효성 검증
	public Boolean rcValidate() {
		// 차량번호 입력 여부
		String carNo = rcd.getJtfCarnum().getText().trim();
		if (carNo.equals("")) {
			JOptionPane.showMessageDialog(rcd, "차량번호를 입력해주세요");
			return false;
		}

		// 차량번호 검증
		String regexCarNo = "\\d{2}[가-힣]\\d{4}";
		if (!carNo.matches(regexCarNo)) {
			;
			JOptionPane.showMessageDialog(rcd, "올바른 차량번호 형식으로 입력해주세요." + "\nex)12가3456");
			return false;
		}

		// 주행거리 입력 여부
		String distance = rcd.getJtfDistance().getText().trim();
		if (distance.equals("")) {
			JOptionPane.showMessageDialog(rcd, "주행거리를 입력해주세요");
//			valFlag = false;
			return false;
		}

		// 주행거리 검증
		if (distance.length() > 7) {
			JOptionPane.showMessageDialog(rcd, "주행거리는 최대 999,9999km까지 입력 가능합니다.");
			return false;
		}

		return true;

	}

}
