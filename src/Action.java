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
        while (this.dragon.getHp() > 0 && this.hero.getHp() > 0) {
            choiceToDo();
        }
    }

    public void choiceToDo(){
        System.out.println("Выберите что будет делать герой");
        System.out.println("1: атаковать врага, 2: ничего не делать, 3: применить щит");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                damageToDragon();
                if (this.dragon.getHp() <= 0) {
                    System.out.println("Герой победил");
                    return;
                }
                damageToHero();
                if (this.hero.getHp() <= 0) {
                    System.out.println("Дракон победил");
                    return;
                }
                break;
            case 2:
                System.out.println("Герой ничего не делает.");
                damageToHero();
                if (this.hero.getHp() <= 0) {
                    System.out.println("Дракон победил");
                    return;
                }
                break;
            case 3:
                applyShield();
                break;
            default:
                System.out.println("Неверный выбор, выберите 1, 2 или 3");
                choiceToDo(); // Повторить выбор
        }
    }

    public void applyShield() {
        hero.setDefence(hero.getDefence() + hero.getShield());
        System.out.println("Защита = " + hero.getDefence());
        damageToHero();
    }

    private void damageToDragon() {
        int damageHero = getDamageHero();
        int randomHeroAttack = rnd.nextInt(4);
        if (randomHeroAttack == 3) {
            System.out.println("Герой промахнулся");
            damageToHero();
            return;
        }
        if (this.dragon.getHp() <= damageHero) {
            this.dragon.setHp(0);
            System.out.println("Герой нанес урон по дракону " + damageHero);
            System.out.println("Дракон повержен.");
        } else {
            this.dragon.setHp(this.dragon.getHp() - damageHero);
            System.out.println("Герой нанес урон по дракону " + damageHero);
            System.out.println("Осталось хп у дракона " + dragon.getHp());
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
        if (this.hero.getHp() <= damageDragon) {
            this.hero.setHp(0);
            System.out.println("Дракон нанес урона герою " + damageDragon);
            System.out.println("Герой повержен.");
        } else {
            this.hero.setHp(this.hero.getHp() - damageDragon);
            System.out.println("Дракон атакует и наносит урон герою " + damageDragon);
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
