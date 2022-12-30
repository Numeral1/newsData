package ru.irbis.newsData.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.irbis.newsData.dto.request.NewsRequestDto;
import ru.irbis.newsData.mapper.NewsMapper;
import ru.irbis.newsData.dto.response.NewsResponseDto;
import ru.irbis.newsData.repository.NewsRepository;
import ru.irbis.newsData.repository.SourceRepository;
import ru.irbis.newsData.repository.TopicRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    private final TopicRepository topicRepository;

    private final SourceRepository sourceRepository;

    private final NewsMapper newsMapper;

    public List<NewsResponseDto> getNews(NewsRequestDto requestDto, Pageable pageable){
        if (requestDto.getSource() != null && requestDto.getTopic() == null) {
            return newsRepository.findAllBySourceName(requestDto.getSource(), pageable)
                    .stream()
                    .map(newsMapper::mapToNewsResponseDto)
                    .collect(Collectors.toList());
        } else if (requestDto.getTopic() != null && requestDto.getSource() == null) {
            return newsRepository.findAllByTopicName(requestDto.getTopic(), pageable)
                    .stream()
                    .map(newsMapper::mapToNewsResponseDto)
                    .collect(Collectors.toList());
        } else if (requestDto.getSource() != null) {
            return newsRepository.findAllBySourceNameAndTopicName(requestDto.getSource(),requestDto.getTopic(), pageable)
                    .stream()
                    .map(newsMapper::mapToNewsResponseDto)
                    .collect(Collectors.toList());
        }

        return newsRepository.findAll(pageable)
                .stream()
                .map(newsMapper::mapToNewsResponseDto)
                .collect(Collectors.toList());
    }


}
