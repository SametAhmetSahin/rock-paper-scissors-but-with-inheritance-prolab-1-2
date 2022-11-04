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
    public void ShowObjectStats()
    {
        System.out.println("=================================================================");
        System.out.println("Master Scissor");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + super.GetSharpness());
        System.out.println("Speed = " + this.speed);
        System.out.println("=================================================================");
    }

    @Override
    public double CalculateAttackValue(Rock enemyRock)
    {
        return (super.GetSharpness() * this.speed) / ((1.0 - a) * enemyRock.GetHardness());
    }

    @Override
    public double CalculateAttackValue(Paper enemyPaper)
    {
        return (super.GetSharpness() * this.speed) / (a * enemyPaper.GetInfluence());
    }

    @Override
    public double CalculateAttackValue(Scissor enemyScissor)
    {
        return 0;   // Çünkü usta makasın makasa karşı bir etkisi olamaz.
    }

    @Override
    public double CalculateAttackValue(HeavyRock enemyHeavyRock)
    {
        return (super.GetSharpness() * this.speed) / ((1.0 - a) * enemyHeavyRock.GetHardness() * enemyHeavyRock.GetHeat());
    }

    @Override
    public double CalculateAttackValue(SpecialPaper enemySpecialPaper)
    {
        return (super.GetSharpness() * this.speed) / (a * enemySpecialPaper.GetInfluence() * enemySpecialPaper.GetThickness());
    }

    @Override
    public double CalculateAttackValue(MasterScissor enemyMasterScissor)
    {
        return 0;   // Çünkü usta makasın usta makasa karşı bir etkisi olamaz.
    }

    @Override
    public int UpdateStats(long addToDurability, long addToLevelPoint)
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
