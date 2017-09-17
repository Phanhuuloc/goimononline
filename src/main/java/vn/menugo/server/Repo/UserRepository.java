package vn.menugo.server.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.menugo.server.model.Client;

import java.util.UUID;

/**
 * Created by itn0309 on 8/3/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<Client, UUID> {
    Client findByUuid(UUID uuid);
}
