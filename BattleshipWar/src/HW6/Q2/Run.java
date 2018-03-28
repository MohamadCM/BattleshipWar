package HW6.Q2;

/**
 * This class is used to have main method and running the game
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
public class Run {
    public static void main(String[] args) {
        Field field = new Field();
        UserPlayer userPlayer = new UserPlayer("Mohamad");
        UserPlayer player = new UserPlayer("Ali");
        player.setOpponentField(userPlayer);
        userPlayer.setOpponentField(player);
        userPlayer.printBoards();
        field.createBattleship();
        //field.createBattleship();
        field.printBoard();
    }
}
