package com.housh.springmybatisdemo;

import com.housh.springmybatisdemo.mapper.EmployeeMapper;
import com.housh.springmybatisdemo.model.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringmybatisdemoApplicationTests {

    private static Logger logger = Logger.getLogger(SpringmybatisdemoApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    private SqlSession getSqlSession() {
        String source = "mybatis/mybatis-config.xml";
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream(source);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            SqlSession session = factory.openSession();
            return session;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    /*接口式編程*/
    @Test
    public void GetEmployeeById() {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getById(1);
        System.out.println(employee.toString());
        logger.debug("LIJUI");
    }

    /*Map 入參*/
    @Test
    public void GetByMapIdAndLastName() {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("lastname", "test01");
        Employee byMapIdAndLastName = mapper.getByMapIdAndLastName(map);
        System.out.println(byMapIdAndLastName);
    }

    /*Select返回List*/
    @Test
    public void GetList() {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.getEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

    /*Select 返回Map*/
    @Test
    public void getEmpByIdReturnMap()
    {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> empByIdReturnMap = mapper.getEmpByIdReturnMap(1);
        System.out.println(empByIdReturnMap);
    }

    /*Select 返回Map*/
    @Test
    public void getEmpReturnEmployees()
    {
        SqlSession session = getSqlSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Map<String, Employee> empByIdReturnMap = mapper.getEmpReturnEmployees();
        System.out.println(empByIdReturnMap);
    }



}
