package com.mycompany.app.roles;

import com.mycompany.app.users.User;

public class RoleFactory {

    public static Role getRole(String roleName) {
        if (roleName != null) {
            if (roleName.equals("CLIENT") || roleName.equals("client") || roleName.equals("Client")) {
                return new Client();
            } else if (roleName.equals("ADMIN") || roleName.equals("admin") || roleName.equals("Admin")) {
                return new Admin();
            } else if (roleName.equals("MANAGER") || roleName.equals("manager") || roleName.equals("Manager")) {
                return new Manager();
            } else if (roleName.equals("GOD") || roleName.equals("god")  || roleName.equals("God")) {
                return new God();
            }
        }
        return null;
    }

}
