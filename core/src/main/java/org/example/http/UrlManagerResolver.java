package org.example.http;

import lombok.NonNull;
import org.example.constants.Constants;
import org.example.properties.PropertyManager;
import org.example.properties.PropertyManagerImpl;

public final class UrlManagerResolver {

    public static UrlManager resolve(@NonNull String searchEngine) throws Exception {

        switch (searchEngine) {
            case Constants.SEARCH_ENGINE_GOOGLE:
                return new GoogleUrlManager((PropertyManager) new PropertyManagerImpl("/pom.properties"));
        }

        return null;
    }
}
