package bjv.proiect.bookmanagementsys.repository.generic;

import bjv.proiect.bookmanagementsys.util.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class RepositoryImpl<T> implements Repository<T> {

    private final Class<T> entityClass;

    public RepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) {
        Transaction transaction = null;
        try(Session session = SessionManager.getSessionFactory().openSession()){
            transaction= session.beginTransaction();

            session.save(entity);

            transaction.commit();
        } catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try(Session session = SessionManager.getSessionFactory().openSession()){
            transaction= session.beginTransaction();

            session.update(entity);

            transaction.commit();
        } catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = null;
        try(Session session = SessionManager.getSessionFactory().openSession()){
            transaction= session.beginTransaction();

            session.delete(entity);

            transaction.commit();
        } catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
        }
    }

    @Override
    public Optional<T> showById(int id) {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            return Optional.ofNullable(session.find(entityClass,id));
        }
    }

    @Override
    public List<T> showAll() {
        try(Session session = SessionManager.getSessionFactory().openSession()){
            Query<T> query = session.createQuery(
                    "from " + entityClass.getSimpleName()
            );
            return query.list();
        }
    }
}
