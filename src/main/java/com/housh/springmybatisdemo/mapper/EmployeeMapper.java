package com.housh.springmybatisdemo.mapper;

import com.housh.springmybatisdemo.model.Employee;
import java.util.List;

public interface EmployeeMapper {
    int insert(Employee record);

    List<Employee> selectAll();
}