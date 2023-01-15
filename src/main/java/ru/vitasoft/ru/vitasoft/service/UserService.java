package ru.vitasoft.ru.vitasoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vitasoft.ru.vitasoft.dto.UserDto;
import ru.vitasoft.ru.vitasoft.exception.AllException;
import ru.vitasoft.ru.vitasoft.mapper.UserMapper;
import ru.vitasoft.ru.vitasoft.model.Role;
import ru.vitasoft.ru.vitasoft.model.User;
import ru.vitasoft.ru.vitasoft.repository.RequestRepository;
import ru.vitasoft.ru.vitasoft.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RequestRepository requestRepository;

    public Optional<List<UserDto>> findAll() {
        List<User> personList = userRepository.findAll();

        return Optional.ofNullable(Optional.of(personList.stream()
                        .map(userMapper::convertToUserFromUserDto)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new AllException(("Ошибка вызова, обратитесь к администратору"))));
    }

    public UserDto assignOperaRightsToUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Set<Role> roles = new HashSet<>();
            roles.add(Role.OPERATOR);
            user.get().setRole(Role.OPERATOR);
           // user = requestRepository.save(user.get());
        }

        return userMapper.convertToUserFromUserDto(user.get());
    }
}
