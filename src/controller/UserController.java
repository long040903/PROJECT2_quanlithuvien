package controller;

import data.EmployeeData;

public class UserController {
    private static EmployeeData loggedInUser;

    public static void setLoggedInUser(EmployeeData user) {
        loggedInUser = user;
    }

    public static EmployeeData getLoggedInUser() {
        return loggedInUser;
    }

    public static void logout() {
        loggedInUser = null;
    }
}

