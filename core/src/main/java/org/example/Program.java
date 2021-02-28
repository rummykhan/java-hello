package org.example;

import org.example.serchmanager.SearchManager;
import org.example.serchmanager.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

public class Program {

    private static final Logger logger = LoggerFactory.getLogger(Program.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static ConfigurableApplicationContext context = null;

    public static void main(String[] args) {
        logger.info("Hello logger");

        context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        SearchManager searchManager = context.getBean("search-manager", SearchManager.class);

        logger.info("Bean created: {}", searchManager);

        List<SearchResult> results = null;

        try {
            results = searchManager.search("tesla");

        } catch (Exception e) {
            logger.error("Error: {}", e.getMessage());
        } finally {
            context.close();
        }

        if (results == null) {
            logger.info("Search result empty");
            return;
        }

        logger.info("Search results found: {}", results.size());

        for (Iterator<SearchResult> iterator = results.iterator(); iterator.hasNext(); ) {

            SearchResult searchResult = iterator.next();

            String title = searchResult.getTitle();
            String link = searchResult.getLink();

            logger.info("{} -- {}", link, title);
        }
    }
}
