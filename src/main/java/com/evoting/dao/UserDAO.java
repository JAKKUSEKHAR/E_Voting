package com.evoting.dao;

import java.util.List;
import com.evoting.dto.User;

public interface UserDAO {

    boolean registerUser(User u);

    User login(String email, String password);

    List<User> getPendingUsers();

    boolean approveUser(int userId, String token);
}
