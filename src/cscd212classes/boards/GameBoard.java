package cscd212classes.boards;

import cscd212classes.lifeform.LifeForm;
import cscd212enums.DifficultyLevel;

import java.util.ArrayList;

public abstract class GameBoard
{
    /**
     * An arrayList of enemy LifeForms
     */
    protected ArrayList<LifeForm> enemyLifeForms;
    /**
     * The player LifeForm
     */
    protected LifeForm player;

    /**
     * The explicit value constructor that receives a difficulty level
     * and creates the game board by first creating an empty arrayList,
     * then creating the life forms by calling the appropriate subclass
     * createLifeForms method, adjusting the difficulty level and finally
     * trimming the enemy life forms arrayList to the proper size
     * @param difficultyLevel Representing the base difficulty level
     */

    public GameBoard(DifficultyLevel difficultyLevel)
    {
        this.enemyLifeForms = new ArrayList<>();
        this.createLifeForms();
        this.adjustForDifficulty(difficultyLevel);
        this.enemyLifeForms.trimToSize();
    }

    /**
     * The getPlayer method returns the current player
     * @return LifeForm representing the current player
     */

    public LifeForm getPlayer()
    {
        return this.player;
    }

    /**
     * The getEnemyLifeForms returns the ArrayList of LifeForms
     * that represent the enemies
     * @return ArrayList Representing the arraylist of enemies
     */

    public ArrayList<LifeForm> getEnemyLifeForms()
    {
        return this.enemyLifeForms;
    }

    /**
     * This abstract method is overridden in
     * all the subclasses of GameBoard
     */

    protected abstract void createLifeForms();

    /**
     * This method adjusts the enemies life points based on
     * the difficulty level of the game. The more difficult the
     * game is, the more life points are awarded to the enemies.
     * This method first grabs each enemy's life points, it then multiplies
     * those life points by the difficulty level modifier. Finally,
     * a cast is made (to an int) and individual enemy's life points
     * are set
     * @param difficultyLevel Representing the difficulty level
     */

    protected void adjustForDifficulty(DifficultyLevel difficultyLevel)
    {
        for (LifeForm enemy : this.enemyLifeForms)
        {
            int currentLifePoints = enemy.getCurrentLifePoints();
            int adjustLifePoints = (int) (currentLifePoints * difficultyLevel.getModifier());
            enemy.setCurrentLifePoints(adjustLifePoints);
        }
    }
}
