package ru.vitasoft.ru.vitasoft.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.vitasoft.ru.vitasoft.model.User;
import ru.vitasoft.ru.vitasoft.security.UserDetailsServiceImpl;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private final UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean supports(Class<?> aClazz) {
        return User.class.equals(aClazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        try {
            userDetailsService.loadUserByUsername(user.getName());
        } catch (UsernameNotFoundException ignored) {
            return;
        }
        errors.rejectValue("username","", "Человек с таким именем уже существует");
    }
}
