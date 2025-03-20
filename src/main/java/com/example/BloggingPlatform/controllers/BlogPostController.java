package com.example.BloggingPlatform.controllers;


import com.example.BloggingPlatform.models.Blogger;
import com.example.BloggingPlatform.services.BlogPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogPostController {
  private final BlogPostService service;

  public BlogPostController(BlogPostService service) {
    this.service = service;
  }

  @PostMapping("/createPost")
  public ResponseEntity<Blogger> createPost(@RequestBody Blogger post) {
    return ResponseEntity.status(201).body(service.createPost(post));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Blogger> updatePost(@PathVariable Long id, @RequestBody Blogger updatedPost) {
    return ResponseEntity.ok(service.updatePost(id, updatedPost));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePost(@PathVariable Long id) {
    service.deletePost(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Blogger> getPost(@PathVariable Long id) {
    return ResponseEntity.ok(service.getPost(id));
  }

  @GetMapping("/getAllPosts")
  public ResponseEntity<List<Blogger>> getAllPosts(@RequestParam(required = false) String term) {
    return ResponseEntity.ok(service.getAllPosts(term));
  }
}

