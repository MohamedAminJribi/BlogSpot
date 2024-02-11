package com.example.sparkit.fr.BlogSpot.service;

import com.example.sparkit.fr.BlogSpot.Dto.CommentDto;
import com.example.sparkit.fr.BlogSpot.entity.Comment;
import com.example.sparkit.fr.BlogSpot.entity.Publication;
import com.example.sparkit.fr.BlogSpot.info.CommentInfo;

import java.util.List;

public interface CommentService {



    Comment addComment(CommentDto commentDto);

    String deleteComment(Long id);

     Comment updateComment(CommentDto commentDto);


    List<CommentInfo> findAllComment();

    List<CommentInfo> findCommentByPublicationId(Long id);


}
