package com.mycompany.app.actionTypes;

import java.util.Objects;

public class Write implements ActionType {

    private String action = "READ";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Write)) return false;
        Write write = (Write) o;
        return action.equals(write.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }

    public Write() {}

    public int checkActionType(String action) {
        if (action == this.action) {
            return 1;
        }
        return 0;
    }
}
