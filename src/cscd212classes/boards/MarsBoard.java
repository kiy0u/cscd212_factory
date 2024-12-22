package cscd212classes.boards;

import cscd212classes.lifeform.Human;
import cscd212classes.lifeform.LifeForm;
import cscd212classes.lifeform.Martian;
import cscd212enums.DifficultyLevel;

public class MarsBoard extends GameBoard
{
    public MarsBoard(final DifficultyLevel difficultyLevel)
    {
        super(difficultyLevel);
    }

    /**
     * For MarsBoard this overridden method sets the player to a
     * HUMAN
     * The enemies are:
     * MARTIAN with default life points and name
     * MARTIAN named Steve with 50 life points
     * HUMAN named Evil Carl with 110 life points
     * HUMAN named Carl with 100 life points
     */

    @Override
    protected void createLifeForms()
    {
        this.player = new Human("Hugh Mann", 100);


        LifeForm enemy1 = new Martian("Marvin", 120);
        LifeForm enemy2 = new Martian("Steve", 50);
        LifeForm enemy3 = new Human("Evil Carl", 110);
        LifeForm enemy4 = new Human("Carl", 100);

        this.enemyLifeForms.add(enemy1);
        this.enemyLifeForms.add(enemy2);
        this.enemyLifeForms.add(enemy3);
        this.enemyLifeForms.add(enemy4);
    }
}
