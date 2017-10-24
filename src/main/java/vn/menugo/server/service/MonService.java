package vn.menugo.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.model.Category;
import vn.menugo.server.model.Mon;
import vn.menugo.server.model.Provider;
import vn.menugo.server.repo.CategoryRepository;
import vn.menugo.server.repo.MonRepository;
import vn.menugo.server.repo.ProviderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
@Service
public class MonService {

    private final MonRepository monRepository;
    private final CategoryRepository categoryRepository;
    private final ProviderRepository providerRepository;

    @Autowired
    MonService(MonRepository monRepository, CategoryRepository categoryRepository,
               ProviderRepository providerRepository) {
        this.monRepository = monRepository;
        this.categoryRepository = categoryRepository;
        this.providerRepository = providerRepository;
    }

    public List<Mon> findAllByCategory(UUID cid) {
        return monRepository.findAllByCategoryUuid(cid);
    }
}
