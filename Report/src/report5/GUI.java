package report5;

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

public class GUI extends Application{
  private  TextField time =new TextField();
  private  TextField timelater =new TextField();
  private TextField  name= new TextField();
  private TextField qweqField=new TextField();
  private Button qweButton =new Button("查询");
  private Button timeButton =new Button("获取当前时间");
  private Button timelaterButton=new Button("x天后时间");
  private Button nameButton=new Button("图书情况");
  private Button OK=new Button("确认");
  
  
 
  Calendar calendar= Calendar.getInstance();
  SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
 
 
  public void start(Stage PrimaryStage) {
	  GridPane gridPane=new GridPane();
	  gridPane.setHgap(5);
	  gridPane.setVgap(6);
	    

	  
	  gridPane.add(timeButton, 0, 0);
	  gridPane.add(time, 1, 0);
	  gridPane.add(new Label("请输入几天后还书："), 0, 1);
	  gridPane.add(timelater, 1, 1);
	  gridPane.add(timelaterButton, 2, 1);
	  gridPane.add(new Label("请输入借阅的书名："), 0,2);
	  gridPane.add(name, 1,2);
	  gridPane.add(nameButton, 2, 2);
	  gridPane.add(new Label("查询时一年中的第几天"), 0, 3);
	  gridPane.add(new Label("输入格式为 （xxxx-xx-xx）"), 0, 4);
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
	  PrimaryStage.setTitle("江理工图书借阅");
	  PrimaryStage.setScene(scene);
	  PrimaryStage.show();	  
}




public void Luckvalue() {  
	int FortuneValue=(int)(Math.random()*50+50);	
	int LoveValue=(int)(Math.random()*50+50);	
    	
	 Stage stage2=new Stage();
	 Pane pane =new Pane();
	 Text text1=new Text(20,20,name.getText()+"的剩余数目为"+FortuneValue);
	 Text text2=new Text(20,40,name.getText()+"的热度为"+LoveValue);
	 Text text3=new Text(20,60,"您的眼光不错");
	 Text text4=new Text(20,60,"库存不多了哦");
	 pane.getChildren().add(text1);
	 pane.getChildren().add(text2);
	 stage2.setTitle("图书情况");

		
	 
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
     Text tesText=new Text(20,20,"是"+year+"的第"+totalDay+"天");
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
	  String timeString = distance+"天为"+dateFormat.format(calendar.getTime());

	  Stage stage1=new Stage();
//	  GridPane gridPane1=new GridPane();
//	  gridPane1.setHgap(5);
//	  gridPane1.setVgap(2);
//	  Scene scene =new Scene(gridPane1,400,250);
	  stage1.setScene(new Scene(new Button(timeString),200,200));
	  stage1.setTitle("几天后时间");
	  stage1.show();	  
	
}


  
  public static void main(String[] args) {  
    launch(args);  
  }  		
}