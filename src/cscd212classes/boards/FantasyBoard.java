package cscd212classes.boards;

import cscd212classes.lifeform.HalfOrc;
import cscd212classes.lifeform.Human;
import cscd212classes.lifeform.Kryptonians;
import cscd212classes.lifeform.LifeForm;
import cscd212enums.DifficultyLevel;

public class FantasyBoard extends GameBoard
{
    /**
     * This explicit value constructor simply calls the constructor in GameBoard
     * @param difficultyLevel Representing the difficulty level of the game
     */

    public FantasyBoard(final DifficultyLevel difficultyLevel)
    {
        super(difficultyLevel);
    }

    /**
     * For FantasyBoard, this overriden method sets the player to a HALF_ORC
     * The enemies are:
     * KRYPTON with defualt life points and name
     * KRYPTON name "Uzguk" with 80 life points
     * HUMAN named "Dave" with 110 life points
     */

    @Override
    protected void createLifeForms()
    {
        this.player = new HalfOrc("Gruumsh", 200);

        LifeForm enemy1 = new Kryptonians("Kal-El", 300);
        LifeForm enemy2 = new Kryptonians("Uzguk", 80);
        LifeForm enemy3 = new Human("Dave", 80);

        this.enemyLifeForms.add(enemy1);
        this.enemyLifeForms.add(enemy2);
        this.enemyLifeForms.add(enemy3);
    }

}
