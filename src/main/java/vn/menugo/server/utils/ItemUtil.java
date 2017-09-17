//package vn.menugo.server.utils;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import vn.menugo.server.Service.MenuItemRepositoryService;
//import vn.menugo.server.model.Mon;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by itn0309 on 9/9/2017.
// */
//public class ItemUtil {
//
//    @Autowired
//    private static MenuItemRepositoryService mService;
//
//    public static long countPrice (List<Mon> items){
//        long result= 0;
//        if(items != null){
//            for (Mon item: items){
//                result += item.getPrice();
//            }
//        }
//        return result;
//
//    }
//
//}
