package com.mycompany.app.roles;

import com.mycompany.app.actionTypes.ActionType;

import java.util.Objects;

public class Client implements Role {

    private String roleName = "CLIENT";

    public Client() {}

    public int checkIfActionCanBePerformed(ActionType actionType) {
        if (actionType.checkActionType("READ") == 1) {
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
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getRoleName().equals(client.getRoleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleName());
    }
}
