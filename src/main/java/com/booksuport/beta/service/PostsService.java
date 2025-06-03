package com.booksuport.beta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booksuport.beta.domain.posts.Posts;
import com.booksuport.beta.domain.posts.PostsRepository;
import com.booksuport.beta.web.dto.PostsResponseDto;
import com.booksuport.beta.web.dto.PostsSaveRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsResponseDto> findAll() {
        List<Posts> postsList = postsRepository.findAll();
        return postsList.stream()
                .map(PostsResponseDto::new)
                .collect(Collectors.toList());
    }
}
