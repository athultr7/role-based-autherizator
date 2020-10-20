package com.mycompany.app.actionTypes;

import java.util.Objects;

public class Add implements ActionType {

    private String action = "ADD";

    public Add() {}

    @Override
    public int checkActionType(String action) {
        if (action == this.action) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Add)) return false;
        Add add = (Add) o;
        return action.equals(add.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action);
    }
}
