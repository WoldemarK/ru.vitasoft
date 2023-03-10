package ru.vitasoft.ru.vitasoft.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.ru.vitasoft.dto.UserDto;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/user")
@Tag(name = "Управление", description = "Администратор управляет правами доступа.")
public interface UserControllerApi {

    @GetMapping("/admin") // list
    @PreAuthorize("hasAuthority('user:write')")
    @Operation(summary = "Вывод ", description = "Позволяет вывести всех пользователей")
    ResponseEntity<List<UserDto>> getAll();
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    @Operation(summary = "Вывод ", description = "Позволяет вывести пользователя по ID")
    ResponseEntity<UserDto> getByIdUsers(@Validated @PathVariable("id")Long id);

    @PostMapping("/admin/{id}") // /ID/role
    @PreAuthorize("hasAuthority('user:update')")
    @Operation(summary = "Добавление ", description = "Позволяет добавить пользователю роль оператора")
    ResponseEntity<UserDto> addOperator(@PathVariable("id") Long id);
}

