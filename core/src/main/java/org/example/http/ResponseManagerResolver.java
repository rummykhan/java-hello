package org.example.http;

import lombok.NonNull;
import org.example.constants.Constants;

public class ResponseManagerResolver {

    public static ResponseManager resolve(@NonNull String response, @NonNull String searchEngine) {


        switch (searchEngine){
            case Constants.SEARCH_ENGINE_GOOGLE:
                return new GoogleResponseManager(response);
        }

        return null;
    }
}
