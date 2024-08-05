package pet.hungman.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pet.hungman.entity.GameSession;
import pet.hungman.repository.GameSessionRepository;
import pet.hungman.service.programmbody.WordBody;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class HungmanStartGame {
    private WordBody wordBody;
    private GameSessionRepository gameSessionRepository;

    public String bodyChaineMethod(int complexity, Model model) {

        String word = wordBody.word(complexity);
        List<Character> list = wordBody.fillTheWord(complexity);
        List<String> suggestByUser = new ArrayList<>();
        GameSession gameSession = new GameSession();
        gameSession.setSuggestedByUser(suggestByUser);
        gameSession.setWord(word);
        gameSession.setMask(list);
        GameSession saved = gameSessionRepository.save(gameSession);

        model.addAttribute("sessionKey", saved.getKeyId().toString());
        model.addAttribute("maskedWord", list);
        return "game";
    }

}
