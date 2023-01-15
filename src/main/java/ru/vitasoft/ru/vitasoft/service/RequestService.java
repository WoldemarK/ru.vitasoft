package ru.vitasoft.ru.vitasoft.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vitasoft.ru.vitasoft.dto.RequestDto;
import ru.vitasoft.ru.vitasoft.exception.AllException;
import ru.vitasoft.ru.vitasoft.mapper.RequestMapper;
import ru.vitasoft.ru.vitasoft.model.Request;
import ru.vitasoft.ru.vitasoft.model.StatusRequest;
import ru.vitasoft.ru.vitasoft.repository.RequestRepository;
import ru.vitasoft.ru.vitasoft.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final RequestMapper requestMapper;

    public RequestDto createRequest(RequestDto requestDto) {
        Request request = requestMapper.convertToRequest(requestDto);
        request = requestRepository.save(request);
        return requestMapper.convertToRequestDto(request);
    }

    public RequestDto viewingApplications(Long id) {
        List<RequestDto> list = requestRepository.findByUser(userRepository.findById(id).get());
        return list.stream().findAny().orElseThrow(() -> new AllException(""));

    }

    public RequestDto update(RequestDto requestDto) {
        if (requestDto.getStatusRequest() == StatusRequest.DRAFT) {
            Request request = requestMapper.convertToRequest(requestDto);
            request = requestRepository.save(request);
            requestMapper.updateFromDto(requestDto, request);
        }
        return requestDto;
    }

    public RequestDto submitForReviewRequest(Long id) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new AllException("submitForReviewRequest"));
        if (!(request == null)) {
            request.setStatusRequest(StatusRequest.SENT);
            request = requestRepository.save(request);
        }
        return requestMapper.convertToRequestDto(request);
    }
//
//    public RequestDto getAllRequestStatus() {
//        List<Request> request = requestRepository.findAllByStatus(Status.SENT);
//        return (RequestDto) (RequestDto) request
//                .stream()
//                .map(requestMapper::convertToRequestDto)
//                .collect(Collectors.toList());
//    }

//    public RequestDto s(Long id, String status) {
//
//        Optional<Request> request = Optional.ofNullable(requestRepository.findById(id)
//                .orElseThrow(() -> new AllException("В метеде " + id + ("Не найден"))));
//
//        if (request.isPresent() & (request.equals(Status.ACCEPTED) || request.equals(Status.REJECTED))) {
//            request.get().setStatus(request);
//            request = Optional.of(requestRepository.save(request.get()));
//        }
//        return requestMapper.convertToRequestDto(request);
//    }
}
