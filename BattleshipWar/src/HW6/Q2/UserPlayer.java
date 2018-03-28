package HW6.Q2;

import java.util.Random;
import java.util.Scanner;

/**
 * This class creates player that users interact with
 * in order to play the game,
 * this is a subclass of Player
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class UserPlayer extends Player {
    /**
     * Each UserPlayer needs a name
     * @param name
     */
    public UserPlayer(String name)
    {
        super(name);
    }
    @Override
    protected int[] fire() {
        System.out.println("What kind of shot do you want\n1- Normal \t 2- Inaccurate ");
        short typeOfShot = -1;
        while (true)
        {
            try {
                Scanner scanner = new Scanner(System.in);
                typeOfShot = scanner.nextShort();
            }catch (Exception e){
                System.out.println("Wrong input,Try agin");
                Scanner scanner = new Scanner(System.in);
                typeOfShot = scanner.nextShort();
            }
            if (typeOfShot == 1 || typeOfShot == 2)
                break;
            System.out.println("Wrong input,Try agin");
        }
        System.out.println("Please enter location of the shot as two integers between 0, 9:");
        int x, y;
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                x = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Wrong input, try agian");
                Scanner scanner = new Scanner(System.in);
                x = scanner.nextInt();
            }
            if (x <= 9 && x >= 0)
                break;
            System.out.println("Wrong input, try agian");
        }

        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                y = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Wrong input, try agian");
                Scanner scanner = new Scanner(System.in);
                y = scanner.nextInt();
            }
            if (y <= 9 && y >= 0)
                break;
            System.out.println("Wrong input, try agian");
        }
        int [] result = new int[2];
        if (typeOfShot == 2) {
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
        result[1] = y;
        return result;
    }

    @Override
    public boolean placeShot() {
        int[] location = fire();
        if(opponentField.getBoard()[location[0]][location[1]] == '#' || opponentField.getBoard()[location[0]][location[1]] == 'X')
        {
            System.out.println("Wrong position, you lost your turn");
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
