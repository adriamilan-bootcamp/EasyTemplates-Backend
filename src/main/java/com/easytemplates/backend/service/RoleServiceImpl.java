package com.easytemplates.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easytemplates.backend.dao.IRoleDAO;
import com.easytemplates.backend.dto.Role;

@Service(value = "roleSvc")
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
    private IRoleDAO roleDAO;

    @Override
    public Role findByName(String name) {
        Role role = roleDAO.findByName(name);
        return role;
    }
    
}
