package vn.menugo.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.menugo.server.model.Client;
import vn.menugo.server.model.User;

import java.util.UUID;

/**
 * Created by itn0309 on 8/3/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    User findByEmail(String email);
}
