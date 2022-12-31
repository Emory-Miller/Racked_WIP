package rocks.zipcode.service.dto;

import java.io.Serializable;
import java.util.Objects;
import rocks.zipcode.domain.enumeration.RackSize;
import rocks.zipcode.domain.enumeration.StarRating;

/**
 * A DTO for the {@link rocks.zipcode.domain.Review} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReviewDTO implements Serializable {

    private Long id;

    private StarRating starRating;

    private RackSize rackSize;

    private String amenities;

    private String comments;

    private UserDTO user;

    private RackDTO rack;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public RackSize getRackSize() {
        return rackSize;
    }

    public void setRackSize(RackSize rackSize) {
        this.rackSize = rackSize;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public RackDTO getRack() {
        return rack;
    }

    public void setRack(RackDTO rack) {
        this.rack = rack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReviewDTO)) {
            return false;
        }

        ReviewDTO reviewDTO = (ReviewDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, reviewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReviewDTO{" +
            "id=" + getId() +
            ", starRating='" + getStarRating() + "'" +
            ", rackSize='" + getRackSize() + "'" +
            ", amenities='" + getAmenities() + "'" +
            ", comments='" + getComments() + "'" +
            ", user=" + getUser() +
            ", rack=" + getRack() +
            "}";
    }
}
