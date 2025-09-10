package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

     public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<BookDTO> all() {
        return service.getAllBooks()
                      .stream()
                      .map(book -> new BookDTO(book.getTitle()))
                      .collect(Collectors.toList());
    }

    @PostMapping
    public BookDTO add(@RequestBody BookDTO dto) {
        Book book = new Book(dto.getTitle());
        Book saved = service.addBook(book);
        return new BookDTO(saved.getTitle());
    }
}
