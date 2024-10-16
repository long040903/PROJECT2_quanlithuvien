package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import database.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import data.EmployeeData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DbConnection;

public class ChangePasswordController implements Initializable {
	private final Connection con;

	@FXML
	private Button changeButton;

	@FXML
	private TextField confirmNewPassword;

	@FXML
	private TextField confirmNewPasswordTextField;

	@FXML
	private TextField currentPassword;

	@FXML
	private TextField currentPasswordTextField;

	@FXML
	private TextField newPassword;

	@FXML
	private TextField newPasswordTextField;

	@FXML
	private CheckBox showPasswordCheckBox;

	@FXML
	private Window window;

	@FXML
	private void handleShowPasswordCheckbox(MouseEvent event) {
		if (showPasswordCheckBox.isSelected()) {
			newPassword.setVisible(false);
			newPasswordTextField.setVisible(true);
			newPasswordTextField.setText(newPassword.getText());
		} else {
			newPassword.setVisible(true);
			newPasswordTextField.setVisible(false);
			newPassword.setText(newPasswordTextField.getText());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		newPassword.setVisible(true);
		newPasswordTextField.setVisible(false);
	}

	public ChangePasswordController() {
		DbConnection dbc = DbConnection.getDatabaseConnection();
		con = dbc.getConnection();
	}

	@FXML
	private void changepass() throws Exception {
		String CurrentPassword = currentPassword.getText();
		String NewPassword = newPassword.getText();
		String ConfirmNewPassword = confirmNewPassword.getText();

		// Xác định người dùng đã đăng nhập (ở đây giả sử đang sử dụng một biến toàn cục
		// để lưu thông tin người dùng đã đăng nhập)
		EmployeeData loggedInUser = UserController.getLoggedInUser();

		// Kiểm tra mật khẩu hiện tại có đúng không
		if (CurrentPassword.isEmpty() || !loggedInUser.getPassword().equals(CurrentPassword)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Invalid current password");
			alert.showAndWait();
			return;
		}

		// Kiểm tra xác nhận mật khẩu mới
		if (!NewPassword.equals(ConfirmNewPassword)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("New password and confirm password do not match");
			alert.showAndWait();
			return;
		}

		// Cập nhật mật khẩu mới cho người dùng
		loggedInUser.setPassword(NewPassword);

		// Lưu trạng thái người dùng lại (cập nhật mật khẩu mới) trong cơ sở dữ liệu nếu
		// cần
		updatePasswordInDatabase(loggedInUser);
	}

	// Hàm cập nhật mật khẩu mới trong cơ sở dữ liệu (nếu cần)
	private void updatePasswordInDatabase(EmployeeData user) throws IOException {
		// Thực hiện truy vấn SQL để cập nhật mật khẩu mới
		String query = "UPDATE users SET password_hash = ? WHERE id = ?";
		try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setInt(2, user.getEmployeeID());
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				Scene scene = changeButton.getScene();
				Stage stage = (Stage) scene.getWindow();
				stage.close();

				Parent root = FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));

				Scene newScene = new Scene(root);

				stage.setScene(newScene);
				stage.setTitle("Library Management");
				stage.show();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Update new password failded!");
				alert.showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
