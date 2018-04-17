package com.housh.springmybatisdemo.service;

import com.housh.springmybatisdemo.model.MenuBinding;

import java.util.List;

public interface MenuService {
    List<MenuBinding> getMenus();
}
