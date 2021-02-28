package org.example.http;

import lombok.NonNull;
import org.apache.http.client.utils.URIBuilder;
import org.example.constants.Constants;
import org.example.properties.PropertyManager;

public class GoogleUrlManager implements UrlManager {

    private PropertyManager propertyManager;

    public GoogleUrlManager(@NonNull PropertyManager propertyManager) {
        this.propertyManager = propertyManager;
    }

    @Override
    public String createUrl(String searchTerm) throws Exception {
        String googleApiKey = this.getApiKey();
        String googleProjectId = this.googleProjectId();

        URIBuilder uriBuilder = new URIBuilder(Constants.GOOGLE_URL);
        uriBuilder.addParameter("q", searchTerm);
        uriBuilder.addParameter("key", googleApiKey);
        uriBuilder.addParameter("cx", googleProjectId);

        return uriBuilder.toString();
    }

    private String getApiKey() {
        return this.propertyManager.get(Constants.GOOGLE_API_KEY);
    }

    private String googleProjectId() {
        return this.propertyManager.get(Constants.GOOGLE_PROJECT_ID);
    }

}
