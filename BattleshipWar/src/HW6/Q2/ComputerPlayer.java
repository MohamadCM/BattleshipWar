package HW6.Q2;

import java.util.Random;

/**
 * This class creates player that computer interact with
 * in order to play the game with user,
 * this is a subclass of Player
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class ComputerPlayer extends Player{
    /**
     * Computer player will be created by a default name (Computer)
     */
    public ComputerPlayer()
    {
        super("Computer");
    }

    @Override
    protected int[] fire() {
        Random randomGenerator = new Random();
        int[] result = new int[2];
        int x, y;
        x = randomGenerator.nextInt(10);
        y = randomGenerator.nextInt(10);
        if (randomGenerator.nextInt(2) == 0) {
            if(x == 0)
                x += 1;
            else if(x == 9)
                x -= 1;
            else {
                Random random = new Random();
                x += (random.nextInt(3) -1);
            }
            if(y == 0)
                y += 1;
            else if(y == 9)
                y -= 1;
            else {
                Random random = new Random();
                y += (random.nextInt(3) -1);
            }
        }
        result[0] = x;
        result [1] = y;
        return result;
    }

    @Override
    public boolean placeShot() {
        int[] location = fire();
        if(opponentField.getBoard()[location[0]][location[1]] == '#' || opponentField.getBoard()[location[0]][location[1]] == 'X')
        {
            System.out.println("Wrong position, computer lost it's turn");
            return false;
        }
        if(opponentField.getBoard()[location[0]][location[1]] == '@')
        {
            char[][] result = opponentField.getBoard();
            result[location[0]][location[1]] = '#';
            opponentField.setBoard(result);
            return true;
        }
        else
        {
            char[][] result = opponentField.getBoard();
            result[location[0]][location[1]] = 'X';
            opponentField.setBoard(result);
            return false;
        }
    }
}
