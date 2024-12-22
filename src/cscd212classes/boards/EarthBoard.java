package cscd212classes.boards;

import cscd212classes.lifeform.Human;
import cscd212classes.lifeform.LifeForm;
import cscd212classes.lifeform.Martian;
import cscd212enums.DifficultyLevel;

public class EarthBoard extends GameBoard
{
    /**
     * This explicit value constructor simply calls the constructor in GameBoard
     * @param difficultyLevel Representing the difficulty level of the game
     */

    public EarthBoard(final DifficultyLevel difficultyLevel)
    {
        super(difficultyLevel);
    }

    /**
     * For EarthBoard this overriden method sets the player
     * to a MARTIAN
     * The enemies are:
     * HUMAN named Dave with 110 life points
     * HUMAN with default life points and name
     */

    @Override
    protected void createLifeForms()
    {
        this.player = new Martian("Marvin", 120);

        LifeForm enemy1 = new Human("Dave", 110);
        LifeForm enemy2 = new Human("Hugh Mann", 100);

        this.enemyLifeForms.add(enemy1);
        this.enemyLifeForms.add(enemy2);
    }
}
