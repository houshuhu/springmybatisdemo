package com.housh.springmybatisdemo.mapper;

import com.housh.springmybatisdemo.model.MenuBinding;

import java.util.List;

public interface MenuBindingMapper {
    int insert(MenuBinding record);

    int insertSelective(MenuBinding record);

    List<MenuBinding> getMenus();
}