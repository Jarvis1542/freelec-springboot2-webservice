package com.jojoldu.book.springboot.springboot.web.dto;

import com.jojoldu.book.springboot.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto { // 이 클래스는 Entity클래스와 유사하다. 하지만 Entity클래스로 request/response하면 안된다.
// 왜냐하면 DB에 접근하는 핵심클래스기 때문
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
