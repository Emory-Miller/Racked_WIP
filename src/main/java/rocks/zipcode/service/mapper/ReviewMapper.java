package rocks.zipcode.service.mapper;

import org.mapstruct.*;
import rocks.zipcode.domain.Rack;
import rocks.zipcode.domain.Review;
import rocks.zipcode.domain.User;
import rocks.zipcode.service.dto.RackDTO;
import rocks.zipcode.service.dto.ReviewDTO;
import rocks.zipcode.service.dto.UserDTO;

/**
 * Mapper for the entity {@link Review} and its DTO {@link ReviewDTO}.
 */
@Mapper(componentModel = "spring")
public interface ReviewMapper extends EntityMapper<ReviewDTO, Review> {
    @Mapping(target = "user", source = "user", qualifiedByName = "userLogin")
    @Mapping(target = "rack", source = "rack", qualifiedByName = "rackId")
    ReviewDTO toDto(Review s);

    @Named("userLogin")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "login", source = "login")
    UserDTO toDtoUserLogin(User user);

    @Named("rackId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RackDTO toDtoRackId(Rack rack);
}
