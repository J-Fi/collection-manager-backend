package com.kodilla.collectionmanagerbackend.mapper;

import com.kodilla.collectionmanagerbackend.domain.Author;
import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.domain.BookDto;
import com.kodilla.collectionmanagerbackend.domain.Subject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BookMapper {

    public String mapAuthorsListToString(List<Author> authors) {
        String s = authors.stream().map(Object::toString).collect(Collectors.joining("; "));
        System.out.println("String: " + s);
        return s;
    }

    public List<Author> mapStringToAuthorsList(String authors) {
        List<Author> list = Stream.of(authors.split("; ")).map(author -> new Author(author)).collect(Collectors.toList());
        System.out.println(list.size());
        return list;
    }

    public String mapSubjectsListToString(List<Subject> subjects) {
        String s = subjects.stream().map(Object::toString).collect(Collectors.joining("; "));
        System.out.println("String: " + s);
        return s;
    }

    public List<Subject> mapStringToSubjectsList(String subjects) {
        List<Subject> list = Stream.of(subjects.split("; ")).map(subject -> new Subject(subject)).collect(Collectors.toList());
        System.out.println(list.size());
        return list;
    }

    public BookDto mapToBookDto(Book book) {
        return new BookDto(
                book.getIsbn(),
                book.getIsbn13(),
                book.getTitle(),
                book.getPublisher(),
                book.getSynopsys(),
                book.getImage(),
                mapStringToAuthorsList(book.getAuthors()),
                mapStringToSubjectsList(book.getSubjects()),
                book.getPublishDate());
    }

    public Book mapToBook(BookDto bookDto) {
        return new Book(bookDto.getIsbn(),
                bookDto.getIsbn13(),
                bookDto.getTitle(),
                bookDto.getPublisher(),
                bookDto.getSynopsys(),
                bookDto.getImage(),
                mapAuthorsListToString(bookDto.getAuthors()),
                mapSubjectsListToString(bookDto.getSubjects()),
                bookDto.getPublishDate());
    }
}
