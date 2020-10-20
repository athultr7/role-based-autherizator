package com.mycompany.app.users;

import com.mycompany.app.actionTypes.ActionType;
import com.mycompany.app.resources.Resource;
import com.mycompany.app.resources.ResourceImpl;
import com.mycompany.app.roles.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class UserImpl implements User {

    private String userName;

    public UserImpl(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserImpl)) return false;
        UserImpl user = (UserImpl) o;
        return userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
