//package vn.menugo.server.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.Data;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.annotation.Generated;
//import javax.persistence.*;
//import java.util.List;
//import java.util.UUID;
//
///**
// * Created by itn0309 on 8/1/2017.
// */
//@Entity(name = "client")
//@Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-25T04:31:55.163Z")
//public @Data class Client {
//
//    @Id
//    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
//    @Column(name = "uid", length = 16)
//    private UUID uuid;
//    private String name;
//    private String pass;
//    private String email;
//    private String address;
//
////    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
////    private List<Bill> bill;
//
//    public Client(UUID uuid, String name, String pass, String email, String address) {
//        this.uuid = uuid;
//        this.name = name;
//        this.pass = pass;
//        this.email = email;
//        this.address = address;
//    }
//
//    public Client() {
//    }
//
//}
