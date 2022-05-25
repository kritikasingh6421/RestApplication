package com.nagarro.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.rest.dao.RestDao;
import com.nagarro.rest.pojo.Book;

@WebMvcTest
public class RestApiTest {
	
	@Autowired
    MockMvc mockMvc;
	
    @Autowired
    ObjectMapper mapper;

    @MockBean
    private RestDao dao;

    Book RECORD_1 = new Book(101,"java","himani","24 May 2022");
	Book RECORD_2 = new Book(102,"c","yashvant","24 May 2022");
	Book RECORD_3 = new Book(103,"cpp","ashok","24 May 2022");
	Book RECORD_4 = new Book(104,"python","ram","24 May 2022");
	Book RECORD_5 = new Book(105,"python","ram","24 May 2022");

	@Test
	public void getAllRecords_success() throws Exception {
	    List<Book> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
	    
	    Mockito.when(dao.findAll()).thenReturn(records);
	    String url = "/api/v1/library-management/book";
	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/book")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", hasSize(3)))
	            .andExpect(jsonPath("$[2].bookName", is("cpp")));
	}
	
	@Test
	public void getPatientById_success() throws Exception {
	    Mockito.when(dao.findById(RECORD_1.getBookCode())).thenReturn(java.util.Optional.of(RECORD_1));

	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/book/101")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.bookName", is("java")));
	}
	
	/*@Test
	public void createRecord_success() throws Exception {
	    Book book = Book.builder()
	    		.bookCode(101)
	            .bookName("english")
	            .author("Ram")
	            .date("24 May 2022")
	            .build();

	    Mockito.when(dao.save(book)).thenReturn(book);

	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/book")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(book));

	    mockMvc.perform(mockRequest)
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.bookName", is("english")));
	    }
	
	@Test
	public void updatePatientRecord_success() throws Exception {
	    Book book = Book.builder()
	    		.bookCode(101)
	            .bookName("math")
	            .author("Ram")
	            .date("24 May 2022")
	            .build();

	    Mockito.when(dao.findById(RECORD_1.getBookCode())).thenReturn(Optional.of(RECORD_1));
	    Mockito.when(dao.save(book)).thenReturn(book);

	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/book")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(this.mapper.writeValueAsString(book));

	    mockMvc.perform(mockRequest)
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$", notNullValue()))
	            .andExpect(jsonPath("$.bookName", is("math")));
	}*/
	
	@Test
	public void deletePatientById_success() throws Exception {
	    Mockito.when(dao.findById(RECORD_2.getBookCode())).thenReturn(Optional.of(RECORD_2));

	    mockMvc.perform(MockMvcRequestBuilders
	            .delete("/book/102")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	}
}
