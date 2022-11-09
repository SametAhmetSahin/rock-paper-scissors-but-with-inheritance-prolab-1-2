package GameObjects;

public class MasterScissor extends Scissor
{
    private double speed;

    protected MasterScissor()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetSharpness(2.0);
        super.SetType(GameObjectType.MasterScissor);
        this.speed = 2.0;
    }

    protected MasterScissor(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetSharpness(2.0);
        super.SetType(GameObjectType.MasterScissor);
        this.speed = 2.0;
    }

    protected MasterScissor(double startDurability, double startLevelPoint, double startSharpness, double startSpeed)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetSharpness(startSharpness);
        super.SetType(GameObjectType.MasterScissor);
        this.speed = startSpeed;
    }

    protected void SetSpeed(double newSpeed)
    {
        this.speed = newSpeed;
    }

    protected double GetSpeed()
    {
        return this.speed;
    }

    @Override
    protected void ShowObjectStats()
    {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("Master Scissor");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + super.GetSharpness());
        System.out.println("Speed = " + this.speed);
        System.out.println("=================================================================");
    }

    @Override
    protected double CalculateAttackValue(Rock enemyRock)
    {
        return (super.GetSharpness() * this.speed) / ((1.0 - a) * enemyRock.GetHardness());
    }

    @Override
    protected double CalculateAttackValue(Paper enemyPaper)
    {
        return (super.GetSharpness() * this.speed) / (a * enemyPaper.GetInfluence());
    }

    @Override
    protected double CalculateAttackValue(Scissor enemyScissor)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return (super.GetSharpness() * this.speed) / enemyScissor.GetSharpness();
    }

    @Override
    protected double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return (super.GetSharpness() * this.speed) / ((1.0 - a) * enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    protected double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return (super.GetSharpness() * this.speed) / (a * enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    protected double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        // Dökümanda aynı tip nesnelerin birbirlerine karşı etkilerinin hesaplanmasına dair bir formül yer almaması nedeniyle
        // dökümandaki formüller esas alınmak suretiyle en gerçekçi formül oluşturulmaya çalışılmıştır.
        return (super.GetSharpness() * this.speed) / (enemyMasterScissor.GetSharpness() * enemyMasterScissor.GetSpeed());
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
