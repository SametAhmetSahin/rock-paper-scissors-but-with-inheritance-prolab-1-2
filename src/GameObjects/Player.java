package GameObjects;

import java.util.ArrayList;
import java.util.Random;

public abstract class Player
{
    public class DeckItem
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

    public ArrayList<DeckItem> deck = new ArrayList<>();
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
                case 0 -> this.deck.add(new DeckItem(new Rock(), i));
                case 1 -> this.deck.add(new DeckItem(new Paper(), i));
                case 2 -> this.deck.add(new DeckItem(new Scissor(), i));
            }
        }
    }

    public ArrayList<DeckItem> GetItemDeck()
    {
        return this.deck;
    }

    public abstract void RemoveItem(DeckItem disqualified);

    public abstract void UpgradeItem(DeckItem obsolete);

    public abstract void ShowScore();

    public abstract DeckItem SelectItem(int selection);
}
