import java.util.Scanner;

public class Main {
    int rock = 0;
    int paper = 0;
    int scissors = 0;
    int playerWins = 0;
    int cpuWins = 0;
    public static void main(String[] args) {
        Main obj = new Main();
        for (int i = 0; i < 10; i++) {
            System.out.println("Rock... Paper... Scissors");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            switch (input) {
                case "rock":
                    obj.rock += 1;
                    break;
                case "paper":
                    obj.paper += 1;
                    break;
                case "scissors":
                    obj.scissors += 1;
                    break;
                default:
                    System.out.println("Try 'rock', 'scissors', or 'paper'");
            }
            int winner = getWinner(getComp(obj), input);
            switch (winner){
                case 0:
                    obj.cpuWins += 1;
                    System.out.println("Computer Wins!");
                    break;
                case 1:
                    obj.playerWins += 1;
                    System.out.println("Player Wins!");
                    break;
                case 2:
                    System.out.println("Tie... No one won");
            }
        }

    }
    public static String getComp(Main obj){
        String cpuChoice = "rock";
        if(obj.rock < obj.paper && obj.rock < obj.scissors){
            if(obj.paper < obj.scissors){
                cpuChoice = "rock";
            } else if(obj.scissors < obj.paper) {
                cpuChoice = "scissors";
            }
        } else if(obj.scissors < obj.rock && obj.paper < obj.rock){
            cpuChoice = "paper";
        } else if(obj.scissors == obj.rock && obj.scissors == obj.paper){
            int randomNum = (int)(Math.random() * 4);
            switch (randomNum) {
                case 1:
                    cpuChoice = "paper";
                    break;
                case 2:
                    cpuChoice = "scissors";
                    break;
                default:
                    cpuChoice = "rock";
                    break;
            }
        }
        System.out.println("Computer chose "+ cpuChoice + " Player Wins " +obj.playerWins + ": Computer Wins "+ obj.cpuWins);
        return cpuChoice;
    }
    public static int getWinner(String cpu, String input) {
        int winner = 0;
        //0 = CPU wins, 1 = Player wins, 2 = Tie
        switch (input){
            case "rock":
                switch (cpu){
                    case "paper":
                        winner = 0;
                        break;
                    case "scissors":
                        winner = 1;
                        break;
                    case "rock":
                        winner = 2;
                        break;
                }
                break;
            case "paper":
                switch (cpu){
                    case "paper":
                        winner = 2;
                        break;
                    case "scissors":
                        winner = 0;
                        break;
                    case "rock":
                        winner = 1;
                        break;
                }
                break;
            case "scissors":
                switch (cpu){
                    case "paper":
                        winner = 1;
                        break;
                    case "scissors":
                        winner = 2;
                        break;
                    case "rock":
                        winner = 0;
                        break;
                }
                break;
        }
        return winner;
    }
}
