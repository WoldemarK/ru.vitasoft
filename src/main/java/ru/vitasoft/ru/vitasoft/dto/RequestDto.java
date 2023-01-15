package ru.vitasoft.ru.vitasoft.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import ru.vitasoft.ru.vitasoft.model.StatusRequest;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Сущность проекта заявки")
public class RequestDto {
    @Schema(description = "Уникальный идентификатор заявки")
    private Long id;
    @Schema(description = "Заголовок")
    private String header;
    @Schema(description = "Описание проблемы")
    private String description;
    @Schema(description = "ID Person")
    private long personId;
    @Schema(description = "Статус заявки")
    private StatusRequest statusRequest;

    @Schema(description = "Дата  создания заявки")
    private LocalDateTime creation;
}
