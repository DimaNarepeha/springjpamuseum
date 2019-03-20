package ua.home.service;

import java.util.Random;

public class GameService {

    private final Random random = new Random();
    private String result;
    private final int bound = 2;
    public void isGameWon(String num) {
        int guess = Integer.parseInt(num);
        if(guess>=bound) result = "Is it just me being hypercritical or something is wrong???";
        else {
            int number = random.nextInt(bound);

            result = (guess == number) ? "Impeccable!You won!" : "Too bad...You lost!";
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
