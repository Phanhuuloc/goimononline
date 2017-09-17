package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * Created by itn0309 on 8/1/2017.
 */
@Entity(name = "bill")
public class Bill {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "UID", length = 16)
    private UUID uuid;
    private String type;
    private long price;
    private int status;
    private Date date;

    @ManyToOne
    @JsonBackReference
    private Client client;

    @JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bill_mon",
            joinColumns = {@JoinColumn(name = "uid_bill", referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "uid_mon", referencedColumnName = "uid")})
    private Set<Mon> mons = new HashSet<Mon>();

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

//    public Set<Mon> getMons() {
//        return mons;
//    }
//
//    public void setMons(Set<Mon> mons) {
//        this.mons = mons;
//    }
}
