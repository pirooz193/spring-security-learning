package com.mycompany.onlineexam.service.mapper;

import com.mycompany.onlineexam.domain.Student;
import com.mycompany.onlineexam.service.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "phoneNumber" , target = "phoneNumber")
    Student toEntity(StudentDTO studentDTO);
}
