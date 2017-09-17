package vn.menugo.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.menugo.server.Repo.ProviderRepository;
import vn.menugo.server.model.Provider;

import java.util.List;
import java.util.UUID;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;


    @Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider getOne(UUID uuid) {
        return providerRepository.getOne(uuid);
    }

    public void create(Provider provider) {
        provider.setUuid(UUID.randomUUID());
        providerRepository.save(provider);
    }

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }
}
