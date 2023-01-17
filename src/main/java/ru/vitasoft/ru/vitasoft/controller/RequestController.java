package ru.vitasoft.ru.vitasoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vitasoft.ru.vitasoft.controller.api.RequestControllerApi;
import ru.vitasoft.ru.vitasoft.dto.RequestDto;
import ru.vitasoft.ru.vitasoft.service.RequestService;

@RestController
@RequiredArgsConstructor
public class RequestController implements RequestControllerApi {
    private final RequestService requestService;
    @Override
    public ResponseEntity<RequestDto> createRequest(RequestDto requestDto) {
        return ResponseEntity.ok(requestService.createRequest(requestDto));
    }
    @Override
    public RequestDto viewingApplications(Long id) {
        return requestService.viewingApplications(id);
    }
    @Override
    public ResponseEntity<RequestDto> update(RequestDto requestDto) {
        return ResponseEntity.ok(requestService.update(requestDto));
    }
    @Override
    public ResponseEntity<RequestDto> submitForReviewRequest(Long id) {
        return ResponseEntity.ok(requestService.submitForReviewRequest(id));
    }

    @Override
    public RequestDto getAllRequestStatus() {
        return requestService.getAllRequestStatus();
    }
}
