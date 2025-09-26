package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

// Unit test without Spring context
class BookControllerTest {

    @Test
    void all_shouldReturnListOfBooks() {
        // Arrange: create a fake BookService
        BookService mockService = mock(BookService.class);
        List<Book> fakeBooks = Arrays.asList(
                new Book("1984"),
                new Book("Brave New World"));
        when(mockService.getAllBooks()).thenReturn(fakeBooks);

        // Act: inject fake service into controller
        BookController controller = new BookController(mockService);
        List<BookDTO> result = controller.all();

        // Assert: controller returns the list from the service
        assertEquals(2, result.size());
        assertEquals("1984", result.get(0).getTitle());
    }
}
