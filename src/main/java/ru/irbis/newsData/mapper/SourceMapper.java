package ru.irbis.newsData.mapper;

import org.springframework.stereotype.Component;
import ru.irbis.newsData.dto.response.SourceResponseDto;
import ru.irbis.newsData.entity.Source;

@Component
public class SourceMapper {
    public SourceResponseDto mapToSourceDto(Source source) {
        return SourceResponseDto.builder()
                .id(source.getId())
                .source(source.getName())
                .build();
    }
}
