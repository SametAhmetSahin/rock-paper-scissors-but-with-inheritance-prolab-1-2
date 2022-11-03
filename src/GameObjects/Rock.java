package GameObjects;

public class Rock extends GameObject
{
    protected double hardness;

    public Rock()
    {
        super.SetDurability(20);
        super.SetLevelPoint(0);
        super.SetType(GameObjectType.Rock);
        this.hardness = 2.0;
    }

    public Rock(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Rock);
        this.hardness = 2.0;
    }

    public Rock(double startDurability, double startLevelPoint, double startHardness)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Rock);
        this.hardness = startHardness;
    }

    public void SetHardness(double newHardness)
    {
        this.hardness = newHardness;
    }

    public double GetHardness()
    {
        return this.hardness;
    }

    @Override
    public void ShowObjectStats()
    {
        System.out.println("Rock");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Hardness = " + this.hardness);
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return 2.0 + 2.0;
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return 2.0 + 2.0;
    }

    @Override
    public void UpdateStats()
    {

    }
}
