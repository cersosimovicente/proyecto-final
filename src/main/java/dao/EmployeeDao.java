package dao;

import com.cerso.proyectofinal.model.Employee;
import com.cerso.proyectofinal.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

    private Connection connection = DBConnection.getConnection();

    private PreparedStatement preparedStatement = null;

    private ResultSet resultSet = null;

    public int add(Employee employee) {

        int row = 0;
        String sql = "INSERT INTO empleados (nombre, departamento) VALUES (?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDepartment());
            row = preparedStatement.executeUpdate();
            System.out.println("Empleado agregado");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return row;
    }
    
    
    //prueba metodo add
    
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDao();
        Employee employee = new Employee();
        employee.setName("Ada");
        employee.setDepartment("Info");
        
        employeeDao.add(employee);
    }
    
}
