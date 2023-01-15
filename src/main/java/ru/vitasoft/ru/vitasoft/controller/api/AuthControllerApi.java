package ru.vitasoft.ru.vitasoft.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
@Tag(name = "Авторизация", description = "Авторизация на портале.")
public interface AuthControllerApi {

    @GetMapping("/login")
    @Operation(summary = "Клиентский вход ",
            description = "Если пользователь зарегистрирован на портале")
    String getLoginPage();
}
