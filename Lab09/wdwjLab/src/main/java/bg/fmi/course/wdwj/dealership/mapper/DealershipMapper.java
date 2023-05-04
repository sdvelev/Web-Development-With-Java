package bg.fmi.course.wdwj.dealership.mapper;

import bg.fmi.course.wdwj.dealership.dto.DealershipDto;
import bg.fmi.course.wdwj.dealership.model.Dealership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DealershipMapper {

    DealershipMapper INSTANCE = Mappers.getMapper(DealershipMapper.class);

    DealershipDto toDto (Dealership model);

    //@Mapping()
    List<DealershipDto> toList(List<Dealership> entities);
}
