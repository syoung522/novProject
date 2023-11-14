/*머스테치에 URL을 매핑해주는 컨트롤러*/

package com.novProject.web;

import com.novProject.config.auth.LoginUser;
import com.novProject.config.auth.dto.SessionUser;
import com.novProject.domain.posts.Posts;
import com.novProject.service.posts.PostsService;
import com.novProject.web.dto.CommentListResponseDto;
import com.novProject.web.dto.PostsResponseDto;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @Autowired
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model,
                        @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                        @LoginUser SessionUser user) {
        //게시글 목록 + 페이징
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
    public String search(Model model,
                         @RequestParam("keyword_1") String keyword_1,
                         @RequestParam("keyword_2") String keyword_2,
                         @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                         @LoginUser SessionUser user){
        //로그인
        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        //검색목록 + 페이징
        if(keyword_1.equals("ALL")){
            Page<Posts> searchList = postsService.findByTitleContaining(keyword_2, pageable);
            model.addAttribute("searchList", searchList);
            model.addAttribute("prev", pageable.previousOrFirst().getPageNumber()); //이전 페이지
            model.addAttribute("next", pageable.next().getPageNumber()); //다음 페이지

            model.addAttribute("hasNext", searchList.hasNext());
            model.addAttribute("hasPrev", searchList.hasPrevious());

            model.addAttribute("keyword_1", keyword_1);
            model.addAttribute("keyword_2", keyword_2);
        } else {
            Page<Posts> searchList = postsService.findByCategoryAndTitleContaining(keyword_1, keyword_2, pageable);
            model.addAttribute("searchList", searchList);
            model.addAttribute("prev", pageable.previousOrFirst().getPageNumber()); //이전 페이지
            model.addAttribute("next", pageable.next().getPageNumber()); //다음 페이지

            model.addAttribute("hasNext", searchList.hasNext());
            model.addAttribute("hasPrev", searchList.hasPrevious());

            model.addAttribute("keyword_1", keyword_1);
            model.addAttribute("keyword_2", keyword_2);
        }

        return "posts-search";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user){
        //로그인
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        //로그인
        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        model.addAttribute("id", id);
        return "posts-update";
    }

    @GetMapping("/posts/view/{id}")
    public String postsView(Model model,
                            @PathVariable Long id,
                            @LoginUser SessionUser user) {
        //사용자
        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        //게시글
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        //댓글
        PostsResponseDto dto_ = postsService.findById(id);
        List<CommentListResponseDto> commentList = dto_.getComments();
        if(commentList != null && !commentList.isEmpty()){
            model.addAttribute("commentList", commentList);
        }
        
        return "posts-view";
    }

    @GetMapping("/group/save")
    public String groupSave(){
        return "group-save";
    }
}
