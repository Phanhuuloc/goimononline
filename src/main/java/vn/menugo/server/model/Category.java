package vn.menugo.server.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 7/7/2017.
 */
@Entity(name = "category")
public class Category {
    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "uid", length = 16)
    private UUID uuid;

    private String name;

    private String defaultImage;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_mon",
            joinColumns = {@JoinColumn(name = "uid_category", referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "uid_mon", referencedColumnName = "uid")})
    private Set<Mon> mons = new HashSet<>();

    @ManyToMany(mappedBy = "categories")
    private Set<Provider> providers = new HashSet<>();

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    public Set<Mon> getMons() {
        return mons;
    }

    public void setMons(Set<Mon> mons) {
        this.mons = mons;
    }


//    public Set<Provider> getProviders() {
//        return providers;
//    }

    public void setProviders(Set<Provider> providers) {
        this.providers = providers;
    }
}
