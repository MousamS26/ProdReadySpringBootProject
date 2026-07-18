package com.module4.org.Module4.services;

import com.module4.org.Module4.dto.PostDTO;
import com.module4.org.Module4.entities.PostEntity;
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
}
