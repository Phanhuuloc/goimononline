package vn.menugo.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.repo.CategoryRepository;
import vn.menugo.server.repo.MonRepository;
import vn.menugo.server.repo.ProviderRepository;
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

    public Provider findByUuid(UUID uuid) {
        return providerRepository.findByUuid(uuid);
    }

    public void create(Provider provider) {
        Provider p = providerRepository.findByName(provider.getName());
        provider.setUuid(p != null ? p.getUuid() : UUID.randomUUID());
        providerRepository.save(provider);
    }

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    public Category createCategory(UUID pid, String name) {
        Provider provider = providerRepository.findByUuid(pid);
        Category category = categoryRepository.findByProviderUuidAndName(pid, name);
        if (null == category) {
            category = new Category(name);
            category.setProvider(provider);
            Set<Category> categories = provider.getCategories() != null ? provider.getCategories() : new HashSet<>();
            categories.add(category);
        }
        categoryRepository.save(category);
        providerRepository.save(provider);

        return category;
    }

    public void fetchMon(UUID pid, String cat, String name, int price, String des, String note) {
        Category category = createCategory(pid, cat);
        Mon mon = monRepository.findAllByCategoryProviderUuidAndCategoryNameAndName(pid, cat, name);
        if (null == mon) {
            mon = new Mon(name, price, des, note);
            mon.setCategory(category);
            Set<Mon> mons = category.getMons() != null ? category.getMons() : new HashSet<>();
            mons.add(mon);
        }
        monRepository.save(mon);
        categoryRepository.save(category);
    }

    public Provider updateToken(UUID uuid, String token) {
        Provider provider = providerRepository.findByUuid(uuid);
        provider.setToken(token);
        providerRepository.save(provider);
        return provider;
    }
}
