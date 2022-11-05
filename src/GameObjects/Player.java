package GameObjects;

import java.util.ArrayList;
import java.util.Random;

public abstract class Player
{
    private class DeckItem
    {
        GameObject object;
        boolean isUsed;
        long id;

        DeckItem(GameObject startItem, long startID)
        {
            this.object = startItem;
            this.isUsed = false;
            this.id = startID;
        }
    }

    private long playerID;
    private String playerName;
    private long score;

    private ArrayList<DeckItem> deck = new ArrayList<>();
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
                case 0 -> this.deck.add(new DeckItem(new Rock(), i));
                case 1 -> this.deck.add(new DeckItem(new Paper(), i));
                case 2 -> this.deck.add(new DeckItem(new Scissor(), i));
            }
        }
    }

    protected ArrayList<DeckItem> GetItemDeck()
    {
        return this.deck;
    }

    protected void RemoveItem(DeckItem disqualified)
    {
        this.deck.remove(disqualified);
    }

    protected void UpgradeItem(DeckItem obsolete)
    {
        DeckItem toAdded;

        switch(obsolete.object.GetType())
        {
            case Paper -> toAdded = new DeckItem(new SpecialPaper(obsolete.object.GetDurability(), obsolete.object.GetLevelPoint()), obsolete.id);
            case Scissor -> toAdded = new DeckItem(new MasterScissor(obsolete.object.GetDurability(), obsolete.object.GetLevelPoint()), obsolete.id);
            default -> toAdded = new DeckItem(new HeavyRock(obsolete.object.GetDurability(), obsolete.object.GetLevelPoint()), obsolete.id);
        }

        this.deck.set(this.deck.indexOf(obsolete), toAdded);
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
