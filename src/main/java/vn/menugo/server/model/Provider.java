package vn.menugo.server.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 5/29/2017.
 */
@Getter
@Setter
@Entity(name = "provider")
public class Provider {

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provider")
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

}
