package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 5/29/2017.
 */
@Entity(name = "provider")
@Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-25T04:31:55.163Z")
public @Data class Provider {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uid", length = 16)
    private UUID uuid;
    private String name;
    private String image;
    private String description;
    private String address;
    private String url;
    private double latitude;
    private double longitude;
    private String openHour;
    private int star;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinTable(name = "provider_category",
            joinColumns = {@JoinColumn(name = "uid_provider", referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "uid_category", referencedColumnName = "uid")})
    private Set<Category> categories = new HashSet<>();

    public Provider() {
    }

    public Provider(String name, String image, String description, String address, String url, double latitude,
                    double longitude, String openHour, int star) {
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
}
