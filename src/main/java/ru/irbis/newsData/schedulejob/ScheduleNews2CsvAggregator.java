package ru.irbis.newsData.schedulejob;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.irbis.newsData.entity.Source;
import ru.irbis.newsData.repository.SourceRepository;
import ru.irbis.newsData.service.News2CsvAggregator;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduleNews2CsvAggregator {

    private final News2CsvAggregator news2CsvAggregator;

    private final SourceRepository sourceRepository;

    @Scheduled(fixedDelay = 20000)
    public void scheduleFixedDelayTask() throws InterruptedException {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);

        List<Source> sources = sourceRepository.findAll();

        for (Source source : sources) {
            news2CsvAggregator.setSource(source.getName());
            Thread newThread = new Thread(news2CsvAggregator);
            newThread.start();
            newThread.join();
        }


        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
    }
}
