package com.example.sparkit.fr.BlogSpot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReactionDto {
    private Long id;
    private  Boolean reaction ;
    private Long userId;
    private Long pubId;

}
