package com.nagarro.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.rest.dao.RestDao;
import com.nagarro.rest.pojo.Book;


@RestController
//@RequestMapping("/api/v1/application/")
public class RestApiController {
	
	@Autowired
	RestDao dao;
	
	/**
	 * return list of book 
	 * @return List<Book>
	 */
	@GetMapping("/book")
	public List<Book> allBooks(){
		return dao.findAll();
	}

	/**
	 * create new book record in database
	 * @param book
	 */
	@PostMapping("/book")
	public Book createBook(@RequestBody Book book) {
		return dao.save(book);
	}
	
	/**
	 * return book having given id
	 * @param id
	 * @return
	 */
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable int id){
		return dao.findById(id).get();
		
	}
	
	/**
	 * update book having given id from database 
	 * @param id
	 * @param bookDetails
	 * @return
	 */
	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable int id, @RequestBody Book bookDetails){

		Book book = dao.findById(id).get();
	    book.setBookCode(bookDetails.getBookCode());
	    book.setBookName(bookDetails.getBookName());
	    book.setAuthor(bookDetails.getAuthor());
	    book.setDate(bookDetails.getDate());
	    //dao.updateBook(book);
	    return dao.save(book);
	}
	
	/**
	 * delete book having given id from database
	 * @param id
	 * @return
	 */
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable int id){
		dao.deleteById(id);
	}
}
