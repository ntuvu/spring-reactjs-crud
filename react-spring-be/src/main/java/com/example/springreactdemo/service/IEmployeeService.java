package com.example.springreactdemo.service;

import com.example.springreactdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
  List<Employee> index();
  Employee create(Employee employee);
  Employee show(long id);
  Employee update(long id, Employee employee);
  void delete(long id);
}
