package com.example.sparkit.fr.BlogSpot.service.impl;

import com.example.sparkit.fr.BlogSpot.Dto.PublicationDto;
import com.example.sparkit.fr.BlogSpot.Exeption.HttpCustomException;
import com.example.sparkit.fr.BlogSpot.entity.Comment;
import com.example.sparkit.fr.BlogSpot.entity.Publication;
import com.example.sparkit.fr.BlogSpot.entity.Reaction;
import com.example.sparkit.fr.BlogSpot.entity.User;
import com.example.sparkit.fr.BlogSpot.info.CommentInfo;
import com.example.sparkit.fr.BlogSpot.info.PublicationInfo;
import com.example.sparkit.fr.BlogSpot.info.ReactionInfo;
import com.example.sparkit.fr.BlogSpot.repo.CommentRepo;
import com.example.sparkit.fr.BlogSpot.repo.PublicationRepo;
import com.example.sparkit.fr.BlogSpot.repo.ReactionRepo;
import com.example.sparkit.fr.BlogSpot.repo.UserRepo;
import com.example.sparkit.fr.BlogSpot.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.sparkit.fr.BlogSpot.Exeption.ErrorCode.PUBLICATION_NOT_FOUND;
import static com.example.sparkit.fr.BlogSpot.Exeption.ErrorCode.USER_NOT_FOUND;

@Service
public class PublicationIMPL implements PublicationService {
    @Autowired
    private PublicationRepo publicationRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ReactionRepo reactionRepo;


    @Override
    public Publication addPublication(PublicationDto publicationDto) {
        User user = userRepo.findById(publicationDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"+publicationDto.getUserId()));
        Publication publication = new Publication(
                publicationDto.getId(),
                publicationDto.getContent(),
                publicationDto.getTitle(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                user);

        return publicationRepo.save(publication);
    }

    @Override
    public List<PublicationInfo > findAllPublications() {
        List<Publication> publications = publicationRepo.findAll();
        List<PublicationInfo> publicationInfos = new ArrayList<>();

        for (Publication publication : publications)
        {   PublicationInfo info = new PublicationInfo();
            info.setId(publication.getId());
            info.setContent(publication.getContent());
            info.setTitle(publication.getTitle());
            info.setUsername(publication.getUser().getUserName());
            info.setCreatedT(publication.getCreatePub());
            info.setUpdatedT(publication.getUpdatePub());
            info.setId(publication.getId());
            publicationInfos.add(info);
            info.setNumberOfComment(commentRepo.countCommentByPublicationId(publication.getId()));
            info.setNumberOfReact(reactionRepo.countReactionByPublicationId(publication.getId()));
        }

        return publicationInfos ;
    }

    public String deletePublication(Long id) {
        Publication existingPublication = publicationRepo.findById(id)
                .orElseThrow(() -> new HttpCustomException("Publication not found",PUBLICATION_NOT_FOUND));

        publicationRepo.delete(existingPublication);
        return ("publication deleted");
    }

    @Override
    public PublicationInfo findPublications(Long id) {
        Publication existingPublication = publicationRepo.findById(id)
                .orElseThrow(() -> new HttpCustomException("Publication not found",PUBLICATION_NOT_FOUND));
        PublicationInfo info = new PublicationInfo();
        info.setId(existingPublication.getId());
        info.setContent(existingPublication.getContent());
        info.setTitle(existingPublication.getTitle()); ;
        info.setUsername(existingPublication.getUser().getUserName());
        info.setCreatedT(existingPublication.getCreatePub());
        info.setUpdatedT(existingPublication.getUpdatePub());

        List<Comment> comments = commentRepo.findByPublicationId(id);
        List<CommentInfo> commentInfos = new ArrayList<>();

        for (Comment comment : comments)
        {   CommentInfo com = new CommentInfo();
            com.setContent(comment.getContent());
            com.setUsername(comment.getUser().getUserName());
            com.setCreatedT(comment.getCreateCom());
            com.setUpdatedT(comment.getUpdateCom());
            commentInfos.add(com);
        }
             info.setComments(commentInfos);

        List<Reaction> reactions = reactionRepo.findByPublicationId(id);
        List<ReactionInfo> reactionInfos = new ArrayList<>();
        for (Reaction reaction : reactions)
        {
            ReactionInfo react = new ReactionInfo();
            react.setReaction(reaction.getReaction());
            react.setUsername(reaction.getUser().getUserName());
            reactionInfos.add(react);
        }
        info.setReacts((reactionInfos));
        info.setNumberOfComment(commentRepo.countCommentByPublicationId(id));
        info.setNumberOfReact(reactionRepo.countReactionByPublicationId(id));
        return info;
    }
    @Override
    public Publication updatePublication(PublicationDto publicationDto){
        User  user = userRepo.findById(publicationDto.getUserId())
                .orElseThrow(() -> new HttpCustomException("user of Publication not found",USER_NOT_FOUND));
        Publication publication = publicationRepo.findById(publicationDto.getId())
                .orElseThrow(() -> new HttpCustomException("Publication not found",PUBLICATION_NOT_FOUND));
        publication.setTitle(publicationDto.getTitle());
        publication.setContent(publicationDto.getContent());
        publication.setUpdatePub(LocalDateTime.now());

        return publicationRepo.save(publication);

    }







}


