package GameObjects;

import java.util.ArrayList;
import java.util.Random;

public abstract class Player
{
    private long playerID;
    private String playerName;
    private long score;

    private ArrayList<GameObject> deckItems = new ArrayList<>();
    final Random rng = new Random();

    protected Player()
    {
        this.playerID = this.rng.nextLong();
        this.playerName = "Player";
        this.score = 0;
        InitializeDeck();
    }

    protected Player(long id, String name)
    {
        this.playerID = id;
        this.playerName = name;
        this.score = 0;
        InitializeDeck();
    }

    protected Player(long id, String name, long startScore)
    {
        this.playerID = id;
        this.playerName = name;
        this.score = startScore;
        InitializeDeck();
    }

    protected void SetPlayerID(long newID)
    {
        this.playerID = newID;
    }

    protected void SetPlayerName(String newName)
    {
        this.playerName = newName;
    }

    protected void SetPlayerScore(long newScore)
    {
        this.score = newScore;
    }

    protected long GetPlayerID()
    {
        return this.playerID;
    }

    protected String GetPlayerName()
    {
        return this.playerName;
    }

    protected long GetPlayerScore()
    {
        return this.score;
    }

    protected void InitializeDeck()
    {
        for(byte i = 0; i < 5; i++)
        {
            switch (this.rng.nextInt(3))
            {
                case 0 -> this.deckItems.add(new Rock());
                case 1 -> this.deckItems.add(new Paper());
                case 2 -> this.deckItems.add(new Scissor());
            }
        }
    }

    protected ArrayList<GameObject> GetItemDeck()
    {
        return this.deckItems;
    }

    protected void RemoveItem(GameObject disqualified)
    {
        this.deckItems.remove(disqualified);
    }

    protected void UpgradeItem(GameObject obsolete)
    {
        GameObject toAdded;

        switch(obsolete.GetType())
        {
            case Paper -> toAdded = new SpecialPaper(obsolete.GetDurability(), obsolete.GetLevelPoint());
            case Scissor -> toAdded = new MasterScissor(obsolete.GetDurability(), obsolete.GetLevelPoint());
            default -> toAdded = new HeavyRock(obsolete.GetDurability(), obsolete.GetLevelPoint());
        }

        this.deckItems.set(this.deckItems.indexOf(obsolete), toAdded);
    }

    protected void ShowScore()
    {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("Player ID: " + this.playerID);
        System.out.println("Player's Name: " + this.playerName);
        System.out.println("Player's Score = " + this.score);
        System.out.println("=================================================================");
    }

    protected void SelectItem()
    {

    }
}
