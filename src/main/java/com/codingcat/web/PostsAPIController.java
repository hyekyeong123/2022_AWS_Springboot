package com.codingcat.web;

import com.codingcat.service.posts.PostsService;
import com.codingcat.web.dto.PostsResponseDto;
import com.codingcat.web.dto.PostsSaveRequestDto;
import com.codingcat.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostsAPIController {

    private final PostsService postsService;

    // 등록하기
    @PostMapping("")
    public Long save(
            @RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);

    }

    // 수정하기
    @PutMapping("{id}")
    public Long update(
            @PathVariable Long id,
            @RequestBody PostsUpdateRequestDto requestDto
    ){
        return postsService.update(id, requestDto);
    }

    // 아이디로 조회하기
    @GetMapping("{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    // 삭제하기
    @DeleteMapping("{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}

