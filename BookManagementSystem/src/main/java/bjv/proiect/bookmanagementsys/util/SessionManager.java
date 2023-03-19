package bjv.proiect.bookmanagementsys.util;


import bjv.proiect.bookmanagementsys.model.Author;
import bjv.proiect.bookmanagementsys.model.Book;
import bjv.proiect.bookmanagementsys.model.Review;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {
    private static final SessionManager INSTANCE = new SessionManager();

    private SessionManager() {

    }

    public static SessionFactory getSessionFactory() {
        return INSTANCE.getSessionFactory("book_management_sys");
    }

    public static void shutdown() {
        INSTANCE.shutdownSessionManager();
    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Review.class);
    }
}
