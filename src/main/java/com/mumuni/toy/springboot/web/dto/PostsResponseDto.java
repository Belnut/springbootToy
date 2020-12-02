package com.mumuni.toy.springboot.web.dto;

import com.mumuni.toy.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String context;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.context = entity.getContent();
        this.author = entity.getAuthor();
    }
}
