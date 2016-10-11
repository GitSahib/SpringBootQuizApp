package edu.mum.quiz.service.security.interfaces;

import edu.mum.quiz.domain.Role;

public interface RoleService {
    void save(Role role);
    Role findRoleByName(String name);
}
