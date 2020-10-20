package com.mycompany.app.actionTypes;

import java.util.Objects;

public class Delete implements ActionType {
    private String action = "DELETE";

    public Delete() {}

    public int checkActionType(String action) {
        if (action == this.action) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delete)) return false;
        Delete delete = (Delete) o;
        return action.equals(delete.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }

}
