package ru.vitasoft.ru.vitasoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.ru.vitasoft.controller.api.UserControllerApi;
import ru.vitasoft.ru.vitasoft.dto.UserDto;
import ru.vitasoft.ru.vitasoft.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserControllerApi {
    private final UserService userService;

    @Override
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.findAll());

    }

    @Override
    public ResponseEntity<UserDto> getByIdUsers(Long id) {
        return ResponseEntity.ok(userService.getByIdUsers(id));

    }

    @Override
    public ResponseEntity<UserDto> addOperator(Long id) {
        UserDto person = userService.assignOperatorRoleToUser(id);
        return ResponseEntity.ok(person);
    }
}
