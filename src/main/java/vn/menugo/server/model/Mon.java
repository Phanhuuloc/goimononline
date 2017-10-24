package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 5/29/2017.
 */
@Data
@EqualsAndHashCode(exclude = {"category", "bills"})
@Entity(name = "mon")
public class Mon implements Serializable{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uid", updatable = false, nullable = false, length = 16)
    private UUID uuid;
    private String name;
    private long price;
    private String description;
    private String note;

    @ManyToOne
    @JoinColumn(name = "category_uid")
    @JsonBackReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Category category;

    @ManyToMany(mappedBy = "mons")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Set<Bill> bills = new HashSet<>();

    public Mon(UUID uuid, String name, long price, String description, String note) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.description = description;
        this.note = note;
    }

    public Mon() {
    }

}
