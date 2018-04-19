package com.housh.springmybatisdemo.mapper;

import com.housh.springmybatisdemo.model.Company;
import java.util.List;

public interface CompanyMapper {
    int insert(Company record);

    List<Company> selectAll();
}