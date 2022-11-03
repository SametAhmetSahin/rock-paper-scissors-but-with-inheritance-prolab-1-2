package GameObjects;

public class HumanPlayer extends Player
{
    public HumanPlayer()
    {
        super.playerID = 0;
        super.playerName = "Human";
        super.score = 0;
    }

    public HumanPlayer(long ID, String name)
    {
        super.playerID = ID;
        super.playerName = name;
        super.score = 0;
    }

    public HumanPlayer(long ID, String name, long startScore)
    {
        super.playerID = ID;
        super.playerName = name;
        super.score = startScore;
    }
}
