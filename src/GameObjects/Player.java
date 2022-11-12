package GameObjects;

import java.util.ArrayList;
import java.util.Random;

public abstract class Player
{
    public class DeckItem
    {
        public GameObject object;
        public boolean isUsed;
        long id;

        DeckItem(GameObject startItem, long startID)
        {
            this.object = startItem;
            this.isUsed = false;
            this.id = startID;
        }

        public void ShowStats()
        {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Item's ID: " + this.id);
            System.out.println("Is item used: " + this.isUsed);
            System.out.println("-----------------------------------------------------------------");
            this.object.ShowObjectStats();
            System.out.println("-----------------------------------------------------------------");
        }
    }

    private long playerID;
    private String playerName;
    private double score;

    public ArrayList<DeckItem> deck = new ArrayList<>();
    final Random rng = new Random();

    public Player()
    {
        this.playerID = this.rng.nextLong();
        this.playerName = "Player";
        this.score = 0.0;
        InitializeDeck();
    }

    public Player(long id, String name)
    {
        this.playerID = id;
        this.playerName = name;
        this.score = 0.0;
        InitializeDeck();
    }

    public Player(long id, String name, double startScore)
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

    public void SetPlayerScore(double newScore)
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

    public double GetPlayerScore()
    {
        UpdatePlayerScore();
        return this.score;
    }

    public void UpdatePlayerScore()
    {
        double newScore = 0.0;
        for(DeckItem i : this.GetItemDeck())
            newScore += i.object.GetDurability();

        this.SetPlayerScore(newScore);
    }

    public void InitializeDeck()
    {
        for(long i = 0; i < 5; i++)
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
