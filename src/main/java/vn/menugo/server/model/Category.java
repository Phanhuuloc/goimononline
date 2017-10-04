package vn.menugo.server.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 7/7/2017.
 */
@Data
@EqualsAndHashCode(exclude = "providers")
@ToString(exclude = {"providers", "mons"})
@Entity(name = "category")
public class Category implements Serializable{
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uid", updatable = false, nullable = false)
    private UUID uuid;
    private String name;
    private String defaultImage;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_mon",
            joinColumns = {@JoinColumn(name = "uid_category", referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "uid_mon", referencedColumnName = "uid")})
    private Set<Mon> mons = new HashSet<>();

    @ManyToMany(mappedBy = "categories")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Set<Provider> providers = new HashSet<>();

    public Category() {
    }

    public Category(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
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
//    public String getDefaultImage() {
//        return defaultImage;
//    }
//
//    public void setDefaultImage(String defaultImage) {
//        this.defaultImage = defaultImage;
//    }
}
