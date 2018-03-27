package HW6.Q2;

/**
 * This class is used to have main method and running the game
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class Run {
    public static void main(String[] args) {
        Field field = new Field();
        field.createBattleship();
        field.printBoard();
    }
}
