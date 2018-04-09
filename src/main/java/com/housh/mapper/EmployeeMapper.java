package com.housh.mapper;

import com.housh.model.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Employee getById(Integer id);

    Employee getByMapIdAndLastName(Map<String, Object> map);

    //返回List
    List<Employee> getEmployees();

    //返回Map,key是列名， value是列值
    Map<String, Object> getEmpByIdReturnMap(Integer id);

    //返回Map,key是主鍵id， value是employee
    @MapKey("id")
    Map<String, Employee> getEmpReturnEmployees();
}
