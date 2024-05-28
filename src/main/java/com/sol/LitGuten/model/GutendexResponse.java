package com.sol.LitGuten.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sol.LitGuten.model.Book;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexResponse {
    private int count;
    private List<Book> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Book> getResults() {
        return results;
    }

    public void setResults(List<Book> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GutendexResponse{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}