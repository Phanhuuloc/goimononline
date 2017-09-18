package vn.menugo.server.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 7/7/2017.
 */
@Entity(name = "category")
@Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-25T04:31:55.163Z")
public @Data
class Category {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "uid", length = 16)
    private UUID uuid;
    private String name;
    private String defaultImage;

//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JoinTable(name = "category_mon",
//            joinColumns = {@JoinColumn(name = "uid_category", referencedColumnName = "uid")},
//            inverseJoinColumns = {@JoinColumn(name = "uid_mon", referencedColumnName = "uid")})
//    private Set<Mon> mons = new HashSet<>();

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
}
