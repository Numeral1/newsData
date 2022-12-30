package ru.irbis.newsData.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.irbis.newsData.mapper.TopicMapper;
import ru.irbis.newsData.dto.response.TopicResponseDto;
import ru.irbis.newsData.repository.TopicRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    private final TopicMapper topicMapper;

    public List<TopicResponseDto> getTopic(){
       return topicRepository.findAll()
                .stream()
                .map(topicMapper::mapToTopicDto)
                .collect(Collectors.toList());

    }
}
