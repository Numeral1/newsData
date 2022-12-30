package ru.irbis.newsData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.irbis.newsData.entity.Source;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {

}
