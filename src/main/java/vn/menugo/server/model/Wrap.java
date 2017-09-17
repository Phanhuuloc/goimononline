package vn.menugo.server.model;

import java.util.Collection;
import java.util.List;

/**
 * Created by itn0309 on 6/28/2017.
 */
public class Wrap<T> {
    private Collection<T> items ;

    public Wrap(Collection<T> items) {
        this.items = items;
    }

    public Collection<T> getItems() {
        return items;
    }

    public void setItems(Collection<T> items) {
        this.items = items;
    }
}
