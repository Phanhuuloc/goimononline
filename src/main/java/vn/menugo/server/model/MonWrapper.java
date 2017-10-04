package vn.menugo.server.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class MonWrapper {
    Set<UUID> mons;
}
