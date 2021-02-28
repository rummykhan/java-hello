package org.example.serchmanager;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class SearchResultImpl implements SearchResult {

    private static final Logger logger = LoggerFactory.getLogger(SearchResultImpl.class);

    private String title;
    private String text;
    private String link;
}
