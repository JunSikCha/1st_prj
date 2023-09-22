package kr.co.sist.user.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import kr.co.sist.user.dao.NotificateDAO;
import kr.co.sist.user.design.NotificateDesign;
import kr.co.sist.user.vo.NotificateVO;

public class NotificateEvt extends WindowAdapter {
	
	private NotificateDesign nd;

	// 알림창에 들어갈 내용
	public String notificateInfo() throws ParseException {

		StringBuilder sbBi = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();

		// Calendar 객체를 사용하여 일주일 전의 날짜 계산
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DAY_OF_MONTH, -7);

		// 일주일 후의 날짜 얻기
		Date lastWeekDate = cal.getTime();

		try {
			NotificateDAO noDAO = NotificateDAO.getInstance();
			NotificateVO boVO = noDAO.selectBookingInfo(UserData.id); // 예약정보VO
			NotificateVO hiVO = noDAO.selectHistoryInfo(UserData.id); // 정비내역VO
			
			// 예약여부
			if (boVO != null) {
				
				if (boVO.getBstatus()==null) { // 예약이 처리되기 이전인 경우
					sbBi
					.append("안녕하세요, " + UserData.name + " 고객님!\n")
					.append("BMW자동차 " + boVO.getCtname() + " 예약센터입니다.\n")
					.append("["+boVO.getBdate() + "] 예약이 처리중이오니 잠시만 기다려주세요.");
				}else if (boVO.getBstatus().equals("y")) { // 예약이 수락되었을 경우
					sbBi
					.append("안녕하세요, " + UserData.name + " 고객님!\n")
					.append("BMW자동차 " + boVO.getCtname() + " 예약센터입니다.\n")
					.append("["+boVO.getBdate() + "] 예약이 완료되었습니다.");
				} else if (boVO.getBstatus().equals("n")) { // 예약이 거절되었을 경우
					sbBi
					.append("안녕하세요, " + UserData.name + " 고객님!\n")
					.append("BMW자동차 " + boVO.getCtname() + " 예약센터입니다.\n")
					.append("["+boVO.getBdate() + "] 예약이 ")
					.append("'" + boVO.getReason() + "'")
					.append(" 사유로 반려되었습니다.");
				}
			} else {
				sbBi.append("알림 내역이 없습니다.");
			}

			// 수리완료여부
			Date outDate = null; 

			if (hiVO != null) {
				String outbound = hiVO.getOutbound();
				if (outbound != null) {
					outDate = sdf.parse(outbound); // VO 객체에서 받아온 문자열 형식의 날짜를 Date 형식으로 변환
					if (outDate.after(lastWeekDate) && !outDate.after(currentDate)) { // 출고일이 오늘로부터 7일 이내일 때
						sbBi
						.append("\n\n")
						.append("안녕하세요, " + UserData.name + " 고객님!\n")
						.append("BMW 서비스 센터입니다.\n")
						.append("고객님의 소중한 차량의 수리가 [" + outbound + "] 부로 완료되었습니다.");
					}
				}
			}

			// hiVO가 null인 경우 예외 처리
			if (hiVO == null) {
				sbBi.append("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		String BookInfo = sbBi.toString();
		return BookInfo;
	}// NotificateInfo

	@Override
	public void windowClosing(WindowEvent e) {
		nd.dispose();
	}

}
