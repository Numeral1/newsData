package ru.irbis.newsData.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irbis.newsData.dto.response.TopicResponseDto;
import ru.irbis.newsData.service.TopicService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/topic")
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public ResponseEntity<List<TopicResponseDto>> getTopic(){
        return ResponseEntity.ok(topicService.getTopic());
    }

}