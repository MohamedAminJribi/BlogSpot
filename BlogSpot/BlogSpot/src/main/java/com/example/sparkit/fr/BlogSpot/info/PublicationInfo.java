package com.example.sparkit.fr.BlogSpot.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationInfo {
    private Long id;
    private String content;
    private String title;
    private String username;
    private LocalDateTime createdT;
    private LocalDateTime updatedT;
    private List<CommentInfo> comments;
    private List<ReactionInfo> reacts ;
    private Integer numberOfComment;
    private Integer numberOfReact;
}
