/**
 * 
 */
package com.nagarro.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nagarro.rest.pojo.Book;



/**
 * @author kritikasingh02
 *
 */
public interface RestDao extends JpaRepository<Book, Integer> {}
