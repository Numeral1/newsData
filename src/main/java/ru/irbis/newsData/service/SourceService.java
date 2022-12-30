package ru.irbis.newsData.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.irbis.newsData.mapper.SourceMapper;
import ru.irbis.newsData.dto.response.SourceResponseDto;
import ru.irbis.newsData.repository.SourceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SourceService {
    private final SourceRepository sourceRepository;

    private final SourceMapper sourceMapper;

    public List<SourceResponseDto> getSources() {
        return sourceRepository.findAll()
                .stream()
                .map(sourceMapper::mapToSourceDto)
                .collect(Collectors.toList());
    }
}
