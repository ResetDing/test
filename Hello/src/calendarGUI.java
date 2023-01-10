import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.application.*;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class calendarGUI extends Application{
  private  TextField time =new TextField();
  private  TextField timelater =new TextField();
  private TextField  name= new TextField();
  private TextField qweqField=new TextField();
  private Button qweButton =new Button("��ѯ");
  private Button timeButton =new Button("��ȡ��ǰʱ��");
  private Button timelaterButton=new Button("x���ʱ��");
  private Button nameButton=new Button("����");
  
  
 
  Calendar calendar= Calendar.getInstance();
  SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
 
 
  public void start(Stage PrimaryStage) {
	  GridPane gridPane=new GridPane();
	  gridPane.setHgap(5);
	  gridPane.setVgap(6);
	    

	  
	  gridPane.add(timeButton, 0, 0);
	  gridPane.add(time, 1, 0);
	  gridPane.add(new Label("�����뼸���"), 0, 1);
	  gridPane.add(timelater, 1, 1);
	  gridPane.add(timelaterButton, 2, 1);
	  gridPane.add(new Label("���������Ӣ������"), 0,2);
	  gridPane.add(name, 1,2);
	  gridPane.add(nameButton, 2, 2);
	  gridPane.add(new Label("��ѯʱһ���еĵڼ���"), 0, 3);
	  gridPane.add(new Label("�����ʽΪ ��xxxx-xx-xx��"), 0, 4);
	  gridPane.add(qweqField, 1, 3);
	  gridPane.add(qweButton, 2, 3);
	  
	  gridPane.setAlignment(Pos.CENTER);
	  timelater.setAlignment(Pos.BASELINE_RIGHT);
	  name.setAlignment(Pos.BOTTOM_RIGHT);
	  qweqField.setAlignment(Pos.BASELINE_RIGHT);
	  gridPane.setHalignment(qweButton, HPos.RIGHT);
	  gridPane.setHalignment(timeButton, HPos.RIGHT);	
	  gridPane.setHalignment(timelaterButton, HPos.RIGHT);	
	  gridPane.setHalignment(nameButton, HPos.RIGHT);	
	  
	  timeButton.setOnAction(EventHandler ->showtime());
	  timelaterButton.setOnAction(EventHandler ->showTimeLater());
	  nameButton.setOnAction(EventHandler ->Luckvalue());
	  qweButton.setOnAction(EventHandler ->howDays());
	  
	  Scene scene =new Scene(gridPane,400,250);
	  PrimaryStage.setTitle("����");
	  PrimaryStage.setScene(scene);
	  PrimaryStage.show();	  
}




public void Luckvalue() {  //�ж�����
	int FortuneValue=(int)(Math.random()*50+50);	
	int LoveValue=(int)(Math.random()*50+50);	
    	
	 Stage stage2=new Stage();
	 Pane pane =new Pane();
	 Text text1=new Text(20,20,name.getText()+"������Ϊ"+FortuneValue);
	 Text text2=new Text(20,40,name.getText()+"���һ���Ϊ"+LoveValue);
	 Text text3=new Text(20,60,"�����һ��˲���");
	 Text text4=new Text(20,60,"��˥Ŷ����������");
	 pane.getChildren().add(text1);
	 pane.getChildren().add(text2);
	 stage2.setTitle("����");

	 
	if(LoveValue>60) {
		pane.getChildren().add(text3);
		
	}else {
		pane.getChildren().add(text4);
		}
	 Scene scene=new Scene(pane);
	 stage2.setScene(scene);
	 stage2.show();
   }

public  void howDays() {
	
    String str=qweqField.getText();
    String[] strArr=str.split("-");
    int year=Integer.parseInt(strArr[0]);
    int month=Integer.parseInt(strArr[1]);
    int towMonth=28;
  
    if((year%4==0&&year%100!=0)||(year%400==0)){
        towMonth=29;
    }
    int totalDay=0;
    int[] months={31,towMonth,31,30,31,30,31,31,30,31,30,31};
 
    for(int i=0;i<months.length;i++){
        if(month>=i+1){
            if(month==i+1){
                totalDay+=Integer.parseInt(strArr[2]);
                break;
            }else{
                totalDay+=months[i];
            }
        }
    }
   
     Stage stage3=new Stage();
	 Pane pane1 =new Pane();
     Scene scene1=new Scene(pane1);
     Text tesText=new Text(20,20,"��"+year+"�ĵ�"+totalDay+"��");
     pane1.getChildren().add(tesText);
	 stage3.setScene(scene1);
	 stage3.show();
  

}

public  void showtime() {
	time.setText(dateFormat.format(calendar.getTime()));
	
}

public void showTimeLater() {
	int distance=Integer.parseInt(timelater.getText());
	calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + distance);	
	  String timeString = distance+"��Ϊ"+dateFormat.format(calendar.getTime());

	  Stage stage1=new Stage();
//	  GridPane gridPane1=new GridPane();
//	  gridPane1.setHgap(5);
//	  gridPane1.setVgap(2);
//	  Scene scene =new Scene(gridPane1,400,250);
	  stage1.setScene(new Scene(new Button(timeString),200,200));
	  stage1.setTitle("�����ʱ��");
	  stage1.show();	  
	
}


  
  public static void main(String[] args) {  
    launch(args);  
  }  		
}
/*	 Button OK=new Button("���ң�û�о�ϲ");
Scene scene=new Scene(OK,500,200);
primaryStage.setTitle("����1");
primaryStage.setScene(scene);
primaryStage.show();

for(int i=0;i<=2;i++) {
	 Stage stage=new Stage();
    stage.setTitle("����2");
    stage.setScene(new Scene(new Button("nono"),50,50));
    stage.show();
}

FlowPane pane1=new FlowPane();
pane1.setPadding(new Insets(11,12,13,14));
pane1.setHgap(5);
pane1.setVgap(5);
pane1.getChildren().addAll(new Label("Name"),new TextField(),new Label("PassWord"),new TextField());
pane1.getChildren().addAll(new Label("��֤��"));
TextField tfMi=new TextField();
tfMi.setPrefColumnCount(5);
pane1.getChildren().addAll(tfMi);

Scene scene2=new Scene(pane1,650,100);
primaryStage.setTitle("��������ϵͳ");
primaryStage.setScene(scene2);
primaryStage.show();
*/


