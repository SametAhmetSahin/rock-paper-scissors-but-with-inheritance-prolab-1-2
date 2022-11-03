package GameObjects;

public abstract class GameObject
{
    protected enum GameObjectType
    {
        Rock,
        Paper,
        Scissor,
        HeavyRock,
        SpecialPaper,
        ProfessionalScissor
    }

    protected GameObjectType type;
    protected double durability;
    protected double levelPoint;

    public GameObject()
    {
        // Dökümanda belirtilen varsayılan değerler
        this.durability = 20.0;
        this.levelPoint = 0.0;
    }

    public GameObject(double startDurability, double startLevelPoint)
    {
        this.durability = startDurability;
        this.levelPoint = startLevelPoint;
    }

    public void SetDurability(double newDurability)
    {
        this.durability = newDurability;
    }

    public void SetLevelPoint(double newLevelPoint)
    {
        this.levelPoint = newLevelPoint;
    }

    public void SetType(GameObjectType newType)
    {
        this.type = newType;
    }

    public double GetDurability()
    {
        return this.durability;
    }

    public double GetLevelPoint()
    {
        return this.levelPoint;
    }

    public GameObjectType GetType()
    {
        return this.type;
    }

    public void ShowObjectStats()
    {
        System.out.println("This object's durability = " + durability);
        System.out.println("This object's level point = " + levelPoint);
    }

    public double CalculateAttackValue()
    {
        return 2.0 + 2.0;
    }

    public void UpdateStats()
    {
        System.out.println("Something happened.");
    }
}
