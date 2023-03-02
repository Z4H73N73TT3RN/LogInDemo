package com.contractManager.contractsManager;

import java.util.List;

import com.contractManager.contractsManager.repositories.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}