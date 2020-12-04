package com.mumuni.toy.springboot.web;

import com.mumuni.toy.springboot.config.auth.LoginUser;
import com.mumuni.toy.springboot.config.auth.dto.SessionUser;
import com.mumuni.toy.springboot.domain.posts.PostsService;
import com.mumuni.toy.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index"; //gradle 'org.springframework.boot:spring-boot-starter-mustache' 로 인해 앞의 경로와 파일확장자가 자동 입력됨
                        //해당 경우 default 경로로서 src/main/resource/templates/index.mustache 로 전환되어 View Resolver 가 처리하게 됨
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "post-update";
    }
}
