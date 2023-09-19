package manager.carmanager;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import manager.MyInformation.MyInformationTab;
import manager.booking.BookingManagerTab;
import manager.calculate.CalculateTab;
import manager.inventory.InventoryManagerTab;
import manager.login.LoginVO;
import manager.order.OrderManagerTab;

public class CarManager extends JFrame {//

    
   private JTabbedPane jtp;
   
   
   public CarManager() {
      super("MYCAR");
      jtp=new JTabbedPane();
      
      
      //상단 탭
      CarManagerTab cmt1=new CarManagerTab(); 
      InventoryManagerTab cmt2=new InventoryManagerTab(); 
      OrderManagerTab cmt3=new OrderManagerTab(); 
      BookingManagerTab cmt4=new BookingManagerTab(); 
      CalculateTab cmt5=new CalculateTab(); 
      MyInformationTab cmt6= new MyInformationTab(this); 
      
//      setLayout(null);
      
      jtp.add(cmt1,"차 량 관 리");
      jtp.add(cmt2,"재 고 관 리");
      jtp.add(cmt3,"발 주 관 리");
      jtp.add(cmt4,"예 약 관 리");
      jtp.add(cmt5," 정    산 ");
      jtp.add(cmt6,"내   정 보");
      
      add("Center",jtp);
      
      
      //글씨
      cmt1.setFont(new Font("맑은 고딕",Font.PLAIN,12));
      cmt2.setFont(new Font("맑은 고딕",Font.PLAIN,12));
      cmt3.setFont(new Font("맑은 고딕",Font.PLAIN,12));
      cmt4.setFont(new Font("맑은 고딕",Font.PLAIN,12));
      cmt5.setFont(new Font("맑은 고딕",Font.PLAIN,12));
      cmt6.setFont(new Font("맑은 고딕",Font.PLAIN,12));
      
        
      //크기 조정 및 배치  
      setBounds(400, 150, 950, 740);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      
   }//CarManager
   
   
   public static void main(String[] args) {
      new CarManager();
   }//main


public LoginVO getlVO() {
	// TODO Auto-generated method stub
	return null;
}

}//class