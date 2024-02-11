package com.example.sparkit.fr.BlogSpot.service.impl;

import com.example.sparkit.fr.BlogSpot.Dto.ReactionDto;
import com.example.sparkit.fr.BlogSpot.Exeption.HttpCustomException;
import com.example.sparkit.fr.BlogSpot.entity.Comment;
import com.example.sparkit.fr.BlogSpot.entity.Publication;
import com.example.sparkit.fr.BlogSpot.entity.Reaction;
import com.example.sparkit.fr.BlogSpot.entity.User;
import com.example.sparkit.fr.BlogSpot.repo.PublicationRepo;
import com.example.sparkit.fr.BlogSpot.repo.ReactionRepo;
import com.example.sparkit.fr.BlogSpot.repo.UserRepo;
import com.example.sparkit.fr.BlogSpot.service.CommentService;
import com.example.sparkit.fr.BlogSpot.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import static com.example.sparkit.fr.BlogSpot.Exeption.ErrorCode.Reaction_NOT_FOUND;

@Service
public class ReactionIMPL implements ReactionService {
    @Autowired
    private ReactionRepo reactionRepo;
    @Autowired
    private PublicationRepo publicationRepo;
    @Autowired
    private UserRepo userRepo;




    @Override
    public  Reaction addReaction(ReactionDto reactionDto) {
        User user = userRepo.findById(reactionDto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found "));
        Publication publication = publicationRepo.findById(reactionDto.getPubId())
                .orElseThrow(() -> new EntityNotFoundException("publication not found "));

        Reaction reaction = new Reaction(
                reactionDto.getId(),
                reactionDto.getReaction(),
                user,
                publication);
        return  reactionRepo.save(reaction) ;}

    @Override
    public String deleteReaction(Long id) {
        Reaction existingReaction = reactionRepo.findById(id)
                .orElseThrow(() -> new HttpCustomException("reaction not found",Reaction_NOT_FOUND));

        reactionRepo.delete(existingReaction);
        return ("reaction deleted successfully");
    }

}
