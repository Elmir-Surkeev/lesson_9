package old_file;

import java.util.Random;

public class Hero {
    private int hp;
    private int defence;
    private int atack;
    private int weapon;
    private int shield;

    public Hero(int hp, int defence, int atack, int weapon, int shield){
        this.hp = hp;
        this.defence = defence;
        this.atack = atack;
        this.weapon = weapon;
        this.shield = shield;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getAtack() {
        return atack;
    }
    public void attackDragon(Hero dragon){
        Random random = new Random();
        int maybeDragonWantToAttack = random.nextInt(((1-1)+1)+1);
        if (this.hp>0){
            //В тз не указано когда не захочет бить Дракон, сделал вариант, что 50 на 50
            //и также всегда бьет, чтобы код работал
            if (maybeDragonWantToAttack>0 || 1>0){
                int damageDragon = dragon.getAtack()+dragon.getWeapon()-this.shield;
                this.hp -=damageDragon;
                if(this.hp>0){
                    System.out.println("Жизнь Героя после атаки Дракона в "+ damageDragon+ " осталась = "+ this.hp);
                }
            }
            if(this.hp <= 0){
                System.out.println("Дракон победил Героя");
            }
        }else {
            System.out.println("Возникла ошибка в игре, нужно попробовать перезагрузить программу");
        }
    }
}