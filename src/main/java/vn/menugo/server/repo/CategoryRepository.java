package vn.menugo.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.menugo.server.model.Category;


import java.util.UUID;

/**
 * Created by itn0309 on 7/8/2017.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByName(String name);
    Category findByUuid(UUID uuid);
    Category findByProviderUuidAndName(UUID uuid, String name);
}
