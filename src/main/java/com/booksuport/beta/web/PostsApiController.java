package com.booksuport.beta.web;

import com.booksuport.beta.service.PostsService;
import com.booksuport.beta.web.dto.PostsResponseDto;
import com.booksuport.beta.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    /**
     * JSON 방식 요청 처리
     */
    @PostMapping(value = "/api/v1/posts", consumes = "application/json")
    public Long saveJson(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    /**
     * HTML form 방식 요청 처리
     */
    @PostMapping(value = "/api/v1/posts", consumes = "application/x-www-form-urlencoded")
    public Long saveForm(@ModelAttribute PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    /**
     * 전체 게시글 조회
     */
    @GetMapping("/api/v1/posts")
    public List<PostsResponseDto> getAllPosts() {
        return postsService.findAll();
    }
}
