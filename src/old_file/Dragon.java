package old_file;

public class Dragon {
    private int hp;
    private int defence;
    private int attack;

    private int weapon;

    public int getDefence() {
        return defence;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Dragon(int hp, int defence, int attack, int weapon){
        this.hp = hp;
        this.defence = defence;
        this.attack = attack;
        this.weapon = weapon;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
    public void attackHero(Hero hero){
        if (this.hp>0){
            int damageHero = hero.getAtack()+ hero.getWeapon()+this.defence;
            this.hp-=damageHero;
            //System.out.println("Жизнь Дракона после атаки Героя в "+ damageHero+" осталась = " + this.hp);
            hero.attackDragon(hero);
        }else if (this.hp<0){
            //System.out.println("Герой победил Дракона");
        }else {
            //System.out.println("Произошла ошибка в ходе игры, зайдите заново");
        }
    }
}