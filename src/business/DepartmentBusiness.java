package business;


import entity.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentBusiness implements IDepartmentDesign {
    public static List<Department> departments = new ArrayList<>();

    @Override
    public boolean create(Department department) {
        departments.add(department);
        return true;

    }

    @Override
    public boolean update(Department department) {
        int index = departments.indexOf(findById(department.getDepartmentId()));
        if (index != -1) {
            departments.set(index, department);
            return true;
        } else {
            return false; // Or throw an exception if the department does not exist
        }
    }

    @Override
    public boolean deleteById(String id) {
//        return departments.remove(findById(id));
        return departments.removeIf(department -> department.getDepartmentId().equals(id));
    }

    @Override
    public Department findById(String id) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(id)) return department;
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        return departments;
    }

}