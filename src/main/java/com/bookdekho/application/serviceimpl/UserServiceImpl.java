package com.bookdekho.application.serviceimpl;

import com.bookdekho.application.dto.UserDTO;
import com.bookdekho.application.exception.EntityNotFoundException;
import com.bookdekho.application.model.LoginDTO;
import com.bookdekho.application.model.User;
import com.bookdekho.application.repository.UserRepository;
import com.bookdekho.application.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private static final String AUTHENTICATED_USER = "Authenticated User";
    private static final String INCORRECT_PASSWORD = "Incorrect Password";

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encryptedPassword);

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

    @Override
    public String authenticateUser(LoginDTO loginDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(loginDTO.getUserName());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(bCryptPasswordEncoder.matches(loginDTO.getPassword(), user.getPassword()))
                return AUTHENTICATED_USER;
            else
                return INCORRECT_PASSWORD;
        }
        throw new EntityNotFoundException("User is not found with this username !!");
    }
}
