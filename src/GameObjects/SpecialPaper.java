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
        return (this.influence * this.thickness) / (a * enemyRock.hardness);
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return 0;   // Çünkü özel kağıdın kağıda karşı bir etkisi olamaz.
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return (this.influence * this.thickness) / ((1.0 - a) * enemyScissor.sharpness);
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return (this.influence * this.thickness) / (a * enemyHeavyRock.hardness * enemyHeavyRock.heat);
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return 0;   // Çünkü özel kağıdın özel kağıda karşı bir etkisi olamaz.
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return (this.influence * this.thickness) / ((1.0 - a) * enemyMasterScissor.sharpness * enemyMasterScissor.speed);
    }

    @Override
    public void UpdateStats()
    {

    }
}
