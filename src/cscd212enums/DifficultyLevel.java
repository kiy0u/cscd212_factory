package cscd212enums;

public enum DifficultyLevel
{
    EASY(0.7),
    HARD(1.5),
    INSANE(2),
    NORMAL(1);

    /**
     * Private data member representing the difficulty modifier.
     */

    private double difficultyModifier;

    /**
     * This constructor sets the difficulty modifier to the value passed in.
     * @param difficultyModifier representing the enumerated type
     */

    private DifficultyLevel(double difficultyModifier)
    {
        if (difficultyModifier <= 0)
        {
            throw new IllegalArgumentException("difficultyModifier is less than or equal to 0");
        }

        this.difficultyModifier = difficultyModifier;
    }

    /**
     * The getModifier returns the value of the difficulty modifier
     * @return double representing the difficulty modifier
     */

    public double getModifier()
    {
        return this.difficultyModifier;
    }


}
