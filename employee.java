package com.coderound;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.ws.rs.*;
import java.ws.rs.core.*;
@Path("/employees")
public class EmployeeResource{
private static List<Employee> employees =new ArrayList<>();
@Post
@Consumes(MediaType.APPLICATION_JSON);

    public Response addEmployee(Employee employee) {
        
       
        List<String> errors = validateEmployeeData(employee);
        if (!errors.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
        }
        
        employees.add(employee);
        return Response.status(Response.Status.CREATED).build();
    }
    
    
    private List<String> validateEmployeeData(Employee employee) {
        List<String> errors = new ArrayList<>();
        
        if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            errors.add("Employee ID is required");
        }
        
        if (employee.getFirstName() == null || employee.getFirstName().isEmpty()) {
            errors.add("First name is required");
        }
        
        if (employee.getLastName() == null || employee.getLastName().isEmpty()) {
            errors.add("Last name is required");
        }
        
        if (employee.getEmail() == null || employee.getEmail().isEmpty() ||
            !Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+\\.[a-zA-Z]", employee.getEmail())) {
            errors.add("Invalid email format");
        }
        
        if (employee.getPhoneNumber() == null || employee.getPhoneNumber().isEmpty()) {
            errors.add("Phone number is required");
        } else {
            String[] phoneNumbers = employee.getPhoneNumber().split(",");
            for (String phoneNumber : phoneNumbers) {
                if (!Pattern.matches("\\d{10}", phoneNumber)) {
                    errors.add("Invalid phone number format: " + phoneNumber);
                }
            }
        }
        
        if (employee.getDoj() == null) {
            errors.add("Date of Joining is required");
        }
        
        if (employee.getSalary() == null) {
            errors.add("Salary is required");
        } else if (employee.getSalary() <= 0) {
            errors.add("Salary must be greater than 0");
        }
        
        return errors;
    }
}

class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date doj;
    private Double salary;
    
  
}