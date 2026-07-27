package com.module4.org.Module4.services;

import com.module4.org.Module4.dto.PostDTO;
import com.module4.org.Module4.entities.PostEntity;
import com.module4.org.Module4.exceptions.ResourceNotFoundException;
import com.module4.org.Module4.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService
{

    private final PostRepository postRepository;
    private final ModelMapper getModelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postEntity -> getModelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = getModelMapper.map(inputPost, PostEntity.class); // Save the inputPost using ModelMapper to Entity class
        return getModelMapper.map(postRepository.save(postEntity), PostDTO.class); // Save this entity inside Repository. Then convert it to DTO

    }

    @Override
    public PostDTO getPostById(Long id) {
        PostEntity postEntity = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post Not found with id: "+ id));
        return getModelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
        // Find the post with the ID, which we want to change
        PostEntity olderPost = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post Not found with id: "+ postId));
        //Set the id of new input post as it would be null by default
        inputPost.setId(postId);
        //Use model mapper to map the new input post to older post
        getModelMapper.map(inputPost, olderPost);
        //Save the older post as its updated now
        PostEntity savedPostEntity = postRepository.save(olderPost);
        //Map that older post to DTO class using entity
        return getModelMapper.map(savedPostEntity, PostDTO.class);
    }


}
