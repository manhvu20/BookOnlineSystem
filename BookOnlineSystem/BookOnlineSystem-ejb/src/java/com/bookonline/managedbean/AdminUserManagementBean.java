package com.bookonline.managedbean;

import javax.inject.Inject;
import com.bookonline.entities.User;
import com.bookonline.sessions.UserManagement;
import java.util.List;

public class AdminUserManagementBean {

    @Inject
    private UserManagement userManagement;

    public List<User> getAllUsers() {
        return userManagement.getAllUsers();
    }

    public void updateUser(User user) {
        userManagement.updateUser(user);
    }

    public void deleteUser(String username) {
        userManagement.deleteUser(username);
    }
}
