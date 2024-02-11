package com.example.sparkit.fr.BlogSpot.service.impl;

import com.example.sparkit.fr.BlogSpot.Dto.CommentDto;
import com.example.sparkit.fr.BlogSpot.Exeption.HttpCustomException;
import com.example.sparkit.fr.BlogSpot.entity.Comment;
import com.example.sparkit.fr.BlogSpot.entity.Publication;
import com.example.sparkit.fr.BlogSpot.entity.User;
import com.example.sparkit.fr.BlogSpot.info.CommentInfo;
import com.example.sparkit.fr.BlogSpot.repo.CommentRepo;
import com.example.sparkit.fr.BlogSpot.repo.PublicationRepo;
import com.example.sparkit.fr.BlogSpot.repo.UserRepo;
import com.example.sparkit.fr.BlogSpot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentIMPL implements CommentService {
    @Autowired
    private PublicationRepo publicationRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Override
    public Comment addComment(CommentDto commentDTO) {
        User user = userRepo.findById(commentDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found "));
        Publication publication = publicationRepo.findById(commentDTO.getPubId())
                .orElseThrow(() -> new EntityNotFoundException("publication not found "));
        Comment comment = new Comment(
                commentDTO.getId(),
                commentDTO.getContent(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                user,
                publication
        );

        return commentRepo.save(comment);

    }
    @Override
    public String deleteComment(Long id) {
        Comment existingComment = commentRepo.findById(id)
                .orElseThrow(() -> new HttpCustomException("Comment not found",401));

        commentRepo.delete(existingComment);
        return ("Comment deleted successfully");
    }
    @Override
    public Comment updateComment (CommentDto commentDto){
        User  user = userRepo.findById(commentDto.getUserId())
                .orElseThrow(() -> new HttpCustomException("user of Publication not found"));
        Publication publication = publicationRepo.findById(commentDto.getPubId())
                .orElseThrow(() -> new HttpCustomException("Publication not found"));
        Comment comment = commentRepo.findById(commentDto.getId())
                .orElseThrow(() -> new HttpCustomException("Comment not found"));
        comment.setContent(commentDto.getContent());
        comment.setUpdateCom(LocalDateTime.now());

        return commentRepo.save(comment);
    }
    @Override
    public List<CommentInfo> findAllComment() {
        List<Comment> comments = commentRepo.findAll();
        List<CommentInfo> commentInfos =new ArrayList<>();
        for (Comment comment: comments){
            CommentInfo info = new CommentInfo();
            info.setContent(comment.getContent());
            info.setUsername(comment.getUser().getUserName());
            info.setCreatedT(comment.getCreateCom());
            info.setUpdatedT(comment.getUpdateCom());
            commentInfos.add(info);
        }




        return commentInfos;
        }

    @Override
    public List<CommentInfo> findCommentByPublicationId(Long id) {
        Publication publication = publicationRepo.findById(id)
                .orElseThrow(() -> new HttpCustomException("Publication not found"));
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


        return commentInfos;


    }

}
