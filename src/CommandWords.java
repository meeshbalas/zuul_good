/**
 * This class holds information about valid commands.
 */
public class CommandWords
{
    private static final String[] validCommands = {
            "go", "quit", "help", "back"
    };


    public CommandWords()
    {

    }


    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++)
        {
            if(validCommands[i].equals(aString))
                return true;
        }

        return false;
    }
}