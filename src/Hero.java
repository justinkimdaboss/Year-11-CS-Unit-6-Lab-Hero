import java.util.Random;

public class Hero
{
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void attack(Hero opponent)
    {
        double randomNumber = Math.random();

        if (randomNumber < 0.5)
        {
            opponent.hitPoints = opponent.getHitPoints() - 10;
        }
        else
        {
            hitPoints = hitPoints - 10;
        }
    }
    public void senzuBean()
    {
        hitPoints = 100;
    }
    private void fightUntilTheDeathHelper(Hero opponent)
    {
        while((this.hitPoints > 0) && (opponent.getHitPoints() >0))
        {
            this.attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent)
    {
        senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ": " + hitPoints + opponent.getName() + ": " + opponent.getHitPoints();
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n)
    {
        int heroDubs = 0;
        int opponentDubs = 0;
        int dubs[] = new int[2];
        while (n > 0)
        {
            fightUntilTheDeath(opponent);
            senzuBean();
            opponent.senzuBean();
            n = n - 1;

            if (hitPoints > 0)
            {
                heroDubs++;
                dubs[0] = heroDubs;
                dubs[1] = opponentDubs;
                return dubs;
            }
            else
            {
                opponentDubs++;
                dubs[0] = heroDubs;
                dubs[1] = opponentDubs;
                return dubs;
            }
        }
        return null;
    }

    public String nFightsToTheDeath(Hero opponent, int n)
    {
        int dubs[] = nFightsToTheDeathHelper(opponent, n);

        String firstL = name + ": " + dubs[0] + "wins";
        String secondL = opponent.getName() + ": " + dubs[1] + "wins";
        String thirdL = "";

        if (dubs[0] > dubs[1]) {
            thirdL = name + " wins!";
        }
        else if (dubs[0] == dubs[1]) {
            thirdL = "DRAW!";
        }
        else {
            thirdL = opponent.getName() + " wins!";
        }
        return firstL + secondL + thirdL;
    }

    public void dramaticFightToTheDeath(Hero opponent)
    {
    }
}
