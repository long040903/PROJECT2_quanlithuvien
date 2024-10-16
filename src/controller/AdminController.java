package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import data.AreaData;
import data.BookData;
import data.BorrowedBookData;
import data.BorrowedBookDetailData;
import data.BorrowedBookDetailDisplayData;
import data.BorrowedBookDisplayData;
import data.BorrowedBookInfo;
import data.CategoryData;
import data.CustomerData;
import data.EmployeeData;
import database.DbConnection;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class AdminController implements Initializable {

	private static final int DEFAULT_USER_ID = 0;

	@FXML
	private Button addArea_addBtn;

	@FXML
	private TableColumn<AreaData, Integer> addArea_col_areaID;

	@FXML
	private TableColumn<AreaData, String> addArea_col_areaName;

	@FXML
	private TableColumn<?, ?> addArea_col_areaStatus;

	@FXML
	private Button addArea_deleteBtn;

	@FXML
	private TextField addArea_name;

	@FXML
	private TextField addArea_search;

	@FXML
	private TableView<AreaData> addArea_tableView;

	@FXML
	private Button addArea_updateBtn;

	@FXML
	private Button addBook_addBtn;

	@FXML
	private ComboBox<String> addBook_area;

	@FXML
	private TextField addBook_author;

	@FXML
	private TextField addBook_bookName;

	@FXML
	private Button addBook_btn;

	@FXML
	private ComboBox<String> addBook_category;

	@FXML
	private Button addBook_clearBtn;

	@FXML
	private TableColumn<BookData, String> addBook_col_area;

	@FXML
	private TableColumn<BookData, String> addBook_col_author;

	@FXML
	private TableColumn<BookData, Integer> addBook_col_bookID;

	@FXML
	private TableColumn<BookData, String> addBook_col_bookName;

	@FXML
	private TableColumn<BookData, String> addBook_col_category;

	@FXML
	private TableColumn<BookData, Date> addBook_col_publicationYear;

	@FXML
	private TableColumn<BookData, Integer> addBook_col_quantity;

	@FXML
	private Button addBook_deleteBtn;

	@FXML
	private AnchorPane addBook_form;

	@FXML
	private ImageView addBook_image;

	@FXML
	private Button addBook_importBtn;

	@FXML
	private TextField addBook_publicationYear;

	@FXML
	private TextField addBook_quantity;

	@FXML
	private TextField addBook_search;

	@FXML
	private TableView<BookData> addBook_tableView;

	@FXML
	private Button addBook_updateBtn;

	@FXML
	private Button addCategory_addBtn;

	@FXML
	private TableColumn<CategoryData, Integer> addCategory_col_categoryID;

	@FXML
	private TableColumn<CategoryData, String> addCategory_col_categoryName;

	@FXML
	private Button addCategory_deleteBtn;

	@FXML
	private TextField addCategory_name;

	@FXML
	private TextField addCategory_search;

	@FXML
	private TableView<CategoryData> addCategory_tableView;

	@FXML
	private Button addCategory_updateBtn;

	@FXML
	private Button addCustomer_addBtn;

	@FXML
	private DatePicker addCustomer_arriveDate;

	@FXML
	private Button addCustomer_clearBtn;

	@FXML
	private TableColumn<CustomerData, Date> addCustomer_col_arriveDate;

	@FXML
	private TableColumn<CustomerData, Integer> addCustomer_col_customerID;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_email;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_fullname;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_gender;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_phone;

	@FXML
	private TableColumn<CustomerData, String> addCustomer_col_status;

	@FXML
	private Button addCustomer_deleteBtn;

	@FXML
	private TextField addCustomer_email;

	@FXML
	private AnchorPane addCustomer_form;

	@FXML
	private TextField addCustomer_fullname;

	@FXML
	private ComboBox<?> addCustomer_gender;

	@FXML
	private TextField addCustomer_phone;

	@FXML
	private TextField addCustomer_search;

	@FXML
	private ComboBox<?> addCustomer_status;

	@FXML
	private TableView<CustomerData> addCustomer_tableView;

	@FXML
	private Button addCustomer_updateBtn;

	@FXML
	private Button addEmployee_addBtn;

	@FXML
	private TextField addEmployee_address;

	@FXML
	private DatePicker addEmployee_arriveDate;

	@FXML
	private Button addEmployee_btn;

	@FXML
	private Button addEmployee_clearBtn;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_address;

	@FXML
	private TableColumn<EmployeeData, Date> addEmployee_col_arriveDate;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_email;

	@FXML
	private TableColumn<EmployeeData, Integer> addEmployee_col_employeeID;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_fullname;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_gender;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_phone;

	@FXML
	private TableColumn<EmployeeData, String> addEmployee_col_username;

	@FXML
	private Button addEmployee_deleteBtn;

	@FXML
	private TextField addEmployee_email;

	@FXML
	private AnchorPane addEmployee_form;

	@FXML
	private TextField addEmployee_fullname;

	@FXML
	private ComboBox<?> addEmployee_gender;

	@FXML
	private ImageView addEmployee_image;

	@FXML
	private Button addEmployee_import;

	@FXML
	private PasswordField addEmployee_password;

	@FXML
	private TextField addEmployee_phone;

	@FXML
	private TextField addEmployee_search;

	@FXML
	private TableView<EmployeeData> addEmployee_tableView;

	@FXML
	private Button addEmployee_updateBtn;

	@FXML
	private TextField addEmployee_username;

	@FXML
	private Button area_btn;

	@FXML
	private AnchorPane area_form;

	@FXML
	private TableColumn<BookData, String> borrowBook_col_bookName;

	@FXML
	private TableColumn<BookData, Integer> borrowBook_col_bookQuantity;

	@FXML
	private Button borrowBook_orderBtn;

	@FXML
	private TableView<BookData> borrowBook_tableView;

	@FXML
	private TabPane categoryTabPane;

	@FXML
	private Button category_btn;

	@FXML
	private AnchorPane category_form;

	@FXML
	private Button changepass;

	@FXML
	private Button confirmOrder_Btn;

	@FXML
	private TextField customerName;

	@FXML
	private Button customers_btn;

	@FXML
	private Button home_btn;

	@FXML
	private AnchorPane home_form;

	@FXML
	private Label home_totalBook;

	@FXML
	private Label home_totalCustomer;

	@FXML
	private Label home_totalEmployee;

	@FXML
	private Button logout;

	@FXML
	private Button minus_quantityBtn;

	@FXML
	private Button plus_quantityBtn;

	@FXML
	private ImageView posDetailBookImage;

	@FXML
	private TextField posDetailBookName;

	@FXML
	private TextField posQuantity;

	@FXML
	private Button pos_btn;

	@FXML
	private AnchorPane pos_form;

	@FXML
	private TextField pos_search;

	@FXML
	private Button removeOrder_btn;
	
	@FXML
    private TableColumn<BorrowedBookDetailDisplayData, String> staticisBookDetails_col_borrowDate;

    @FXML
    private TableColumn<BorrowedBookDetailDisplayData, String> staticisBookDetails_col_dueDate;

    @FXML
    private TableColumn<BorrowedBookDetailDisplayData, String> staticisBookDetails_col_nameBook;

    @FXML
    private TableColumn<BorrowedBookDetailDisplayData, Integer> staticisBookDetails_col_quantityBook;

    @FXML
    private TableView<BorrowedBookDetailDisplayData> staticisBookDetails_tableView;

	@FXML
	private TableColumn<BorrowedBookDisplayData, Integer> staticisBook_col_ID;

	@FXML
	private TableColumn<BorrowedBookDisplayData, String> staticisBook_col_customerName;

	@FXML
	private TableColumn<BorrowedBookDisplayData, String> staticisBook_col_employeeName;

	@FXML
	private TableColumn<BorrowedBookDisplayData, Integer> staticisBook_col_quantityBook;

	@FXML
	private TableView<BorrowedBookDisplayData> staticisBook_tableView;

	@FXML
	private Button staticis_btn;

	@FXML
	private TextField staticis_totalBookLoanCoupon;

	@FXML
	private TextField staticis_totalQuantityBook;
	
	@FXML
    private Button staticis_viewChartBtn;

	@FXML
	private Button staticis_viewDetailsBtn;

	@FXML
	private AnchorPane statics_form;

	@FXML
	private Label username;

	@FXML
	private Button viewBookLoanCoupon_Btn;

	private Connection connect;
	private Statement statement;
	private PreparedStatement prepare;
	private ResultSet result;

	private Image image;
	private String imagePath;

//---------------------------------------------------------------------------------------------------------
	// STATICS
	public void staticsTotalEmployee() {
		String sql = "SELECT COUNT(id) FROM users WHERE role = 0";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		int countEmployees = 0;

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				countEmployees = result.getInt("COUNT(id)");
			}

			home_totalEmployee.setText(String.valueOf(countEmployees));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void staticsTotalCustomers() {
		String sql = "SELECT COUNT(id) FROM customer";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		int countCustomers = 0;

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				countCustomers = result.getInt("COUNT(id)");
			}

			home_totalCustomer.setText(String.valueOf(countCustomers));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void staticsTotalBooksBorrowed() {
		String sql = "SELECT SUM(quantity) FROM borrowedbooksdetails";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		int totalBooksBorrowed = 0;

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				totalBooksBorrowed = result.getInt("SUM(quantity)");
			}

			home_totalBook.setText(String.valueOf(totalBooksBorrowed));
			staticis_totalQuantityBook.setText(String.valueOf(totalBooksBorrowed));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void staticsTotalBooksLoanCoupon() {
		String sql = "SELECT COUNT(id) FROM borrowedbooks";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		int totalBooksLoanCoupon = 0;

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				totalBooksLoanCoupon = result.getInt("COUNT(id)");
			}
			
			staticis_totalBookLoanCoupon.setText(String.valueOf(totalBooksLoanCoupon));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public ObservableList<BorrowedBookDisplayData> staticsBookListData() {

		ObservableList<BorrowedBookDisplayData> listData = FXCollections.observableArrayList();
		String sql = "SELECT borrowedbooks.id, customer.fullname, users.fullname, borrowedbooks.total_quantity " +
                "FROM borrowedbooks " +
                "INNER JOIN customer ON borrowedbooks.customer_id = customer.id " +
                "INNER JOIN users ON borrowedbooks.user_id = users.id";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			BorrowedBookDisplayData borrowedBookDisplayData;

			while (result.next()) {
				borrowedBookDisplayData = new BorrowedBookDisplayData(
		                result.getInt("borrowedbooks.id"),
		                result.getString("customer.fullname"),
		                result.getString("users.fullname"),
		                result.getInt("total_quantity")
		            );
				listData.add(borrowedBookDisplayData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;

	}

	private ObservableList<BorrowedBookDisplayData> staticsBookListData;

	public void staticsBookShowListData() {
		staticsBookListData = staticsBookListData();

		staticisBook_col_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
	    staticisBook_col_customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
	    staticisBook_col_employeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
	    staticisBook_col_quantityBook.setCellValueFactory(new PropertyValueFactory<>("totalQuantity"));

	    staticisBook_tableView.setItems(staticsBookListData);

	}
	
	public void updateStaticisBookTableView() {
	    staticsBookListData.clear(); // Xóa dữ liệu hiện tại trong danh sách

	    // Gọi hàm staticsBookListData() để lấy dữ liệu mới từ cơ sở dữ liệu
	    ObservableList<BorrowedBookDisplayData> newData = staticsBookListData();

	    // Thêm dữ liệu mới vào danh sách hiện tại
	    staticsBookListData.addAll(newData);

	    // Cập nhật TableView để hiển thị dữ liệu mới
	    staticisBook_tableView.refresh();
	}
	
	private ObservableList<BorrowedBookDetailDisplayData> borrowedBookDetailsList = FXCollections.observableArrayList();

	@FXML
	private void viewBookLoanCoupon(ActionEvent event) {
	    BorrowedBookDisplayData selectedBorrowedBook = staticisBook_tableView.getSelectionModel().getSelectedItem();

	    if (selectedBorrowedBook != null) {
	        int borrowedBookId = selectedBorrowedBook.getId();

	        // Sử dụng borrowedBookId để truy xuất dữ liệu chi tiết từ bảng borrowedbooksdetails trong cơ sở dữ liệu
	        try {
	            DbConnection dbc = DbConnection.getDatabaseConnection();
	            Connection connect = dbc.getConnection();

	            // Tạo truy vấn SQL để lấy dữ liệu chi tiết phiếu mượn
	            String sql = "SELECT borrowedbooksdetails.*, books.book_name FROM borrowedbooksdetails INNER JOIN books ON borrowedbooksdetails.book_id = books.book_id WHERE borrow_id = ?";
	            PreparedStatement preparedStatement = connect.prepareStatement(sql);
	            preparedStatement.setInt(1, borrowedBookId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            staticisBookDetails_col_borrowDate.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
	            staticisBookDetails_col_dueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
	            staticisBookDetails_col_nameBook.setCellValueFactory(new PropertyValueFactory<>("bookName"));
	            staticisBookDetails_col_quantityBook.setCellValueFactory(new PropertyValueFactory<>("quantity"));


	            // Xử lý dữ liệu chi tiết phiếu mượn và đưa nó vào borrowedBookDetailsList
	            borrowedBookDetailsList.clear(); // Xóa dữ liệu hiện tại
	            while (resultSet.next()) {
	                String borrowDate = resultSet.getString("borrow_date");
	                String dueDate = resultSet.getString("due_date");
	                String bookName = resultSet.getString("book_name");
	                int quantity = resultSet.getInt("quantity");

	                BorrowedBookDetailDisplayData detailData = new BorrowedBookDetailDisplayData(borrowDate, dueDate, bookName, quantity);
	                borrowedBookDetailsList.add(detailData);
	            }

	            // Đặt items của TableView bằng borrowedBookDetailsList để hiển thị dữ liệu
	            staticisBookDetails_tableView.setItems(borrowedBookDetailsList);
	            staticisBookDetails_tableView.refresh(); // Làm mới giao diện
	         
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            // Hiển thị thông báo lỗi cho người dùng nếu có lỗi khi truy xuất cơ sở dữ liệu
	        }
	    } else {
	        // Hiển thị thông báo cho người dùng nếu không có phiếu nào được chọn
	        showAlert("Lỗi", "Không có phiếu nào được chọn", Alert.AlertType.ERROR);
	    }
	}


//---------------------------------------------------------------------------------------------------------
	// CRUD BOOKS

	public void addBookAdd() {
		String sql = "INSERT INTO books (book_name, author_name, publication_year, quantity, book_image, category_id, area_id) VALUES(?,?,?,?,?,?,?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			if (addBook_bookName.getText().isEmpty() || addBook_author.getText().isEmpty()
					|| addBook_publicationYear.getText().isEmpty() || addBook_quantity.getText().isEmpty()
					|| addBook_area.getSelectionModel().getSelectedItem() == null
					|| addBook_category.getSelectionModel().getSelectedItem() == null || imagePath == null
					|| imagePath.isEmpty()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill all blank fields");
				alert.showAndWait();
			} else {
				String check = "SELECT book_name FROM books WHERE book_name = ?";
				PreparedStatement checkStatement = connect.prepareStatement(check);
				checkStatement.setString(1, addBook_bookName.getText());
				ResultSet result = checkStatement.executeQuery();

				if (result.next()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Book name: " + addBook_bookName.getText() + " already exists!");
					alert.showAndWait();
				} else {
					PreparedStatement prepare = connect.prepareStatement(sql);
					prepare.setString(1, addBook_bookName.getText());
					prepare.setString(2, addBook_author.getText());
					prepare.setInt(3, Integer.parseInt(addBook_publicationYear.getText()));
					prepare.setString(4, addBook_quantity.getText());
					prepare.setString(5, imagePath);

					// Retrieve the category_id based on the selected category name
					String selectedCategory = (String) addBook_category.getSelectionModel().getSelectedItem();
					int categoryId = getCategoryIdByName(selectedCategory);
					prepare.setInt(6, categoryId);

					String selectedArea = (String) addBook_area.getSelectionModel().getSelectedItem();
					int areaId = getAreaIdByName(selectedArea);
					prepare.setInt(7, areaId);

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();

					addBookShowListData();
					addBookReset();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getCategoryIdByName(String categoryName) {
		try {
			String query = "SELECT id FROM category WHERE category_name = ?";
			prepare = connect.prepareStatement(query);
			prepare.setString(1, categoryName);
			ResultSet resultSet = prepare.executeQuery();

			if (resultSet.next()) {
				return resultSet.getInt("id");
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	private int getAreaIdByName(String areaName) {
		try {
			String query = "SELECT id FROM area WHERE area_name = ?";
			prepare = connect.prepareStatement(query);
			prepare.setString(1, areaName);
			ResultSet resultSet = prepare.executeQuery();

			if (resultSet.next()) {
				return resultSet.getInt("id");
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public ObservableList<String> getAreas() {
		ObservableList<String> areas = FXCollections.observableArrayList();

		String sql = "SELECT area_name FROM area";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				areas.add(result.getString("area_name"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return areas;
	}

	public ObservableList<String> getCategories() {
		ObservableList<String> categories = FXCollections.observableArrayList();

		String sql = "SELECT category_name FROM category";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				categories.add(result.getString("category_name"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return categories;
	}

	public void addBookUpdate() {
		BookData bookData = addBook_tableView.getSelectionModel().getSelectedItem();

		if (bookData != null) {
			int bookId = bookData.getBookID();

			String sql = "UPDATE books SET book_name = ?, author_name = ?, publication_year = ?, quantity = ?, book_image = ?, category_id = ?, area_id = ? WHERE book_id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String bookName = addBook_bookName.getText().trim();
				String authorName = addBook_author.getText().trim();
				int publicationYear = Integer.parseInt(addBook_publicationYear.getText());
				String quantity = addBook_quantity.getText().trim();
				String bookImage = imagePath;
				int categoryId = getCategoryIdByName((String) addBook_category.getSelectionModel().getSelectedItem());
				int areaId = getAreaIdByName((String) addBook_area.getSelectionModel().getSelectedItem());

				if (bookName.isEmpty() && authorName.isEmpty() && quantity.isEmpty() && bookImage.isEmpty()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill all blank fields");
					alert.showAndWait();
				} else {
					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Message");
					alert.setHeaderText(null);
					alert.setContentText("Are you sure you want to UPDATE the book?");
					Optional<ButtonType> option = alert.showAndWait();

					if (option.get() == ButtonType.OK) {
						PreparedStatement prepare = connect.prepareStatement(sql);
						prepare.setString(1, bookName);
						prepare.setString(2, authorName);
						prepare.setInt(3, publicationYear);
						prepare.setString(4, quantity);
						prepare.setString(5, bookImage);
						prepare.setInt(6, categoryId);
						prepare.setInt(7, areaId);
						prepare.setInt(8, bookId);

						prepare.executeUpdate();

						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Message");
						alert.setHeaderText(null);
						alert.setContentText("Successfully Updated!");
						alert.showAndWait();

						addBookShowListData();
						addBookReset();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book to update.");
			alert.showAndWait();
		}
	}

	public void addBookDelete() {
		BookData bookData = addBook_tableView.getSelectionModel().getSelectedItem();

		if (bookData != null) {
			int bookId = bookData.getBookID();

			String sql = "DELETE FROM books WHERE book_id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				prepare = connect.prepareStatement(sql);
				prepare.setInt(1, bookId);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE this book?");

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Book deleted successfully!");
					alert.showAndWait();

					addBookShowListData();
					addBookReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book to delete.");
			alert.showAndWait();
		}
	}

	public void addBookReset() {
		addBook_bookName.setText("");
		addBook_author.setText("");
		addBook_publicationYear.setText("");
		addBook_quantity.setText("");
		addBook_area.getSelectionModel().clearSelection();
		addBook_category.getSelectionModel().clearSelection();
		addBook_image.setImage(null);
		imagePath = "";

	}

	public void addBookInsertImage() {
		FileChooser open = new FileChooser();
		File file = open.showOpenDialog(addBook_form.getScene().getWindow());

		if (file != null) {
			imagePath = file.getAbsolutePath();

			image = new Image(file.toURI().toString(), 101, 127, false, true);
			addBook_image.setImage(image);

		}
	}

	public void addBookSearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addBook_search.getText();

		FilteredList<BookData> filter = new FilteredList<>(addBookList, e -> true);

		filter.setPredicate(bookData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(bookData.getBookID()).toLowerCase().contains(searchKey)
					|| bookData.getBookName().toLowerCase().contains(searchKey)
					|| bookData.getAuthorName().toLowerCase().contains(searchKey)
					|| bookData.getPublicationYear().toLowerCase().contains(searchKey)
					|| Integer.toString(bookData.getQuantity()).toLowerCase().contains(searchKey)
					|| bookData.getCategoryName().toLowerCase().contains(searchKey)
					|| bookData.getAreaName().toLowerCase().contains(searchKey);
		});

		SortedList<BookData> sortList = new SortedList<>(filter);
		sortList.comparatorProperty().bind(addBook_tableView.comparatorProperty());

		addBook_tableView.setItems(sortList);
	}

	public ObservableList<BookData> addBookListData() {

		ObservableList<BookData> listData = FXCollections.observableArrayList();
		String sql = "SELECT books.*, category.category_name, area.area_name FROM books INNER JOIN category ON books.category_id = category.id INNER JOIN area ON books.area_id = area.id";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			BookData bookData;

			while (result.next()) {
				bookData = new BookData(result.getInt("book_id"), result.getString("book_name"),
						result.getString("author_name"), result.getString("publication_year"),
						result.getInt("quantity"), result.getString("book_image"), result.getInt("category_id"),
						result.getInt("area_id"), result.getString("category_name"), result.getString("area_name"));
				listData.add(bookData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;

	}

	private ObservableList<BookData> addBookList;

	public void addBookShowListData() {
		addBookList = addBookListData();

		addBook_col_bookID.setCellValueFactory(new PropertyValueFactory<>("bookID"));
		addBook_col_bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
		addBook_col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		addBook_col_publicationYear.setCellValueFactory(new PropertyValueFactory<>("publicationYear"));
		addBook_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		addBook_col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		addBook_col_area.setCellValueFactory(new PropertyValueFactory<>("areaName"));

		addBook_tableView.setItems(addBookList);

	}

	public void addBookSelect() {
		BookData bookData = addBook_tableView.getSelectionModel().getSelectedItem();

		if (bookData != null) {
			addBook_bookName.setText(String.valueOf(bookData.getBookName()));
			addBook_author.setText(String.valueOf(bookData.getAuthorName()));
			addBook_publicationYear.setText(String.valueOf(bookData.getPublicationYear()));
			addBook_quantity.setText(String.valueOf(bookData.getQuantity()));

			String uri = "file:" + bookData.getBookImage();
			image = new Image(uri, 101, 127, false, true);
			addBook_image.setImage(image);

			addBook_area.getSelectionModel().select(bookData.getAreaName());
			addBook_category.getSelectionModel().select(bookData.getCategoryName());
		}
	}

	public void updateBookListFromDatabase() {
		// Xóa dữ liệu hiện có trong addBook_tableView
		addBook_tableView.getItems().clear();

		// Truy vấn cơ sở dữ liệu để lấy dữ liệu sách mới
		ObservableList<BookData> newBookList = getBookListFromDatabase();

		// Cập nhật addBook_tableView bằng dữ liệu mới
		addBook_tableView.setItems(newBookList);
	}

	public ObservableList<BookData> getBookListFromDatabase() {
		ObservableList<BookData> listData = FXCollections.observableArrayList();
		String sql = "SELECT books.*, category.category_name, area.area_name FROM books INNER JOIN category ON books.category_id = category.id INNER JOIN area ON books.area_id = area.id";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			BookData bookData;

			while (result.next()) {
				bookData = new BookData(result.getInt("book_id"), result.getString("book_name"),
						result.getString("author_name"), result.getString("publication_year"),
						result.getInt("quantity"), result.getString("book_image"), result.getInt("category_id"),
						result.getInt("area_id"), result.getString("category_name"), result.getString("area_name"));
				listData.add(bookData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;
	}
	
	@FXML
	private void viewStaticis(ActionEvent event) throws IOException {
	    // Tạo một mới màn hình (scene) cho StaticisChartView
	    Parent root = FXMLLoader.load(getClass().getResource("/views/StaticisChartView.fxml"));
	    Scene staticisScene = new Scene(root);

	    // Lấy cửa sổ hiện tại
	    Scene scene = staticis_viewChartBtn.getScene();
	    Stage stage = (Stage) scene.getWindow();

	    // Đặt màn hình mới cho cửa sổ hiện tại
	    stage.setScene(staticisScene);
	    stage.show();
	}


//---------------------------------------------------------------------------------------------
	// CRUD EMPLOYEES
	public void addEmployeeAdd() {
		String sql = "INSERT INTO users (fullname, username, email, phone_number, password_hash, gender, user_image, address, arrive_date, role) VALUES(?,?,?,?,?,?,?,?,?,?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			String fullname = addEmployee_fullname.getText().trim();
			String username = addEmployee_username.getText().trim();
			String email = addEmployee_email.getText().trim();
			String phone = addEmployee_phone.getText().trim();
			String passwordHash = addEmployee_password.getText().trim();
			String gender = (String) addEmployee_gender.getSelectionModel().getSelectedItem();
			String userImage = imagePath;
			String address = addEmployee_address.getText().trim();
			LocalDate arriveDate = addEmployee_arriveDate.getValue();
			int role = 0;

			if (fullname.isEmpty() || username.isEmpty() || email.isEmpty() || phone.isEmpty() || passwordHash.isEmpty()
					|| gender == null || userImage == null || address == null || arriveDate == null) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill all fields");
				alert.showAndWait();
			} else {
				if (!isValidEmail(email)) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Invalid email format");
					alert.showAndWait();
				} else if (!isValidPhoneNumber(phone)) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Invalid phone number format");
					alert.showAndWait();
				} else {
					PreparedStatement prepare = connect.prepareStatement(sql);
					prepare.setString(1, fullname);
					prepare.setString(2, username);
					prepare.setString(3, email);
					prepare.setString(4, phone);
					prepare.setString(5, passwordHash);
					prepare.setString(6, gender);
					prepare.setString(7, userImage);
					prepare.setString(8, address);
					prepare.setDate(9, java.sql.Date.valueOf(arriveDate));
					prepare.setInt(10, role);

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();

					addEmployeeShowListData();
					addEmployeeReset();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addEmployeeUpdate() {
		EmployeeData employeeData = addEmployee_tableView.getSelectionModel().getSelectedItem();

		if (employeeData != null) {
			int employeeId = employeeData.getEmployeeID();

			String sql = "UPDATE users SET fullname = ?, username = ?, email = ?, phone_number = ?, password_hash = ?, gender = ?, user_image = ?, address = ?, arrive_date = ?, role = ? WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String fullname = addEmployee_fullname.getText().trim();
				String username = addEmployee_username.getText().trim();
				String email = addEmployee_email.getText().trim();
				String phone = addEmployee_phone.getText().trim();
				String passwordHash = addEmployee_password.getText().trim();
				String gender = (String) addEmployee_gender.getSelectionModel().getSelectedItem();
				String userImage = imagePath;
				String address = addEmployee_address.getText().trim();
				LocalDate arriveDate = addEmployee_arriveDate.getValue();
				int role = 0;

				if (fullname.isEmpty() && email.isEmpty() && phone.isEmpty() && passwordHash.isEmpty() && gender == null
						&& userImage == null && address == null && arriveDate == null) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill all fields");
					alert.showAndWait();
				} else {
					if (!isValidEmail(email)) {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Message");
						alert.setHeaderText(null);
						alert.setContentText("Invalid email format");
						alert.showAndWait();
					} else if (!isValidPhoneNumber(phone)) {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Message");
						alert.setHeaderText(null);
						alert.setContentText("Invalid phone number format");
						alert.showAndWait();
					} else {
						alert = new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Confirmation Message");
						alert.setHeaderText(null);
						alert.setContentText("Are you sure you want to UPDATE the employee?");
						Optional<ButtonType> option = alert.showAndWait();

						if (option.get() == ButtonType.OK) {
							PreparedStatement prepare = connect.prepareStatement(sql);
							prepare.setString(1, fullname);
							prepare.setString(2, username);
							prepare.setString(3, email);
							prepare.setString(4, phone);
							prepare.setString(5, passwordHash);
							prepare.setString(6, gender);
							prepare.setString(7, userImage);
							prepare.setString(8, address);
							prepare.setDate(9, java.sql.Date.valueOf(arriveDate));
							prepare.setInt(10, role);
							prepare.setInt(11, employeeId);

							prepare.executeUpdate();

							alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Information Message");
							alert.setHeaderText(null);
							alert.setContentText("Successfully Updated!");
							alert.showAndWait();

							addEmployeeShowListData();
							addEmployeeReset();
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select an employee to update.");
			alert.showAndWait();
		}
	}

	public void addEmployeeDelete() {
		EmployeeData employeeData = addEmployee_tableView.getSelectionModel().getSelectedItem();

		if (employeeData != null) {
			int employeeId = employeeData.getEmployeeID();

			String sql = "DELETE FROM users WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE the employee?");
				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					PreparedStatement prepare = connect.prepareStatement(sql);
					prepare.setInt(1, employeeId);

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Deleted!");
					alert.showAndWait();

					addEmployeeShowListData();
					addEmployeeReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select an employee to delete.");
			alert.showAndWait();
		}
	}

	public void addEmployeeReset() {
		addEmployee_fullname.setText("");
		addEmployee_username.setText("");
		addEmployee_email.setText("");
		addEmployee_phone.setText("");
		addEmployee_password.setText("");
		addEmployee_gender.getSelectionModel().clearSelection();
		addEmployee_address.setText("");
		addEmployee_arriveDate.setPromptText("");
		addEmployee_image.setImage(null);
		imagePath = "";
	}

	public void addEmployeeGenderList() {
		List<String> listGender = new ArrayList<>();

		for (String data : genderList) {
			listGender.add(data);
		}

		ObservableList listData1 = FXCollections.observableArrayList(listGender);
		addEmployee_gender.setItems(listData1);
	}

	public void addEmployeeInsertImage() {
		FileChooser open = new FileChooser();
		File file = open.showOpenDialog(addEmployee_form.getScene().getWindow());

		if (file != null) {
			imagePath = file.getAbsolutePath();

			image = new Image(file.toURI().toString(), 101, 127, false, true);
			addEmployee_image.setImage(image);

		}
	}

	public void addEmployeeSearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addEmployee_search.getText();

		FilteredList<EmployeeData> filter = new FilteredList<>(addEmployeeList, e -> true);

		filter.setPredicate(employeeData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(employeeData.getEmployeeID()).toLowerCase().contains(searchKey)
					|| employeeData.getUserName().toLowerCase().contains(searchKey)
					|| employeeData.getFullName().toLowerCase().contains(searchKey)
					|| employeeData.getPhoneNumber().toLowerCase().contains(searchKey)
					|| employeeData.getEmail().toLowerCase().contains(searchKey)
					|| employeeData.getGender().toLowerCase().contains(searchKey)
					|| employeeData.getAddress().toLowerCase().contains(searchKey)
					|| employeeData.getArriveDate().toString().toLowerCase().contains(searchKey);
		});

		SortedList<EmployeeData> sortList = new SortedList<>(filter);
		sortList.comparatorProperty().bind(addEmployee_tableView.comparatorProperty());

		addEmployee_tableView.setItems(sortList);
	}

	public ObservableList<EmployeeData> addEmployeeListData() {

		ObservableList<EmployeeData> listData = FXCollections.observableArrayList();
		String sql = "SELECT * FROM users WHERE ROLE = 0";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			EmployeeData employeeData;

			while (result.next()) {
				employeeData = new EmployeeData(result.getInt("id"), result.getString("fullname"),
						result.getString("username"), result.getString("email"), result.getString("phone_number"),
						result.getString("password_hash"), result.getString("gender"), result.getString("user_image"),
						result.getString("address"), result.getDate("arrive_date"), result.getInt("role"));
				listData.add(employeeData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listData;

	}

	private ObservableList<EmployeeData> addEmployeeList;

	public void addEmployeeShowListData() {
		addEmployeeList = addEmployeeListData();

		addEmployee_col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
		addEmployee_col_username.setCellValueFactory(new PropertyValueFactory<>("userName"));
		addEmployee_col_fullname.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		addEmployee_col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		addEmployee_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		addEmployee_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		addEmployee_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
		addEmployee_col_arriveDate.setCellValueFactory(new PropertyValueFactory<>("arriveDate"));

		addEmployee_tableView.setItems(addEmployeeList);

	}

	public void addEmployeeSelect() {
		EmployeeData employeeData = addEmployee_tableView.getSelectionModel().getSelectedItem();

		if (employeeData != null) {
			addEmployee_username.setText(String.valueOf(employeeData.getUserName()));
			addEmployee_password.setText(String.valueOf(employeeData.getPassword()));
			addEmployee_fullname.setText(String.valueOf(employeeData.getFullName()));
			addEmployee_phone.setText(String.valueOf(employeeData.getPhoneNumber()));
			addEmployee_email.setText(String.valueOf(employeeData.getEmail()));
			addEmployee_gender.setPromptText(employeeData.getGender());

			Date arriveDate = employeeData.getArriveDate();
			if (arriveDate != null) {
				addEmployee_arriveDate.setPromptText(arriveDate.toString());
			} else {
				addEmployee_arriveDate.setPromptText("");
			}

			addEmployee_address.setText(String.valueOf(employeeData.getAddress()));

			String uri = "file:" + employeeData.getEmployeeImage();
			image = new Image(uri, 101, 127, false, true);
			addEmployee_image.setImage(image);
		}
	}

//---------------------------------------------------------------------------------------------	

//	// CRUD CUSTOMERS

	public void addCustomerAdd() {

		Date date = new Date(0);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		String sql = "INSERT INTO customer (fullname, email, gender, phone_number, arrive_date, status) VALUES(?,?,?,?,?,?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			String fullname = addCustomer_fullname.getText().trim();
			String email = addCustomer_email.getText().trim();
			String gender = (String) addCustomer_gender.getSelectionModel().getSelectedItem();
			String phone = addCustomer_phone.getText().trim();
			LocalDate arriveDate = addCustomer_arriveDate.getValue();
			String status = (String) addCustomer_status.getSelectionModel().getSelectedItem();

			if (fullname.isEmpty() || email.isEmpty() || gender == null || phone.isEmpty() || arriveDate == null
					|| status == null) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill all fields");
				alert.showAndWait();
			} else {
				if (!isValidEmail(email)) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Invalid email format");
					alert.showAndWait();
				} else if (!isValidPhoneNumber(phone)) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Invalid phone number format");
					alert.showAndWait();
				} else {
					prepare = connect.prepareStatement(sql);
					prepare.setString(1, fullname);
					prepare.setString(2, email);
					prepare.setString(3, gender);
					prepare.setString(4, phone);
					prepare.setDate(5, java.sql.Date.valueOf(arriveDate));
					prepare.setString(6, status);

					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Successfully Added!");
					alert.showAndWait();

					addCustomerShowListData();
					addCustomerReset();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
		return email.matches(emailRegex);
	}

	private boolean isValidPhoneNumber(String phone) {
		String phoneRegex = "^[0-9]{10}$";
		return phone.matches(phoneRegex);
	}

	public void addCustomerUpdate() {
		CustomerData customerData = addCustomer_tableView.getSelectionModel().getSelectedItem();

		if (customerData != null) {
			int customerID = customerData.getCustomerID();

			String sql = "UPDATE customer SET fullname = ?, email = ?, gender = ?, phone_number = ?, arrive_date = ?, status = ? WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String fullname = addCustomer_fullname.getText().trim();
				String email = addCustomer_email.getText().trim();
				String gender = (String) addCustomer_gender.getSelectionModel().getSelectedItem();
				String phone = addCustomer_phone.getText().trim();
				LocalDate arriveDate = addCustomer_arriveDate.getValue();
				String status = (String) addCustomer_status.getSelectionModel().getSelectedItem();

				if (fullname.isEmpty() && email.isEmpty() && gender == null && phone.isEmpty() && arriveDate == null
						&& status == null) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill all blank fields");
					alert.showAndWait();
				} else {
					if (!isValidEmail(email)) {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Message");
						alert.setHeaderText(null);
						alert.setContentText("Invalid email format");
						alert.showAndWait();
					} else if (!isValidPhoneNumber(phone)) {
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error Message");
						alert.setHeaderText(null);
						alert.setContentText("Invalid phone number format");
						alert.showAndWait();
					} else {
						if (arriveDate == null) {
							alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error Message");
							alert.setHeaderText(null);
							alert.setContentText("Please select an arrival date.");
							alert.showAndWait();
						} else {
							alert = new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Confirmation Message");
							alert.setHeaderText(null);
							alert.setContentText("Are you sure you want to UPDATE customer");
							Optional<ButtonType> option = alert.showAndWait();

							if (option.get() == ButtonType.OK) {
								prepare = connect.prepareStatement(sql);
								prepare.setString(1, fullname);
								prepare.setString(2, email);
								prepare.setString(3, gender);
								prepare.setString(4, phone);
								prepare.setDate(5, java.sql.Date.valueOf(arriveDate));
								prepare.setString(6, status);
								prepare.setInt(7, customerID);

								prepare.executeUpdate();

								alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Information Message");
								alert.setHeaderText(null);
								alert.setContentText("Successfully Updated!");
								alert.showAndWait();

								addCustomerShowListData();
								addCustomerReset();
							}
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a customer to update.");
			alert.showAndWait();
		}
	}

	public void addCustomerDelete() {
		CustomerData customerData = addCustomer_tableView.getSelectionModel().getSelectedItem();

		if (customerData != null) {
			int customerID = customerData.getCustomerID();

			String sql = "DELETE FROM customer WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				prepare = connect.prepareStatement(sql);
				prepare.setInt(1, customerID);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE this customer?");

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Customer deleted successfully!");
					alert.showAndWait();

					addCustomerShowListData();
					addCustomerReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a customer to delete.");
			alert.showAndWait();
		}
	}

	public void addCustomerReset() {
		addCustomer_fullname.setText("");
		addCustomer_phone.setText("");
		addCustomer_email.setText("");
		addCustomer_arriveDate.setPromptText("");
		addCustomer_gender.getSelectionModel().clearSelection();
		addCustomer_status.getSelectionModel().clearSelection();
	}

	private String[] genderList = { "Male", "Female" };

	public void addCustomerGenderList() {
		List<String> listGender = new ArrayList<>();

		for (String data : genderList) {
			listGender.add(data);
		}

		ObservableList listData1 = FXCollections.observableArrayList(listGender);
		addCustomer_gender.setItems(listData1);
	}

	private String[] statusList = { "The customer has returned the book", "The customer has not returned the book" };

	public void addCustomerStatusList() {
		List<String> listStatus = new ArrayList<>();

		for (String data : statusList) {
			listStatus.add(data);
		}

		ObservableList listData1 = FXCollections.observableArrayList(listStatus);
		addCustomer_status.setItems(listData1);
	}

	public void addCustomerSearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addCustomer_search.getText();

		FilteredList<CustomerData> filter = new FilteredList<>(addCustomerList, e -> true);

		filter.setPredicate(customerData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(customerData.getCustomerID()).toLowerCase().contains(searchKey)
					|| customerData.getFullName().toLowerCase().contains(searchKey)
					|| customerData.getPhoneNumber().toLowerCase().contains(searchKey)
					|| customerData.getEmail().toLowerCase().contains(searchKey)
					|| customerData.getGender().toLowerCase().contains(searchKey)
					|| customerData.getArriveDate().toString().toLowerCase().contains(searchKey)
					|| customerData.getStatus().toLowerCase().contains(searchKey);
		});

		SortedList<CustomerData> sortList = new SortedList<>(filter);
		sortList.comparatorProperty().bind(addCustomer_tableView.comparatorProperty());
		addCustomer_tableView.setItems(sortList);
	}

	public ObservableList<CustomerData> addCustomerListData() {

		ObservableList<CustomerData> listData1 = FXCollections.observableArrayList();
		String sql = "SELECT * FROM customer";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			CustomerData customerData;

			while (result.next()) {
				customerData = new CustomerData(result.getInt("id"), result.getString("fullname"),
						result.getString("email"), result.getString("gender"), result.getString("phone_number"),
						result.getDate("arrive_date"), result.getString("status"));
				listData1.add(customerData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listData1;

	}

	private ObservableList<CustomerData> addCustomerList;

	public void addCustomerShowListData() {
		addCustomerList = addCustomerListData();

		addCustomer_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
		addCustomer_col_fullname.setCellValueFactory(new PropertyValueFactory<>("fullName"));
		addCustomer_col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
		addCustomer_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		addCustomer_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		addCustomer_col_arriveDate.setCellValueFactory(new PropertyValueFactory<>("arriveDate"));
		addCustomer_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

		addCustomer_tableView.setItems(addCustomerList);
	}

	public void addCustomerSelect() {

		CustomerData customerData = addCustomer_tableView.getSelectionModel().getSelectedItem();
		if (customerData != null) {
			addCustomer_fullname.setText(customerData.getFullName());
			addCustomer_phone.setText(customerData.getPhoneNumber());
			addCustomer_email.setText(customerData.getEmail());
			addCustomer_gender.setPromptText(customerData.getGender());
			addCustomer_arriveDate.setPromptText(customerData.getArriveDate().toString());
			addCustomer_status.setPromptText(customerData.getStatus());
		}

	}

//----------------------------------------------------------------------------------------------------
	// CRUD AREA

	public void addAreaAdd() {

		String sql = "INSERT INTO area (area_name) VALUES(?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			String areaname = addArea_name.getText().trim();

			if (areaname.isEmpty()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill area name");
				alert.showAndWait();
			} else {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, areaname);

				prepare.executeUpdate();

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("Successfully Added!");
				alert.showAndWait();

				addAreaShowListData();
				addAreaReset();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addAreaUpdate() {
		AreaData areaData = addArea_tableView.getSelectionModel().getSelectedItem();

		if (areaData != null) {
			int areaID = areaData.getAreaID();

			String sql = "UPDATE area SET area_name = ? WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String areaname = addArea_name.getText().trim();

				if (areaname.isEmpty()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill area name");
					alert.showAndWait();
				} else {
					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Message");
					alert.setHeaderText(null);
					alert.setContentText("Are you sure you want to UPDATE area");
					Optional<ButtonType> option = alert.showAndWait();

					if (option.get() == ButtonType.OK) {
						prepare = connect.prepareStatement(sql);
						prepare.setString(1, areaname);
						prepare.setInt(2, areaID);

						prepare.executeUpdate();

						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Message");
						alert.setHeaderText(null);
						alert.setContentText("Successfully Updated!");
						alert.showAndWait();

						addAreaShowListData();
						addAreaReset();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a area to update.");
			alert.showAndWait();
		}

	}

	public void addAreaDelete() {
		AreaData areaData = addArea_tableView.getSelectionModel().getSelectedItem();

		if (areaData != null) {
			int areaID = areaData.getAreaID();

			String sql = "DELETE FROM area WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				prepare = connect.prepareStatement(sql);
				prepare.setInt(1, areaID);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE this area?");

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Area deleted successfully!");
					alert.showAndWait();

					addAreaShowListData();
					addAreaReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a area to delete.");
			alert.showAndWait();
		}
	}

	public void addAreaReset() {
		addArea_name.setText("");
	}

	public void addAreaSearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addArea_search.getText();

		FilteredList<AreaData> filter2 = new FilteredList<>(addAreaList, e -> true);

		filter2.setPredicate(areaData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(areaData.getAreaID()).toLowerCase().contains(searchKey)
					|| areaData.getAreaName().toLowerCase().contains(searchKey);

		});

		SortedList<AreaData> sortList2 = new SortedList<>(filter2);
		sortList2.comparatorProperty().bind(addArea_tableView.comparatorProperty());
		addArea_tableView.setItems(sortList2);
	}

	public ObservableList<AreaData> addAreaListData() {

		ObservableList<AreaData> listData2 = FXCollections.observableArrayList();
		String sql = "SELECT * FROM area";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			AreaData areaData;

			while (result.next()) {
				areaData = new AreaData(result.getInt("id"), result.getString("area_name"));
				listData2.add(areaData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listData2;

	}

	private ObservableList<AreaData> addAreaList;

	public void addAreaShowListData() {
		addAreaList = addAreaListData();

		addArea_col_areaID.setCellValueFactory(new PropertyValueFactory<>("areaID"));
		addArea_col_areaName.setCellValueFactory(new PropertyValueFactory<>("areaName"));

		addArea_tableView.setItems(addAreaList);
	}

	public void addAreaSelect() {

		AreaData areaData = addArea_tableView.getSelectionModel().getSelectedItem();
		if (areaData != null) {
			addArea_name.setText(areaData.getAreaName());
		}

	}

	// ----------------------------------------------------------------------------------------------------
	// CRUD CATEGORY

	public void addCategoryAdd() {

		String sql = "INSERT INTO category (category_name) VALUES(?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			Alert alert;

			String categoryname = addCategory_name.getText().trim();

			if (categoryname.isEmpty()) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error Message");
				alert.setHeaderText(null);
				alert.setContentText("Please fill category name");
				alert.showAndWait();
			} else {
				prepare = connect.prepareStatement(sql);
				prepare.setString(1, categoryname);

				prepare.executeUpdate();

				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Message");
				alert.setHeaderText(null);
				alert.setContentText("Successfully Added!");
				alert.showAndWait();

				addCategoryShowListData();
				addCategoryReset();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addCategoryUpdate() {
		CategoryData categoryData = addCategory_tableView.getSelectionModel().getSelectedItem();

		if (categoryData != null) {
			int categoryID = categoryData.getCategoryID();

			String sql = "UPDATE category SET category_name = ? WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				Alert alert;

				String categoryname = addCategory_name.getText().trim();

				if (categoryname.isEmpty()) {
					alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Message");
					alert.setHeaderText(null);
					alert.setContentText("Please fill category name");
					alert.showAndWait();
				} else {
					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Message");
					alert.setHeaderText(null);
					alert.setContentText("Are you sure you want to UPDATE category");
					Optional<ButtonType> option = alert.showAndWait();

					if (option.get() == ButtonType.OK) {
						prepare = connect.prepareStatement(sql);
						prepare.setString(1, categoryname);
						prepare.setInt(2, categoryID);

						prepare.executeUpdate();

						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Information Message");
						alert.setHeaderText(null);
						alert.setContentText("Successfully Updated!");
						alert.showAndWait();

						addCategoryShowListData();
						addCategoryReset();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a category to update.");
			alert.showAndWait();
		}

	}

	public void addCategoryDelete() {
		CategoryData categoryData = addCategory_tableView.getSelectionModel().getSelectedItem();

		if (categoryData != null) {
			int categoryID = categoryData.getCategoryID();

			String sql = "DELETE FROM category WHERE id = ?";

			DbConnection dbc = DbConnection.getDatabaseConnection();
			connect = dbc.getConnection();

			try {
				prepare = connect.prepareStatement(sql);
				prepare.setInt(1, categoryID);

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Message");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to DELETE this category?");

				Optional<ButtonType> option = alert.showAndWait();

				if (option.get() == ButtonType.OK) {
					prepare.executeUpdate();

					alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Message");
					alert.setHeaderText(null);
					alert.setContentText("Category deleted successfully!");
					alert.showAndWait();

					addCategoryShowListData();
					addCategoryReset();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Message");
			alert.setHeaderText(null);
			alert.setContentText("Please select a category to delete.");
			alert.showAndWait();
		}
	}

	public void addCategoryReset() {
		addCategory_name.setText("");
	}

	public void addCategorySearch(KeyEvent event) {
		// Lấy giá trị nhập vào từ TextField
		String searchValue = addCategory_search.getText();

		FilteredList<CategoryData> filter3 = new FilteredList<>(addCategoryList, e -> true);

		filter3.setPredicate(categoryData -> {
			if (searchValue == null || searchValue.isEmpty()) {
				return true;
			}

			String searchKey = searchValue.toLowerCase().trim();

			return Integer.toString(categoryData.getCategoryID()).toLowerCase().contains(searchKey)
					|| categoryData.getCategoryName().toLowerCase().contains(searchKey);

		});

		SortedList<CategoryData> sortList3 = new SortedList<>(filter3);
		sortList3.comparatorProperty().bind(addCategory_tableView.comparatorProperty());
		addCategory_tableView.setItems(sortList3);
	}

	public ObservableList<CategoryData> addCategoryListData() {

		ObservableList<CategoryData> listData3 = FXCollections.observableArrayList();
		String sql = "SELECT * FROM category";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();
			CategoryData categoryData;

			while (result.next()) {
				categoryData = new CategoryData(result.getInt("id"), result.getString("category_name"));
				listData3.add(categoryData);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listData3;

	}

	private ObservableList<CategoryData> addCategoryList;

	private int selectedBookId;

	public void addCategoryShowListData() {
		addCategoryList = addCategoryListData();

		addCategory_col_categoryID.setCellValueFactory(new PropertyValueFactory<>("categoryID"));
		addCategory_col_categoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

		addCategory_tableView.setItems(addCategoryList);
	}

	public void addCategorySelect() {

		CategoryData categoryData = addCategory_tableView.getSelectionModel().getSelectedItem();
		if (categoryData != null) {
			addCategory_name.setText(categoryData.getCategoryName());
		}

	}
//------------------------------------------------------------------------------------------------------

	// LOGOUT

	@FXML
	private void Logout(ActionEvent event) throws IOException {
		Alert alert;
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to logout?");
		Optional<ButtonType> option = alert.showAndWait();

		if (option.get() == ButtonType.OK) {
			Scene scene = logout.getScene();
			Stage stage = (Stage) scene.getWindow();
			stage.close();

			Parent root = FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));

			Scene newScene = new Scene(root);

			stage.setScene(newScene);
			stage.setTitle("Library Management");
			stage.show();
		}
	}

//-------------------------------------------------------------------------------------------------------
	// CHANGE PASSWORD
	@FXML
	private void ChangePass(ActionEvent event) throws IOException {
		Alert alert;
		alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to change password?");
		Optional<ButtonType> option = alert.showAndWait();

		if (option.get() == ButtonType.OK) {
			Scene scene = logout.getScene();
			Stage stage = (Stage) scene.getWindow();
			stage.close();

			Parent root = FXMLLoader.load(getClass().getResource("/views/ChangePasswordView.fxml"));

			Scene newScene = new Scene(root);

			stage.setScene(newScene);
			stage.setTitle("Library Management");
			stage.show();
		}
	}

//-------------------------------------------------------------------------------------------------------
	// POS
	public Map<String, List<BookData>> getCategoryData() {
		Map<String, List<BookData>> categoryDataMap = new HashMap<>();
		String sql = "SELECT books.book_id, category.category_name, books.book_name, books.quantity, books.author_name, books.publication_year, books.book_image, books.category_id, books.area_id, category.category_name AS category_name, area.area_name AS area_name "
				+ "FROM category " + "INNER JOIN books ON category.id = books.category_id "
				+ "INNER JOIN area ON books.area_id = area.id"; // Bổ sung INNER JOIN để lấy area_name

		DbConnection dbc = DbConnection.getDatabaseConnection();
		connect = dbc.getConnection();

		try {
			prepare = connect.prepareStatement(sql);
			result = prepare.executeQuery();

			while (result.next()) {
				int id = result.getInt("book_id");
				String categoryName = result.getString("category_name");
				String bookName = result.getString("book_name");
				int quantity = result.getInt("quantity");
				String authorName = result.getString("author_name");
				String publicationYear = result.getString("publication_year");
				String bookImage = result.getString("book_image");
				int categoryId = result.getInt("category_id");
				int areaId = result.getInt("area_id");
				String areaName = result.getString("area_name");

				// Kiểm tra xem danh mục đã tồn tại trong Map chưa
				if (!categoryDataMap.containsKey(categoryName)) {
					categoryDataMap.put(categoryName, new ArrayList<>());
				}

				// Thêm sách vào danh sách sách của danh mục
				categoryDataMap.get(categoryName).add(new BookData(id, bookName, authorName, publicationYear, quantity,
						bookImage, categoryId, areaId, categoryName, areaName));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return categoryDataMap;
	}

	private Map<String, List<BookData>> categoryDataMap = getCategoryData();

	public void populateCategoryTabs() {

		for (Map.Entry<String, List<BookData>> entry : categoryDataMap.entrySet()) {
			String categoryName = entry.getKey();
			List<BookData> books = entry.getValue();

			Tab categoryTab = new Tab(categoryName);

			// Tạo nội dung cho mỗi tab ở đây.
			// Sử dụng TableView hoặc các điều khiển khác để hiển thị dữ liệu danh mục và
			// sách trong danh mục.

			// Ở đây, bạn có thể sử dụng TableView để hiển thị danh sách sách (books) trong
			// danh mục.
			TableView<BookData> bookTableView = createBookTableView(books);

			categoryTab.setContent(bookTableView);

			categoryTabPane.getTabs().add(categoryTab);
		}
	}

	private void updateCategoryTabPane() {
		if (categoryDataMap != null && !categoryDataMap.isEmpty()) {
			categoryTabPane.getTabs().clear(); // Xóa tất cả các tab hiện có

			for (Map.Entry<String, List<BookData>> entry : categoryDataMap.entrySet()) {
				String categoryName = entry.getKey();
				List<BookData> books = entry.getValue();

				Tab categoryTab = new Tab(categoryName);
				TableView<BookData> bookTableView = createBookTableView(books);
				categoryTab.setContent(bookTableView);
				categoryTabPane.getTabs().add(categoryTab);
			}
		}
	}

	private List<BorrowedBookInfo> borrowedBooksList = new ArrayList<>(); // Danh sách lưu thông tin sách và số lượng

	@FXML
	private void orderBook(ActionEvent event) {
		// Kiểm tra xem tab được chọn trong categoryTabPane
		Tab selectedTab = categoryTabPane.getSelectionModel().getSelectedItem();
		if (selectedTab != null) {
			Node tabContent = selectedTab.getContent();
			if (tabContent instanceof TableView) {
				TableView<BookData> bookTableView = (TableView<BookData>) tabContent;
				BookData selectedBook = bookTableView.getSelectionModel().getSelectedItem();
				if (selectedBook != null) {
					// Lấy thông tin sách đã chọn
					int bookId = selectedBook.getBookID();
					String bookName = selectedBook.getBookName();
					int selectedQuantity = Integer.parseInt(posQuantity.getText()); // Lấy giá trị từ posQuantity

					// Kiểm tra xem sách đã có trong danh sách mượn hay chưa
					boolean isBookInList = false;
					for (BorrowedBookInfo borrowedBookInfo : borrowedBooksList) {
						if (borrowedBookInfo.getBook().getBookID() == bookId) {
							// Sách đã có trong danh sách mượn, cộng thêm số lượng
							int currentQuantity = borrowedBookInfo.getQuantity();
							borrowedBookInfo.setQuantity(currentQuantity + selectedQuantity);
							isBookInList = true;
							break;
						}
					}

					if (!isBookInList) {
						// Sách chưa có trong danh sách mượn, thêm thông tin sách mới vào danh sách mượn
						BorrowedBookInfo borrowedBookInfo = new BorrowedBookInfo(selectedBook, selectedQuantity);
						borrowedBooksList.add(borrowedBookInfo);
					}

					// Giảm số lượng sách trong danh sách gốc
					selectedBook.setQuantity(selectedBook.getQuantity() - selectedQuantity);

					// Cập nhật số lượng sách ban đầu trong categoryTabPane
					updateCategoryTabPane();

					// Cập nhật borrowBook_tableView
					updateBorrowBookTableView();

					// Cập nhật số lượng sách trong cơ sở dữ liệu (thực hiện sau)
					updateBookQuantityInDatabase(bookId, selectedBook.getQuantity());
				}
			}
		}
	}

	private void updateBorrowBookTableView() {
		// Tạo một danh sách tạm thời để lưu trữ các cuốn sách có quantity > 0
		List<BookData> booksWithQuantityGreaterThanZero = new ArrayList<>();

		// Duyệt qua danh sách sách đã mượn và cập nhật lại borrowBook_tableView
		for (BorrowedBookInfo borrowedBookInfo : borrowedBooksList) {
			BookData book = borrowedBookInfo.getBook();
			int quantity = borrowedBookInfo.getQuantity();

			if (quantity > 0) {
				// Thêm các cuốn sách có quantity > 0 vào danh sách tạm thời
				booksWithQuantityGreaterThanZero.add(book);
			}
		}

		// Xóa tất cả dữ liệu hiện tại trong borrowBook_tableView
		borrowBook_tableView.getItems().clear();

		// Tạo cột "bookQuantityColumn" và gán giá trị dựa vào danh sách tạm thời
		TableColumn<BookData, Integer> bookQuantityColumn = borrowBook_col_bookQuantity;
		bookQuantityColumn.setCellValueFactory(cellData -> {
			BookData book = cellData.getValue();
			for (BorrowedBookInfo borrowedBookInfo : borrowedBooksList) {
				if (borrowedBookInfo.getBook().getBookID() == book.getBookID()) {
					return new SimpleIntegerProperty(borrowedBookInfo.getQuantity()).asObject();
				}
			}
			return new SimpleIntegerProperty(0).asObject(); // Trả về 0 nếu không tìm thấy
		});

		// Tạo cột "bookNameColumn" và gán giá trị từ dữ liệu sách trong danh sách tạm
		// thời
		TableColumn<BookData, String> bookNameColumn = borrowBook_col_bookName;
		bookNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookName()));

		// Thêm lại các cuốn sách có quantity > 0 vào borrowBook_tableView
		borrowBook_tableView.getItems().addAll(booksWithQuantityGreaterThanZero);
	}

	private void updateBookQuantityInDatabase(int bookId, int newQuantity) {
		String sql = "UPDATE books SET quantity = ? WHERE book_id = ?";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		Connection connect = dbc.getConnection();
		PreparedStatement prepare = null;

		try {
			prepare = connect.prepareStatement(sql);
			prepare.setInt(1, newQuantity);
			prepare.setInt(2, bookId);

			int rowsAffected = prepare.executeUpdate();

			if (rowsAffected > 0) {

			} else {
				showAlert("Lỗi", "Không thể cập nhật số lượng sách trong cơ sở dữ liệu.", Alert.AlertType.ERROR);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Đóng PreparedStatement
			if (prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public TableView<BookData> createBookTableView(List<BookData> books) {
		TableView<BookData> tableView = new TableView<>();
		TableColumn<BookData, String> nameColumn = new TableColumn<>("Book Name");
		TableColumn<BookData, Integer> quantityColumn = new TableColumn<>("Quantity");

		// Đặt chiều rộng cho cột Book Name
		nameColumn.setPrefWidth(213);

		// Đặt chiều rộng cho cột Quantity
		quantityColumn.setPrefWidth(70);

		// Đặt giá trị cho cột Book Name từ dữ liệu sách
		nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBookName()));

		// Đặt giá trị cho cột Quantity từ dữ liệu sách
		quantityColumn.setCellValueFactory(cellData -> {
			IntegerBinding integerBinding = Bindings.createIntegerBinding(() -> cellData.getValue().getQuantity());
			return integerBinding.asObject();
		});

		// Thêm cột vào TableView
		tableView.getColumns().addAll(nameColumn, quantityColumn);

		// Đặt dữ liệu sách vào TableView
		tableView.setItems(FXCollections.observableArrayList(books));

		return tableView;
	}

	public void selectBookFromCategoryTab() {
		Tab selectedTab = categoryTabPane.getSelectionModel().getSelectedItem();
		if (selectedTab != null) {
			Node tabContent = selectedTab.getContent();
			if (tabContent instanceof TableView) {
				TableView<BookData> bookTableView = (TableView<BookData>) tabContent;
				BookData selectedBook = bookTableView.getSelectionModel().getSelectedItem();
				if (selectedBook != null) {
					// Hiển thị thông tin sách trong các trường thông tin
					posDetailBookName.setText(selectedBook.getBookName());

					String uri = "file:" + selectedBook.getBookImage();
					image = new Image(uri, 101, 127, false, true);
					posDetailBookImage.setImage(image);

					// Reset quantityBook và posQuantity về 1 khi chọn hàng mới
					quantityBook = 1;
					posQuantity.setText(Integer.toString(quantityBook));
				}
			}
		}
	}

	private int quantityBook = 1;

	@FXML
	private void plusQuantity(ActionEvent event) {
		Tab selectedTab = categoryTabPane.getSelectionModel().getSelectedItem();
		if (selectedTab != null) {
			Node tabContent = selectedTab.getContent();
			if (tabContent instanceof TableView) {
				TableView<BookData> bookTableView = (TableView<BookData>) tabContent;
				BookData selectedBook = bookTableView.getSelectionModel().getSelectedItem();
				if (selectedBook != null) {
					int maxQuantity = selectedBook.getQuantity();
					if (quantityBook < maxQuantity) {
						quantityBook++;
						posQuantity.setText(Integer.toString(quantityBook));
					} else {
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setTitle("Lỗi");
						alert.setHeaderText(null);
						alert.setContentText("Không thể tăng số lượng được nữa.");
						alert.showAndWait();
					}
				}
			}
		}
	}

	@FXML
	private void minusQuantity(ActionEvent event) {
		if (quantityBook > 1) {
			quantityBook--;
			posQuantity.setText(Integer.toString(quantityBook));
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Lỗi");
			alert.setHeaderText(null);
			alert.setContentText("Không thể giảm số lượng dưới 1.");
			alert.showAndWait();
		}
	}

	@FXML
	private void confirmOrder(ActionEvent event) {
		// Lấy thông tin sách từ borrowedBooksList
		EmployeeData currentUser = UserController.getLoggedInUser();

		if (borrowedBooksList.isEmpty()) {
			// Kiểm tra nếu không có sách nào trong borrowedBooksList
			showAlert("Lỗi", "Không có sách nào để mượn.", Alert.AlertType.ERROR);
			return;
		}

		// Kiểm tra xem customerName đã được nhập hay chưa
		String customerNameValue = customerName.getText().trim(); // Lấy giá trị và loại bỏ khoảng trắng đầu và cuối
																	// chuỗi

		if (customerNameValue.isEmpty()) {
			// Nếu customerName chưa được nhập
			showAlert("Lỗi", "Vui lòng nhập tên khách hàng.", Alert.AlertType.ERROR);
			return; // Không thực hiện xử lý tiếp theo
		}
		
		borrowedBooksList.removeIf(borrowedBookInfo -> borrowedBookInfo.getQuantity() <= 0);

	    if (borrowedBooksList.isEmpty()) {
	        // Kiểm tra sau khi loại bỏ, nếu không còn sách nào trong borrowedBooksList
	        showAlert("Lỗi", "Không có sách nào để mượn.", Alert.AlertType.ERROR);
	        return;
	    }

		// Thực hiện việc thêm thông tin sách vào cơ sở dữ liệu borrowedbooks
		int borrowId = addBooksToBorrowedBooks(currentUser, borrowedBooksList); // Lấy borrowId

		if (borrowId > 0) { // Nếu thành công
			boolean success = addBooksToBorrowedBooksDetails(currentUser, borrowedBooksList, borrowId); // Truyền
																										// borrowId vào
																										// phương thức
																										// addBooksToBorrowedBooksDetails

			if (success) {
				// Xóa tất cả sách khỏi borrowBook_tableView nếu thêm thành công
				borrowBook_tableView.getItems().clear();
				borrowedBooksList.clear(); // Xóa danh sách sách đã mượn
				showAlert("Thông báo", "Đã mượn thành công tất cả các cuốn sách.", Alert.AlertType.INFORMATION);
			} else {
				// Xử lý lỗi nếu không thể thêm sách vào cơ sở dữ liệu
				showAlert("Lỗi", "Không thể thêm sách vào borrowedbooksdetails.", Alert.AlertType.ERROR);
			}
		} else {
			// Xử lý lỗi nếu không thể thêm thông tin sách vào cơ sở dữ liệu borrowedbooks
			showAlert("Lỗi", "Không thể thêm thông tin sách vào borrowedbooks.", Alert.AlertType.ERROR);
		}
	}

	private int addBooksToBorrowedBooks(EmployeeData currentUser, List<BorrowedBookInfo> selectedBooks) {
		String sql = "INSERT INTO borrowedbooks (customer_id, user_id, borrow_date, due_date, total_quantity) VALUES (?, ?, ?, ?, ?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		Connection connect = dbc.getConnection();
		PreparedStatement prepare = null;

		try {
			int customerId = getCurrentCustomerId(); // Lấy customer_id
			int userId = getCurrentUserId(currentUser); // Lấy user_id

			if (customerId <= 0 || userId <= 0) {
				showAlert("Error Message", "Invalid input data", Alert.AlertType.ERROR);
				return -1; // Trả về -1 để chỉ ra lỗi
			}

			LocalDate borrowDate = LocalDate.now(); // Ngày mượn
			LocalDate dueDate = borrowDate.plusDays(7); // Ngày đến hạn

			int totalQuantity = 0; // Tính tổng quantity

			// Tính tổng quantity cho các đối tượng mượn sách
			for (BorrowedBookInfo borrowedBookInfo : selectedBooks) {
				totalQuantity += borrowedBookInfo.getQuantity();
			}

			prepare = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			prepare.setInt(1, customerId);
			prepare.setInt(2, userId);
			prepare.setDate(3, Date.valueOf(borrowDate));
			prepare.setDate(4, Date.valueOf(dueDate));
			prepare.setInt(5, totalQuantity);

			int rowsAffected = prepare.executeUpdate();

			if (rowsAffected > 0) {
				// Lấy borrow_id sau khi thêm dữ liệu
				ResultSet generatedKeys = prepare.getGeneratedKeys();
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				}
			} else {
				showAlert("Error Message", "Failed to add data to borrowedbooks", Alert.AlertType.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Đóng PreparedStatement
			if (prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return -1; // Trả về -1 nếu có lỗi
	}

	private boolean addBooksToBorrowedBooksDetails(EmployeeData currentUser, List<BorrowedBookInfo> selectedBooks,
			int borrowId) {
		String sql = "INSERT INTO borrowedbooksdetails (borrow_id, book_id, quantity, borrow_date, due_date) VALUES (?, ?, ?, ?, ?)";

		DbConnection dbc = DbConnection.getDatabaseConnection();
		Connection connect = dbc.getConnection();
		PreparedStatement prepare = null;

		try {
			for (BorrowedBookInfo borrowedBookInfo : selectedBooks) {
				BookData book = borrowedBookInfo.getBook();
				int bookId = book.getBookID();
				int quantity = borrowedBookInfo.getQuantity(); // Lấy số lượng tương ứng

				LocalDate borrowDate = LocalDate.now(); // Ngày mượn
				LocalDate dueDate = borrowDate.plusDays(7); // Ngày đến hạn (ví dụ: 7 ngày sau ngày mượn)

				prepare = connect.prepareStatement(sql);
				prepare.setInt(1, borrowId);
				prepare.setInt(2, bookId);
				prepare.setInt(3, quantity); // Thêm selectedQuantity vào câu SQL
				prepare.setDate(4, Date.valueOf(borrowDate));
				prepare.setDate(5, Date.valueOf(dueDate));

				int rowsAffected = prepare.executeUpdate();

				if (rowsAffected <= 0) {
					return false; // Trả về false nếu có lỗi khi thêm sách
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Đóng PreparedStatement
			if (prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false; // Trả về false nếu có lỗi
	}

	@FXML
	private void removeOrder(ActionEvent event) {
		// Kiểm tra xem đã chọn một cuốn sách để xóa chưa
		BookData selectedBook = borrowBook_tableView.getSelectionModel().getSelectedItem();
		if (selectedBook != null) {
			int bookId = selectedBook.getBookID();

			// Lấy số lượng đã mượn của cuốn sách đã chọn
			int quantityToReturn = 0;
			for (BorrowedBookInfo borrowedBookInfo : borrowedBooksList) {
				if (borrowedBookInfo.getBook().getBookID() == bookId) {
					quantityToReturn = borrowedBookInfo.getQuantity();
					break;
				}
			}

			// Tìm cuốn sách trong danh sách đã mượn và cập nhật số lượng
			for (BorrowedBookInfo borrowedBookInfo : borrowedBooksList) {
				if (borrowedBookInfo.getBook().getBookID() == bookId) {
					int currentQuantity = borrowedBookInfo.getQuantity();

					if (quantityToReturn >= 0 && quantityToReturn <= currentQuantity) {
						borrowedBookInfo.setQuantity(currentQuantity - quantityToReturn);

						// Cập nhật lại số lượng sách trong danh sách gốc
						selectedBook.setQuantity(selectedBook.getQuantity() + quantityToReturn);

						// Cập nhật borrowBook_tableView
						updateBorrowBookTableView();

						if (selectedBook.getQuantity() > 0) {
	                        // Cập nhật số lượng sách trong cơ sở dữ liệu
	                        updateBookQuantityInDatabase(bookId, selectedBook.getQuantity());
	                    }

						// Cập nhật số lượng sách trong categoryDataMap
						updateCategoryDataMap(selectedBook.getCategoryName(), bookId, quantityToReturn);
					} else {
						showAlert("Lỗi", "Số lượng trả lại không hợp lệ.", Alert.AlertType.ERROR);
					}
					break;
				}
			}
		} else {
			showAlert("Lỗi", "Vui lòng chọn một cuốn sách để xóa.", Alert.AlertType.ERROR);
		}
	}

	private void updateCategoryDataMap(String categoryName, int bookId, int quantityReturned) {
		// Kiểm tra xem danh mục đã tồn tại trong Map chưa
		if (categoryDataMap.containsKey(categoryName)) {
			// Tìm cuốn sách trong danh mục và cập nhật lại số lượng
			List<BookData> booksInCategory = categoryDataMap.get(categoryName);
			for (BookData selectedBook : booksInCategory) {
				if (selectedBook.getBookID() == bookId) {
					int currentQuantity = selectedBook.getQuantity() - quantityReturned;

					// Kiểm tra nếu borrowedBookInfo.setQuantity = 0 thì xóa cuốn sách khỏi
					// borrowedBooksList
					if (quantityReturned == 0) {
						borrowedBooksList.removeIf(
								borrowedBookInfoToRemove -> borrowedBookInfoToRemove.getBook().getBookID() == bookId);
					}

					// Cập nhật lại book.setQuantity thành (currentQuantity + quantityReturned)
					selectedBook.setQuantity(currentQuantity + quantityReturned);
					break;
				}
			}
		}
		// Cập nhật lại giao diện của borrowBook_tableView và categoryTabPane
		updateBorrowBookTableView();
		updateCategoryTabPane();
	}

	// Phương thức để lấy thông tin khách hàng hiện tại (customerId)
	private int getCurrentCustomerId() {
		String customername = customerName.getText(); // Lấy tên khách hàng từ giao diện người dùng
		int defaultCustomerId = 1; // Giá trị mặc định khi không có customerId

		// Triển khai logic để lấy customerId từ cơ sở dữ liệu dựa trên tên khách hàng
		int customerId = getCustomerIdByName(customername);

		if (customerId <= 0) {
			// Nếu không thể lấy được customerId, trả về giá trị mặc định.
			return defaultCustomerId;
		} else {
			return customerId;
		}
	}

	private int getCustomerIdByName(String customerName) {
		String sql = "SELECT id FROM customer WHERE fullname = ?";
		int customerId = -1; // Giá trị mặc định khi không tìm thấy khách hàng

		try {
			prepare = connect.prepareStatement(sql);
			prepare.setString(1, customerName);

			ResultSet resultSet = prepare.executeQuery();

			if (resultSet.next()) {
				customerId = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Đóng PreparedStatement
			if (prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return customerId;
	}

	// Phương thức để lấy thông tin người dùng hiện tại (userId)
	private int getCurrentUserId(EmployeeData user) {
		if (user != null) {
			return user.getEmployeeID();
		} else {
			// Xử lý trường hợp user là null, ví dụ: trả về một giá trị mặc định
			return DEFAULT_USER_ID;
		}
	}

	// Search book in POS
	public void searchBooks(KeyEvent event) {
		// Lấy giá trị tìm kiếm từ TextField pos_search
		String searchValue = pos_search.getText().toLowerCase().trim();

		// Duyệt qua các tab trong categoryTabPane
		for (Tab categoryTab : categoryTabPane.getTabs()) {
			Node tabContent = categoryTab.getContent();
			if (tabContent instanceof TableView) {
				TableView<BookData> bookTableView = (TableView<BookData>) tabContent;

				// Áp dụng bộ lọc tìm kiếm cho mỗi TableView
				FilteredList<BookData> filteredList = new FilteredList<>(
						FXCollections.observableArrayList(bookTableView.getItems()));

				filteredList.setPredicate(bookData -> {
					if (searchValue == null || searchValue.isEmpty()) {
						return true;
					}

					return bookData.getBookName().toLowerCase().contains(searchValue)
							|| bookData.getAuthorName().toLowerCase().contains(searchValue)
							|| bookData.getPublicationYear().toLowerCase().contains(searchValue)
							|| Integer.toString(bookData.getQuantity()).contains(searchValue)
							|| bookData.getCategoryName().toLowerCase().contains(searchValue)
							|| bookData.getAreaName().toLowerCase().contains(searchValue);
				});

				bookTableView.setItems(filteredList);
			}
		}

		if (searchValue.isEmpty()) {
			restoreOriginalData();
		}
	}

	private Map<String, List<BookData>> originalCategoryDataMap;

	private void restoreOriginalData() {
		for (Tab categoryTab : categoryTabPane.getTabs()) {
			Node tabContent = categoryTab.getContent();
			if (tabContent instanceof TableView) {
				TableView<BookData> bookTableView = (TableView<BookData>) tabContent;
				String categoryName = categoryTab.getText();

				// Lấy danh sách ban đầu từ danh sách Map
				List<BookData> originalData = originalCategoryDataMap.get(categoryName);

				// Đặt danh sách ban đầu vào TableView
				bookTableView.setItems(FXCollections.observableArrayList(originalData));
			}
		}
	}

	// Phương thức để hiển thị thông báo
	private void showAlert(String title, String content, Alert.AlertType alertType) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}

	// Book loan coupon
	private EmployeeData currentUser; // Khai báo biến thành viên

	// Hàm để gán giá trị cho currentUser
	public void setCurrentUser(EmployeeData user) {
		this.currentUser = user;
	}

	@FXML
	private void viewBookCoupon(ActionEvent event) {
		if (!borrowedBooksList.isEmpty()) {
			// Tạo danh sách tạm thời để lưu trữ thông tin phiếu mượn sách chỉ với các cuốn
			// sách có quantity > 0
			List<BorrowedBookInfo> booksWithQuantityGreaterThanZero = new ArrayList<>();

			// Duyệt qua danh sách sách đã mượn và thêm thông tin từng cuốn sách vào danh
			// sách tạm thời
			for (BorrowedBookInfo borrowedBookInfo : borrowedBooksList) {
				int quantity = borrowedBookInfo.getQuantity();

				if (quantity > 0) {
					// Thêm các cuốn sách có quantity > 0 vào danh sách tạm thời
					booksWithQuantityGreaterThanZero.add(borrowedBookInfo);
				}
			}

			// Kiểm tra xem có cuốn sách nào có quantity > 0 không
			if (!booksWithQuantityGreaterThanZero.isEmpty()) {
				// Tạo chuỗi thông tin phiếu mượn sách
				StringBuilder couponInfo = new StringBuilder();
				String customerFullName = customerName.getText(); // Lấy tên khách hàng từ giao diện người dùng
				String employeeFullName = currentUser.getFullName(); // Lấy tên của currentUser
				couponInfo.append("                                               PHIẾU MƯỢN SÁCH\n");
				couponInfo.append("Ngày:\n");
				couponInfo.append("Giờ: \n");
				// Thêm thông tin tên khách hàng và tên của currentUser vào couponInfo
				couponInfo.append("Khách hàng: ").append(customerFullName).append("\n");
				couponInfo.append("Nhân viên: ").append(employeeFullName).append("\n\n");
				couponInfo.append(
						"-------------------------------------------------------------------------------------------------------\n");
				couponInfo.append("                                           THÔNG TIN THANH TOÁN\n");
				couponInfo.append(
						"-------------------------------------------------------------------------------------------------------\n");
				couponInfo.append(
						"     Tên sách                                                                    Số lượng        ")
						.append("\n");
				couponInfo.append(
						"-------------------------------------------------------------------------------------------------------\n");
				// Duyệt qua danh sách sách đã mượn và thêm thông tin từng cuốn sách vào
				// couponInfo
				for (BorrowedBookInfo borrowedBookInfo : booksWithQuantityGreaterThanZero) {
					BookData book = borrowedBookInfo.getBook();
					int quantity = borrowedBookInfo.getQuantity();

					couponInfo.append("     ").append(book.getBookName())
							.append("                                                                           ")
							.append(quantity).append("            ").append("\n");

					// Thêm thông tin khác của sách nếu cần

					couponInfo.append(
							"-------------------------------------------------------------------------------------------------------\n");
				}
				couponInfo.append("                                         CẢM ƠN QUÝ KHÁCH!\n");

				// Tạo tệp tin txt chứa thông tin phiếu mượn sách
				try (PrintWriter writer = new PrintWriter("LoanSlip.txt")) {
					writer.println(couponInfo.toString());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					showAlert("Lỗi", "Không thể tạo tệp tin phiếu mượn sách.", Alert.AlertType.ERROR);
				}

				// Mở tệp tin txt để hiển thị
				openTxtFile("LoanCoupon.txt");
			} else {
				showAlert("Lỗi", "Không có sách nào để tạo phiếu mượn.", Alert.AlertType.ERROR);
			}
		}
	}

	private void openTxtFile(String filePath) {
		File file = new File(filePath);
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
			showAlert("Lỗi", "Không thể mở tệp tin.", Alert.AlertType.ERROR);
		}
	}

//-------------------------------------------------------------------------------------------------------

	// Switch form
	public void switchForm(ActionEvent event) {
		if (event.getSource() == home_btn) {
			home_form.setVisible(true);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(false);
			area_form.setVisible(false);
			addCustomer_form.setVisible(false);
			category_form.setVisible(false);
			pos_form.setVisible(false);
			statics_form.setVisible(false);

			home_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
			addBook_btn.setStyle("-fx-background-color: transparent");
			addEmployee_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: transparent");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: transparent");
			staticis_btn.setStyle("-fx-background-color: transparent");

		} else if (event.getSource() == addBook_btn) {
			if (currentUser.getRoleID() == 1) {
				home_form.setVisible(false);
				addBook_form.setVisible(true);
				addEmployee_form.setVisible(false);
				area_form.setVisible(false);
				addCustomer_form.setVisible(false);
				category_form.setVisible(false);
				pos_form.setVisible(false);
				statics_form.setVisible(false);

				home_btn.setStyle("-fx-background-color: transparent");
				addBook_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
				addEmployee_btn.setStyle("-fx-background-color: transparent");
				area_btn.setStyle("-fx-background-color: transparent");
				customers_btn.setStyle("-fx-background-color: transparent");
				category_btn.setStyle("-fx-background-color: transparent");
				pos_btn.setStyle("-fx-background-color: transparent");
				staticis_btn.setStyle("-fx-background-color: transparent");

				updateBookListFromDatabase();
			} else {
				showAlert("Lỗi", "Chỉ admin mới có quyền truy cập.", Alert.AlertType.ERROR);
			}
		}

		else if (event.getSource() == addEmployee_btn) {
			if (currentUser.getRoleID() == 1) {
				home_form.setVisible(false);
				addBook_form.setVisible(false);
				addEmployee_form.setVisible(true);
				area_form.setVisible(false);
				addCustomer_form.setVisible(false);
				category_form.setVisible(false);
				pos_form.setVisible(false);
				statics_form.setVisible(false);

				addEmployee_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
				home_btn.setStyle("-fx-background-color: transparent");
				addBook_btn.setStyle("-fx-background-color: transparent");
				area_btn.setStyle("-fx-background-color: transparent");
				customers_btn.setStyle("-fx-background-color: transparent");
				category_btn.setStyle("-fx-background-color: transparent");
				pos_btn.setStyle("-fx-background-color: transparent");
				staticis_btn.setStyle("-fx-background-color: transparent");
			} else {
				showAlert("Lỗi", "Chỉ admin mới có quyền truy cập.", Alert.AlertType.ERROR);
			}
		}

		else if (event.getSource() == area_btn) {
			if (currentUser.getRoleID() == 1) {
				home_form.setVisible(false);
				addBook_form.setVisible(false);
				addEmployee_form.setVisible(false);
				area_form.setVisible(true);
				addCustomer_form.setVisible(false);
				category_form.setVisible(false);
				pos_form.setVisible(false);
				statics_form.setVisible(false);

				addEmployee_btn.setStyle("-fx-background-color: transparent");
				home_btn.setStyle("-fx-background-color: transparent");
				addBook_btn.setStyle("-fx-background-color: transparent");
				area_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
				customers_btn.setStyle("-fx-background-color: transparent");
				category_btn.setStyle("-fx-background-color: transparent");
				pos_btn.setStyle("-fx-background-color: transparent");
				staticis_btn.setStyle("-fx-background-color: transparent");
			} else {
				showAlert("Lỗi", "Chỉ admin mới có quyền truy cập.", Alert.AlertType.ERROR);
			}

		} else if (event.getSource() == customers_btn) {
			home_form.setVisible(false);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(false);
			area_form.setVisible(false);
			addCustomer_form.setVisible(true);
			category_form.setVisible(false);
			pos_form.setVisible(false);
			statics_form.setVisible(false);

			addEmployee_btn.setStyle("-fx-background-color: transparent");
			home_btn.setStyle("-fx-background-color: transparent");
			addBook_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: transparent");
			staticis_btn.setStyle("-fx-background-color: transparent");

		} else if (event.getSource() == category_btn) {
			if (currentUser.getRoleID() == 1) {
				home_form.setVisible(false);
				addBook_form.setVisible(false);
				addEmployee_form.setVisible(false);
				area_form.setVisible(false);
				addCustomer_form.setVisible(false);
				category_form.setVisible(true);
				pos_form.setVisible(false);
				statics_form.setVisible(false);

				addEmployee_btn.setStyle("-fx-background-color: transparent");
				home_btn.setStyle("-fx-background-color: transparent");
				addBook_btn.setStyle("-fx-background-color: transparent");
				area_btn.setStyle("-fx-background-color: transparent");
				customers_btn.setStyle("-fx-background-color: transparent");
				category_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
				pos_btn.setStyle("-fx-background-color: transparent");
				staticis_btn.setStyle("-fx-background-color: transparent");
			} else {
				showAlert("Lỗi", "Chỉ admin mới có quyền truy cập.", Alert.AlertType.ERROR);
			}

		} else if (event.getSource() == pos_btn) {
			home_form.setVisible(false);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(false);
			area_form.setVisible(false);
			addCustomer_form.setVisible(false);
			category_form.setVisible(false);
			pos_form.setVisible(true);
			statics_form.setVisible(false);

			addEmployee_btn.setStyle("-fx-background-color: transparent");
			home_btn.setStyle("-fx-background-color: transparent");
			addBook_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: transparent");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");
			staticis_btn.setStyle("-fx-background-color: transparent");

			categoryDataMap = getCategoryData();
			updateCategoryTabPane();

		} else if (event.getSource() == staticis_btn) {
			home_form.setVisible(false);
			addBook_form.setVisible(false);
			addEmployee_form.setVisible(false);
			area_form.setVisible(false);
			addCustomer_form.setVisible(false);
			category_form.setVisible(false);
			pos_form.setVisible(false);
			statics_form.setVisible(true);

			addEmployee_btn.setStyle("-fx-background-color: transparent");
			home_btn.setStyle("-fx-background-color: transparent");
			addBook_btn.setStyle("-fx-background-color: transparent");
			area_btn.setStyle("-fx-background-color: transparent");
			customers_btn.setStyle("-fx-background-color: transparent");
			category_btn.setStyle("-fx-background-color: transparent");
			pos_btn.setStyle("-fx-background-color: transparent");
			staticis_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #4d2572, #3404a6)");

			staticsTotalEmployee();
			staticsTotalCustomers();
			staticsTotalBooksBorrowed();
			staticsTotalBooksLoanCoupon();
			updateStaticisBookTableView();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		addBookShowListData();
		addCustomerShowListData();
		addCustomerGenderList();
		addCustomerStatusList();
		addCustomer_search.setOnKeyTyped(event -> {
			addCustomerSearch(event);
		});

		addAreaShowListData();
		addArea_search.setOnKeyTyped(event -> {
			addAreaSearch(event);
		});

		ObservableList<String> areas = getAreas();
		addBook_area.setItems(areas);

		addCategoryShowListData();
		addCategory_search.setOnKeyTyped(event -> {
			addCategorySearch(event);
		});

		ObservableList<String> categories = getCategories();
		addBook_category.setItems(categories);

		addEmployeeShowListData();
		addEmployeeGenderList();
		addEmployee_search.setOnKeyTyped(event -> {
			addEmployeeSearch(event);
		});

		populateCategoryTabs();

		categoryTabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
			if (newTab != null) {
				TableView<BookData> tableView = (TableView<BookData>) newTab.getContent();
				tableView.setOnMouseClicked(event -> {
					// Xử lý khi người dùng click vào TableView
					BookData selectedBook = tableView.getSelectionModel().getSelectedItem();
					if (selectedBook != null) {
						// Hiển thị thông tin sách được chọn hoặc thực hiện các xử lý khác ở đây
						posDetailBookName.setText(selectedBook.getBookName());
						String uri = "file:" + selectedBook.getBookImage();
						image = new Image(uri, 101, 127, false, true);
						posDetailBookImage.setImage(image);

						quantityBook = 1;
						posQuantity.setText(Integer.toString(quantityBook));
					}
				});
			}
		});

		posQuantity.setText(Integer.toString(quantityBook));

		originalCategoryDataMap = getCategoryData();
		pos_search.setOnKeyTyped(event -> {
			searchBooks(event);
		});

		// Book loan coupon
		EmployeeData loggedInUser = UserController.getLoggedInUser();
		if (loggedInUser != null) {
			setCurrentUser(loggedInUser);
		}

		StringProperty usernameProperty = new SimpleStringProperty(currentUser.getUserName());

		// Liên kết usernameProperty với Label
		username.textProperty().bind(usernameProperty);

		staticsTotalEmployee();
		staticsTotalCustomers();
		staticsTotalBooksBorrowed();
		staticsTotalBooksLoanCoupon();
		
		staticsBookShowListData();

	}

}
