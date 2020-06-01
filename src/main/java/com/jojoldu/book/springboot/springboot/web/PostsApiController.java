package com.jojoldu.book.springboot.springboot.web;

import com.jojoldu.book.springboot.springboot.service.PostsService;
import com.jojoldu.book.springboot.springboot.web.dto.PostsResponseDto;
import com.jojoldu.book.springboot.springboot.web.dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService; // autoWired를 쓰지 않는다. -> RequiredArgsConstructor로 생성자를 주입받기 때문

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
