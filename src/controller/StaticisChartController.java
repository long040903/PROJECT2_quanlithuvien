package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DbConnection;

public class StaticisChartController {

    @FXML
    private BarChart<String, Integer> barChart;
    
    @FXML
    private CategoryAxis xAxis;
    
    @FXML
    private NumberAxis yAxis;

    public void initialize() {
        // Đặt tên trục X và trục Y của biểu đồ
        xAxis.setLabel("Tháng");
        yAxis.setLabel("Số lượng sách đã mượn");
        
        // Lấy dữ liệu từ cơ sở dữ liệu và đưa vào biểu đồ
        updateChart();
    }

    private void updateChart() {
    	
    	Platform.runLater(() -> {
    		// Tạo một chuỗi biểu đồ dạng cột
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName("Số lượng sách đã mượn");

            // Kết nối cơ sở dữ liệu và tạo truy vấn SQL
            try {
                DbConnection dbc = DbConnection.getDatabaseConnection();
                Connection connect = dbc.getConnection();
                
                // Sử dụng GROUP BY để nhóm dữ liệu theo tháng và lấy tổng số lượng sách đã mượn cho mỗi tháng
                String sql = "SELECT MONTH(borrow_date) AS month, SUM(total_quantity) AS total FROM borrowedbooks GROUP BY month";
                PreparedStatement preparedStatement = connect.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                // Thêm dữ liệu từ cơ sở dữ liệu vào chuỗi biểu đồ
                while (resultSet.next()) {
                    int month = resultSet.getInt("month");
                    int totalQuantity = resultSet.getInt("total");
                    
                    // Đặt tên tháng dựa trên giá trị số tháng (ví dụ: "Tháng 1", "Tháng 2", ...)
                    String monthName = "Tháng " + month;
                    
                    // Thêm dữ liệu vào chuỗi biểu đồ
                    series.getData().add(new XYChart.Data<>(monthName, totalQuantity));
                }
                
                // Đóng tài nguyên (ResultSet, PreparedStatement và kết nối) sau khi sử dụng
                resultSet.close();
                preparedStatement.close();
                connect.close();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Xử lý lỗi khi truy xuất cơ sở dữ liệu
            }

            // Đặt dữ liệu vào biểu đồ
            barChart.getData().clear();
            barChart.getData().add(series);
        });
        
    }
}