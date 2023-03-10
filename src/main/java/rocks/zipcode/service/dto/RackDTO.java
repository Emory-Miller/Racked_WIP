package rocks.zipcode.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the {@link rocks.zipcode.domain.Rack} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RackDTO implements Serializable {

    private Long id;

    private String name;

    private Double longitude;

    private Double latitude;

    @Lob
    private byte[] image;

    private String imageContentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RackDTO)) {
            return false;
        }

        RackDTO rackDTO = (RackDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, rackDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RackDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", longitude=" + getLongitude() +
            ", latitude=" + getLatitude() +
            ", image='" + getImage() + "'" +
            "}";
    }
}
