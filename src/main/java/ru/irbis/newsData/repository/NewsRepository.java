package ru.irbis.newsData.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.irbis.newsData.entity.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllBySourceName(String source, Pageable pageable);

    Integer countNewsBySourceName(String source);

    List<News> findAllByTopicName(String topic, Pageable pageable);

    List<News> findAllBySourceNameAndTopicName(String source, String topic, Pageable pageable);
}
