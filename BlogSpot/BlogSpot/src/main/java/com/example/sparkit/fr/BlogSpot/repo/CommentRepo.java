package com.example.sparkit.fr.BlogSpot.repo;

import com.example.sparkit.fr.BlogSpot.Dto.CommentDto;
import com.example.sparkit.fr.BlogSpot.Dto.PublicationDto;
import com.example.sparkit.fr.BlogSpot.entity.Comment;
import com.example.sparkit.fr.BlogSpot.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
    Optional<Comment> findById(CommentDto commentDto);
    Integer countCommentByPublicationId(Long id);
    List<Comment> findByPublicationId(Long id);

}
