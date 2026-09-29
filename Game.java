public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;


    public Game()
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room outside, theater, pub, lab, office, library, cellar;


        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        library = new Room("in the university library");
        cellar = new Room("in a dark underground cellar");


        // normal exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("north", library);
        library.setExit("south", outside);

        theater.setExit("west", outside);


        pub.setExit("east", outside);


        lab.setExit("north", outside);
        lab.setExit("east", office);


        office.setExit("west", lab);


        // new up/down directions
        library.setExit("down", cellar);
        cellar.setExit("up", library);

        outside.setExit("north", library);
        currentRoom = outside;
        previousRoom = null;
    }



    public void play()
    {
        printWelcome();

        boolean finished = false;

        while (!finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing. Good bye.");
    }



    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();

        printDirection();
    }



    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;


        if(command.isUnknown())
        {
            System.out.println("I don't know what you mean...");
            return false;
        }


        String commandWord = command.getCommandWord();


        if(commandWord.equals("help"))
        {
            printHelp();
        }

        else if(commandWord.equals("go"))
        {
            goRoom(command);
        }

        else if(commandWord.equals("back"))
        {
            goBack();
        }

        else if(commandWord.equals("quit"))
        {
            wantToQuit = quit(command);
        }


        return wantToQuit;
    }



    private void printHelp()
    {
        System.out.println("You are lost. You are alone.");
        System.out.println("Your command words are:");
        System.out.println("go quit help back");
    }



    private void goRoom(Command command)
    {
        if(!command.hasSecondWord())
        {
            System.out.println("Go where?");
            return;
        }


        String direction = command.getSecondWord();


        Room nextRoom = currentRoom.getExit(direction);


        if(nextRoom == null)
        {
            System.out.println("There is no door!");
        }

        else
        {
            previousRoom = currentRoom;
            currentRoom = nextRoom;

            printDirection();
        }
    }



    private void goBack()
    {
        if(previousRoom == null)
        {
            System.out.println("You cannot go back.");
        }

        else
        {
            Room temp = currentRoom;

            currentRoom = previousRoom;
            previousRoom = temp;

            printDirection();
        }
    }



    public void printDirection()
    {
        currentRoom.printLongDescription();
    }



    private boolean quit(Command command)
    {
        if(command.hasSecondWord())
        {
            System.out.println("Quit what?");
            return false;
        }

        else
        {
            return true;
        }
    }
}