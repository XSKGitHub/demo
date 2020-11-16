package org.xsk.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xsk.entity.Book;

@RestController
public class BookController {
    
    @GetMapping("/book")
    public Book book(){
       return Book.builder().author("罗贯中").name("三国演义").price(30f).publicationDate(new Date()).build();
    }
}
