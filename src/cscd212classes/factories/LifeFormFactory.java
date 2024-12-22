package cscd212classes.factories;

import cscd212classes.lifeform.*;
import cscd212enums.LifeFormType;

public class LifeFormFactory
{
    public LifeFormFactory()
    {

    }

    /**
     * This method creates the appropriate life form by calling the
     * appropriate constructor and passing the correct parameters.
     * It checks the life form type and depending on which life form type
     * creates a new LifeForm object.
     * @param lifeFormType The enumerated type representing the life form
     * @param name The name of the life form
     * @param currentLifePoints The current life points of the life form
     * @return LifeForm Representing the appropriate object
     */

    public static LifeForm getLifeForm(final LifeFormType lifeFormType, final String name, final int currentLifePoints)
    {
        if (name == null || name.isBlank() || currentLifePoints < 1)
        {
            throw new IllegalArgumentException("name is null, empty or currentLifePoints is less than 1 ");
        }

        switch (lifeFormType)
        {
            case HUMAN:
                return new Human(name, currentLifePoints);
            case HALF_ORC:
                return new HalfOrc(name, currentLifePoints);
            case KRYPTON:
                return new Kryptonians(name, currentLifePoints);
            case MARTIAN:
                return new Martian(name, currentLifePoints);
            default:
                throw new IllegalArgumentException("invalid lifeForm inputted");
        }

    }

    /**
     * This method creates the appropriate life form by calling
     * the other get life form method and passing it the default values
     * for the name and the current life points
     * @param lifeFormType The enumerated type representing the life form
     * @return LifeForm Representing the appropriate object to be built
     */

    public static LifeForm getLifeForm(final LifeFormType lifeFormType)
    {
        return getLifeForm(lifeFormType, lifeFormType.getName(), lifeFormType.getCurrentLifePoints());
    }
}
