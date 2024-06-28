package business;

import entity.Department;
import entity.Employee;

import java.util.*;

public class EmployeeBusiness implements IEmployeeDesign{
    public static List<Employee> employees = new ArrayList<>();

//    Thống kê số lượng nhân viên trung bình của mỗi phòng
//    phòng A: 5 nhân viên
//    phòng B: 3 nhân viên
//    phòng C: 2 nhân viên
//    phòng D: 7 nhân viên
//    phòng E: 9 nhân viên

    @Override
    public int calEmployeeAvg() {
        Map<Department, Integer> departments = new HashMap<>();
        for(Employee employee : employees){
            Department department = employee.getDepartment();
            if(!departments.containsKey(department))departments.put(department, 1);
            else departments.put(department, departments.get(department)+1);
        }
        int totalDepartment = departments.size();
        int totalEmployees = employees.size();
        return (int) totalEmployees / totalDepartment;
    }

    @Override
    public List<Map.Entry<Department, Integer>> mostCrowded() {
        return Collections.emptyList();
    }

    @Override
    public Employee manageMostEmploy() {
        return null;
    }

    @Override
    public List<Employee> employeeAgeMax() {
        return Collections.emptyList();
    }

    @Override
    public List<Employee> employeeSalaryMax() {
        return Collections.emptyList();
    }

    @Override
    public boolean existByEmployeeId(String depId) {
        for(Employee employee : employees){
            if(employee.getEmployeeId().equals(depId)) return true;
        }
        return false;
    }

    @Override
    public boolean create(Employee employee) {
        employees.add(employee);
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        int index = employees.indexOf(findById(employee.getEmployeeId()));
        if(index != -1) {
            employees.set(index, employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return employees.removeIf( employee -> employee.getEmployeeId().equals(id));
    }

    @Override
    public Employee findById(String id) {
        for(Employee employee : employees){
            if(employee.getEmployeeId().equals(id)) return employee;
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }
}
