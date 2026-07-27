package com.module4.org.Module4.services;

import com.module4.org.Module4.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long id);

    PostDTO updatePost(PostDTO inputPost, Long postId);
}
