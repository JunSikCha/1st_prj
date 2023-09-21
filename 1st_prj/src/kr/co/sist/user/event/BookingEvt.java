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
import kr.co.sist.user.vo.BookingVO;
import kr.co.sist.user.vo.CenterVO;

public class BookingEvt implements ActionListener{
	
		private BookingDesign bD;
		private BookingVO bVO;
		private BookingDAO bDAO;

		private boolean dateFlag;// 선택일자의 유효성
		private boolean todayFlag;// 선택일자가 오늘인가?
		private boolean timeFlag;// 선택시간의 유효성
		
		
		private List<CenterVO> centerVOList ;
		
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
			addDate();
		}
		
		//CenterVO를 받아서 콤보리스트를 추가해주는 method
		public void addCenterInfo() {
			for (int i=0; i< centerVOList.size(); i++) {
						String CName = centerVOList.get(i).getcName();
						bD.getJcbBranch().addItem(CName);
			}
			//기본값 설정
			CenterVO cVO = centerVOList.get(0);
			bVO.setCentername(cVO.getcName());
			bVO.setCenterno(cVO.getCenterNo());
			
		}
				
		//연월 추가 메소드
		public void addDate() {
			LocalDate currentDate = LocalDate.now();
			
			//연추가
			int year = currentDate.getYear();
			bD.getJcbBookYear().addItem(String.valueOf(year));
			bD.getJcbBookYear().addItem(String.valueOf(year+1));
			//월 추가
			for(int i=1; i<13; i++) {
				bD.getJcbBookMonth().addItem(String.valueOf(i));
			}
		}	
			
		//일 추가
		public void addDay() {
			bD.getJcbBookDay().removeAllItems(); //이전의 값 지우기

			LocalDate now = LocalDate.now();
			int year= now.getYear();
			int month= now.getMonthValue();
			int day= now.getDayOfMonth();
			
			int setYear = Integer.valueOf(bD.getJcbBookYear().getSelectedItem().toString());
			int setMonth = Integer.valueOf(bD.getJcbBookMonth().getSelectedItem().toString());
			int setDay = 1;
			
			if(setYear==year) {
				if(setMonth==month) {
					setDay=day;
				}
			}
			
			LocalDate setDate = LocalDate.of(setYear,setMonth,day);
			int maxDay = setDate.lengthOfMonth();
			
			for(int i=setDay; i<maxDay+1; i++) {//달의 최대일수까지 콤보박스에 넣기
				bD.getJcbBookDay().addItem(String.valueOf(i));
			}//end for
			
		}

		//날짜의 유효성 검증 메소드
		public void validateDate() {
			// 현재 날짜을 가져옵니다.
	        LocalDate currentDate = LocalDate.now();
	        //선택된 날짜 객체 생성
	        int selectedYear = Integer.valueOf(bD.getJcbBookYear().getSelectedItem().toString());
	        System.out.println(selectedYear);
	        int selectedMonth = Integer.valueOf(bD.getJcbBookMonth().getSelectedItem().toString());
	        System.out.println(selectedMonth);
	        int selectedDay = Integer.valueOf(bD.getJcbBookDay().getSelectedItem().toString());
	        System.out.println(selectedDay);
	        
	        LocalDate selectedDate= LocalDate.of(selectedYear,selectedMonth,selectedDay);//월은 1부터 시작한다. Calendar과 다르게
	        System.out.println(selectedDate);
	        System.out.println(currentDate.isBefore(selectedDate));
	        
	        // 오늘날짜보다 과거인지 검증.
	       if(selectedDate.isBefore(currentDate)){
	    	  JOptionPane.showMessageDialog(bD, "오늘보다 이전의 날짜는 선택할 수 없습니다.");
	    	  dateFlag=false;
	    	  return; 
	       };
	       
	       dateFlag=true;
	       todayFlag=false;
	       //시간검증을 위해서 선택된 날짜가 오늘인지 검증
	       if(selectedDate.equals(currentDate)) {
	    	   todayFlag=true;
	       }
		}//validateDate
		
		//현재시간을 짝수시간으로 바꾼 후, +2시간씩 콤보박스에 추가해주는 메소드
		public void addBookingTime() {
			// 현재 시간을 가져옵니다.
			Calendar calendar = Calendar.getInstance();
			int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
			
			//현재시간이 홀수일 경우.
			if(currentHour%2==1) {
				currentHour++;
			}
			//일자를 얻어서 선택된날짜가 오늘이라면 지금 이후시간, 오늘이 아니고 내일이라면 전체시간
			bD.getJcbBookTime().removeAllItems(); //이전의 값 지우기
			String time="";
			
			//오늘이 아니라면 일자 검증을 통과했으므로 시간 추가
			if(!todayFlag) {
				for(int i=10; i<18 ; i+=2) {
					time=String.valueOf(i)+":00";
					bD.getJcbBookTime().addItem(time);
				}//콤보박스에 시간 추가
				return;
			}

			//일자가 오늘일 경우 시간 검증
			if(currentHour >=16) {
				JOptionPane.showMessageDialog(bD, "16시 이후로는 예약이 불가능합니다.");
				timeFlag=false;
				return;
			}
			//검증 통과시 시간 넣기
			for(int i=currentHour; i<18 ; i+=2) {
				time=String.valueOf(i)+":00";
				bD.getJcbBookTime().addItem(time);
			}
			timeFlag=true;
			
		}//addBookingTime

		@Override
		public void actionPerformed(ActionEvent e) {

			//지점 이름이 선택됬을 때
			if( e.getSource()==bD.getJcbBranch() ) {
				//선택된 값의 인덱스 추출
				int index=0;
				System.out.println(index);
				index = bD.getJcbBranch().getSelectedIndex();
				//해당 인덱스값으로 지점번호 가져오기
				CenterVO cVO = centerVOList.get(index);
				System.out.println(cVO);
				System.out.println(cVO.getCenterNo());
				System.out.println(cVO.getcName());
				bVO.setCenterno(cVO.getCenterNo());
				bVO.setCentername(cVO.getcName());
			}
			
			//예약 일자가 선택됬을때
			//연,월,일의 콤보박스가 분리되었으므로 3번해야함
			//유효성검증의 경우 일자가 선택되었을 시 수행.
			String selectedMonth=" ";
			String selectedDay=" ";
			String selectedYear=" ";
			//연도 선택시
			if( e.getSource()==bD.getJcbBookYear() ) {
				//연도 얻어오기
//				selectedYear = bD.getJcbBookYear().getSelectedItem().toString();
				
			}
			
			//월 선택시
			if( e.getSource()==bD.getJcbBookMonth()) {
				//월 얻어오기
				selectedMonth = bD.getJcbBookMonth().getSelectedItem().toString(); //월은 0월부터 시작
				addDay();
			}
			
			//일 선택시
			if( e.getSource()==bD.getJcbBookDay() ) {

				//일 얻어오기
				if(bD.getJcbBookDay().getSelectedItem() != null) {
				selectedDay = bD.getJcbBookDay().getSelectedItem().toString();
				 //날짜에 대한 유효성 검증
				validateDate();
				
				//시간 추가
				addBookingTime();
				}
			}
			

			//예약시간이 선택되었을때
			if(  bD.getJcbBookTime().getSelectedItem() !=null && e.getSource()== bD.getJcbBookTime()  ) {
				
				selectedYear = bD.getJcbBookYear().getSelectedItem().toString();
				selectedMonth = bD.getJcbBookMonth().getSelectedItem().toString();
				selectedDay = bD.getJcbBookDay().getSelectedItem().toString();
				
				String time = bD.getJcbBookTime().getSelectedItem().toString();
				StringBuilder bDate= new StringBuilder();
				bDate.append(selectedYear).append("-").append(selectedMonth).append("-").append(selectedDay).append(" ").append(time);
				System.out.println(bDate);
				//VO객체에 시간 설정
				bVO.setBdate(bDate.toString());
			}

			//고장 증상이 선택됬을때.
			//Details 에는 Null값이 가능함. 그래서 그냥 객체 가져와서 데이터 내용을 String에 담으면 될듯함.
			
			 //예약버튼이 눌렸을때.
	 		//현재까지 입력된 데이터는 지점정보,번호,예약날짜.
	 		//추가적으로 유저 아이디로 조회한 차량번호와 모델번호 가 bVO에 들어가야함.
			 //해당데이터는 준식이가 앞부분 작업하면서 매개변수로 넣어주기로 했음.
	 		//데이터를 모두 bVO에 담은 상태에서 insertBooking 메소드 실행. 
	 		//쿼리 성공/실패에 따라 예약신청이 완료되었습니다. 잘못된 정보입니다 다시 확인해주세요 나눠서 출력
			if(e.getSource()==bD.getJbtComplete()) {
				if(!dateFlag) {
					JOptionPane.showMessageDialog(bD, "예약일자를 확인해 주세요");
					return;
				}
				
				bVO.setCarno(UserData.carno);
				bVO.setModelno(UserData.modelno);
				bVO.setIssue(bD.getJtaDetail().getText());
				System.out.println(bVO.getCarno());
				System.out.println(bVO.getModelno());
				System.out.println(bVO.getIssue());
				System.out.println(bVO.getBdate());
				System.out.println(bVO.getCentername());
				System.out.println(bVO.getCenterno());
				
				
				
				try {
					bDAO.insertBooking(bVO);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(bD,"정비 예약 신청이 완료되었습니다");
				bD.dispose();
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
