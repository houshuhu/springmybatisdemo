package com.housh.springmybatisdemo.controller;

import com.housh.springmybatisdemo.mapper.EmployeeMapper;
import com.housh.springmybatisdemo.model.Employee;
import com.housh.springmybatisdemo.model.MenuBinding;
import com.housh.springmybatisdemo.service.MenuService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private MenuService menuService;
    @ResponseBody
    @RequestMapping(value = "/getMenus", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<MenuBinding> GetMenus() {
        List<MenuBinding> menus = menuService.getMenus();
        return menus;
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<Employee> GetAll() {
        SqlSession sqlSession = getSqlSession1();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.getEmployees();
        return employees;
    }


    private SqlSession getSqlSession1() {
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
}
