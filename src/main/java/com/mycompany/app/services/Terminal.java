package com.mycompany.app.services;

import java.util.Scanner;

public class Terminal {


    private AuthenterizationService authenterizationService;

    public Terminal() {
        authenterizationService = new AuthenterizationService();
    }

    public void start () {
        System.out.println("Usage: >> <user-name> <action-type> <resource-name>");
        System.out.println("Example: >> athul read server-production");
        while (true) {
            System.out.print(">> ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            if (command.equals("exit") || command.equals("Q") || command.equals("quit")) {
                System.exit(1);
            }

            String[] commandSplited = command.split("\\s+");
            if (commandSplited.length == 5 && commandSplited[0].equals("add") && commandSplited[1].equals("role")) {
                String userName = commandSplited[2];
                String roleName = commandSplited[3];
                String resourceName = commandSplited[4];
                int status = authenterizationService.addUserResourceRole(userName, resourceName, roleName);
                if (status == 1) {
                    System.out.println("New role added for " + userName);
                } else if (status == 0) {
                    System.out.println("You are not authorized to perform this action. Sorry.");
                } else if (status == -1) {
                    System.out.println("The resource does not exist. Please check.");
                } else if (status == -2) {
                    System.out.println("The requested action is not valid. Please check.");
                } else if (status == -3) {
                    System.out.println("The username is not valid. Please check.");
                } else if (status == -5) {
                    System.out.println("The user already has the role for this resource.");
                }
            } else if (commandSplited.length == 5 && commandSplited[0].equals("remove") && commandSplited[1].equals("role")) {
                String userName = commandSplited[2];
                String roleName = commandSplited[3];
                String resourceName = commandSplited[4];
                int status = authenterizationService.removeUserResourceRole(userName, resourceName, roleName);
            } else if (commandSplited.length == 3 && commandSplited[0].equals("add") && commandSplited[1].equals("user")) {
                int status = authenterizationService.addNewUser(commandSplited[2]);
                if (status == 1) {
                    System.out.println("New user " + commandSplited[2] + " created.");
                } else if (status == 0) {
                    System.out.println("User " + commandSplited[2] + " already exists.");
                }
            } else if (commandSplited.length == 3) {
                String userName = commandSplited[0];
                String actionType = commandSplited[1];
                String resourceName = commandSplited[2];

                int status = authenterizationService.checkAutherization(userName, actionType, resourceName);
                if(status == 1) {
                    System.out.println("You are authorized to perform this action.");
                } else if(status == 0) {
                    System.out.println("You are not authorized to perform this action. Sorry.");
                } else if(status == -1) {
                    System.out.println("The resource does not exist. Please check.");
                } else if(status == -2) {
                    System.out.println("The requested action is not valid. Please check.");
                } else if(status == -3) {
                    System.out.println("The username is not valid. Please check.");
                }
            } else {
                System.out.println("Invalid command entered.");
                System.out.println("Please follow this convention: >> <user-name> <action-type> <resource-name>");
            }
        }
    }
}
