package com.example.BloggingPlatform.services;


import com.example.BloggingPlatform.models.Blogger;
import com.example.BloggingPlatform.repositories.BlogPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
  private final BlogPostRepository repository;

  public BlogPostService(BlogPostRepository repository) {
    this.repository = repository;
  }

  public Blogger createPost(Blogger post) {
    return repository.save(post);
  }

  public Blogger updatePost(Long id, Blogger updatedPost) {
    Blogger existingPost = repository.findById(id).orElse(null);
    if (existingPost == null) {
      throw new RuntimeException("Post not found");
    }

    existingPost.setTitle(updatedPost.getTitle());
    existingPost.setContent(updatedPost.getContent());
    existingPost.setCategory(updatedPost.getCategory());
    existingPost.setTags(updatedPost.getTags());

    return repository.save(existingPost);
  }

  public void deletePost(Long id) {
    Blogger existingPost = repository.findById(id).orElse(null);
    if (existingPost == null) {
      throw new RuntimeException("Post not found");
    }

    repository.delete(existingPost);
  }

  public Blogger getPost(Long id) {
    Blogger post = repository.findById(id).orElse(null);
    if (post == null) {
      throw new RuntimeException("Post not found");
    }
    return post;
  }

  public List<Blogger> getAllPosts(String searchTerm) {
    if (searchTerm != null && !searchTerm.isEmpty()) {
      return repository.searchByTerm(
          searchTerm);
    }
    return repository.findAll();
  }
}

