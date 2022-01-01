package com.mycompany.onlineexam.service.mapper;

import com.mycompany.onlineexam.domain.Course;
import com.mycompany.onlineexam.service.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "capacity" , target = "courseCapacity")
    Course toEntity(CourseDTO courseDTO);
}
