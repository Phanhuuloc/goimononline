//package vn.menugo.server.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import vn.menugo.server.Repo.CategoryRepository;
//import vn.menugo.server.Repo.MenuItemRepository;
//import vn.menugo.server.Repo.ProviderRepository;
//import vn.menugo.server.model.Category;
//import vn.menugo.server.model.Mon;
//import vn.menugo.server.model.Provider;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//
///**
// * Created by itn0309 on 6/10/2017.
// */
//@Service
//public class MenuItemRepositoryService implements MenuItemCrudService {
//
//    private final MenuItemRepository menuItemRepository;
//    private final CategoryRepository categoryRepository;
//    private final ProviderRepository providerRepository;
//
//    @Autowired
//    MenuItemRepositoryService(MenuItemRepository menuItemRepository, CategoryRepository categoryRepository,
//                              ProviderRepository providerRepository) {
//        this.menuItemRepository = menuItemRepository;
//        this.categoryRepository = categoryRepository;
//        this.providerRepository = providerRepository;
//    }
//
//    @Override
//    public void create(Mon newEntry) {
//
//        Mon Mon = menuItemRepository.save(newEntry);
//    }
//
//    @Override
//    public Mon delete(UUID uuid) {
//        return null;
//    }
//
//    @Override
//    public List<Mon> findAll() {
//        return null;
//    }
//
//    @Override
//    public Mon findByUuid(UUID uuid) {
//        return menuItemRepository.findByUuid(uuid);
//    }
//
//    @Override
//    public Mon update(Mon newEntry) {
//        return menuItemRepository.save(newEntry);
//    }
//
//    @Override
//    public List<Mon> findByProvider(Provider provider) {
//        return menuItemRepository.findByProvider(provider);
//    }
//
//    public List<Mon> findFullObjects(List<Mon> items) {
//
//        List<Mon> newList = new ArrayList<Mon>();
//        if (items != null) {
//            for (Mon item : items) {
//                Mon newItem = menuItemRepository.findByUuid(item.getUuid());
//                newList.add(newItem);
//            }
//        }
//        return newList;
//    }
//
//    public void createItem(UUID pid, String category, String name, String price) {
//        Provider p = createProvider(pid);
//        Category c = createCategory(pid, category);
//        Mon m = createMenuItem(name, price);
//
//        m.setCategory(c);
//        m.setProvider(p);
//
//        List<Mon> cMenu = c.getMenu();
//        if (cMenu == null) {
//            cMenu = new ArrayList<>();
//        }
//        if(!cMenu.contains(m)) {
//            cMenu.add(m);
//            c.setMenu(cMenu);
//        }
//
//        List<Mon> pMenu = p.getMenu();
//        if (pMenu == null) {
//            pMenu = new ArrayList<>();
//        }
//        if(!pMenu.contains(m)) {
//            pMenu.add(m);
//            p.setMenu(pMenu);
//        }
//
//        c.setProvider(p);
//        List<Category> pCate = p.getCat();
//        if (pMenu == null) {
//            pCate = new ArrayList<>();
//        }
//        if (!pCate.contains(c)) {
//            pCate.add(c);
//            p.setCat(pCate);
//        }
//
//        providerRepository.save(p);
//    }
//
//    private Mon createMenuItem(String name, String price) {
//        Mon p = menuItemRepository.findTopByName(name);
//        if (p == null) {
//            p = new Mon();
//            p.setUuid(UUID.randomUUID());
//            p.setName(name);
//        }
//
//        p.setPrice(Long.valueOf(price));
//        return p;
//    }
//
//    public Provider createProvider(UUID provider) {
//        Provider p = providerRepository.findByUuid(provider);
//        if (p == null) {
//            p = new Provider();
//            p.setUuid(UUID.randomUUID());
//        }
//        return p;
//    }
//
//    public Category createCategory(UUID pid, String name) {
//        Category p = categoryRepository.findByNameAndProviderUuid(name, pid);
//        if (p == null) {
//            p = new Category();
//            p.setUuid(UUID.randomUUID());
//            p.setName(name);
//        }
//        return p;
//    }
//}
