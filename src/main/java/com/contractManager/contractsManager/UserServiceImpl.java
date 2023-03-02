package com.contractManager.contractsManager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.contractManager.contractsManager.repositories.Role;
import com.contractManager.contractsManager.repositories.RoleRepository;
import com.contractManager.contractsManager.repositories.User;
import com.contractManager.contractsManager.repositories.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
    	System.out.println("UserService - saveUser start");
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    	System.out.println("UserService - role problem?");
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        System.out.println(role.toString());
        user.setRoles(Arrays.asList(role));
    	System.out.println("UserService - Role not problem");
    	System.out.println(user);
        userRepository.save(user);
    	System.out.println("UserService - saveUser end");
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        //String[] str = user.getName().split(" ");
        //userDto.setFirstName(str[0]);
        //userDto.setLastName(str[1]);
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
    	System.out.println("mapToUserDto");
        return userDto;
    }

    private Role checkRoleExist(){
    	System.out.println("UserService - checkRoleExist");
        Role role = new Role();
        role.setName("ADMIN");
        return roleRepository.save(role);
    }
}
