package com.example.mybooks.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/new-book")
	public List<Book> newBook(@RequestParam Integer page) {
		ArrayList<Book> newBookList = new ArrayList<>();
		Book.sampleData().forEach(list -> {
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
		Book.sampleData().forEach(list -> {
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
		Book.sampleData().forEach(list -> {
			totalList.add(list);
		});
		ArrayList<Book> randomList = new ArrayList<>();

		Collections.shuffle(totalList);

		for (int i = 0; i < 9; i++) {
			randomList.add(totalList.get(i));
//			int a = random.nextInt(100);
//			if(randomList.contains(a)) {
//				continue;
//			}
//			randomList.add(totalList.get(a)); 
		}

		return randomList;
	}
<<<<<<< HEAD
	
	
	@GetMapping("/search")
	public List<Book> search(@RequestParam String title) {
		ArrayList<Book> searchList = new ArrayList<>();
		Book.sampleData().forEach(list -> {
			if(list.getTitle().replace(" ", "").toUpperCase().contains(title)) {
				searchList.add(list);
			}
		});
		return searchList;
	}
=======

	@PostMapping("/favorite")
	public Book favorite(@RequestBody Book book) {
		Book.sampleData().forEach(t -> {
			if (t.getBuyUrl().equals(book.getBuyUrl())) {
				if(t.getFavorite() == false) {
					t.setFavorite(true);					
				} else {
					t.setFavorite(false);
				}
			}
		});
		return book;
	}

>>>>>>> 5354fb160f919b2f967b06d6416af8b407c70d14
}