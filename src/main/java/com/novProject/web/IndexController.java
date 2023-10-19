package com.novProject.web;

import com.novProject.service.posts.PostsService;
import com.novProject.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @Autowired
    PostsService postsService;

    @GetMapping("/")
    public String index(Model model) { //model객체를 파라미터로 받는 메소드
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id); //findById()는 Posts타입의 객체를 반환함
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
