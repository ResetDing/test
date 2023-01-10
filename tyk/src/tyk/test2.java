package tyk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class test2 extends Application {
  
	 public void start(Stage PrimaryStage) {
		 Button OK=new Button("按钮");
		 Scene scene=new Scene(OK,500,200);
		 PrimaryStage.setTitle("窗体1");
		 PrimaryStage.setScene(scene);
		 PrimaryStage.show();
		 
		 Stage stage=new Stage();
		 stage.setTitle("窗体2");
		 stage.setScene(new Scene(new Button("糖掉下来啦"),200,100));
		 
		 stage.show();
		 
	 }
        
	 public static void main(String[] args) {  
		    launch(args);  
		  }  	
	
}
