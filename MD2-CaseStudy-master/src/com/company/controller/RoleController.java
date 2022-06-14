package com.company.controller;

import com.company.model.Role;
import com.company.service.role.RoleSeviceIMPL;

import java.util.List;

public class RoleController {
    RoleSeviceIMPL roleSeviceIMPL = new RoleSeviceIMPL();
    public List<Role> showListRole(){
        return roleSeviceIMPL.findAll();
    }
}
