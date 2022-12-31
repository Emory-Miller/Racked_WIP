package rocks.zipcode.service.mapper;

import org.mapstruct.*;
import rocks.zipcode.domain.Rack;
import rocks.zipcode.service.dto.RackDTO;

/**
 * Mapper for the entity {@link Rack} and its DTO {@link RackDTO}.
 */
@Mapper(componentModel = "spring")
public interface RackMapper extends EntityMapper<RackDTO, Rack> {}
