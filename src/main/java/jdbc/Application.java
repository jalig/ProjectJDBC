package jdbc;

import jdbc.dao.EmployeeDAO;
import jdbc.dao.EmployeeDAOImpl;
import jdbc.model.Employee;

public class Application {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Employee employee = new Employee(9,"Slavik","Varan","male",20,5);

//        employeeDAO.create(employee);

//        System.out.println(employeeDAO.getById(2));

//        System.out.println(employeeDAO.getAllEmployees());

//        employeeDAO.updateById(new Employee(9,"Bplavik","Baran","male",5,5));

//        employeeDAO.deleteById(employee);
    }
}
