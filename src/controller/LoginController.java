package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.awt.Image;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import data.EmployeeData;
import database.DbConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController implements Initializable {
	private final Connection con;

	@FXML
	private TextField username;

	@FXML
	private TextField password;

	@FXML
	private TextField passwordTextField;

	@FXML
	private CheckBox showPasswordCheckBox;

	@FXML
	private Button loginButton;

	@FXML
	private Window window;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		password.setVisible(true);
		passwordTextField.setVisible(false);
	}

	public LoginController() {
		DbConnection dbc = DbConnection.getDatabaseConnection();
		con = dbc.getConnection();
	}

	@FXML
	private void login() throws Exception {
		String Username = username.getText();
		String Password = password.getText();

		if (Username.isEmpty() || Password.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please fill in both username and password fields");
			alert.showAndWait();
			return;
		}

		PreparedStatement ps;
		ResultSet rs;

		String query = "SELECT * FROM users WHERE username = ? and password_hash = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, Username);
			ps.setString(2, Password);
			rs = ps.executeQuery();

			if (rs.next()) {
				EmployeeData loggedInUserData = new EmployeeData(rs.getInt("id"), rs.getString("fullname"),
						rs.getString("username"), rs.getString("email"), rs.getString("phone_number"),
						rs.getString("password_hash"), rs.getString("gender"), rs.getString("user_image"),
						rs.getString("address"), rs.getDate("arrive_date"), rs.getInt("role"));

				// Đặt thông tin người dùng đã đăng nhập
				UserController.setLoggedInUser(loggedInUserData);

				Scene scene = loginButton.getScene();
				Stage stage = (Stage) scene.getWindow();
				stage.close();

				Parent root = FXMLLoader.load(getClass().getResource("/views/AdminView.fxml"));

				Scene newScene = new Scene(root);

				stage.setScene(newScene);
				stage.setTitle("Library Management");
//				stage.getIcons().add(new javafx.scene.image.Image("/asset/icon.png"));
				stage.show();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Invalid username or password");
				alert.showAndWait();
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	@FXML
	private void handleShowPasswordCheckbox(MouseEvent event) {
		if (showPasswordCheckBox.isSelected()) {
			password.setVisible(false);
			passwordTextField.setVisible(true);
			passwordTextField.setText(password.getText());
		} else {
			password.setVisible(true);
			passwordTextField.setVisible(false);
			password.setText(passwordTextField.getText());
		}
	}

}



