package ru.irbis.newsData.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.irbis.newsData.entity.News;
import ru.irbis.newsData.repository.NewsRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class News2CsvAggregator implements Runnable {

    private String source;

    private final NewsRepository newsRepository;

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public void run() {
        someFunc(source);
    }

    private void someFunc(String source) {
        Integer newsCount = newsRepository.countNewsBySourceName(source);

        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]
                { "Тема", "Количество новостей" });

        dataLines.add(new String[]
                { source, newsCount.toString() });

        File csvOutputFile = new File(String.format("%s.csv", source));
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            csvOutputFile.createNewFile(); // if file already exists will do nothing
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String convertToCSV(String[] data) {
        return String.join(",", data);
    }
}
