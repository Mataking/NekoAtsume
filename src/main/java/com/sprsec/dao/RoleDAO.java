package com.sprsec.dao;

import com.sprsec.model.Role;

public interface RoleDAO {

    //permet d'ajouter un nouveau rôle veteran, novice etc ..
    public Role getRole(int id);
}
