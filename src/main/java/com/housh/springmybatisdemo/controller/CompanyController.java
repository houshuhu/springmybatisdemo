package com.housh.springmybatisdemo.controller;

import com.housh.springmybatisdemo.mapper.CompanyMapper;
import com.housh.springmybatisdemo.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyMapper mapper;

    @RequestMapping("/getAll")
    public List<Company> selectAll() {
        return mapper.selectAll();
    }
}
