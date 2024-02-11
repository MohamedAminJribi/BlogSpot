package com.example.sparkit.fr.BlogSpot.controller;

import com.example.sparkit.fr.BlogSpot.Dto.CommentDto;
import com.example.sparkit.fr.BlogSpot.entity.Comment;
import com.example.sparkit.fr.BlogSpot.info.CommentInfo;
import com.example.sparkit.fr.BlogSpot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
      private   CommentService commentService;
    @PostMapping(path= "/save")
    public ResponseEntity<Comment> addComment(@RequestBody CommentDto commentDto){
        Comment addComment = commentService.addComment(commentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addComment);
    }
    @PutMapping("update")
    public Comment updateComment(@RequestBody CommentDto commentDto){

        return commentService.updateComment (commentDto) ;
    }

    @DeleteMapping("{id}")
    public String deletePublication(@PathVariable Long id) {

        return commentService.deleteComment(id);
    }
    @GetMapping(path = "/affiche")
    public List<CommentInfo> findAllComment() {

        return commentService.findAllComment();
    }

    @GetMapping(path = "{id}")
    public List<CommentInfo>  findByPublicationId(@PathVariable Long id) {
        return commentService.findCommentByPublicationId(id);
    }

}
