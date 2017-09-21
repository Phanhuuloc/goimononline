package vn.menugo.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.menugo.server.model.Provider;

import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, UUID> {
    Provider findByUuid(UUID uuid);
    Provider findByName(String name);
}
