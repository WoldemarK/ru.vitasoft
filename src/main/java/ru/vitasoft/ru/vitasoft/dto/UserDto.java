package ru.vitasoft.ru.vitasoft.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import ru.vitasoft.ru.vitasoft.model.Role;
import ru.vitasoft.ru.vitasoft.model.Status;

@Data
@Builder
@Schema(description = "Сущность проекта инициатора")
public class UserDto {
    @Schema(description = "Уникальный идентификатор заявки")
    private Long id;
    @Schema(description = "Имя инициатора заявки")
    private String name;
    @Schema(description = "Логин")
    private String email;
    @Schema(description = "Роль на портале")
    private Role role;

    @Schema(description = "Статус активности аккаунта")
    private Status status;
}
