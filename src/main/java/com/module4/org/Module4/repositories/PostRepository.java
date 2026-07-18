package com.module4.org.Module4.repositories;

import com.module4.org.Module4.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
