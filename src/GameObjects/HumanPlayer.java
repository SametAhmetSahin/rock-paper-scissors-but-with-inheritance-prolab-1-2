package GameObjects;

public class HumanPlayer extends Player
{
    public HumanPlayer()
    {
        super.SetPlayerID(0);
        super.SetPlayerName("Human");
        super.SetPlayerScore(0);
    }

    public HumanPlayer(long ID, String name)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(0);
    }

    public HumanPlayer(long ID, String name, long startScore)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(startScore);
    }
}
