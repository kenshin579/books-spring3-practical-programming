package madvirus.spring.chap06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game/users/{userId}")
public class CharacterInfoController {

    @RequestMapping("/characters/{characterId}")
    public String characterInfo(@PathVariable String userId,
                                @PathVariable int characterId, ModelMap model) {
        model.addAttribute("userId", userId);
        model.addAttribute("characterId", characterId);
        return "game/character/info";
    }
}
