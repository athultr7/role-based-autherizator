package com.mycompany.app.actionTypes;

import java.util.Objects;

public class Grant implements ActionType {
    private String action = "GRANT";

    public Grant() {}

    @Override
    public int checkActionType(String action) {
        if (this.action == action) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grant)) return false;
        Grant grant = (Grant) o;
        return action.equals(grant.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }

}
