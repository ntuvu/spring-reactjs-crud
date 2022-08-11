package com.example.springreactdemo.controller;

import com.example.springreactdemo.model.Employee;
import com.example.springreactdemo.service.IEmployeeService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  private final IEmployeeService employeeService;

  public EmployeeController(IEmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/")
  public ResponseEntity<List<Employee>> index() {
    return new ResponseEntity<List<Employee>>(employeeService.index(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> show(@PathVariable("id") long id) {
    return new ResponseEntity<Employee>(employeeService.show(id), HttpStatus.OK);
  }

  @PostMapping("/")
  public ResponseEntity<Employee> create(@RequestBody Employee employee) {
    return new ResponseEntity<Employee>(employeeService.create(employee), HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Employee> update(
      @PathVariable("id") long id,
      @RequestBody Employee employee
  ) {
    return new ResponseEntity<Employee>(employeeService.update(id, employee), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
    employeeService.delete(id);
    return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
  }
}
