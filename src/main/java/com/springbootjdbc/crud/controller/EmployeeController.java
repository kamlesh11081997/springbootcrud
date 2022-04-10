package com.springbootjdbc.crud.controller;

import com.springbootjdbc.crud.dao.EmployeeDao;
import com.springbootjdbc.crud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDao.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeDao.findById(id);
    }

    @PostMapping("/employees")
    public String save(@RequestBody Employee e){
        return employeeDao.save(e)+" Saved successfully!";
    }

    @DeleteMapping("/employees/{id}")
    public String delete(@PathVariable int id){
        return employeeDao.deleteById(id)+" deleted successfully!";
    }

    @PutMapping("/employees")
    public String update(@RequestBody Employee e,int id){
        return employeeDao.update(e,id)+" updated successfully!";
    }


}
