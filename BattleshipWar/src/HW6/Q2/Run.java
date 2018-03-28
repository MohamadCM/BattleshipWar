package HW6.Q2;

import java.util.Scanner;

/**
 * This class is used to have main method and running the game
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class Run {
    public static void main(String[] args) {
        System.out.println("How Do you want to play?\n1- Against another player             2- Against computer");
        int typeOfGame = -1;
        while (true)
        {
            try{
                Scanner scanner = new Scanner(System.in);
                typeOfGame = scanner.nextInt();
            } catch (Exception e){
                System.out.println("Wrong input,try again");
                Scanner scanner = new Scanner(System.in);
                typeOfGame = scanner.nextInt();
            }
            if(typeOfGame == 1 || typeOfGame == 2)
                break;
            System.out.println("Wrong input,try again");
        }
        if (typeOfGame == 1)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter first players name");
            UserPlayer player1 = new UserPlayer(scanner.next());
            System.out.println("Please enter second players name");
            UserPlayer player2 = new UserPlayer(scanner.next());
            System.out.println("Now creating ships for: " + player1.getPlayerName());
            for(int i = 0 ; i < 5 ; i++)
            {
                player1.getCurrentField().createBattleship();
            }
            System.out.println("Now creating ships for: " + player2.getPlayerName());
            for(int i = 0 ; i < 5 ; i++)
            {
                player2.getCurrentField().createBattleship();
            }
            player1.setOpponentField(player2);
            player2.setOpponentField(player1);
            while (player1.hasWon() == false && player2.hasWon() == false) {
                while (true){
                    System.out.println("Player's 1 turn;");
                    player1.printBoards();
                    if(player1.placeShot() == false)
                        break;
                    if(player1.hasWon())
                        break;
                }
                while (true){
                    System.out.println("Player's 2 turn;");
                    player2.printBoards();
                    if(player2.placeShot() == false)
                        break;
                    if(player2.hasWon())
                        break;
                }
            }
            if(player1.hasWon())
                System.out.println(player1.getPlayerName() + " is the winner");
            else
                System.out.println(player2.getPlayerName() + " is the winner");
        }
        if (typeOfGame == 2)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter players name");
            UserPlayer player1 = new UserPlayer(scanner.next());
            ComputerPlayer player2 = new ComputerPlayer();
            System.out.println("Now creating ships for: " + player1.getPlayerName());
            for(int i = 0 ; i < 5 ; i++)
            {
                player1.getCurrentField().createBattleship();
            }
            System.out.println("Now creating ships for: " + player2.getPlayerName());
            for(int i = 0 ; i < 5 ; i++)
            {
                player2.getCurrentField().createBattleshipByComputer();
            }
            player1.setOpponentField(player2);
            player2.setOpponentField(player1);
            while (player1.hasWon() == false && player2.hasWon() == false) {
                while (true){
                    System.out.println("Player's 1 turn;");
                    player1.printBoards();
                    if(player1.placeShot() == false)
                        break;
                    if(player1.hasWon())
                        break;
                }
                while (true){
                    System.out.println("Player's 2 turn;");
                    player2.printBoards();
                    if(player2.placeShot() == false)
                        break;
                    if (player2.hasWon())
                        break;
                }
            }

            if(player1.hasWon())
                System.out.println(player1.getPlayerName() + " is the winner");
            else
                System.out.println(player2.getPlayerName() + " is the winner");
        }
    }
}
