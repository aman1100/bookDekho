package com.bookdekho.application.serviceimpl;

import com.bookdekho.application.dto.UserDTO;
import com.bookdekho.application.exception.EntityNotFoundException;
import com.bookdekho.application.model.User;
import com.bookdekho.application.repository.UserRepository;
import com.bookdekho.application.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).orElseThrow(EntityNotFoundException :: new);
        BeanUtils.copyProperties(userDTO,user);
        userRepository.save(user);
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    @Override
    public UserDTO getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException :: new);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    @Override
    public Page<User> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Boolean checkUserExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
