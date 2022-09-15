package com.easytemplates.backend.security;

import java.util.HashMap;
import java.util.Map;

import com.easytemplates.backend.security.SecurityConfig.SECURITY_ROLE;

public class SecurityRole {

    public static final Map<SECURITY_ROLE, Class> MAPPING = new HashMap<>();

    static {
        MAPPING.put(SECURITY_ROLE.ROLE_ADMIN, role_admin.class);
        MAPPING.put(SECURITY_ROLE.ROLE_USER, role_user.class);
    }

    public static class role_user {

    }

    public static class role_admin extends role_user {

    }
}
