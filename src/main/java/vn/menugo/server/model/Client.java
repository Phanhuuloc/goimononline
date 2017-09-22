package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 8/1/2017.
 */
@Getter
@Setter
@Entity(name = "client")
public class Client {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uid", updatable = false, nullable = false)
    private UUID uuid;
    private String name;
    private String pass;
    private String email;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Bill> bill;

    public Client(UUID uuid, String name, String pass, String email, String address) {
        this.uuid = uuid;
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.address = address;
    }

    public Client() {
    }

}
