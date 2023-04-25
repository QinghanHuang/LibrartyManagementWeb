package com.library.dao;

import com.library.entity.Book;
import com.library.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    @Results({
            @Result(column = "borrow_id",property = "borrowId"),
            @Result(column = "bid",property = "bid"),
            @Result(column = "title",property = "bookTitle"),
            @Result(column = "borrow_date",property = "borrowDate"),
            @Result(column = "s_name",property = "studentName"),
            @Result(column = "sid",property = "sid")
    })
    @Select("select * from borrow b,student s, book bo where b.bid=bo.bid and s.sid=b.sid")
    List<Borrow> getBorrowList();

    @Delete("delete from borrow where borrow_id = #{id}")
    boolean returnBook(String id);

    @Insert("insert into borrow(sid, bid, borrow_date) values(#{sid},#{bid},now())")
    boolean addBorrow(@Param("sid") int sid,@Param("bid")  int bid);


    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "title",property = "title"),
            @Result(column = "price",property = "price"),
            @Result(column = "book_info",property = "bookInfo"),
    })
    @Select("select * from book")
    List<Book> getBookList();

    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "title",property = "title"),
            @Result(column = "price",property = "price"),
            @Result(column = "book_info",property = "bookInfo"),
    })
    @Select("select book.bid,title,price,book_info from book left join borrow on book.bid = borrow.bid where borrow.bid is null")
    List<Book> getActiveBookList();




}
