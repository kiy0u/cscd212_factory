package cscd212enums;

import cscd212classes.lifeform.LifeForm;

import java.util.ArrayList;

public enum LifeFormType
{
    HUMAN("Hugh Mann", 100),
    MARTIAN("Marvin", 120),
    KRYPTON("Kal-El", 300),
    HALF_ORC("Gruumsh", 200);

    /**
     * Represents the currentLifePoints
     */

    private int currentLifePoints;

    /**
     * Represents the name
     */

    private String name;

    /**
     * The private constructor for the LifeFormType's enumerated type
     * @param name Representing the LifeFormType's name
     * @param currentLifePoints Representing the LifeFormType's current life points
     */

    private LifeFormType(final String name, final int currentLifePoints)
    {
        if (name == null || name.isBlank() || currentLifePoints <= 0)
        {
            throw new IllegalArgumentException("name is null, empty or currentLifePoints is less than or equal to 0");
        }

        this.name = name;
        this.currentLifePoints = currentLifePoints;
    }



    /**
     * The getName returns the LifeFormTypeName
     * @return int Representing the LifeFOrmType current life points
     */

    public String getName()
    {
        return this.name;
    }

    /**
     * The getCurrentLifePoints returns the LifeFormType current life points
     * @return int Representing the LifeFormType current life points
     */

    public int getCurrentLifePoints()
    {
        return this.currentLifePoints;
    }



}
