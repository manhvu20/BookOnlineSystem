package com.bookonline.sessions;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import com.bookonline.entities.Book;

@Stateless
@LocalBean
public class BookManagement {

    @PersistenceContext
    private EntityManager entityManager;

    public void addBook(Book book) {
        entityManager.persist(book);
    }

    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    public void deleteBook(Long bookId) {
        Book book = entityManager.find(Book.class, bookId);
        if (book != null) {
            entityManager.remove(book);
        }
    }

    public Book findBookById(Long bookId) {
        return entityManager.find(Book.class, bookId);
    }

    public List<Book> getAllBooks() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }
}
