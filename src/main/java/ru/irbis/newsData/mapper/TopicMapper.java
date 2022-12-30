package ru.irbis.newsData.mapper;

import org.springframework.stereotype.Component;
import ru.irbis.newsData.dto.response.TopicResponseDto;
import ru.irbis.newsData.entity.Topic;
@Component
public class TopicMapper {

    public TopicResponseDto mapToTopicDto(Topic topic) {
        return TopicResponseDto.builder()
                .id(topic.getId())
                .name(topic.getName())
                .build();
    }
}
