package com.example.BloggingPlatform.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
public class Blogger {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String content;

  private String category;

  @ElementCollection
  private List<String> tags;

  @CreationTimestamp
  private Date createdAt;

  @UpdateTimestamp
  private Date updatedAt;

}
//"id": 1,
//    "title": "My First Blog Post",
//    "content": "This is the content of my first blog post.",
//    "category": "Technology",
//    "tags": ["Tech", "Programming"],
//    "createdAt": "2021-09-01T12:00:00Z",
//    "updatedAt": "2021-09-01T12:00:00Z"
