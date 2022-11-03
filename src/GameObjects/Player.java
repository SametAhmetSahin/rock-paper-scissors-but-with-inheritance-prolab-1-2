package GameObjects;

import java.util.ArrayList;

public abstract class Player
{
    protected long playerID;
    protected String playerName;
    protected long score;

    protected ArrayList<GameObject.GameObjectType> items = new ArrayList<>();

    public Player()
    {
        this.playerID = 0;
        this.playerName = "Player";
        this.score = 0;
    }

    public Player(long id, String name)
    {
        this.playerID = id;
        this.playerName = name;
        this.score = 0;
    }

    public Player(long id, String name, long startScore)
    {
        this.playerID = id;
        this.playerName = name;
        this.score = startScore;
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
}
