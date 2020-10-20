package com.mycompany.app.roles;

import com.mycompany.app.actionTypes.ActionType;

import java.util.Objects;

public class Admin implements Role {

    String roleName = "ADMIN";

    public Admin() {}

    @Override
    public int checkIfActionCanBePerformed(ActionType actionType) {
        if (actionType.checkActionType("READ") == 1) {
            return 1;
        } else if (actionType.checkActionType("WRITE") == 1) {
            return 1;
        }
        return 0;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return getRoleName().equals(admin.getRoleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleName());
    }
}
