package GameObjects;

public class Scissor extends GameObject
{
    protected double sharpness;

    public Scissor()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetType(GameObjectType.Scissor);
        sharpness = 2.0;
    }

    public Scissor(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Scissor);
        this.sharpness = 2.0;
    }

    public Scissor(double startDurability, double startLevelPoint, double startSharpness)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetType(GameObjectType.Scissor);
        this.sharpness = startSharpness;
    }

    public void SetSharpness(double newSharpness)
    {
        this.sharpness = newSharpness;
    }

    public double GetSharpness()
    {
        return this.sharpness;
    }

    @Override
    public void ShowObjectStats()
    {
        System.out.println("Scissor");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + this.sharpness);
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
