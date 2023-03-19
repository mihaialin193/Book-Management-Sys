package bjv.proiect.bookmanagementsys.repository.generic;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    Optional<T> showById(int id);

    List<T> showAll();
}
