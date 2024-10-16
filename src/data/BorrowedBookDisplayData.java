package data;

public class BorrowedBookDisplayData {
    private int id;
    private String customerName;
    private String employeeName;
    private int totalQuantity;

    public BorrowedBookDisplayData(int id, String customerName, String employeeName, int totalQuantity) {
        this.id = id;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.totalQuantity = totalQuantity;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }
}

