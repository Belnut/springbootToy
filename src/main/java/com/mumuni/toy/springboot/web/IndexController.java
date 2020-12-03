package com.mumuni.toy.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index"; //gradle 'org.springframework.boot:spring-boot-starter-mustache' 로 인해 앞의 경로와 파일확장자가 자동 입력됨
                        //해당 경우 default 경로로서 src/main/resource/templates/index.mustache 로 전환되어 View Resolver 가 처리하게 됨
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
