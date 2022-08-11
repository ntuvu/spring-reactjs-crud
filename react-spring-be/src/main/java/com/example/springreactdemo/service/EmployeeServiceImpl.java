package com.example.springreactdemo.service;

import com.example.springreactdemo.exception.ResourceNotFoundException;
import com.example.springreactdemo.model.Employee;
import com.example.springreactdemo.repository.IEmployeeRepository;
import org.apache.el.util.ReflectionUtil;
import org.aspectj.util.Reflection;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

  private final IEmployeeRepository employeeRepository;

  public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> index() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee create(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee show(long id) {
    return employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
  }

  @Override
  public Employee update(long id, Employee employee) {
    Employee existingEmployee = employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    if (employee.getFirstName() == null) employee.setFirstName(existingEmployee.getFirstName());
    if (employee.getLastName() == null) employee.setLastName(existingEmployee.getLastName());
    if (employee.getEmail() == null) employee.setEmail(existingEmployee.getEmail());
    existingEmployee.setFirstName(employee.getFirstName());
    existingEmployee.setLastName(employee.getLastName());
    existingEmployee.setEmail(employee.getEmail());
    return employeeRepository.save(existingEmployee);
  }

  @Override
  public void delete(long id) {
    Employee existingEmployee = employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    employeeRepository.delete(existingEmployee);
  }
}
