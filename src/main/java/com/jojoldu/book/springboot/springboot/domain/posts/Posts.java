package com.jojoldu.book.springboot.springboot.domain.posts;

import com.jojoldu.book.springboot.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // NoArgsConstructor : 기본생성자 자동추가
@Entity // Entity : 테이블과 링크될 클래스 클래스이름을 _로 테이블 이름 매칭 ex) SalesManager.java -> sales_manager table
public class Posts extends BaseTimeEntity { // 실제 DB 테이블과 매칭될 클래스

    @Id // Id : PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue : PK 생성규칙, GenerationType.IDENTITY : auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // Column : 굳이 선언 안해도됨, 이런 필드는 모두 칼럼이 됨.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 기본값 외의 추가로 변경이 필요한 옵션이 있으면 사용
    private String content;

    private String author;

    @Builder // 해당 클래스 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){ // 이 빌더 클래스가 생성자와 setter역할을 한다.
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
