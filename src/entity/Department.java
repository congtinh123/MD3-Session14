package entity;


import util.InputMethods;

public class Department implements IManagement {
    //    Attribute:
    private String departmentId, departmentName;
    private static int autoId = 0;
    private int totalMembers;


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public Department() {
        this.departmentId = String.format("D%04d", ++autoId);
    }

    public Department(String departmentId, String departmentName, int totalMembers) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = totalMembers;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập tên phòng ban:");
        this.departmentName = InputMethods.getString();
        System.out.println("Nhập tổng số nhân viên:");
        this.totalMembers = InputMethods.getInteger();
    }

    @Override
    public void displayData() {
        System.out.printf("|ID : %-4s | Name: %-6s | Total members : %2s |\n", departmentId, departmentName, totalMembers);
    }
}