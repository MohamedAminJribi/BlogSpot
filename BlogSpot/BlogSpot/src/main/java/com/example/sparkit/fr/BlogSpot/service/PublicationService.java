package com.example.sparkit.fr.BlogSpot.service;

import com.example.sparkit.fr.BlogSpot.Dto.PublicationDto;
import com.example.sparkit.fr.BlogSpot.entity.Publication;
import com.example.sparkit.fr.BlogSpot.info.PublicationInfo;

import java.time.LocalDateTime;
import java.util.List;

public interface PublicationService {
    Publication addPublication(PublicationDto publicationDto);

    List<PublicationInfo> findAllPublications();

    Publication updatePublication(PublicationDto publicationDto);

    String  deletePublication(Long id);

    PublicationInfo findPublications(Long id);


}
