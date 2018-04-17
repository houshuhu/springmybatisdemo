package com.housh.springmybatisdemo.service.impl;

import com.housh.springmybatisdemo.mapper.MenuBindingMapper;
import com.housh.springmybatisdemo.model.MenuBinding;
import com.housh.springmybatisdemo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuBindingMapper menuBindingMapper;
    @Override
    public List<MenuBinding> getMenus() {
        return menuBindingMapper.getMenus();
    }
}
