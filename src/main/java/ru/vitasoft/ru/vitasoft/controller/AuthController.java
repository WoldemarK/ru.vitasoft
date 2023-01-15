package ru.vitasoft.ru.vitasoft.controller;

import org.springframework.stereotype.Controller;
import ru.vitasoft.ru.vitasoft.controller.api.AuthControllerApi;

@Controller
public class AuthController implements AuthControllerApi {
    @Override
    public String getLoginPage() {
        return "login";
    }


}
