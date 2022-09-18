package com.easytemplates.backend.service;

import com.easytemplates.backend.dto.Role;

public interface IRoleService {
	Role findByName(String name);
}
