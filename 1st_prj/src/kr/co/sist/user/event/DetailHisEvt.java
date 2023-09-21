package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.user.dao.DetailHisDAO;
import kr.co.sist.user.design.DetailHisDesign;
import kr.co.sist.user.design.HistoryDesign;
import kr.co.sist.user.vo.HistoryVO;

public class DetailHisEvt implements ActionListener {

	private HistoryDesign hd;
	private DetailHisDesign dhd;

	public DetailHisEvt(HistoryDesign hd, DetailHisDesign dhd) {
		this.hd = hd; // HistoryDesign 객체를 초기화
		this.dhd = dhd;
		

		// JTable의 칼럼이 0개라면 칼럼명 추가
		if (dhd.getJtPartTable().getColumnCount() == 0) {
			String[] partColumnNames = { "부품명", "단가", "공임비", "사용량", "소계" };
			for (int i = 0; i < partColumnNames.length; i++) {
				dhd.getDtm().addColumn(partColumnNames[i]);
			} // end for
		} // end if
		setDetail();
	}

	public void setDetail() {
		DetailHisDAO dhDAO = DetailHisDAO.getInstance();
		HistoryVO hVO = new HistoryVO();
		List<HistoryVO> partsList = new ArrayList<HistoryVO>();

		// 기존 테이블의 정비번호를 변수에 할당
		int historyno = Integer
				.parseInt(hd.getJtHistoryDesign().getValueAt(hd.getJtHistoryDesign().getSelectedRow(), 4).toString());

		try {
			// 위쪽 상세내역 정보 받기
			hVO = dhDAO.selectDetail(UserData.id, historyno);
			// 부품정보 테이블에 들어갈 정보 받기
			partsList = dhDAO.selectPartsInfo(historyno);

			// 정보를 입력하기
			dhd.getJtfMaintenencrNo().setText(String.valueOf(hVO.getHistoryno()));
			dhd.getJtfcarName().setText(hVO.getModelname());
			dhd.getJtfCarNo().setText(hVO.getCarno());
			dhd.getJtfPhone().setText(hVO.getTel());
			dhd.getJtfreceiveDay().setText(hVO.getOutbound());
			dhd.getJtfempName().setText(hVO.getEmpname());
			dhd.getJtfClientEmail().setText(hVO.getEmail());
			dhd.getJtfReleaseDay().setText(hVO.getInbound());
			dhd.getJtfCarmileage().setText(String.valueOf(hVO.getDistance()));
			dhd.getJtfFaultDetail().setText(hVO.getIssue());
			dhd.getJtfMaintenanceDetail().setText(hVO.getHdetail());
			dhd.getJtfNote().setText(hVO.getHnot());
			dhd.getJtfClientName().setText(hVO.getUsername());

			// JTable 데이터 삭제
			dhd.getDtm().setRowCount(0);

			// JTable 행 정보 추가
			// 사용부품 테이블
			String[] arrRow = new String[5]; // 새로운 배열 생성
			for (int i = 0; i < partsList.size(); i++) {
			    HistoryVO hiVO = partsList.get(i);
			    arrRow[0] = hiVO.getSname();
			    arrRow[1] = String.valueOf(hiVO.getSunitprice());
			    arrRow[2] = String.valueOf(hiVO.getSprice());
			    arrRow[3] = String.valueOf(hiVO.getUpamount());
			    arrRow[4] = String.valueOf((hiVO.getSunitprice() + hiVO.getSprice()) * hiVO.getUpamount());
			    dhd.getDtm().addRow(arrRow);
			    System.out.println("-----------------");
			    System.out.println(hiVO.getSname());
			    System.out.println(hiVO.getSunitprice());
			    System.out.println(hiVO.getSprice());
			    System.out.println(hiVO.getUpamount());
//			    System.out.println(arrRow[0]);
//			    System.out.println(arrRow[1]);
//			    System.out.println(arrRow[2]);
//			    System.out.println(arrRow[3]);
			}

			int total = 0;
			// 합계 구하는 수식
			for (int i = 0; i < dhd.getDtm().getRowCount(); i++) {
				total += Integer.parseInt(String.valueOf(dhd.getDtm().getValueAt(i, 4)));
			} // end if
			dhd.getJtfTotal().setText(String.valueOf(total));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
