package ru.vitasoft.ru.vitasoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.ru.vitasoft.controller.api.UserControllerApi;
import ru.vitasoft.ru.vitasoft.dto.UserDto;
import ru.vitasoft.ru.vitasoft.exception.AllException;
import ru.vitasoft.ru.vitasoft.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@RestController
@RequiredArgsConstructor
public class UserController implements UserControllerApi {
    private final UserService userService;

    @Override
    public Optional<List<UserDto>> getAll() {
        return Optional.ofNullable(Objects.requireNonNull(ResponseEntity.ok(userService.findAll())
                .getBody()).orElseThrow(() -> new AllException("getAll")));
    }

    @Override
    public ResponseEntity<Optional<UserDto>> getByIdUsers(Long id) {
        return ResponseEntity.ok(Optional.ofNullable(userService.getByIdUsers(id)
                .orElseThrow(() -> new AllException("По данному " + id + " пользователь не найден"))));
    }

    @Override
    public ResponseEntity<UserDto> addOperator(Long id) {
        UserDto person = userService.assignOperaRightsToUser(id);
        return ResponseEntity.ok(person);
    }
}
