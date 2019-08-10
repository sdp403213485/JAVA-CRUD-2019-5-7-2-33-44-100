package com.employee.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/getEmployees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getAllUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addEmployees",method = RequestMethod.POST)
    public ResponseEntity<Object> addEmployees(@RequestBody Employee employee){
        employeeService.addUser(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateEmployee/{employeeID}",method = RequestMethod.PUT)
    public ResponseEntity<Object> updateEmployee(@PathVariable int employeeID, @RequestBody Employee employee) throws Exception {
        employeeService.updateUserById(employeeID,employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/deleteEmployee/{employeeID}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployee(@PathVariable int employeeID) throws Exception {
        employeeService.deleteUserById(employeeID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
