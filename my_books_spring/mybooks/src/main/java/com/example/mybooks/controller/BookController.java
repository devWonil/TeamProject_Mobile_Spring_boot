package com.example.mybooks.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybooks.dto.Book;

@RestController
@RequestMapping("/mybooks")
public class BookController {

	@GetMapping("/best-seller")
	public List<Book> bestSeller(@RequestParam Integer page) {
		ArrayList<Book> bestList = new ArrayList<>();
		Book.sampleData().forEach(list -> {
			if (list.getId() == 1) {
				if (list.getPage() == page) {
					bestList.add(list);
				}
			}
		});
		return bestList;
	}
}