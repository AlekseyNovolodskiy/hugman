package pet.hungman.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import pet.hungman.entity.GameSession;
import pet.hungman.repository.GameSessionRepository;
import pet.hungman.service.programmbody.WordBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Slf4j
@Service
@AllArgsConstructor
public class HungmanGame {
    private final GameSessionRepository gameSessionRepository;
    private final WordBody wordBody;


    public String hungmanStartTheGame( String symbol, String key, Model model){



            GameSession gameSession = gameSessionRepository.getReferenceById(UUID.fromString(key));
            gameSession.getSuggestedByUser().add(symbol);
            String word = gameSession.getWord();
            List<Character> mask = gameSession.getMask();
            List<Character> masked = wordBody.masked(symbol, word, mask);


            if(wordBody.testToWin(mask)){                                                       // проверка на одгадывания всех букв
            return "start";                                                                 // возврат на страницу win
        }

            gameSession.setMask(masked);
            gameSessionRepository.save(gameSession);
            log.info(word);
            log.info(gameSession.toString());



            if(gameSession.getMistakes()==null){                                                //счетчик ошибок
                gameSession.setMistakes(0);
            }
            if(!masked.contains(symbol.charAt(0))){
                int mistakes= gameSession.getMistakes();
                gameSession.setMistakes(mistakes+1);
                gameSessionRepository.save(gameSession);
            }
            if(gameSession.getMistakes()>=5){                                                   //возврат на  страницу "loose"
                return "start";                                                                 //при превышении 5 ошибок
            }


            log.info(mask.toString());



            model.addAttribute("sessionKey", key);
            model.addAttribute("maskedWord", masked);
            return "game";


    }

}
