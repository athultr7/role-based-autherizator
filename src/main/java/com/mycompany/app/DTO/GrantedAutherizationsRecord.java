package com.mycompany.app.DTO;

import com.mycompany.app.actionTypes.ActionType;
import com.mycompany.app.resources.Resource;
import com.mycompany.app.roles.Role;
import com.mycompany.app.roles.RoleFactory;
import com.mycompany.app.users.User;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class GrantedAutherizationsRecord {

    private ArrayList<ArrayList<String>> autherizations;

    public GrantedAutherizationsRecord() {
        this.autherizations = new ArrayList<ArrayList<String>>();
    };

    public void addUserResourceRole(String userName, String resourceName, String roleName) {
        autherizations.add(new ArrayList<String>(Arrays.asList(userName, resourceName, roleName)));
    }

    public int checkIfUserResourceRoleExists(String userName, String resourceName, String roleName) {
        for (ArrayList<String> userResourceRole: autherizations) {
            if (userResourceRole.get(0).equals(userName) && userResourceRole.get(1).equals(resourceName) && userResourceRole.get(2).equals(roleName)) {
                return 1;
            }
        }
        return 0;
    }

    public String getRoleByUserResource(String userName, String resourceName) {
        for (ArrayList<String> userResourceRole: autherizations) {
            if (userResourceRole.get(0).equals(userName) && userResourceRole.get(1).equals(resourceName)) {
                return userResourceRole.get(2);
            }
        }
        return null;
    }

    public void deleteByUserRoleResource(String userName, String resourceName, String roleName) {
        Iterator it =  autherizations.iterator();
        while (it.hasNext())
        {
            ArrayList<String> userResourceRole = (ArrayList<String>)it.next();
            if (userResourceRole.get(0).equals(userName) && userResourceRole.get(1).equals(resourceName) && userResourceRole.get(2).equals(roleName)) {
                it.remove();
                break;
            }
        }
    }

}
