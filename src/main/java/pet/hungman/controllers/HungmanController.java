package pet.hungman.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pet.hungman.repository.UserEntityRepository;
import pet.hungman.service.AuthService;
import pet.hungman.service.HungmanGame;
import pet.hungman.service.HungmanStartGame;
import pet.hungman.service.programmbody.WordBody;

import static pet.hungman.controllers.PathConstant.GAME;
import static pet.hungman.controllers.PathConstant.NEW_GAME;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HungmanController {

    private final HungmanStartGame hungmanStartGame;
    private final HungmanGame hungmanGame;
    private final AuthService authService;

    @GetMapping("/")
    public String index() {
        return "start.html";
    }


    @GetMapping("/hungman/auth/")
    public String authorization(@RequestParam String login, @RequestParam String password, Model model) {
        return authService.authTheUser(login, password, model);
    }


    @GetMapping(NEW_GAME)
    public String hungMan(@RequestParam Integer complexity, Model model) {
        return hungmanStartGame.bodyChaineMethod(complexity, model);
    }


    @GetMapping(GAME)
    public String hungManTheGame(@RequestParam String symbol, @RequestParam String key, Model model) {
        return hungmanGame.hungmanStartTheGame(symbol, key, model);
    }
}
