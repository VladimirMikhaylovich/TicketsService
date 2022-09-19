package com.vlady.ticketsservice.services;


import com.vlady.ticketsservice.models.User;

import java.security.PublicKey;
import java.util.List;

public interface UserService {

    public List<User> showUsers();
    public User getUser(int id);
    public User addUser(User user);
    public User updateUser(int id);
    public User markDeleteUser(int id);
}
