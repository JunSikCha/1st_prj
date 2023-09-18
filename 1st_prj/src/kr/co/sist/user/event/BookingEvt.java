package kr.co.sist.user.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.BookingDAO;
import kr.co.sist.user.design.BookingDesign;
import kr.co.sist.user.design.RecallDesign;
import kr.co.sist.user.vo.BookingVO;
import kr.co.sist.user.vo.CenterVO;

public class BookingEvt implements ActionListener{
	
		private BookingDesign bD;
		private BookingVO bVO;
		private BookingDAO bDAO;
		
		
		private String carno;
		private String modelno;
		private String issue;
		private String centername;
		private String bdate;
		
		private boolean ymdFlag;// 년도를 선택했는지 유무
		private boolean dateFlag;// 선택일자의 유효성
		private boolean todayFlag;// 선택일자가 오늘인가?
		private boolean timeFlag;// 선택일자의 유효성
		
		private List<CenterVO> centerVOList ;
		private String cName;
		private String cNO;	
		
		public BookingEvt() {
			
		}
		
		public BookingEvt(BookingDesign bD) {
			this.bD=bD;
			bVO= new BookingVO();
			bDAO = BookingDAO.getInstance();
			try {
				centerVOList= bDAO.getCenterInfo();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			addCenterInfo();
			
		}

		
		//CenterVO를 받아서 콤보리스트를 추가해주는 method
		public void addCenterInfo() {
			for (int i=0; i< centerVOList.size(); i++) {
				String CName = centerVOList.get(i).getcName();
				bD.getJcbBranch().addItem(CName);
			}
		}
			
		
		//예약부터 오늘 이후의 날짜로 리스트에 넣어주는 메소드
		//날짜와 시간 둘다 넣어야함. 각자 객체로
		
		//현재시간을 기준으로 +2시간씩 콤보박스에 추가해주는 메소드
		public void addBookingTime() {
			// 현재 시간을 가져옵니다.
			Calendar calendar = Calendar.getInstance();
	        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);

	        //현재시간이 홀수일 경우.
	        if(currentHour%2==1) {
	        	currentHour++;
	        }
	       //일자를 얻어서 선택된날짜가 오늘이라면 지금 이후시간, 오늘이 아니고 내일이라면 전체시간
	        String time="";
	        if(todayFlag) {
	        	for(int i=currentHour; i<18 ; i+=2) {
	        		time=String.valueOf(i)+":00";
	        		bD.getJcbBookTime().addItem(time);
	        	}//콤보박스에 현재시간을 기준으로 시간을 추가.
        	} else {
        		for(int i=8; i<18 ; i+=2) {
        			time=String.valueOf(i)+":00";
	        		bD.getJcbBookTime().addItem(time);
	        	}//콤보박스에 시간 추가
        	}
	       
		}//addBookingTime
		
		//선택한 시간 유효성 검증 메소드
		//일자를 얻어서 선택된날짜가 오늘이면 시간으로 검증할 메소드 
		public void checkTime(int time) {
			//현재시간이 16시보다 늦은경우, 18시는 서비스센터 종료시간
			//16시인 경우 다음시간대가 종료시간이므로 16시 이후는 예약불가
		       if(time>=16) {
		    	   JOptionPane.showMessageDialog(bD, "16시 이후로는 예약이 불가능합니다.");
		    	   timeFlag=false;
		    	   return;
		       }
		}
			
