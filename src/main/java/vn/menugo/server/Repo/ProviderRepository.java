package vn.menugo.server.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.menugo.server.model.Category;
import vn.menugo.server.model.Provider;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
@Repository
public interface ProviderRepository extends JpaRepository<Provider, UUID> {

}
