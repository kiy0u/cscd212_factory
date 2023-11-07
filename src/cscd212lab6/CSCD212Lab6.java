package cscd212lab6;

import java.util.Scanner;
import java.util.regex.Pattern;

import cscd212classes.lifeform.LifeForm;
import cscd212classes.boards.GameBoard;
import cscd212classes.factories.GameBoardFactory;
import cscd212enums.BoardTheme;
import cscd212enums.DifficultyLevel;

/**
 * The class containing the main method and a few other methods for pseudo game execution
 * <br>You will not modify the code in this class in any fashion
 */
public class CSCD212Lab6 {

    /**
     * The pattern used to determine if a string is an integer
     */
    private static final Pattern IS_NUMBER_PATTERN = Pattern.compile("-?\\d+");

    /**
     * The main method that reads the desired game board, the difficulty level, and then generates a fake game board
     * with a player (adventurer) and some enemies
     *
     * @param args Representing the command line arguments
     */
    public static void main(final String[] args) {
        BoardTheme boardChoice = null;
        DifficultyLevel difficultyLevel = null;
        GameBoard theBoard = null;

        Scanner kb = new Scanner(System.in);

        do {
            boardChoice = getBoardTheme(kb);
            difficultyLevel = getDifficultyLevel(kb);
            theBoard = GameBoardFactory.getGameBoard(boardChoice, difficultyLevel);
            completeGameSetup(theBoard, boardChoice, difficultyLevel);
        } while (goAgain(kb));

    } // end method

    /**
     * This method reads the board theme from the keyboard
     *
     * @param kb Representing the open Scanner
     * @return BoardTheme Representing the appropriate enumerated Board Theme
     * @throws IllegalArgumentException if kb is null
     */
    private static BoardTheme getBoardTheme(final Scanner kb) {
        if (kb == null) {
            throw new IllegalArgumentException("Bad kb in getBoardTheme");
        }

        int choice;
        int x;
        BoardTheme[] array = BoardTheme.values();

        do {
            System.out.println("\nChoose a Board Theme");
            for (x = 0; x < array.length; x++) {
                System.out.println((x + 1) + ") " + array[x].name().charAt(0) +
                        array[x].name().substring(1).toLowerCase());
            }

            System.out.print("Choice --> ");
            String line = kb.nextLine();
            if (line.isBlank() || !IS_NUMBER_PATTERN.matcher(line).matches()) {
                choice = -1;
            } else {
                choice = Integer.parseInt(line);
            }

        } while (choice < 1 || choice > array.length);

        return array[choice - 1];
    } // end method

    /**
     * This method reads the difficulty level from the keyboard
     *
     * @param kb Representing the open Scanner
     * @return BoardTheme Representing the appropriate enumerated Difficulty Level
     * @throws IllegalArgumentException if kb is null
     */
    private static DifficultyLevel getDifficultyLevel(final Scanner kb) {
        if (kb == null) {
            throw new IllegalArgumentException("Bad kb in getDifficultyLevel");
        }

        int choice;
        int x;
        DifficultyLevel[] array = DifficultyLevel.values();

        do {
            System.out.println("\nChoose a Difficulty Level");
            for (x = 0; x < array.length; x++) {
                System.out.println((x + 1) + ") " + array[x].name().charAt(0) +
                        array[x].name().substring(1).toLowerCase());
            }

            System.out.print("Choice --> ");
            String line = kb.nextLine();
            if (line.isBlank() || !IS_NUMBER_PATTERN.matcher(line).matches()) {
                choice = -1;
            } else {
                choice = Integer.parseInt(line);
            }

        } while (choice < 1 || choice > array.length);

        return array[choice - 1];
    } // end method

    /**
     * Displays the Game Setup information to the screen
     *
     * @param board           Representing the GameBoard object
     * @param boardTheme      Representing the enumerated type board theme
     * @param difficultyLevel Representing the enumerated type difficulty level
     */
    private static void completeGameSetup(
            final GameBoard board, final BoardTheme boardTheme, final DifficultyLevel difficultyLevel) {
        System.out.println();
        System.out.println("Finishing Game Board Setup");
        System.out.println("Building Player: " + board.getPlayer().getClass().getSimpleName() +
                " named " + board.getPlayer().getName() +
                " with " + board.getPlayer().getCurrentLifePoints() + " life points");

        System.out.println("Building Game Board: " + boardTheme.name().charAt(0) +
                boardTheme.name().substring(1).toLowerCase());

        System.out.println("Adjusting for Difficulty Level: " + difficultyLevel.name().charAt(0) +
                difficultyLevel.name().substring(1).toLowerCase() + " Level");

        System.out.println("Building Enemies:");

        for (LifeForm lf : board.getEnemyLifeForms()) {
            System.out.println("\tEnemy: " + lf);
        }

        System.out.println();

    } // end method

    /**
     * Prompts the user to play again, ensuring yes or no is entered
     *
     * @param kb Representing the open Scanner object to the keyboard
     * @return boolean Representing if the user wants to build another game board
     */
    private static boolean goAgain(final Scanner kb) {
        if (kb == null) {
            throw new IllegalArgumentException("Bad kb in goAgain");
        }

        String ans = "";

        do {
            System.out.print("Setup a new board (yes/no) ");
            ans = kb.nextLine();
        } while (!ans.equalsIgnoreCase("yes") &&
                !ans.equalsIgnoreCase("no"));

        return ans.equalsIgnoreCase("yes");
    } // end method


} // end class