	/*
		//시간유효성 검증 메소드
		public void validateTime() {
			// 현재 시간을 가져옵니다.
	        Calendar calendar = Calendar.getInstance();
	        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
	       //현재시간이 홀수일 경우
	        if(currentHour%2==1) {
	        	currentHour++;
	        }
	       //현재시간이 16시보다 늦은경우, 18시는 서비스센터 종료시간
	       //16시인 경우 다음시간대가 종료시간이므로 16시 이후는 예약불가
		       if(currentHour>=16) {
		    	   System.out.println("예약이 안됩니다.");
		    	   return;
		       }
		       for(int i=currentHour; i<24 ; i+=2) {
		    	   bD.getJcbBookTime().add(i);
		       }
			}//setDate
	*/
		//날짜의 유효성 검증 메소드
		public void validateDate(int selectedYear,int selectedMonth,int selectedDay) {
			// 현재 날짜을 가져옵니다.
	        LocalDate currentDate = LocalDate.now();
	        //선택된 날짜 객체 생성
	        LocalDate selectedDate= LocalDate.of(selectedYear,selectedYear,selectedDay);
	       
	        // 오늘날짜보다 과거인지 검증.
	       if(selectedDate.isBefore(currentDate)){
	    	   JOptionPane.showMessageDialog(bD, "오늘보다 이전의 일자는 선택할 수 없습니다.");
	    	   dateFlag=false;
	    	   return;
	       }
	       
	       dateFlag=true;
	       //시간검증을 위해서 선택된 날짜가 오늘인지 검증
	       if(selectedDate.equals(currentDate)) {
	    	   todayFlag=true;
	       }
		}//setDate();
		
		
		@Override
		public void actionPerformed(ActionEvent e) {

			//지점 이름이 선택됬을 때
			if( e.getSource()==bD.getJcbBranch() ) {
				//선택된 값의 인덱스 추출
				int index = bD.getJcbBranch().getSelectedIndex();
				//해당 인덱스값으로 지점번호 가져오기
				CenterVO cVO = centerVOList.get(index);
				
				bVO.setCenterno(cVO.getCenterNo());
				bVO.setCentername(cVO.getcName());
			}
			
			//예약 일자가 선택됬을때
			//연,월,일의 콤보박스가 분리되었으므로 3번해야함
			//유효성검증의 경우 일자가 선택되었을 시 수행.
			int selectedYear;
			if( e.getSource()==bD.getJcbBookYear() ) {
				//연도 얻어오기
//				selectedYear = bD.getJcbBookYear().get();
			}
			int selectedMonth;
			if( e.getSource()==bD.getJcbBookMonth()) {
				//월 얻어오기
//				selectedMonth = bD.getJcbBookMonth().getText(); //월은 0월부터 시작
			}
			int selectedDay;
			if( e.getSource()==bD.getJcbBookDay() ) {
			//일 얻어오기
//				selectedDay = bD.getJcbBookDay().getText();
				
				 //날짜에 대한 유효성 검증
//				validateDate(selectedYear, selectedMonth, selectedDay);
				if(!dateFlag) {
					JOptionPane.showMessageDialog(bD, "예약일자를 확인해 주세요");
					return;
				}
				//시간 추가
				addBookingTime();
			}
			

			//예약시간이 선택되었을때
			if( e.getSource()== bD.getJcbBookTime() ) {
	/*			
				StringBuilder bDate= new StringBuilder();
				int time = bD.getJcbBookTime().getSelectedItem();//값 얻어오는걸로 바꿔야함.
				bDate.append(selectedYear).append(selectedMonth).append(selectedDay).append(time);
				//시간의 유효성 검증
				if(todayFlag) {
					checkTime(time);
				}
				//VO객체에 시간 설정
				bVO.setBdate(bDate.toString());
		*/		
			}

			//고장 증상이 선택됬을때.
			//Details 에는 Null값이 가능함. 그래서 그냥 객체 가져와서 데이터 내용을 String에 담으면 될듯함.
			 if( e.getSource()==bD.getJtaDetail() ) {
				String issue = bD.getJtaDetail().getText();
				//VO객체에 고장 증상
				bVO.setIssue(issue);
			}
			
			 //예약버튼이 눌렸을때.
	 		//현재까지 입력된 데이터는 지점정보,번호,예약날짜.
	 		//추가적으로 유저 아이디로 조회한 차량번호와 모델번호 가 bVO에 들어가야함.
			 //해당데이터는 준식이가 앞부분 작업하면서 매개변수로 넣어주기로 했음.
	 		//데이터를 모두 bVO에 담은 상태에서 insertBooking 메소드 실행. 
	 		//쿼리 성공/실패에 따라 예약신청이 완료되었습니다. 잘못된 정보입니다 다시 확인해주세요 나눠서 출력
			if(e.getSource()==bD.getJbtComplete()) {
				bVO.setCarno(UserData.carno);
				bVO.setModelno(UserData.modelno);
				bVO.setIssue(bD.getJtaDetail().getText());
				
				try {
					bDAO.insertBooking(bVO);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(bD,"정비 예약 신청이 완료되었습니다");
				}
	 			
			//취소버튼이 눌렸을때
			if(e.getSource()==bD.getJbtCancel()) {
				int cancle =JOptionPane.showConfirmDialog(bD, "예약 신청을 취소하시겠습니까?",
						"예약신청 취소",	JOptionPane.YES_NO_OPTION);
				switch (cancle) {
					case 0 :
						JOptionPane.showMessageDialog(bD, "예약 신청이 취소되었습니다.");
						bD.dispose();
					break;
				default:
					break;
				}
//				bD.dispose(); 
			}
		
		}//actionListener
			

	}//class
