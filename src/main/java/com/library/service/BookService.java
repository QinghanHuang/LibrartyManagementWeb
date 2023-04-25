package com.library.service;

import com.library.entity.Book;
import com.library.entity.Borrow;

import java.util.List;

public interface BookService {
    List<Borrow> getBorrowList();
    boolean returnBook(String id);
    List<Book> getActivateBookList();
    List<Book> getBookList();
    boolean addBorrow(int sid,int bid);

}
