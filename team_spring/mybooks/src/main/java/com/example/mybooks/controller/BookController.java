package com.example.mybooks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybooks.dto.Book;

@RestController
@RequestMapping("/mybooks")
public class BookController {

	@GetMapping("/best-celler")
	public List<Book> bestCeller(){
		ArrayList<Book> bestList = new ArrayList<>();
		Book.sampleData().forEach(list -> {
			if(list.getId() == 1) {
				bestList.add(list);
			}
		});
		return bestList;
	}
}
