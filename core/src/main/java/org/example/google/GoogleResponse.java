package org.example.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.example.serchmanager.SearchResult;
import org.example.serchmanager.SearchResultImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleResponse {
    private String kind;
    private Url url;
    private SearchInformation searchInformation;
    private List<Item> items;

    private static final Logger logger = LoggerFactory.getLogger(GoogleResponse.class);

    public List<SearchResult> toSearchResult(GoogleResponse response) {

        List<SearchResult> searchResults = new ArrayList<>();

        for (Iterator<Item> iterator = response.getItems().iterator(); iterator.hasNext(); ) {

            SearchResultImpl searchResult = new SearchResultImpl();
            Item item = iterator.next();

            searchResult.setTitle(item.getTitle());
            searchResult.setLink(item.getLink());
            searchResult.setText(item.getDisplayLink());

            searchResults.add(searchResult);
        }

        return searchResults;
    }
}
