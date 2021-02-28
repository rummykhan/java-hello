package org.example.http;

import org.example.serchmanager.SearchResult;

import java.util.List;

public interface ResponseManager {
    public List<SearchResult> getSearchResult() throws Exception;
}
