/*머스테치에 URL을 매핑해주는 컨트롤러*/

package com.novProject.web;

import com.novProject.config.auth.LoginUser;
import com.novProject.config.auth.dto.SessionUser;
import com.novProject.domain.posts.Posts;
import com.novProject.service.posts.PostsService;
import com.novProject.web.dto.PostsResponseDto;
import com.novProject.web.dto.PostsViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @Autowired
    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model,
                        @PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                        @LoginUser SessionUser user) {
        Page<Posts> list = postsService.findAllDesc(pageable);
        model.addAttribute("posts", list);
        model.addAttribute("prev", pageable.previousOrFirst().getPageNumber()); //이전 페이지
        model.addAttribute("next", pageable.next().getPageNumber()); //다음 페이지

        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id); //findById()는 Posts타입의 객체를 반환함
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @GetMapping("/posts/view/{id}")
    public String postsView(@PathVariable Long id, Model model) {
        PostsViewDto dto = postsService.findPostById(id);
        model.addAttribute("post", dto);
        return "posts-view";
    }
}
