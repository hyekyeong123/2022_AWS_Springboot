package com.codingcat.web;

import com.codingcat.config.auth.dto.SessionUser;
import com.codingcat.service.posts.PostsService;
import com.codingcat.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.h2.engine.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
//  ************************************************************

    // 등록하기
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    // 전체 조회하기
    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("posts",postsService.findAllDesc());

        // userName을 Model에 추가
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }


    // 수정내역 보여주기
    @GetMapping("/posts/update/{id}")
    public String postsUpdateView(
            @PathVariable Long id, Model model
    ){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }


}
