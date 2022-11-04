package GameObjects;

public class SpecialPaper extends Paper
{
    private double thickness;

    protected SpecialPaper()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetInfluence(2.0);
        super.SetType(GameObjectType.SpecialPaper);
        this.thickness = 2.0;
    }

    protected SpecialPaper(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetInfluence(2.0);
        super.SetType(GameObjectType.SpecialPaper);
        this.thickness = 2.0;
    }

    protected SpecialPaper(double startDurability, double startLevelPoint, double startInfluence, double startThickness)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetInfluence(startInfluence);
        super.SetType(GameObjectType.SpecialPaper);
        this.thickness = startThickness;
    }

    protected void SetThickness(double newThickness)
    {
        this.thickness = newThickness;
    }

    protected double GetThickness()
    {
        return this.thickness;
    }

    @Override
    protected void ShowObjectStats()
    {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("Special Paper");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + super.GetInfluence());
        System.out.println("Thickness = " + this.thickness);
        System.out.println("=================================================================");
    }

    @Override
    protected double CalculateAttackValue(Rock enemyRock)
    {
        return (super.GetInfluence() * this.thickness) / (a * enemyRock.GetHardness());
    }

    @Override
    protected double CalculateAttackValue(Paper enemyPaper)
    {
        return 0;   // Çünkü özel kağıdın kağıda karşı bir etkisi olamaz.
    }

    @Override
    protected double CalculateAttackValue(Scissor enemyScissor)
    {
        return (super.GetInfluence() * this.thickness) / ((1.0 - a) * enemyScissor.GetSharpness());
    }

    @Override
    protected double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return (super.GetInfluence() * this.thickness) / (a * enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    protected double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return 0;   // Çünkü özel kağıdın özel kağıda karşı bir etkisi olamaz.
    }

    @Override
    protected double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return (super.GetInfluence() * this.thickness) / ((1.0 - a) * enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
    }

    @Override
    protected int UpdateStats(long addToDurability, long addToLevelPoint)
    {
        this.SetDurability(this.GetDurability() + addToDurability);
        this.SetLevelPoint(this.GetLevelPoint() + addToLevelPoint);

        if(this.GetDurability() <= 0)
            return -1;

        if(this.GetLevelPoint() > 30)
            return 1;

        return 0;
    }
}
