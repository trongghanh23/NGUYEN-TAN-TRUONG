package com.code_gym.castudy.controller;

import com.code_gym.castudy.model.employee.Employee;
import com.code_gym.castudy.service.IDivisionService;
import com.code_gym.castudy.service.IEmployeeService;
import com.code_gym.castudy.service.IPositionService;
import com.code_gym.castudy.service.impl.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

;


@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationService educationService;
    @Autowired
    private IDivisionService divisionService;


    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
      employeeService.save(employee);
      return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Optional<Employee> employee = this.employeeService.getId(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/showUpdate")
    public ResponseEntity<Employee> showUpdate(@RequestParam Integer id) {
        Optional<Employee> employee = this.employeeService.getId(id);
        if (employee.isPresent()){
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/saveUpdate")
    public ResponseEntity<List<Employee>> saveUpdateEmployee(@RequestBody Employee employee) {
        try {
            this.employeeService.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}