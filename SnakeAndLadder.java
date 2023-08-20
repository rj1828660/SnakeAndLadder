import java.util.*;


class Game  {
    final static int WINPOINT = 100;
    static Map<Integer, Integer> snake = new HashMap<>();
    static Map<Integer, Integer> ladder = new HashMap<>();
    
       
        ladder.put(8, 25);
        ladder.put(11, 40);
        ladder.put(60, 85);
        ladder.put(46, 90);
        ladder.put(17, 69);
        
        snake.put(99, 45);
        snake.put(70, 56);
        snake.put(52, 42);
        snake.put(28, 2);
        snake.put(90, 78);

    

    
    public int rollDice() {
        int n = 0;
        Random r = new Random();
        n = r.nextInt(7);
        return (n == 0 ? 1 : n);
    }

   
    public int calculatePlayerNewPosition(int playerPosition, int 
diceValue) {
        int playerNewPosition=playerPosition+diceValue;

        if (playerNewPosition > WINPOINT)
            return playerPosition;

        if (snake.get(playerNewPosition)!=null) {
            System.out.println("swallowed by the snake..");
            playerNewPosition=snake.get(playerNewPosition);
        }

        if (ladder.get(playerNewPosition)!=null) {
            System.out.println("climbing the ladder..");
            playerNewPosition=ladder.get(playerNewPosition);
        }

        return playerNewPosition;
    }

    public boolean isWin(int playerPosition) {
        return WINPOINT==playerPosition;
    }

    public void startGame() {
        int player1Position=0, player2Position=0;
        int currentPlayer=1;
        Scanner scan= new Scanner(System.in);
        String input;
        int diceValue = 0;
        do {
            System.out.println(currentPlayer == 1 ? "\nFirst player's turn" : "\nSecond player's turn");
            System.out.println("Press 'r' to roll Dice");
            input=scan.next();
            diceValue=rollDice();

            if (currentPlayer==1) {
                
player1Position=calculatePlayerNewPosition(player1Position, diceValue);
                System.out.println("First Player Position:"+player1Position);
                System.out.println("Second Player Position:"+player2Position);
                System.out.println("-------------------------");
                if (isWin(player1Position)) {
                    System.out.println("Congratulations! First player won");
                    return;
                }
            } else {
                player2Position = calculatePlayerNewPosition(player2Position, diceValue);
                System.out.println("First Player Position:"+player1Position);
                System.out.println("Second Player Position:"+player2Position);
                System.out.println("-------------------------");
                if (isWin(player2Position)) {
                    System.out.println("Congratulations! Second player won");
                    return;
                }
            }
            currentPlayer = currentPlayer==1?2:1;
        } while ("r".equals(input));
    
    }
}

public class SnakeAndLadder{


    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
        


    }



}

