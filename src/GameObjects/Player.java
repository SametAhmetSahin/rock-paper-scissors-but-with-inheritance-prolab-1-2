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

    public Player()
    {
        this.playerID = this.rng.nextLong();
        this.playerName = "Player";
        this.score = 0;
        InitializeDeck();
    }

    public Player(long id, String name)
    {
        this.playerID = id;
        this.playerName = name;
        this.score = 0;
        InitializeDeck();
    }

    public Player(long id, String name, long startScore)
    {
        this.playerID = id;
        this.playerName = name;
        this.score = startScore;
        InitializeDeck();
    }

    public void SetPlayerID(long newID)
    {
        this.playerID = newID;
    }

    public void SetPlayerName(String newName)
    {
        this.playerName = newName;
    }

    public void SetPlayerScore(long newScore)
    {
        this.score = newScore;
    }

    public long GetPlayerID()
    {
        return this.playerID;
    }

    public String GetPlayerName()
    {
        return this.playerName;
    }

    public long GetPlayerScore()
    {
        return this.score;
    }

    public void InitializeDeck()
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

    public ArrayList<GameObject> GetItemDeck()
    {
        return this.deckItems;
    }

    public void RemoveItem(GameObject disqualified)
    {
        this.deckItems.remove(disqualified);
    }

    public void UpdateItem(GameObject obsolete, GameObject newItem)
    {
        GameObject toAdded;

        switch(obsolete.GetType())
        {
            case Rock -> toAdded = new HeavyRock(obsolete.GetDurability(), obsolete.GetLevelPoint());
            case Paper -> toAdded = new SpecialPaper(obsolete.GetDurability(), obsolete.GetLevelPoint());
            case Scissor -> toAdded = new MasterScissor(obsolete.GetDurability(), obsolete.GetLevelPoint());
        }

        this.deckItems.set(this.deckItems.indexOf(obsolete), newItem);
    }

    public void ShowScore()
    {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("Player ID: " + this.playerID);
        System.out.println("Player's Name: " + this.playerName);
        System.out.println("Player's Score = " + this.score);
        System.out.println("=================================================================");
    }
}
