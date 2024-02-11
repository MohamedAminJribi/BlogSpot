package com.example.sparkit.fr.BlogSpot.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicationDto {

    private Long id;

    private String content;

    private String title;

    private Long userId;




}
