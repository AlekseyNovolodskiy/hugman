package pet.hungman.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hungman.service.ProgrammBody;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class controllers {

    private final ProgrammBody programmBody;

    @PostMapping("/hungman")
    public void hungMan(@RequestParam String tt) {

        programmBody.startProgramm();
    }
}
