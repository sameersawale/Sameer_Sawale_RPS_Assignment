package RPS.Player1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class Player1Controller {

    private final List<String> moves = Arrays.asList("Rock", "Paper", "Scissors");
    private final WebClient webClient;

    @PostMapping("/play")
    public String play(@RequestBody String playerMove) {
        String computerMove= WebClient.create().get()
                .uri("http://localhost:8088/get")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        String result = determineWinner(playerMove, computerMove);
        return result;
    }


    private String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It is a tie";
        } else if (playerMove.equals("Rock")) {
            if (computerMove.equals("Scissors")) {
                return "Player wins";
            } else {
                return "Computer wins";
            }
        } else if (playerMove.equals("Paper")) {
            if (computerMove.equals("Rock")) {
                return "Player wins";
            } else {
                return "Computer wins";
            }
        } else { // playerMove is "Scissors"
            if (computerMove.equals("Paper")) {
                return "Player wins";
            } else {
                return "Computer wins";
            }
        }
    }

    
}
