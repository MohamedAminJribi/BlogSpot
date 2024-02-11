package com.example.sparkit.fr.BlogSpot.controller;

import com.example.sparkit.fr.BlogSpot.Dto.ReactionDto;
import com.example.sparkit.fr.BlogSpot.Dto.UserDto;
import com.example.sparkit.fr.BlogSpot.entity.Reaction;
import com.example.sparkit.fr.BlogSpot.service.ReactionService;
import com.example.sparkit.fr.BlogSpot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/reaction")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @PostMapping(path= "/save")
    public Reaction saveReaction (@RequestBody ReactionDto reactionDto){
        return reactionService.addReaction(reactionDto);}

        @DeleteMapping("{id}")
        public String deleteReaction(@PathVariable Long id) {

            return reactionService.deleteReaction(id);
    }
}
