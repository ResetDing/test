package tyk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class test2 extends Application {
  
	 public void start(Stage PrimaryStage) {
		 Button OK=new Button("��ť");
		 Scene scene=new Scene(OK,500,200);
		 PrimaryStage.setTitle("����1");
		 PrimaryStage.setScene(scene);
		 PrimaryStage.show();
		 
		 Stage stage=new Stage();
		 stage.setTitle("����2");
		 stage.setScene(new Scene(new Button("�ǵ�������"),200,100));
		 
		 stage.show();
		 
	 }
        
	 public static void main(String[] args) {  
		    launch(args);  
		  }  	
	
}
