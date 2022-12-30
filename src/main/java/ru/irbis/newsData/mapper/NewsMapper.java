package ru.irbis.newsData.mapper;

import org.springframework.stereotype.Component;
import ru.irbis.newsData.dto.response.NewsResponseDto;
import ru.irbis.newsData.entity.News;

@Component
public class NewsMapper {

    public NewsResponseDto mapToNewsResponseDto(News news){
        return NewsResponseDto.builder()
                .id(news.getId())
                .name(news.getName())
                .build();
    }
}
