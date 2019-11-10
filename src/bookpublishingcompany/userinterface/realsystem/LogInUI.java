package bookpublishingcompany.userinterface.realsystem;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LogInUI extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Label Title = new Label("Book Publishing Company");
		Label UserName = new Label("User Name");
		Label Password = new Label("Password");
		
		Title.setId("Title");
		Title.getStyleClass().add("Label");
		Title.setAlignment(Pos.CENTER);
		UserName.getStyleClass().add("Label");
		Password.getStyleClass().add("Label");
		
		TextField User = new TextField();
		PasswordField Pword = new PasswordField();
		
		User.getStyleClass().add("Text");
		Pword.getStyleClass().add("Text");
		
		CheckBox remember = new CheckBox("Remember Me");
		remember.setId("remember");
		
		Button Log = new Button ("LogIn");
		Log.setId("Create");
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setId("root");
		root.setSpacing(20);
		root.getChildren().addAll(Title, UserName,User,Password,Pword,remember, Log);
		Scene scene = new Scene(root,1000,1000);
		scene.getStylesheets().add("Style.css");
		
		primaryStage.setScene(scene);
		
		
		primaryStage.show();
	}

}
