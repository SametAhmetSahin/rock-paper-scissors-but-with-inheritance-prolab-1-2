package GameObjects;

public class ComputerPlayer extends Player
{
    protected ComputerPlayer()
    {
        super.SetPlayerID(this.rng.nextLong());
        super.SetPlayerName("Computer");
        super.SetPlayerScore(0);
        super.InitializeDeck();
    }

    protected ComputerPlayer(long ID, String name)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(0);
        super.InitializeDeck();
    }

    protected ComputerPlayer(long ID, String name, long startScore)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(startScore);
        super.InitializeDeck();
    }

    @Override
    protected void ShowScore()
    {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("Player ID: " + super.GetPlayerID());
        System.out.println("Player's Name: " + super.GetPlayerName());
        System.out.println("Player's Score = " + super.GetPlayerScore());
        System.out.println("=================================================================");
    }

    @Override
    protected DeckItem SelectItem(int selection)
    {
        do
        {
            selection = super.rng.nextInt(5);
        } while(super.GetItemDeck().get(selection).isUsed);

        return super.GetItemDeck().get(selection);
    }
}
