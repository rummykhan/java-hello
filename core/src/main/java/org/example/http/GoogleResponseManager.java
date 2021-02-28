package org.example.http;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.example.google.GoogleResponse;
import org.example.serchmanager.SearchResult;

import java.util.List;

public class GoogleResponseManager implements ResponseManager {

    private String response = null;
    protected ObjectMapper objectMapper = null;

    public GoogleResponseManager(@NonNull String response) {
        this.response = response;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    }

    @Override
    public List<SearchResult> getSearchResult() throws Exception {

        GoogleResponse googleResponse = this.objectMapper.readValue(response, GoogleResponse.class);

        return googleResponse.toSearchResult(googleResponse);
    }
}
