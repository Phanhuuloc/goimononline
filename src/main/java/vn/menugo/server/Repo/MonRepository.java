package vn.menugo.server.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.menugo.server.model.Mon;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by itn0309 on 6/10/2017.
 */
@Repository
public interface MonRepository extends JpaRepository<Mon, UUID> {
    Mon findByName(String name);
}
