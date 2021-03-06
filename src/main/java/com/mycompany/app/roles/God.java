package com.mycompany.app.roles;

import com.mycompany.app.actionTypes.ActionType;

import java.util.Objects;

public class God implements Role {

    private String roleName = "GOD";

    public God() {}

    @Override
    public int checkIfActionCanBePerformed(ActionType actionType) {
        if (actionType.checkActionType("ADD") == 1) {
            return 1;
        } else if (actionType.checkActionType("GRANT") == 1) {
            return 1;
        } else if (actionType.checkActionType("READ") == 1) {
            return 1;
        } else if (actionType.checkActionType("WRITE") == 1) {
            return 1;
        } else if (actionType.checkActionType("DELETE") == 1) {
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
        if (!(o instanceof God)) return false;
        God god = (God) o;
        return getRoleName().equals(god.getRoleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleName());
    }
}
