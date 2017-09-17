package vn.menugo.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 8/1/2017.
 */
@Entity(name = "client")
public class Client {

    @Id
    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
    @Column(name = "uid", length = 16)
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Bill> getBill() {
        return bill;
    }

    public void setBills(List<Bill> bill) {
        this.bill = bill;
    }
}
