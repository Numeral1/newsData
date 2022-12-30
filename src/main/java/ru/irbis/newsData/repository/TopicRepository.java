package ru.irbis.newsData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.irbis.newsData.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
