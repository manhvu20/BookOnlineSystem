package com.bookonline.managedbean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import com.bookonline.entities.Book;
import com.bookonline.sessions.BookManagement;
import java.util.List;

public class BookManagementBean {

    @EJB
    private BookManagement bookManagement;
    
    private List<Book> books;
    private Book newBook;
    private Book selectedBook;
    
    @PostConstruct
    public void init() {
        books = bookManagement.getAllBooks();
        newBook = new Book();
    }
    
    public void addBook() {
        bookManagement.addBook(newBook);
        books = bookManagement.getAllBooks();
        newBook = new Book(); // Reset newBook
    }
    
    public void updateBook() {
        bookManagement.updateBook(selectedBook);
    }
    
    public void deleteBook(Long bookId) {
        bookManagement.deleteBook(bookId);
        books = bookManagement.getAllBooks();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getNewBook() {
        return newBook;
    }

    public void setNewBook(Book newBook) {
        this.newBook = newBook;
    }

    public Book getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(Book selectedBook) {
        this.selectedBook = selectedBook;
    }
}
