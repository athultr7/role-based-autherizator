package com.mycompany.app.services;

import com.mycompany.app.DTO.GrantedAutherizationsRecord;
import com.mycompany.app.actionTypes.*;
import com.mycompany.app.resources.Resource;
import com.mycompany.app.resources.ResourceImpl;
import com.mycompany.app.roles.*;
import com.mycompany.app.users.User;
import com.mycompany.app.users.UserImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuthenterizationService {

    private List<User> users;

    private List<Resource> resources;

    private List<ActionType> actionTypes;

    private List<Role> roles;

    private GrantedAutherizationsRecord grantedAutherizationsRecord;

    public AuthenterizationService() {
        users = new ArrayList<User>();
        resources = new ArrayList<Resource>();
        actionTypes = new ArrayList<ActionType>();
        roles = new ArrayList<Role>();
        grantedAutherizationsRecord = new GrantedAutherizationsRecord();
        createInitialData();
    }

    public int checkAutherization(String userName, String actionName, String resourceName) {
        User user = new UserImpl(userName);
        Resource resource = new ResourceImpl(resourceName);
        ActionType actionType = ActionTypeFactory.getActionType(actionName);

        if (checkIfUserExists(user) == 1) {
            if (checkIfResourceExists(resource) == 1) {
                if (checkIfActionTypeExists(actionType) == 1) {
                    String roleName = grantedAutherizationsRecord.getRoleByUserResource(
                            user.getUserName(),
                            resource.getResourceName()
                    );
                    Role role = RoleFactory.getRole(roleName);
                    if (role != null && role.checkIfActionCanBePerformed(actionType) == 1) {
                        return 1;
                    } else {
                        return 0;
                    }
                } else {
                    return -2;
                }
            } else {
                return -1;
            }
        }
        return -3;
    }

    public int addNewUser(String userName) {
        User newUser = new UserImpl(userName);
        if (checkIfUserExists(newUser) != 1) {
            users.add(newUser);
            return 1;
        }
        return 0;
    }

    public int addUserResourceRole(String userName, String resourceName, String roleName) {
        User user = new UserImpl(userName);
        Role role = RoleFactory.getRole(roleName);
        Resource resource = new ResourceImpl(resourceName);

        if (checkIfUserExists(user) == 1) {
            if (checkIfResourceExists(resource) == 1) {
                if (checkIfRoleExists(role) == 1) {
//                    checkIfUserCanAddRole();
                    if(checkIfUserRoleResourceExists(user, role, resource) == 0) {
                        addNewUserResourceRole(user, resource, role);
                        return 1;
                    } else {
                        return -5;
                    }
                } else {
                    return -4;
                }
            } else {
                return -1;
            }
        }
        return -3;
    }

    public int removeUserResourceRole(String userName, String resourceName, String roleName) {
        User user = new UserImpl(userName);
        Role role = RoleFactory.getRole(roleName);
        Resource resource = new ResourceImpl(resourceName);

        if (checkIfUserExists(user) == 1) {
            if (checkIfResourceExists(resource) == 1) {
                if (checkIfRoleExists(role) == 1) {
//                    checkIfUserCanAddRole();
                    if(checkIfUserRoleResourceExists(user, role, resource) == 0) {
                        System.out.println(grantedAutherizationsRecord);
                        grantedAutherizationsRecord.deleteByUserRoleResource(
                                user.getUserName(),
                                role.getRoleName(),
                                resource.getResourceName()
                        );
                        System.out.println(grantedAutherizationsRecord);
                        return 1;
                    } else {
                        return -5;
                    }
                } else {
                    return -4;
                }
            } else {
                return -1;
            }
        }
        return -3;
    }

    public void addNewUserResourceRole(User user, Resource resource, Role role) {
        grantedAutherizationsRecord.addUserResourceRole(
                user.getUserName(),
                resource.getResourceName(),
                role.getRoleName()
        );
    }

    public int checkIfUserExists(User user) {
        if (user != null && users.contains(user)) {
            return 1;
        }
        return 0;
    }

    public int checkIfResourceExists(Resource resource) {
        if (resource != null && resources.contains(resource)) {
            return 1;
        }
        return 0;
    }

    public int checkIfActionTypeExists(ActionType actionType) {
        if (actionType != null && actionTypes.contains(actionType)) {
            return 1;
        }
        return 0;
    }

    public int checkIfRoleExists(Role role) {
        if (role != null && roles.contains(role)) {
            return 1;
        }
        return 0;
    }

    public int checkIfUserRoleResourceExists(User user, Role role, Resource resource) {
        return grantedAutherizationsRecord.checkIfUserResourceRoleExists(
                user.getUserName(),
                role.getRoleName(),
                resource.getResourceName()
        );
    }

    public void createInitialData() {
        users.add(new UserImpl("athul"));
        users.add(new UserImpl("linus"));
        users.add(new UserImpl("akame"));

        resources.add(new ResourceImpl("server-development"));
        resources.add(new ResourceImpl("server-production"));

        actionTypes.add(new Read());
        actionTypes.add(new Write());
        actionTypes.add(new Delete());

        roles.add(new God());
        roles.add(new Client());
        roles.add(new Admin());
        roles.add(new Manager());

        grantedAutherizationsRecord.addUserResourceRole("athul","server-development", "ADMIN");
        grantedAutherizationsRecord.addUserResourceRole("athul","server-production", "CLIENT");
        grantedAutherizationsRecord.addUserResourceRole("linus","server-development", "MANAGER");
        grantedAutherizationsRecord.addUserResourceRole("akame", "server-development", "CLIENT");
        grantedAutherizationsRecord.addUserResourceRole("linus", "server-production", "ADMIN");
    }
}
