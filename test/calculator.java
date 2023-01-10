import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class calculator extends Application {
    private TextField num1 = new TextField();
    private TextField num2 = new TextField();
    private TextField res = new TextField();
    
    private Button btAdd = new Button("Add");
    private Button btSub = new Button("Subtract");
    private Button btMul = new Button("Multiply");
    private Button btDiv = new Button("Divide");
    
    @Override
    public void start(Stage primaryStage) {
        HBox top = new HBox();
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(5,10,5,10));
        top.setSpacing(10);
        
        top.getChildren().addAll(
            new Label("Number1"),
            num1,
            new Label("Number2"),
            num2,
            new Label("Result"),
            res);
        
        HBox bottom = new HBox();
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(5,10,5,10));
        bottom.setSpacing(10);
        
        bottom.getChildren().addAll(btAdd,btSub,btMul,btDiv);
            
        BorderPane pane = new BorderPane();
        pane.setTop(top);
        pane.setBottom(bottom);    
        
        btAdd.setOnAction(e -> Add());
        btSub.setOnAction(e -> Sub());
        btMul.setOnAction(e -> Mul());
        btDiv.setOnAction(e -> Div());
        
        Scene scene = new Scene(pane, 900, 80);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
        
    }
    
    private void Add() {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        res.setText(String.format("%.2f", n1+n2));
    }
    
    private void Sub() {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        res.setText(String.format("%.2f", n1-n2));
    }
    
    private void Mul() {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        res.setText(String.format("%.2f", n1*n2));
    }
    
    private void Div() {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());
        res.setText(String.format("%.2f", n1/n2));
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }

}