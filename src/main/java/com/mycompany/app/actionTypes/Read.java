package com.mycompany.app.actionTypes;

import java.util.Objects;

public class Read implements ActionType {

    private String action = "READ";

    public Read() {
    }

    public int checkActionType(String action) {
        if (action == this.action) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Read)) return false;
        Read read = (Read) o;
        return action.equals(read.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }

}
