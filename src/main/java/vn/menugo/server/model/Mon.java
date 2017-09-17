package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 5/29/2017.
 */
@Entity(name = "mon")
public class Mon {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "UID", length = 16)
    private UUID uuid;
    private String name;
    private long price;
    private String description;
    private String note;

    @ManyToMany(mappedBy = "mons")
    @JsonBackReference
    private Set<Category> categories = new HashSet<Category>();

    @ManyToMany(mappedBy = "mons")
    @JsonBackReference
    private Set<Bill> bills = new HashSet<Bill>();

    public Mon(UUID uuid, String name, long price, String description, String note) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.description = description;
        this.note = note;
    }

    public Mon() {
    }

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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

//    public Set<Category> getCategories() {
//        return categories;
//    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }
}
