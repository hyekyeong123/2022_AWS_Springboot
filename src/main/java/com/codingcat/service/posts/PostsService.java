package com.codingcat.service.posts;

import com.codingcat.domain.posts.Posts;
import com.codingcat.domain.posts.PostsRepository;
import com.codingcat.web.dto.PostsListResponseDto;
import com.codingcat.web.dto.PostsResponseDto;
import com.codingcat.web.dto.PostsSaveRequestDto;
import com.codingcat.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// 아래를 사용해야 readOnly를 사용할 수 있다
import org.springframework.transaction.annotation.Transactional;
//import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    // 등록하기
    @Transactional
    public Long save(
            PostsSaveRequestDto requestDto
    ){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    // 수정하기
    @Transactional
    public Long update(
            Long id,
            PostsUpdateRequestDto requestDto
    ){
        Posts posts = postsRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    // 아이디로 조회하기
    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id="+id));

        return new PostsResponseDto(posts);
    }

    // 모두 가져와서 조회하기(정렬 DESC)
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){

        // List로 변환
        return postsRepository.findAllDesc()
                .stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 해당 게시물 삭제
    @Transactional
    public void delete(Long id){

        // 있는지 확인 하고 아이디로 검색해서 가져오기
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id="+id));

        // 삭제
        postsRepository.delete(posts);
    }
}
