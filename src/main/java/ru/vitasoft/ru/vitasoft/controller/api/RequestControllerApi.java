package ru.vitasoft.ru.vitasoft.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.vitasoft.ru.vitasoft.dto.RequestDto;

@RequestMapping("/api/request")
@Tag(name = "Управление заявками", description = "Создание, поиск, получение.")
public interface RequestControllerApi {
    @PostMapping("/")
    @PreAuthorize("hasAuthority('user:write')")
    @Operation(summary = "Пользователь ", description = "Может создавать заявки.")
    ResponseEntity<RequestDto> createRequest(@RequestBody RequestDto requestDto);

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    @Operation(summary = "Пользователь ", description = "Просмотр всех им созданных заявок.")
    RequestDto viewingApplications(@PathVariable("id") Long id);

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('user:update')")
    @Operation(summary = "Пользователь ", description = "Редактировать созданные им заявки в статусе «черновик».")
    ResponseEntity<RequestDto> update(@RequestBody RequestDto requestDto);

    @GetMapping("/{id}/get")
    @PreAuthorize("hasAuthority('user:read')")
    @Operation(summary = "Пользователь ", description = "Отправлять заявки на рассмотрение оператору.")
    ResponseEntity<RequestDto> submitForReviewRequest(@PathVariable Long id);

//    @GetMapping("/")
//    @Operation(summary = "Оператор", description = "Просматривать отправленные на рассмотрение  заявки.")
//    ResponseEntity<RequestDto> getAllRequestStatus();
//
//    @PostMapping("/")
//    @Operation(summary = "Оператор", description = "Принимать заявки.")
//    ResponseEntity<RequestDto>acceptApplications();
//
//    @PostMapping("/")
//    @Operation(summary = "Оператор", description = "Отклонять заявки.")
//    ResponseEntity<RequestDto>rejectApplications();
}
