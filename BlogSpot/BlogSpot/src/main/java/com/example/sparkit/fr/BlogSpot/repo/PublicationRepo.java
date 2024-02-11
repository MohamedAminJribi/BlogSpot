package com.example.sparkit.fr.BlogSpot.repo;

import com.example.sparkit.fr.BlogSpot.Dto.PublicationDto;
import com.example.sparkit.fr.BlogSpot.entity.Publication;
import com.example.sparkit.fr.BlogSpot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepo extends JpaRepository<Publication,Long> {
    Optional<Publication> findById(PublicationDto publicationDto);

    List<Publication> findByUpdatePub(LocalDateTime updateDate);
}
