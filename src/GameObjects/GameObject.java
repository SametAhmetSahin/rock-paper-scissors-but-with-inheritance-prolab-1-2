package GameObjects;

public abstract class GameObject
{
    public enum GameObjectType
    {
        Rock,
        Paper,
        Scissor,
        HeavyRock,
        SpecialPaper,
        MasterScissor
    }

    private GameObjectType type;
    private double durability;
    private double levelPoint;
    private double a = 0.2;

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

    public double GetConstantA()
    {
        return a;
    }

    public void SetConstantA(double newA)
    {
        a = newA;
    }

    public abstract String ShowObjectStats();

    public abstract double CalculateAttackValue(Rock enemyRock);

    public abstract double CalculateAttackValue(Paper enemyPaper);

    public abstract double CalculateAttackValue(Scissor enemyScissor);

    public abstract double CalculateAttackValue(HeavyRock enemyHeavyRock);

    public abstract double CalculateAttackValue(SpecialPaper enemySpecialPaper);

    public abstract double CalculateAttackValue(MasterScissor enemyMasterScissor);

    public abstract int UpdateStats(double addToDurability, double addToLevelPoint);
}
