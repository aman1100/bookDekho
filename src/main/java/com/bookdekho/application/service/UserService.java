package com.bookdekho.application.service;

import com.bookdekho.application.dto.UserDTO;
import com.bookdekho.application.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO addUser(UserDTO userDTO);

    UserDTO updateUser(String userId, UserDTO userDTO);

    UserDTO getUserById(String userId);

    Page<User> getAllUsers(int page, int size);

    void deleteUserById(String userId);

    Boolean checkUserExists(String emailId);
}
