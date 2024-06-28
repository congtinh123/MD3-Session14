package entity;

import util.InputMethods;

import java.time.LocalDate;
import static business.DepartmentBusiness.departments;


public class Employee implements IManagement {
    private String employeeId, employeeName;
    private static int autoId = 0;
    private LocalDate birthday;
    private boolean sex;
    private double salary;
    private Employee manager;
    private Department department;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {
        this.employeeId = String.format("E%05d", ++autoId);
    }

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean sex, double salary, Employee manager, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập tên nhân viên:");
        this.employeeName = InputMethods.getString();
        System.out.println("Nhập ngày sinh:");
        this.birthday = InputMethods.getDate();
        System.out.println("Nhập giới tính:");
        this.sex = InputMethods.getBoolean();
        System.out.println("Nhập lương cơ bản:");
        this.salary = InputMethods.getDouble();

        System.out.println("Danh sách phòng ban: ");
        for (int i = 1; i < departments.size(); i++) {
            System.out.printf("|STT : %-3s | Name : %-15s |\n", i, departments.get(i - 1).getDepartmentName());
        }
        System.out.println("Chọn phòng ban cho nhân viên: ");
        while (true) {
            int index = InputMethods.getInteger();
            if (index >= 1 && index <= departments.size()) {
                this.department = departments.get(index - 1);
                break;
            } else {
                System.err.println("Nhap khong chinh xac , vui long nhap lai");
            }
        }

        System.out.println("Danh sách nhân viên: ");
        for (int i = 1; i < employees.size(); i++) {
            System.out.printf("|STT : %-3s | Name : %-15s |\n", i, employees.get(i - 1).getEmployeeName());
        }
        System.out.println("Chọn quản lý nhân viên: ");
        while (true) {
            int index = InputMethods.getInteger();
            if (index >= 1 && index <= departments.size()) {
                this.manager = employees.get(index - 1);
                break;
            } else {
                System.err.println("Nhap khong chinh xac , vui long nhap lai");
            }
        }
//
    }

    //    Note:
    @Override
    public void displayData() {
        System.out.printf("|ID : %-4s | Name: %-15s| ngày sinh: %10s | Giới tính : %10s | Lương cơ bản  : %10s| người quản lí: %10s | Phòng ban: %10s\n", employeeId, employeeName, birthday, sex, salary, department, manager);

    }
}