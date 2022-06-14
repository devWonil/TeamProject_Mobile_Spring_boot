package com.example.mybooks.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybooks.dto.Book;

@RestController
@RequestMapping("/mybooks")
public class BookController {
	
	public static ArrayList<Book> bookList = (ArrayList<Book>) Book.sampleData();

	@GetMapping("/best-seller")
	public List<Book> bestSeller(@RequestParam Integer page) {
		ArrayList<Book> bestList = new ArrayList<>();
		bookList.forEach(list -> {
			if (list.getId() == 1) {
				if (list.getPage() == page) {
					bestList.add(list);
				}
			}
		});
		return bestList;
	}

	@GetMapping("/new-book")
	public List<Book> newBook(@RequestParam Integer page) {
		ArrayList<Book> newBookList = new ArrayList<>();
		bookList.forEach(list -> {
			if (list.getId() == 0) {
				if (list.getPage() == page) {
					newBookList.add(list);
				}
			}
		});
		return newBookList;
	}

	@GetMapping("/genre")
	public List<Book> novel(@RequestParam Integer page, @RequestParam Integer themeNumber) {
		ArrayList<Book> genreList = new ArrayList<>();
		bookList.forEach(list -> {
			if (list.getTheme() == themeNumber) {
				genreList.add(list);
			}
		});
		return genreList;
	}

	@GetMapping("/random")
	public List<Book> random() {
		Random random = new Random();
		ArrayList<Book> totalList = new ArrayList<>();
		bookList.forEach(list -> {
			totalList.add(list);
		});
		ArrayList<Book> randomList = new ArrayList<>();

		Collections.shuffle(totalList);

		for (int i = 0; i < 9; i++) {
			randomList.add(totalList.get(i));
		}

		return randomList;
	}
	
	@GetMapping("/search")
	public List<Book> search(@RequestParam String title) {
		ArrayList<Book> searchList = new ArrayList<>();
		bookList.forEach(list -> {
			if(list.getTitle().replace(" ", "").toUpperCase().contains(title)) {
				searchList.add(list);
			}
		});
		return searchList;
	}
	
}