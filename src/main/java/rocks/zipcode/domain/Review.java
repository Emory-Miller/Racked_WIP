package rocks.zipcode.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import rocks.zipcode.domain.enumeration.RackSize;
import rocks.zipcode.domain.enumeration.StarRating;

/**
 * A Review.
 */
@Entity
@Table(name = "review")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "star_rating")
    private StarRating starRating;

    @Enumerated(EnumType.STRING)
    @Column(name = "rack_size")
    private RackSize rackSize;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    private User user;

    @ManyToOne
    @JsonIgnoreProperties(value = { "reviews" }, allowSetters = true)
    private Rack rack;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Review id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StarRating getStarRating() {
        return this.starRating;
    }

    public Review starRating(StarRating starRating) {
        this.setStarRating(starRating);
        return this;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public RackSize getRackSize() {
        return this.rackSize;
    }

    public Review rackSize(RackSize rackSize) {
        this.setRackSize(rackSize);
        return this;
    }

    public void setRackSize(RackSize rackSize) {
        this.rackSize = rackSize;
    }

    public String getAmenities() {
        return this.amenities;
    }

    public Review amenities(String amenities) {
        this.setAmenities(amenities);
        return this;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getComments() {
        return this.comments;
    }

    public Review comments(String comments) {
        this.setComments(comments);
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Review user(User user) {
        this.setUser(user);
        return this;
    }

    public Rack getRack() {
        return this.rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public Review rack(Rack rack) {
        this.setRack(rack);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Review)) {
            return false;
        }
        return id != null && id.equals(((Review) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Review{" +
            "id=" + getId() +
            ", starRating='" + getStarRating() + "'" +
            ", rackSize='" + getRackSize() + "'" +
            ", amenities='" + getAmenities() + "'" +
            ", comments='" + getComments() + "'" +
            "}";
    }
}
