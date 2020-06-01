package com.jojoldu.book.springboot.springboot.dto;

import com.jojoldu.book.springboot.springboot.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복기능테스트(){

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // 테스트 검증 라이브러리, 검증하고 싶은 메소드를 인자로 받는다.
        assertThat(dto.getAmount()).isEqualTo(amount); // isEqualTo : 값을 비교해서 같을 때만 성공
    }
}
