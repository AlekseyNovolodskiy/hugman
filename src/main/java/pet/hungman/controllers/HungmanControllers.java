package pet.hungman.controllers;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hungman.entity.GameSession;
import pet.hungman.service.programmbody.WordBody;

import java.util.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HungmanControllers {

    private final WordBody wordBody;

    private final Map<String, GameSession> activeSesseions = new HashMap<>(); //заменить на gamesession repository


    @GetMapping("/hungman/continue/")
    public Object suggestNewSymbol(@RequestParam String key, @RequestParam String symbol) {
        return activeSesseions.get(key);
    }

    @GetMapping("/hungman/newgame")
    public String hungMan(@RequestParam Integer complexity) {
        String key = UUID.randomUUID().toString();
        String word = wordBody.word(complexity);
        log.info(word);
        List<Character> list = wordBody.fillTheWord(complexity);
        List<String> suggestByUser = new ArrayList<>();
        GameSession gameSession = new GameSession();
        gameSession.setSuggestedByUser(suggestByUser);
        gameSession.setWord(word);
        gameSession.setMask(list);
        activeSesseions.put(key,gameSession);
        return key;


    }

    @GetMapping("/hungman/game")
    public List hungManTheGame(@RequestParam String symbol, @RequestParam String key) {

        GameSession gameSession = activeSesseions.get(key);
        gameSession.getSuggestedByUser().add(symbol);
        String word = gameSession.getWord();
        List<Character> mask = gameSession.getMask();
        List<Character> masked = wordBody.masked(symbol, word, mask);
        gameSession.setMask(masked);
        log.info(gameSession.toString());
        return masked;


    }
}
