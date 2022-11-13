package GameObjects;

public class SpecialPaper extends Paper
{
    private double thickness;

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
    public String ShowObjectStats()
    {
        System.out.println("Type: SPECIAL PAPER");
        System.out.println("Durability: " + super.GetDurability());
        System.out.println("Level point: " + super.GetLevelPoint());
        System.out.println("Influence: " + super.GetInfluence());
        System.out.println("Thickness: " + this.thickness);

        return "Type: SPECIAL PAPER\n" +
               "Durability: " + super.GetDurability() + "\n" +
               "Level point: " + super.GetLevelPoint() + "\n" +
               "Influence: " + super.GetInfluence() + "\n" +
               "Thickness: " + this.thickness + "\n";
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return (super.GetInfluence() * this.thickness) / (super.GetConstantA() * enemyRock.GetHardness());
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return (super.GetInfluence() * this.thickness) / enemyPaper.GetInfluence();
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return (super.GetInfluence() * this.thickness) / ((1.0 - super.GetConstantA()) * enemyScissor.GetSharpness());
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return (super.GetInfluence() * this.thickness) / (super.GetConstantA() * enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return (super.GetInfluence() * this.thickness) / (enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return (super.GetInfluence() * this.thickness) / ((1.0 - super.GetConstantA()) * enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
    }

    @Override
    public int UpdateStats(double addToDurability, double addToLevelPoint)
    {
        this.SetDurability(this.GetDurability() + addToDurability);
        this.SetLevelPoint(this.GetLevelPoint() + addToLevelPoint);

        if(this.GetDurability() <= 0.0)
            return -1;

        if(this.GetLevelPoint() > 30.0)
            return 1;

        return 0;
    }
}
