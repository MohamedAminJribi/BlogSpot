package com.example.sparkit.fr.BlogSpot.repo;

import com.example.sparkit.fr.BlogSpot.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReactionRepo extends JpaRepository<Reaction,Long > {
    List<Reaction> findByPublicationId(Long id);
    Integer countReactionByPublicationId(Long id);

}
