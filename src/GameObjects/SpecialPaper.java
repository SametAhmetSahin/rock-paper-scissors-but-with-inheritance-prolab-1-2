package GameObjects;

public class SpecialPaper extends Paper
{
    protected double thickness;

    public SpecialPaper()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetInfluence(2.0);
        super.SetType(GameObjectType.SpecialPaper);
        this.thickness = 2.0;
    }

    public SpecialPaper(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetInfluence(2.0);
        super.SetType(GameObjectType.SpecialPaper);
        this.thickness = 2.0;
    }

    public SpecialPaper(double startDurability, double startLevelPoint, double startInfluence, double startThickness)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetInfluence(startInfluence);
        super.SetType(GameObjectType.SpecialPaper);
        this.thickness = startThickness;
    }

    public void SetThickness(double newThickness)
    {
        this.thickness = newThickness;
    }

    public double GetThickness()
    {
        return this.thickness;
    }

    @Override
    public void ShowObjectStats()
    {
        System.out.println("Special Paper");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + super.GetInfluence());
        System.out.println("Thickness = " + this.thickness);
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
