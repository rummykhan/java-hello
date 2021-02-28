package org.example.serchmanager;

import lombok.NonNull;
import java.util.List;

public interface SearchManager {
    public List<SearchResult> search(@NonNull String searchTerm) throws Exception;
}
