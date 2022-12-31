package rocks.zipcode.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RackMapperTest {

    private RackMapper rackMapper;

    @BeforeEach
    public void setUp() {
        rackMapper = new RackMapperImpl();
    }
}
