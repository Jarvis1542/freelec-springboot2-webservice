package com.jojoldu.book.springboot.springboot.domain.posts;

import org.assertj.core.api.LocalDateTimeAssert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired // 이게 오류가 날 경우 @SpringBootApplication가 있는 클래스가 최상위 패키지 안에 넣어야함.
    PostsRepository postsRepository;

    @After // JUnit에서 단위 테스트가 끝날때마다 수행되는 메소드, @Test가 실행되고나서 마지막에 이거 실행
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트게시글";
        String content = "테스트본문";

        postsRepository.save(Posts.builder() // postsRepository.save : posts table에 insert/update 쿼리를 실행, id 있으면 update, 없으면 insert
                .title(title)
                .content(content)
                .author("pjy4952@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); // posts table의 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        System.out.println("title : " + posts.getTitle());
        System.out.println("content : " + posts.getContent());
        System.out.println("author : " + posts.getAuthor());

    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
            .title("title")
            .content("content")
            .author("author")
            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>> createDate = " + posts.getCreatedDate() + ", modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
