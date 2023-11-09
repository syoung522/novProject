/*머스테치에 URL을 매핑해주는 컨트롤러*/

package com.novProject.web;

import com.novProject.config.auth.LoginUser;
import com.novProject.config.auth.dto.SessionUser;
import com.novProject.domain.posts.Posts;
import com.novProject.service.comment.CommentService;
import com.novProject.service.posts.PostsService;
import com.novProject.web.dto.CommentListResponseDto;
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
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @Autowired
    private final PostsService postsService;
    private final CommentService commentService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model,
                        @PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                        @LoginUser SessionUser user) {
        //페이징
        Page<Posts> list = postsService.findAllDesc(pageable);
        model.addAttribute("posts", list);
        model.addAttribute("prev", pageable.previousOrFirst().getPageNumber()); //이전 페이지
        model.addAttribute("next", pageable.next().getPageNumber()); //다음 페이지

        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());

        //로그인
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/search")
    public String search(Model model, String keyword){
        //검색
        List<Posts> searchList = postsService.findByTitleContaining(keyword);
        model.addAttribute("searchList", searchList);
        return "posts-search";
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
    public String postsView(@PathVariable Long id, Model model,
                            @LoginUser SessionUser user) {
        //게시글
        PostsViewDto dto = postsService.findPostById(id);
        model.addAttribute("post", dto);

        //댓글
        PostsResponseDto dto_ = postsService.findById(id);
        List<CommentListResponseDto> commentList = dto_.getComments();
        if(commentList != null && !commentList.isEmpty()){
            model.addAttribute("commentList", commentList);
        }

        //사용자
        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        return "posts-view";
    }
}
