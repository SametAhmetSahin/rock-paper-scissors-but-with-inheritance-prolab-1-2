package Objects;

public abstract class Object
{
    private int durability;
    private int levelPoint;

    public Object()
    {
        // Dökümanda belirtilen varsayılan değerler
        this.durability = 20;
        this.levelPoint = 0;
    }

    public Object(int startDurability, int startLevelPoint)
    {
        this.durability = startDurability;
        this.levelPoint = startLevelPoint;
    }

    public void SetDurability(int newDurability)
    {
        this.durability = newDurability;
    }

    public void SetLevelPoint(int newLevelPoint)
    {
        this.levelPoint = newLevelPoint;
    }

    public int GetDurability()
    {
        return this.durability;
    }

    public int GetLevelPoint()
    {
        return this.levelPoint;
    }

    public void ShowObjectStats()
    {
        System.out.println("This object's durability = " + durability);
        System.out.println("This object's level point = " + levelPoint);
    }

    public int CalculateAttackValue()
    {
        return 2 + 2;
    }

    public void UpdateStats()
    {
        System.out.println("Something happened.");
    }
}
