package ua.home.controller;

import ua.home.service.GameService;
import ua.home.wire.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/game/{num}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> play(@PathVariable String num) {

        gameService.isGameWon(num);

        GameResponse response = new GameResponse(gameService);

        return new ResponseEntity<>(response.getJson(), response.getResponseHeaders(), HttpStatus.OK);
    }
}
