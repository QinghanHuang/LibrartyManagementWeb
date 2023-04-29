package com.library.service;

import com.library.entity.Book;
import com.library.entity.Borrow;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Borrow> getBorrowList();
    boolean returnBook(int id);
    List<Book> getActivateBookList();
    List<Book> getBookList();
    boolean addBorrow(int sid,int bid);

    Map<Book,Boolean> getBookListWithStatus();
    boolean deleteBook(int bid);
    boolean addBook(String title,String bookInfo,double price);



}
