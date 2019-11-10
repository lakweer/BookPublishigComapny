package bookpublishingcompany.userinterface.realsystem;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.HashMap;


public class AccountCreationUI extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		
		HashMap<String, String> UserInformation = new HashMap<String, String>();
		
		//Start of UI gadgets
		 ComboBox userTypeCombo = new ComboBox();
		 userTypeCombo.getItems().add("Admin");
		 userTypeCombo.getItems().add("Stock Keeper");
		 userTypeCombo.getItems().add("Printer");
		 userTypeCombo.getItems().add("Accountant");
		 userTypeCombo.getItems().add("Head of Typesetting Unit");
		Label Title = new Label("Book Publishing Company");
		Label UType = new Label("Type of User");
		Label FirstName = new Label("First Name");
		Label LastName = new Label("Last Name");
		Label BDay = new Label("Birth Day");
		Label Address = new Label("Address");
		Label PhoneNum = new Label("Phone Number");
		Label Email = new Label("Email Address");
		Label UserName = new Label("User Name");
		Label Password = new Label("Password");
		Label PasswordConfirm = new Label("Confirm Password");
		
		TextField FName = new TextField();
		TextField LName = new TextField();
		TextField Add = new TextField();
		TextField Phone = new TextField();
		TextField Mail = new TextField();
		TextField Uname = new TextField();
		PasswordField Pword = new PasswordField();
		PasswordField PwordCon = new PasswordField();

		DatePicker BD = new DatePicker();
		
		Button Create = new Button ("Create");
		Create.setId("Create");
		Title.setId("Title");
		
		Title.getStyleClass().add("Label");
		Title.setAlignment(Pos.CENTER);
		
		
		UType.getStyleClass().add("Label");
		FirstName.getStyleClass().add("Label");
		LastName.getStyleClass().add("Label");
		BDay.getStyleClass().add("Label");
		Address.getStyleClass().add("Label");
		PhoneNum.getStyleClass().add("Label");
		Email.getStyleClass().add("Label");
		UserName.getStyleClass().add("Label");
		Password.getStyleClass().add("Label");
		PasswordConfirm.getStyleClass().add("Label");
		
		
		FName.getStyleClass().add("Text");
		LName.getStyleClass().add("Text");
		Add.getStyleClass().add("Text");
		Phone.getStyleClass().add("Text");
		Mail.getStyleClass().add("Text");
		Uname.getStyleClass().add("Text");
		Pword.getStyleClass().add("Text");
		PwordCon.getStyleClass().add("Text");

	
		
		
		Create.setOnAction(e -> {
			//define variables
			String userType = (String) userTypeCombo.getValue();
			String firstName = FName.getText();
			String lastName = (String) LName.getText();
			String dob = BD.getValue().toString();
			String address = (String) Add.getText();
			String phone = (String) Phone.getText();
			String email = (String) Mail.getText();
			String username = (String) Uname.getText();
			String password = (String) Pword.getText();
			String passwordConfirm = (String) PwordCon.getText();
			
			
			//insert into a hash map
			UserInformation.put("userType", userType);
			UserInformation.put("firstName", firstName);
			UserInformation.put("lastName", lastName);
			UserInformation.put("dob", dob);
			UserInformation.put("address", address);
			UserInformation.put("phone", phone);
			UserInformation.put("email", email);
			UserInformation.put("username", username);
			UserInformation.put("password", password);
			UserInformation.put("passwordConfirm", passwordConfirm);
			
			
			System.out.println(UserInformation);
			
			
		});
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setId("root");
		root.setSpacing(10);
		root.getChildren().addAll(Title, UType, userTypeCombo, FirstName, FName, LastName, LName, BDay, BD, Address, Add, PhoneNum, Phone, Email, Mail, UserName, Uname, Password, Pword, PasswordConfirm, PwordCon, Create);
		Scene scene = new Scene(root,1000,1000);
		scene.getStylesheets().add("Style.css");
		
		primaryStage.setScene(scene);
		
		
		primaryStage.show();
		
		
	}
}
