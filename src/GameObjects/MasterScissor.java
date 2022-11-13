package GameObjects;

public class MasterScissor extends Scissor
{
    private double speed;

    public MasterScissor()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetSharpness(2.0);
        super.SetType(GameObjectType.MasterScissor);
        this.speed = 2.0;
    }

    public MasterScissor(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetSharpness(2.0);
        super.SetType(GameObjectType.MasterScissor);
        this.speed = 2.0;
    }

    public MasterScissor(double startDurability, double startLevelPoint, double startSharpness, double startSpeed)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetSharpness(startSharpness);
        super.SetType(GameObjectType.MasterScissor);
        this.speed = startSpeed;
    }

    public void SetSpeed(double newSpeed)
    {
        this.speed = newSpeed;
    }

    public double GetSpeed()
    {
        return this.speed;
    }

    @Override
    public String ShowObjectStats()
    {
        System.out.println("Type: MASTER SCISSOR");
        System.out.println("Durability: " + super.GetDurability());
        System.out.println("Level point: " + super.GetLevelPoint());
        System.out.println("Sharpness: " + super.GetSharpness());
        System.out.println("Speed: " + this.speed);

        return "Type: MASTER SCISSOR\n" +
               "Durability: " + super.GetDurability() + "\n" +
               "Level point: " + super.GetLevelPoint() + "\n" +
               "Sharpness: " + super.GetSharpness() + "\n" +
               "Speed: " + this.speed + "\n";
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return (super.GetSharpness() * this.speed) / ((1.0 - super.GetConstantA()) * enemyRock.GetHardness());
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return (super.GetSharpness() * this.speed) / (super.GetConstantA() * enemyPaper.GetInfluence());
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return (super.GetSharpness() * this.speed) / enemyScissor.GetSharpness();
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return (super.GetSharpness() * this.speed) / ((1.0 - super.GetConstantA()) * enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return (super.GetSharpness() * this.speed) / (super.GetConstantA() * enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return (super.GetSharpness() * this.speed) / (enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
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
