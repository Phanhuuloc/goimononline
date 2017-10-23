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

@Getter
@Setter
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uid", updatable = false, nullable = false)
    private UUID uuid;
    private String name;
    private String defaultImage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Mon> mons = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "provider_uid")
    @JsonBackReference
    private Provider provider;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

}
