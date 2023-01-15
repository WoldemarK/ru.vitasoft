package ru.vitasoft.ru.vitasoft.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.vitasoft.ru.vitasoft.dto.RequestDto;
import ru.vitasoft.ru.vitasoft.model.Request;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface RequestMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "creation", target = "creation", dateFormat = "dd/MM/yyyy")
    RequestDto convertToRequestDto(Request request);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "creation", target = "creation", dateFormat = "dd/MM/yyyy")
    Request convertToRequest(RequestDto personDto);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "creation", target = "creation", dateFormat = "dd/MM/yyyy")
    void updateFromDto(RequestDto requestDto, @MappingTarget Request request);
}
