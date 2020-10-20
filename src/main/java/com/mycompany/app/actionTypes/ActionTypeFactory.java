package com.mycompany.app.actionTypes;

public class ActionTypeFactory {

    public static ActionType getActionType(String actionType) {
        if (actionType.equals("READ") || actionType.equals("read") || actionType.equals("Read")) {
            return new Read();
        }
        else if (actionType.equals("WRITE") || actionType.equals("write") || actionType.equals("Write")) {
            return new Write();
        } else if (actionType.equals("DELETE") || actionType.equals("delete") || actionType.equals("Delete")) {
            return new Delete();
        } else if (actionType.equals("ADD") || actionType.equals("add") || actionType.equals("Add")) {
            return new Add();
        } else if (actionType.equals("GRANT") || actionType.equals("grant") || actionType.equals("Grant")) {
            return new Grant();
        }
        return null;
    }

}
