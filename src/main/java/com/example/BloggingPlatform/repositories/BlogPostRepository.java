package com.example.BloggingPlatform.repositories;

import com.example.BloggingPlatform.models.Blogger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<Blogger, Long> {
//  List<Blogger> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrCategoryContainingIgnoreCase(String title, String content, String category);
@Query("SELECT b FROM Blogger b WHERE LOWER(b.title)"
    + " LIKE LOWER(CONCAT('%', :term, '%')) OR LOWER(b.content) "
    + "LIKE LOWER(CONCAT('%', :term, '%')) OR LOWER(b.category) "
    + "LIKE LOWER(CONCAT('%', :term, '%'))")
List<Blogger> searchByTerm(@Param("term") String term);
}
