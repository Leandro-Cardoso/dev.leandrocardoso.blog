package dev.leandrocardoso.blog.service;

import dev.leandrocardoso.blog.model.Post;
import dev.leandrocardoso.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {

        this.postRepository = postRepository;

    }

    public List<Post> getAllPosts() {

        return this.postRepository.findAll();

    }

}
