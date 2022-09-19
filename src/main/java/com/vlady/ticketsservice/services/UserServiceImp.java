package com.vlady.ticketsservice.services;

import com.vlady.ticketsservice.dao.UserRepo;
import com.vlady.ticketsservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> showUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(int id) {
        User user = null;
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent())
            user = optionalUser.get();
        return user;
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(int id) {
        User user = null;
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent())
            user = optionalUser.get();
        return user;
    }

    @Override
    public User markDeleteUser(int id) {
        User user = null;
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent())
            user = optionalUser.get();
        user.setDeleted(false);
        return user;
    }
}
