package com.jojoldu.book.springboot.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


// Posts 클래스가 DB에 접근하게 해줄 클래스, MyBatis로 치면 Dao같은 존재
// @Repository 추가 X -> Entity class와 Entity repository가 함꼐 위치해야한다. -> 프로젝트가 커지면 도메인 패키지에 함꼐 관리
//                                               <Entity class, PK type>
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();

}
