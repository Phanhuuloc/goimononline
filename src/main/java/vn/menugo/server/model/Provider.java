package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.json.JSONObject;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 5/29/2017.
 */
@Data
@EqualsAndHashCode
@Entity(name = "provider")
public class Provider implements Serializable{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uid", updatable = false, nullable = false)
    private UUID uuid;
    private String name;
    private String image;
    private String description;
    private String address;
    private String url;
    private double latitude;
    private double longitude;
    private String openHour;
    private double star;
    private String token;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "provider_category",
            joinColumns = {@JoinColumn(name = "uid_provider", referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "uid_category", referencedColumnName = "uid")})
    private Set<Category> categories = new HashSet<>();

    public Provider() {
    }

    public Provider(String name, String image, String description, String address, String url, double latitude,
                    double longitude, String openHour, double star) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.address = address;
        this.url = url;
        this.latitude = latitude;
        this.longitude = longitude;
        this.openHour = openHour;
        this.star = star;
    }

    public JSONObject toJSON() {

        return null;
    }

//    public UUID getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(UUID uuid) {
//        this.uuid = uuid;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
//
//    public String getOpenHour() {
//        return openHour;
//    }
//
//    public void setOpenHour(String openHour) {
//        this.openHour = openHour;
//    }
//
//    public int getStar() {
//        return star;
//    }
//
//    public void setStar(int star) {
//        this.star = star;
//    }
//
//    public Set<Category> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(Set<Category> categories) {
//        this.categories = categories;
//    }
}
