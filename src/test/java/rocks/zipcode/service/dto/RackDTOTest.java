package rocks.zipcode.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import rocks.zipcode.web.rest.TestUtil;

class RackDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RackDTO.class);
        RackDTO rackDTO1 = new RackDTO();
        rackDTO1.setId(1L);
        RackDTO rackDTO2 = new RackDTO();
        assertThat(rackDTO1).isNotEqualTo(rackDTO2);
        rackDTO2.setId(rackDTO1.getId());
        assertThat(rackDTO1).isEqualTo(rackDTO2);
        rackDTO2.setId(2L);
        assertThat(rackDTO1).isNotEqualTo(rackDTO2);
        rackDTO1.setId(null);
        assertThat(rackDTO1).isNotEqualTo(rackDTO2);
    }
}
