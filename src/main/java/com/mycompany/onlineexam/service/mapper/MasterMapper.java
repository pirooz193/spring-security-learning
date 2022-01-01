package com.mycompany.onlineexam.service.mapper;


import com.mycompany.onlineexam.domain.Master;
import com.mycompany.onlineexam.service.dto.MasterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MasterMapper {

    @Mapping(source = "phoneNumber" , target = "phoneNumber")
    Master toEntity(MasterDTO masterDTO);
}
