package ru.irbis.newsData.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.irbis.newsData.dto.request.NewsRequestDto;
import ru.irbis.newsData.dto.response.NewsResponseDto;
import ru.irbis.newsData.service.NewsService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<NewsResponseDto>> getNews(NewsRequestDto requestDto,
                                                         @PageableDefault Pageable pageable){
       return ResponseEntity.ok(newsService.getNews(requestDto, pageable));
    }
}
