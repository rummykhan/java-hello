package org.example.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private String kind;
    private String title;
    private String htmlTitle;
    private String link;
    private String displayLink;
}
