package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import kr.co.sist.user.dao.RegistCarDAO;
import kr.co.sist.user.design.LoginDesign;
import kr.co.sist.user.vo.RegistCarVO;

public class RegistCarEvt implements ActionListener {

	private RegistCarVO rcVO;

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private void addCarInfo(String carModel, String carNo, int distance) {
		try {		
			
			rcVO = new RegistCarVO();
			rcVO.setCarModel(carModel);
			rcVO.setCarNo(carNo);
			rcVO.setDistance(distance);

			RegistCarDAO rDAO = RegistCarDAO.getInstance();
	        rDAO.insertCarinfo(rcVO);
			
			System.out.println(rcVO.getCarModel()+" 차량 추가 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
