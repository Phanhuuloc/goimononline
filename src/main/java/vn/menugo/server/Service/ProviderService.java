package vn.menugo.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.Repo.CategoryRepository;
import vn.menugo.server.Repo.MonRepository;
import vn.menugo.server.Repo.ProviderRepository;
import vn.menugo.server.model.Category;

import vn.menugo.server.model.Mon;
import vn.menugo.server.model.Provider;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;
    private final CategoryRepository categoryRepository;
    private final MonRepository monRepository;


    @Autowired
    public ProviderService(ProviderRepository providerRepository, CategoryRepository categoryRepository, MonRepository monRepository) {
        this.providerRepository = providerRepository;
        this.categoryRepository = categoryRepository;
        this.monRepository = monRepository;
    }

    public Provider getOne(UUID uuid) {
        return providerRepository.getOne(uuid);
    }

    public void create(Provider provider) {
        Provider p = providerRepository.findByName(provider.getName());
        provider.setUuid(p != null ? p.getUuid() : UUID.randomUUID());
        providerRepository.save(provider);
    }

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    public void createCategory(UUID pid, String name) {
        Provider provider = providerRepository.findByUuid(pid);
        Category category = new Category(UUID.randomUUID(), name);
        Set<Category> categories = provider.getCategories() != null ? provider.getCategories() : new HashSet<>();
        categories.add(category);
        providerRepository.saveAndFlush(provider);
    }

    public void fetchMon(UUID pid, String cName, String name, int price, String des, String note) {
        Provider provider = providerRepository.findOne(pid);
        Category category = createCategory(cName);

        Set<Category> categories = provider.getCategories() != null ? provider.getCategories() : new HashSet<>();
        categories.add(category);
        provider.setCategories(categories);

        Mon mon = createMon(name, price, des, note);
        Set<Mon> mons = category.getMons() != null ? category.getMons() : new HashSet<>();
        mons.add(mon);
        category.setMons(mons);

        providerRepository.saveAndFlush(provider);
    }

    private Mon createMon(String name, int price, String des, String note) {
        Mon mon = monRepository.findByName(name);
        return mon != null ? mon : new Mon(UUID.randomUUID(), name, price, des, note);
    }

    private Category createCategory(String name) {
        Category category = categoryRepository.findByName(name);
        return category != null ? category : new Category(UUID.randomUUID(), name);
    }

//    private Provider createProvider(UUID uuid) {
//        Provider provider = providerRepository.findOne(uuid);
//        if(null==provider){
//            provider = new Provider();
//        }
//        return provider;
//    }
}
