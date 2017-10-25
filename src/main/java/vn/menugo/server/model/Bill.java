package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created by itn0309 on 8/1/2017.
 */
@Setter
@Getter
@Entity(name = "bill")
public class Bill implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uid", updatable = false, nullable = false, length = 16)
    private UUID uuid;
    private String type;
    private long price;
    private int status;
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_uid")
    @JsonBackReference
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bill_mon",
            joinColumns = {@JoinColumn(name = "uid_bill", referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "uid_mon", referencedColumnName = "uid")})
    private Set<Mon> mons = new HashSet<Mon>();

}
