package com.springbootjdbc.crud.model;

public final class QueryConstant {
    public final static String GET_ALL_EMPLOYEE="SELECT * FROM companydata.employeetable";
    public final static String GET_EMPLOYEE_BY_ID="SELECT * FROM companydata.employeetable where id=?";
    public final static String SAVE_EMPLOYEE="INSERT INTO companydata.employeetable (id,name,location,department) VALUES(?,?,?,?)";
    public final static String DELETE_EMPLOYEE_BY_ID="DELETE FROM companydata.employeetable WHERE id=?";
    public final static String UPDATE_EMPLOYEE="UPDATE companydata.employeetable SET name=?,location=?,department=? WHERE id=?";
}
