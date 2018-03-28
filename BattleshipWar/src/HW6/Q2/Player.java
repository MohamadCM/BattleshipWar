package HW6.Q2;

/**
 * This class creates a player
 * Other kinds of players should
 * inherit this class
 * @author Mohamad Chaman-Motlagh
 * @version 1
 */
abstract public class Player {
    private String playerName;
    protected Field currentField;
    protected Field opponentField;
    /**
     * Each player needs a name to get created
     * @param name ig given name
     */
    public Player(String name)
    {
        playerName = name;
        currentField = new Field();
    }

    /**
     * @return players name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets opponents field
     * @param player is a player
     */
    protected void setOpponentField(Player player) {
        this.opponentField = player.getCurrentField();
    }

    /*
          This method is used to place a shot upon enemy's board
          @return location of shot as an array of to integers
         */
    abstract protected int[] fire();

    /**
     * Places a shot on opponents board
     * @return {@code true} if the shot is successful, {@code false} otherwise
     */
    abstract public boolean placeShot();
    /**
     * @return Field of this player
     */
    public Field getCurrentField() {
        return currentField;
    }
    /**
     * Sets a field for this player
     * @param currentField
     */
    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }
    public void printBoards()
    {
        System.out.print(" |");
        for(int i = 0 ; i < 10 ; i++)
            System.out.print(i + "|");
        System.out.print("        |");
        for(int i = 0 ; i < 10 ; i++)
            System.out.print(i + "|");
        System.out.println();
        for(int i = 0 ; i < 10 ; i++)
        {
            for (int k = 0 ; k < 11 ; k++)
                System.out.print("-+");
            System.out.print("       ");
            for (int k = 0 ; k < 11 ; k++)
                System.out.print("-+");
            System.out.println();
            System.out.print(i + "|");
            for(int j = 0 ; j < 10 ; j++)
            {
                if(currentField.getBoard()[i][j] == '@')
                    System.out.print("\u001B[34m" + currentField.getBoard()[i][j] + "\u001B[0m" + "|");
                else if(currentField.getBoard()[i][j] == '#')
                    System.out.print("\u001B[31m" + currentField.getBoard()[i][j] + "\u001B[0m" + "|");
                else if(currentField.getBoard()[i][j] == 'X')
                    System.out.print("\u001B[33m" + currentField.getBoard()[i][j] + "\u001B[0m" + "|");
                else
                    System.out.print(currentField.getBoard()[i][j] + "|");
            }
            System.out.print("       " + i + "|");
            for(int j = 0 ; j < 10 ; j++)
            {
                if(opponentField.getBoard()[i][j] == '@')
                    System.out.print(" |");
                else if(opponentField.getBoard()[i][j] == '#')
                    System.out.print("\u001B[32m" + '&' + "\u001B[0m" + "|");
                else if(opponentField.getBoard()[i][j] == 'X')
                    System.out.print("\u001B[33m" + opponentField.getBoard()[i][j] + "\u001B[0m" + "|");
                else
                    System.out.print(opponentField.getBoard()[i][j] + "|");
            }
            System.out.println();
        }
    }

    /**
     * Checks wheter this player won the game or not
     * @return {@code true} if the game is won, {@code false} otherwise
     */
    public boolean hasWon()
    {
        for(int i = 0 ; i < 10 ; i++)
            for(int j = 0 ; j < 10 ; j++)
                if(opponentField.getBoard()[i][j] == '@')
                    return false;
        return true;
    }
}
