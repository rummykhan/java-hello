package org.example.properties;

import lombok.NonNull;

public interface PropertyManager {

    public String get(@NonNull String key);
}
