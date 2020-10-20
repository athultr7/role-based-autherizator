package com.mycompany.app.roles;

import com.mycompany.app.actionTypes.ActionType;

public interface Role {
    public int checkIfActionCanBePerformed(ActionType actionType);
    public String getRoleName();
    public void setRoleName(String roleName);
}
