package vn.menugo.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.menugo.server.model.Mon;

import java.util.List;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
@Repository
public interface MonRepository extends JpaRepository<Mon, UUID> {
    Mon findByName(String name);

    List<Mon> findAllByCategoryUuid(UUID uuid);

    Mon findAllByCategoryProviderUuidAndCategoryNameAndName(UUID pid, String cat, String name);
}
