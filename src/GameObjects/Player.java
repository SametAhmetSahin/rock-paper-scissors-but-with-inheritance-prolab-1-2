package GameObjects;

import java.util.ArrayList;
import java.util.Random;
import Game.*;

public abstract class Player
{
    public class DeckItem
    {
        public GameObject object;
        public boolean isUsed;
        public long id;

        DeckItem(GameObject startItem, long startID)
        {
            this.object = startItem;
            this.isUsed = false;
            this.id = startID;
        }

        public String ShowStats()
        {
            String text = "";

            System.out.println("-----------------------------------------------------------------");
            System.out.println("Item's ID: " + this.id);
            System.out.println("Is item used: " + this.isUsed);

            text += "-----------------------------------------------------------------\n";
            text += "Item's ID: " + this.id + "\n";
            text += "Is item used: " + this.isUsed + "\n";
            text += this.object.ShowObjectStats();

            System.out.println("-----------------------------------------------------------------");
            text += "-----------------------------------------------------------------\n";

            return text;
        }
    }

    private long playerID;
    private String playerName;
    private double score;

    public ArrayList<DeckItem> deck = new ArrayList<>();
    final Random rng = new Random();

    public Player()
    {
        do
        {
            this.playerID = this.rng.nextLong();
        } while(this.playerID < 0);

        this.playerName = "Player";
        this.score = 0.0;
        //InitializeDeck();
    }

    public Player(long id, String name)
    {
        this.playerID = id;
        this.playerName = name;
        this.score = 0.0;
        //InitializeDeck();
    }

    public Player(long id, String name, double startScore)
    {
        this.playerID = id;
        this.playerName = name;
        this.score = startScore;
        //InitializeDeck();
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
                case 0 -> this.deck.add(new DeckItem(new Rock(Game.startDurability, Game.startLevelPoint, Game.startRockHardness), i));
                case 1 -> this.deck.add(new DeckItem(new Paper(Game.startDurability, Game.startLevelPoint, Game.startPaperInfluence), i));
                case 2 -> this.deck.add(new DeckItem(new Scissor(Game.startDurability, Game.startLevelPoint, Game.startScissorSharpness), i));
            }
        }
    }

    public void InitializeDeck(int[] startingDeck)
    {
        for(int i = 0; i < startingDeck.length; i++)
        {
            switch (startingDeck[i])
            {
                case 0 -> this.deck.add(new DeckItem(new Rock(Game.startDurability, Game.startLevelPoint, Game.startRockHardness), i));
                case 1 -> this.deck.add(new DeckItem(new Paper(Game.startDurability, Game.startLevelPoint, Game.startPaperInfluence), i));
                case 2 -> this.deck.add(new DeckItem(new Scissor(Game.startDurability, Game.startLevelPoint, Game.startScissorSharpness), i));
            }
        }
    }

    public ArrayList<DeckItem> GetItemDeck()
    {
        return this.deck;
    }

    public abstract void RemoveItem(DeckItem disqualified);

    public abstract void UpgradeItem(DeckItem obsolete);

    public abstract void UpdateItem(DeckItem upToDate);

    public abstract String ShowScore();

    public abstract DeckItem SelectItem(int selection);
}
