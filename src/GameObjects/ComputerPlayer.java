package GameObjects;

public class ComputerPlayer extends Player
{
    public ComputerPlayer()
    {
        super.SetPlayerID(0);
        super.SetPlayerName("Computer");
        super.SetPlayerScore(0);
    }

    public ComputerPlayer(long ID, String name)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(0);
    }

    public ComputerPlayer(long ID, String name, long startScore)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(startScore);
    }
}
