package com.springbootjdbc.crud.daoImpl;

import com.springbootjdbc.crud.model.Employee;
import com.springbootjdbc.crud.dao.EmployeeDao;
import com.springbootjdbc.crud.model.QueryConstant;
import com.springbootjdbc.crud.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    EnvironmentService environmentService;

    @Autowired
    public void setEnvironmentService(EnvironmentService environmentService){
        this.environmentService=environmentService;
    }

    @Override
    public List<Employee> findAll() {
        return environmentService.getJdbcTemplate().query(QueryConstant.GET_ALL_EMPLOYEE,
                new EmployeeRowMapper());
    }

    @Override
    public Employee findById(int id) {
        return environmentService.getJdbcTemplate().queryForObject(QueryConstant.GET_EMPLOYEE_BY_ID,
                new EmployeeRowMapper(), id);
    }

    @Override
    public int deleteById(int id) {
        return environmentService.getJdbcTemplate().update(QueryConstant.DELETE_EMPLOYEE_BY_ID,id);
    }

    @Override
    public int save(Employee e) {
        return environmentService.getJdbcTemplate().update(QueryConstant.SAVE_EMPLOYEE,
                e.getId(),e.getName(),e.getLocation(),e.getDepartment());
    }

    @Override
    public int update(Employee e, int id) {
        return environmentService.getJdbcTemplate().update(QueryConstant.UPDATE_EMPLOYEE,
                e.getName(),e.getLocation(),e.getDepartment(),e.getId());
    }
}
