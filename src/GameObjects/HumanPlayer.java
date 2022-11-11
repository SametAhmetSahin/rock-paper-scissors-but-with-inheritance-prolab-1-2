package GameObjects;

public class HumanPlayer extends Player
{
    public HumanPlayer()
    {
        super.SetPlayerID(this.rng.nextLong());
        super.SetPlayerName("Human");
        super.SetPlayerScore(0);
        super.InitializeDeck();
    }

    public HumanPlayer(long ID, String name)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(0);
        super.InitializeDeck();
    }

    public HumanPlayer(long ID, String name, long startScore)
    {
        super.SetPlayerID(ID);
        super.SetPlayerName(name);
        super.SetPlayerScore(startScore);
        super.InitializeDeck();
    }

    @Override
    public void RemoveItem(DeckItem disqualified)
    {
        super.deck.remove(disqualified);
    }

    @Override
    public void UpgradeItem(DeckItem obsolete)
    {
        DeckItem toAdded;

        switch(obsolete.object.GetType())
        {
            case Paper -> toAdded = new DeckItem(new SpecialPaper(obsolete.object.GetDurability(), obsolete.object.GetLevelPoint()), obsolete.id);
            case Scissor -> toAdded = new DeckItem(new MasterScissor(obsolete.object.GetDurability(), obsolete.object.GetLevelPoint()), obsolete.id);
            default -> toAdded = new DeckItem(new HeavyRock(obsolete.object.GetDurability(), obsolete.object.GetLevelPoint()), obsolete.id);
        }

        super.deck.set(super.deck.indexOf(obsolete), toAdded);
    }

    @Override
    public void ShowScore()
    {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("Player ID: " + super.GetPlayerID());
        System.out.println("Player's Name: " + super.GetPlayerName());
        System.out.println("Player's Score = " + super.GetPlayerScore());
        System.out.println("=================================================================");
    }

    @Override
    public DeckItem SelectItem(int selection)
    {
        return super.GetItemDeck().get(selection);
    }
}
