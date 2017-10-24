package vn.menugo.server.repo;

import org.springframework.data.repository.CrudRepository;
import vn.menugo.server.model.Role;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role,UUID> {
    Role findByName(String name);
}
