//package vn.menugo.server.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.Getter;
//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.annotation.Generated;
//import javax.persistence.*;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.UUID;
//
///**
// * Created by itn0309 on 8/1/2017.
// */
//@Entity(name = "bill")
//@Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-25T04:31:55.163Z")
//public @Data class Bill {
//
//    @Id
//    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
//    @Column(name = "UID", length = 16)
//    private UUID uuid;
//    private String type;
//    private long price;
//    private int status;
//    private Date date;
//
////    @ManyToOne
////    @JsonBackReference
////    private Client client;
//
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(name = "bill_mon",
//            joinColumns = {@JoinColumn(name = "uid_bill", referencedColumnName = "uid")},
//            inverseJoinColumns = {@JoinColumn(name = "uid_mon", referencedColumnName = "uid")})
//    private Set<Mon> mons = new HashSet<Mon>();
//
//}
