package learn.spring.boot.tutorial.controllers;



// * Operations

// * GET /employees
// * POST /employees
// * DELETE /employees/{id}

import jakarta.websocket.server.PathParam;
import learn.spring.boot.tutorial.dto.EmployeeDto;
import learn.spring.boot.tutorial.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployeesData(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long employeeId){
     return employeeService.getEmployeeById(employeeId);

    }


//    @GetMapping(path = "/employees")
//    public String getData(@PathParam("sortBy") String sortBy,
//                          @PathParam("limit") Integer limit ){
//        return  "wow!" + sortBy + limit;
//    }

    @PostMapping
    public EmployeeDto getData(@RequestBody EmployeeDto employeeDto ){
         return  employeeService.createNewEmployee(employeeDto);

    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable("id") Long employeeId){
        return employeeService.deleteEmployeeById(employeeId);
    }




}

