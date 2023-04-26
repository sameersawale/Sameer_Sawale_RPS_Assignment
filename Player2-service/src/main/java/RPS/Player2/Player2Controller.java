package RPS.Player2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class Player2Controller {

    private final List<String> moves = Arrays.asList("Rock", "Paper", "Scissors");

    @GetMapping("/get")
    public String getMove(){
        return getRandomMove();
    }

    private String getRandomMove() {
        Random random = new Random();
        int index = random.nextInt(moves.size());
        return moves.get(index);
    }
}
