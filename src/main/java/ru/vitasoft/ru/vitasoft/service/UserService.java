package ru.vitasoft.ru.vitasoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vitasoft.ru.vitasoft.dto.UserDto;
import ru.vitasoft.ru.vitasoft.exception.AllException;
import ru.vitasoft.ru.vitasoft.mapper.UserMapper;
import ru.vitasoft.ru.vitasoft.model.Role;
import ru.vitasoft.ru.vitasoft.model.User;
import ru.vitasoft.ru.vitasoft.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAll() {
        List<User> personList = userRepository.findAll();

        return personList.stream()
                .map(userMapper::convertToUserFromUserDto)
                .collect(Collectors.toList());

    }

    public UserDto assignOperatorRoleToUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setRole(Role.OPERATOR);
            user = Optional.of(userRepository.save(user.get()));
        }

        return userMapper.convertToUserFromUserDto(user.get());
    }

    public UserDto getByIdUsers(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AllException("По данному " + id + " пользователь не найден"));
        return userMapper.convertToUserFromUserDto(user);
    }
}
