package com.springbootjdbc.crud.daoImpl;

import com.springbootjdbc.crud.model.Employee;
import com.springbootjdbc.crud.dao.EmployeeDao;
import com.springbootjdbc.crud.model.QueryConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(QueryConstant.GET_ALL_EMPLOYEE,
                new EmployeeRowMapper());
    }

    @Override
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject(QueryConstant.GET_EMPLOYEE_BY_ID,
                new EmployeeRowMapper(), id);
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update(QueryConstant.DELETE_EMPLOYEE_BY_ID,id);
    }

    @Override
    public int save(Employee e) {
        return jdbcTemplate.update(QueryConstant.SAVE_EMPLOYEE,
                e.getId(),e.getName(),e.getLocation(),e.getDepartment());
    }

    @Override
    public int update(Employee e, int id) {
        return jdbcTemplate.update(QueryConstant.UPDATE_EMPLOYEE,
                e.getName(),e.getLocation(),e.getDepartment(),e.getId());
    }
}
