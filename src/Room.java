import java.util.*;

/**
 * Class Room - a room in an adventure game.
 */
public class Room
{
    private String description;
    private Map<String, Room> exits;

    /**
     * Create a room described "description".
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
    }


    /**
     * Add one exit to this room.
     */
    public void setExit(String direction, Room room)
    {
        exits.put(direction, room);
    }


    /**
     * Return the room in a given direction.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }


    public String getDescription()
    {
        return description;
    }


    /**
     * Print room description and all available exits.
     */
    public void printLongDescription()
    {
        System.out.println("You are " + description);

        System.out.print("Exits: ");

        for(String direction : exits.keySet())
        {
            System.out.print(direction + " ");
        }

        System.out.println();
    }
}