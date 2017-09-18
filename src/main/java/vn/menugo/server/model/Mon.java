//package vn.menugo.server.model;
//
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.UUID;
//
///**
// * Created by itn0309 on 5/29/2017.
// */
//@Entity(name = "mon")
//public @Data class Mon {
//
//    @Id
//    @GenericGenerator(name = "hibernate-uuid", strategy = "hibernate-uuid")
//    @Column(name = "UID", length = 16)
//    private UUID uuid;
//    private String name;
//    private long price;
//    private String description;
//    private String note;
//
//    @ManyToMany(mappedBy = "mons")
//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
//    private Set<Category> categories = new HashSet<Category>();
//
////    @ManyToMany(mappedBy = "mons")
////    @Getter(AccessLevel.NONE)
////    @Setter(AccessLevel.NONE)
////    private Set<Bill> bills = new HashSet<Bill>();
//
//    public Mon(UUID uuid, String name, long price, String description, String note) {
//        this.uuid = uuid;
//        this.name = name;
//        this.price = price;
//        this.description = description;
//        this.note = note;
//    }
//
//    public Mon() {
//    }
//
//}
