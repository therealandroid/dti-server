package com.dti.codechallenge.server.mapper;

import com.dti.codechallenge.server.entities.User;
import com.dti.codechallenge.server.viewmodel.UserViewModel;

public class UserMapper {

    public UserViewModel toViewModel(User u) {
        UserViewModel userViewModel = new UserViewModel();
        userViewModel.setId(u.getId());
        userViewModel.setUsername(u.getUsername());
        userViewModel.setFirstName(u.getFirstName());
        userViewModel.setLastName(u.getLastName());
        userViewModel.setEmail(u.getEmail());
        //Do not expose password
        return userViewModel;
    }

    public User toEntity(UserViewModel userViewModel) {
        User user = new User();
        //ID is auto generated
        user.setFirstName(userViewModel.getFirstName());
        user.setLastName(userViewModel.getLastName());
        user.setUsername(userViewModel.getUsername());
        user.setEmail(userViewModel.getEmail());
        user.setPassword(userViewModel.getPassword());
        return user;
    }

}
