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

    public void ShowObjectStats()
    {
        System.out.println("Special Paper");
        System.out.println("Durability = " + super.GetDurability());
        System.out.println("Level point = " + super.GetLevelPoint());
        System.out.println("Influence = " + super.GetInfluence());
        System.out.println("Thickness = " + this.thickness);
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
