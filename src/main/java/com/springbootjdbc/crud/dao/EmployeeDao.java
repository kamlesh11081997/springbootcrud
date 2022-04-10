package com.springbootjdbc.crud.dao;

import com.springbootjdbc.crud.model.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int id);
    int deleteById(int id);
    int save(Employee e);
    int update(Employee e, int id);
}
