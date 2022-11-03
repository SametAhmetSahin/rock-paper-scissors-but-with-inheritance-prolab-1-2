package GameObjects;

public class HeavyRock extends Rock
{
    protected double heat;

    public HeavyRock()
    {
        super.SetDurability(20.0);
        super.SetLevelPoint(0.0);
        super.SetHardness(2.0);
        super.SetType(GameObjectType.HeavyRock);
        this.heat = 2.0;
    }

    public HeavyRock(double startDurability, double startLevelPoint)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetHardness(2.0);
        super.SetType(GameObjectType.HeavyRock);
        this.heat = 2.0;
    }

    public HeavyRock(double startDurability, double startLevelPoint, double startHardness, double startHeat)
    {
        super.SetDurability(startDurability);
        super.SetLevelPoint(startLevelPoint);
        super.SetHardness(startHardness);
        super.SetType(GameObjectType.HeavyRock);
        this.heat = startHeat;
    }

    public void SetHeat(double newHeat)
    {
        this.heat = newHeat;
    }

    public double GetHeat()
    {
        return this.heat;
    }

    public void ShowObjectStats()
    {
        System.out.println("Heavy Rock");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Hardness = " + super.GetHardness());
        System.out.println("Heat = " + this.heat);
    }

    public double CalculateAttackValue()
    {
        double finalAttackValue = 0.0;

        return finalAttackValue;
    }

    public void UpdateStats()
    {

    }
}
