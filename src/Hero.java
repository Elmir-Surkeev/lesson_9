public class Hero {
    private int hp;
    private int strength;
    private int defence;
    private int weapon;
    private int shield;

    public Hero(int hp, int strength, int defence, int weapon, int shield) {
        this.hp = hp;
        this.strength = strength;
        this.defence = defence;
        this.weapon = weapon;
        this.shield = shield;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }
}
