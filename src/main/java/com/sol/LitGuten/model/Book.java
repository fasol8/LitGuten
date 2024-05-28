package com.sol.LitGuten.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

@Entity
public class Book {
    @Id
    private Long id;
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> subjects;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> languages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getLanguages() { return languages; }

    public void setLanguages(List<String> languages) { this.languages = languages; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", subjects=" + subjects +
                ", languages=" + languages +
                '}';
    }

    public String infoBook() {
        return "Book{" +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", languages=" + languages +
                '}';
    }
}