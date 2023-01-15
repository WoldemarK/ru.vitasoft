package ru.vitasoft.ru.vitasoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.ru.vitasoft.controller.api.RequestControllerApi;
import ru.vitasoft.ru.vitasoft.dto.RequestDto;
import ru.vitasoft.ru.vitasoft.service.RequestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RequestController implements RequestControllerApi {
    private final RequestService requestService;

    @Override
    public ResponseEntity<RequestDto> createRequest(RequestDto requestDto) {
        return ResponseEntity.ok(requestService.createRequest(requestDto));
    }

    @Override
    public ResponseEntity<List<RequestDto>> viewingApplications(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<RequestDto> update(RequestDto requestDto) {
        return null;
    }

    @Override
    public ResponseEntity<RequestDto> submitForReviewRequest(Long id) {
        return null;
    }
}
