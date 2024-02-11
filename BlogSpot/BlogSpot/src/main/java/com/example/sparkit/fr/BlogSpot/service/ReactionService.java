package com.example.sparkit.fr.BlogSpot.service;

import com.example.sparkit.fr.BlogSpot.Dto.ReactionDto;
import com.example.sparkit.fr.BlogSpot.Dto.UserDto;
import com.example.sparkit.fr.BlogSpot.entity.Reaction;

public interface ReactionService {

    Reaction addReaction(ReactionDto reactionDto);


    String deleteReaction(Long id);
}

