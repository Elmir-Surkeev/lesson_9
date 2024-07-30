import java.util.Random;
import java.util.Scanner;

public class Action {
    private final Random rnd = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private final Dragon dragon;
    private final Hero hero;

    public Action(Dragon dragon, Hero hero) {
        this.dragon = dragon;
        this.hero = hero;
    }

    public void startGame() {
        damageToDragon();
    }

    public void choiceToDo(){
        System.out.println("Выберите что будет делать герой");
        System.out.println("1:атаковать врага, 2: дать фору, 3: применить щит");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                damageToHero();
            case 2:
                System.out.println("Нападай я подожду");
            case 3:
                applyShield();
            default:
                System.out.println("Выходит ошибка, выберите 1,2,3");
        }

    }
    public void applyShield(){
        hero.setDefence(hero.getDefence()+hero.getShield());
    }
    private void damageToDragon() {
        int damageHero = getDamageHero();
        while (true) {
            int randomHeroAttack = rnd.nextInt(4);
            if (this.dragon.getHp() <= 0) {
                System.out.println("Герой победил");
                break;
            }
            if (this.hero.getHp() <= 0) {
                System.out.println("Дракон победил");
                break;
            }
            if (randomHeroAttack == 3) {
                System.out.println("Герой промахнулся");
                //damageToHero();
                choiceToDo();
                continue;
            }
            if (this.dragon.getHp() < damageHero) {
                this.dragon.setHp(0);
            } else {
                this.dragon.setHp(this.dragon.getHp() - damageHero);
                System.out.println("Герой нанес урон по дракону " + damageHero);
                System.out.println("Осталось хп у дракона " + dragon.getHp());
                System.out.println("================");
                //damageToHero();
                choiceToDo();
            }

        }
    }

    private void damageToHero() {
        if (this.dragon.getHp() <= 0) {
            return;
        }
        int damageDragon = getDamageDragon();
        int randomDragonAttack = rnd.nextInt(2);
        if (randomDragonAttack == 1) {
            System.out.println("Дракон не стал атаковать");
            return;
        }
        if (this.hero.getHp() < damageDragon) {
            this.hero.setHp(0);
        } else {
            System.out.println("Дракон атакует !!");
            this.hero.setHp(this.hero.getHp() - damageDragon);
            System.out.println("Дракон нанес урона герою " + damageDragon);
            System.out.println("Осталось хп у героя " + hero.getHp());
        }
    }

    private int getDamageHero() {
        return this.hero.getStrength() + this.hero.getWeapon() - this.dragon.getDefence();
    }

    private int getDamageDragon() {
        return this.dragon.getStrength() - this.hero.getDefence();
    }
}
