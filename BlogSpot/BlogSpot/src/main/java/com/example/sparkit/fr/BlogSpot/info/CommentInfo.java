package com.example.sparkit.fr.BlogSpot.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentInfo {
    private String content;
    private String username;
    private LocalDateTime createdT;
    private LocalDateTime updatedT;


}
