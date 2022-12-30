package ru.irbis.newsData.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irbis.newsData.dto.response.SourceResponseDto;
import ru.irbis.newsData.service.SourceService;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/source")
public class SourceController {
    private final SourceService sourceService;

    @GetMapping
    public ResponseEntity<List<SourceResponseDto>> getSources() {
        return ResponseEntity.ok(sourceService.getSources());
    }
}
