package com.mumuni.toy.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//DAO의 역활을 하는 DB Layer 접근자, jpa 에서는 Repository로 부름
//JpaRepository 를 상속 시 기본적으로 CRUD 생성
//Entity 와 Repository 는 항상 같은 곳에 위치시킬 것
//차후 따로 관리가 필요하면 domain 패키지에서 관리할 것
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
