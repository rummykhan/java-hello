package org.example.serchmanager;

import lombok.NonNull;
import org.example.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchManagerImpl implements SearchManager {

    private static final Logger logger = LoggerFactory.getLogger(SearchManagerImpl.class);

    private CoreHttpClient coreHttpClient = null;
    private String searchEngine = null;

    public SearchManagerImpl(@NonNull CoreHttpClient coreHttpClient, @NonNull String searchEngine) {

        this.coreHttpClient = coreHttpClient;
        this.searchEngine = searchEngine;
    }

    @Override
    public List<SearchResult> search(@NonNull final String searchTerm) throws Exception, NullPointerException {
        logger.info("Search term received: {}", searchTerm);

        UrlManager urlManager = this.getUrlManager(this.searchEngine);

        String response = this.coreHttpClient.get(urlManager.createUrl(searchTerm));

        logger.info("Response: {}", response);

        ResponseManager responseManager = ResponseManagerResolver.resolve(response, this.searchEngine);

        logger.info("response: {}", responseManager);

        return responseManager.getSearchResult();
    }

    private UrlManager getUrlManager(String searchEngine) throws Exception {
        return UrlManagerResolver.resolve(searchEngine);
    }
}
