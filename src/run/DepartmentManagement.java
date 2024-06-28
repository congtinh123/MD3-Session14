package run;

import business.DepartmentBusiness;
import business.IDepartmentDesign;
import business.IEmployeeDesign;
import entity.Department;
import entity.Employee;
import util.InputMethods;

import java.time.LocalDate;
import java.util.List;

public class DepartmentManagement {
    private static final IDepartmentDesign departmentBusiness = new DepartmentBusiness();
    private static final IEmployeeDesign employeeBusiness = new EmployeeBusiness();

    public static void main(String[] args) {
        while (true) {
            System.out.println("------------------Product-Management----------------");
            System.out.println("1. Quản lí phòng ban");
            System.out.println("2. Quản lí nhân viên");
            System.out.println("3. Thoát");
            System.out.println("Lựa chọn của bạn:");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    // menu quản lí phòng ban
                    menuDepartment();
                    break;
                case 2:
                    // menu quản lí nhân viên
                    menuEmployee();
                    break;
                case 3:
                    System.out.println("Tạm biệt");
                    break;
                default:
                    System.err.println("Lựa chọn ko chính xác , vui lòng nhập lại");
            }
            if (choice == 3) {
                break;
            }
        }
    }

    private static void menuDepartment() {
        while (true) {
            System.out.println("------------------Department-Menu----------------");
            System.out.println("1. Thêm mơi");
            System.out.println("2. Hiển thị ");
            System.out.println("3. Sửa tên");
            System.out.println("4. Xóa");
            System.out.println("5. Hiển thị danh sách nhân viên của phòng ban theo mã phòng");
            System.out.println("6. Quay lại ");
            System.out.println("Lựa chọn của bạn : ");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    addNewDepartment();
                    break;
                case 2:
                    showDepartmentList();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                case 6:

                    break;
                default:
                    System.err.println("Lựa chọn ko chính xác , vui lòng nhập lại");
            }
            if (choice == 6) {
                break;
            }
        }
    }

    private static void addNewDepartment() {
        System.out.println("Nhập số lượng cần thêm mới");
        byte n = InputMethods.getByte();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho danh mục thứ :" + (i + 1));
            Department newDepartment = new Department(); // chứa logic tự tăng
            newDepartment.inputData(); // cho nhập thông tin
            departmentBusiness.create(newDepartment); // luu lại
        }
        // thông báo thành công
        System.out.println("Đã thêm mới thành công!");
    }

    private static void showDepartmentList() {
        // lấy ra danh sách
        List<Department> departments = departmentBusiness.findAll();
        if (departments.isEmpty()) {
            System.err.println("Danh sách trống !");
        } else {
            System.out.println("-------- Danh sac danh mục --------");
            for (Department cat : departments) {
                cat.displayData();
            }
        }
    }

    private static void deleteDepartment() {
        System.out.println("Nhập mã phòng ban cần xóa ");
        String detId = InputMethods.getString();
        // kiểm tra tồn tại
        // kiểm tra xem có sách thuộc danh mục này không
        if (employeeBusiness.existByEmployeeId(detId)) {
            System.err.println("Phòng ban này có nhân viên nên ko thể xóa");
            return;
        }
        if (departmentBusiness.findById(detId) == null) System.err.println("id không tồn tại");
        else {
            departmentBusiness.deleteById(detId);
            System.out.println(" đã xóa thành công");
        }
    }

    private static void updateDepartment() {
        System.out.println("Nhập mã phòng ban cần chỉnh sửa: ");
        String depUpdate = InputMethods.getString();
        Department existingDepartment = departmentBusiness.findById(depUpdate);

        if (departmentBusiness.findById(depUpdate) == null) System.err.println("id không tồn tại");
        else {
            String name = existingDepartment.getDepartmentName();
            int totalMembers = existingDepartment.getTotalMembers();
//            Department newDepartment = new Department();
            Department newDepartment = new Department(depUpdate, name, totalMembers);
            // constructor không tham số sẽ làm dữ liệu không được cập nhật lại được!!
            newDepartment.inputData(); // cho nhập thông tin
            departmentBusiness.update(newDepartment); // luu lại
            System.out.println("Đã chỉnh sửa thành công");
        }
    }

    //    Employee:
    private static void addNewEmployee() {
        System.out.println("Nhập số lượng cần thêm mới");
        byte n = InputMethods.getByte();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho danh mục thứ :" + (i + 1));
            Employee newEmployee = new Employee(); // chứa logic tự tăng
            newEmployee.inputData(); // cho nhập thông tin
            employeeBusiness.create(newEmployee); // luu lại
        }
        // thông báo thành công
        System.out.println("Đã thêm mới thành công!");
    }

    private static void showEmployeeList() {
        // lấy ra danh sách
        List<Employee> employees = employeeBusiness.findAll();
        if (employees.isEmpty()) System.err.println("Danh sách trống !");
        else {
            System.out.println("-------- Danh sac danh mục --------");
            for (Employee employee : employees) employee.displayData();
        }
    }

    private static void deleteEmployee() {
        System.out.println("Nhập mã phòng ban cần xóa ");
        String employeeId = InputMethods.getString();
        // kiểm tra tồn tại

        if (employeeBusiness.findById(employeeId) == null) System.err.println("id không tồn tại");
        else {
            employeeBusiness.deleteById(employeeId);
            System.out.println("đã xóa thành công");
        }
    }

    private static void updateEmployee() {
        System.out.println("Nhập mã phòng ban cần chỉnh sửa: ");
        String employeeUpdate = InputMethods.getString();
        Employee existingEmployee = employeeBusiness.findById(employeeUpdate);

        if (employeeBusiness.findById(employeeUpdate) == null) System.err.println("id không tồn tại");
        else {
            String name = existingEmployee.getEmployeeName();
            LocalDate birthday = existingEmployee.getBirthday();
            boolean isSex = existingEmployee.isSex();
            double salary = existingEmployee.getSalary();
            Employee manager = existingEmployee.getManager();
            Department department = existingEmployee.getDepartment();
            Employee newEmployee = new Employee(employeeUpdate, name, birthday, isSex, salary, manager, department);

            // constructor không tham số sẽ làm dữ liệu không được cập nhật lại được!!
            newEmployee.inputData(); // cho nhập thông tin
            employeeBusiness.update(newEmployee); // luu lại
            System.out.println("Đã chỉnh sửa thành công");
        }
    }
    // Nhập mã phòng -> Ra phòng ban -> Tìm ra được số nhân viên của phòng ban đấy

    private static void menuEmployee() {
        while (true) {
            System.out.println("------------------Employee-Menu----------------");
            System.out.println("1. Thêm mơi");
            System.out.println("2. Hiển thị ");
            System.out.println("3. Sửa tên");
            System.out.println("4. Xóa");
            System.out.println("5. Hiển thị danh sách nhân viên của phòng ban theo mã phòng");
            System.out.println("6. Quay lại ");
            System.out.println("Lựa chọn của bạn : ");

            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    showEmployeeList();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 6:

                    break;
                default:
                    System.err.println("Lựa chọn ko chính xác , vui lòng nhập lại");
            }
            if (choice == 6) {
                break;
            }
        }
    }

}