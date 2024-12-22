package cscd212classes.factories;

import cscd212classes.boards.EarthBoard;
import cscd212classes.boards.FantasyBoard;
import cscd212classes.boards.GameBoard;
import cscd212classes.boards.MarsBoard;
import cscd212enums.BoardTheme;
import cscd212enums.DifficultyLevel;

public class GameBoardFactory
{
    public GameBoardFactory()
    {

    }

    /**
     * This method builds the appropriate game board by checking the
     * enumerated type and then calling the appropriate game board constructor
     * @param levelTheme The enumerated type board theme
     * @param difficultyLevel The adjusted difficulty level
     * @return GameBoard The appropriate new object for the game board
     */

    public static GameBoard getGameBoard(final BoardTheme levelTheme, final DifficultyLevel difficultyLevel)
    {
        switch (levelTheme)
        {
            case EARTH:
                return new EarthBoard(difficultyLevel);
            case FANTASY:
                return new FantasyBoard(difficultyLevel);
            case MARS:
                return new MarsBoard(difficultyLevel);
            default:
                throw new IllegalArgumentException("improper board theme inputted");
        }
    }
}
