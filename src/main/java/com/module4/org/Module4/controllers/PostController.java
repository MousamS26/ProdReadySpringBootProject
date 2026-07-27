package com.module4.org.Module4.controllers;

import com.module4.org.Module4.dto.PostDTO;
import com.module4.org.Module4.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/posts")
public class PostController
{

    private final PostService postService;

    @GetMapping
    public List<PostDTO> getAllPosts()
    {
        return postService.getAllPosts();
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO inputPost)
    {
        return postService.createNewPost(inputPost);
    }

    @GetMapping("/{postID}")
    public PostDTO getPostByID(@PathVariable Long postID)
    {
        return postService.getPostById(postID);
    }

    @PutMapping("/{postId}")
    public PostDTO updatePost(@RequestBody PostDTO inputPost, @PathVariable Long postId)
    {
        return postService.updatePost(inputPost, postId);
    }
}
