package business;

import entity.Department;
import entity.Employee;
import java.util.List;
import java.util.Map;

public interface IEmployeeDesign extends IGenericDesign<Employee, String> {
    //    Thống kê số lượng nhân viên trung bình của mỗi phòng
    int calEmployeeAvg();

    // Tìm ra 5 phòng có số lượng nhân viên đông nhất
    List<Map.Entry<Department, Integer>> mostCrowded();

    // Tìm ra người quản lý nhiều nhân viên nhất
    Employee manageMostEmploy();

    //Tìm ra 5 nhân viên có tuổi cao nhất công ty
    List<Employee> employeeAgeMax();

    //Tìm ra 5 nhân viên hưởng lương cao nhất
    List<Employee> employeeSalaryMax();

    //
    boolean existByEmployeeId(String depId);
}
