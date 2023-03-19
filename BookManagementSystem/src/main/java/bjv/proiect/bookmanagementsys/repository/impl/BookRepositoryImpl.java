package bjv.proiect.bookmanagementsys.repository.impl;

import bjv.proiect.bookmanagementsys.model.Book;
import bjv.proiect.bookmanagementsys.repository.generic.RepositoryImpl;

public class BookRepositoryImpl extends RepositoryImpl<Book> {

    public BookRepositoryImpl(Class<Book> entityClass) {
        super(entityClass);
    }
}
