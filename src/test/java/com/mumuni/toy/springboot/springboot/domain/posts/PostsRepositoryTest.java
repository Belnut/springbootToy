package com.mumuni.toy.springboot.springboot.domain.posts;

import com.mumuni.toy.springboot.domain.posts.Posts;
import com.mumuni.toy.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) // Spring Boot Test 시 junit4 를 사용한다면 필수 포함
@SpringBootTest //Spring boot 테스트에 거의 모두 필요한 의존성 제공
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 단위 테스트가 끝날 때 마다 실행되는 메소드
    public void cleanup( ) {
        postsRepository.deleteAll();
    }

    @Test
    public void save_load_board() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //posts 테이블에 insert/update 쿼리를 실행 (id 가 있으면 update, 없다면 insert)
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("ohj8447@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
