import java.util.Random;
import java.util.Scanner;

public class Action {
    private final Random rnd = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private final Dragon dragon;
    private final Hero hero;
    private final Gonchaya gonchaya;
    public Action(Dragon dragon, Hero hero, Gonchaya gonchaya) {
        this.dragon = dragon;
        this.hero = hero;
        this.gonchaya = gonchaya;
    }

    public void startGame() {
        int randomEnemy = rnd.nextInt(2);
        if (randomEnemy ==1){
            while (this.dragon.getHp() > 0 && this.hero.getHp() > 0) {
                choiceToDo();
            }
        }else {
            while (this.gonchaya.getHp() > 0 && this.hero.getHp() > 0) {
                choiceToDoForGonchaya();
            }

            }
//        while (this.dragon.getHp() > 0 && this.hero.getHp() > 0) {
//            choiceToDo();
//        }
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
                choiceToDo();
        }
    }
    public void choiceToDoForGonchaya(){
        System.out.println("Выберите что будет делать герой");
        System.out.println("1: атаковать врага, 2: ничего не делать, 3: применить щит");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                if (this.gonchaya.getHp() <= 0) {
                    System.out.println("Герой победил");
                    return;
                }
                damageToGonchaya();
                damageToHeroGonchaya();
                if (this.hero.getHp() <= 0) {
                    System.out.println("Гончая победила");
                    return;
                }
                break;
            case 2:
                if (this.hero.getHp() <= 0) {
                    System.out.println("Гончая победила");
                    return;
                }
                System.out.println("Герой ничего не делает.");
                damageToHeroGonchaya();
                break;
            case 3:
                applyShield();
                break;
            default:
                System.out.println("Неверный выбор, выберите 1, 2 или 3");
                choiceToDoForGonchaya();
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
    private void damageToGonchaya() {
        int damageHero = getDamageHero();
        int randomHeroAttack = rnd.nextInt(4);
        if (randomHeroAttack == 3) {
            System.out.println("Герой промахнулся");
            damageToHeroGonchaya();
            return;
        }
        if (this.gonchaya.getHp() <= damageHero) {
            this.gonchaya.setHp(0);
            System.out.println("Герой нанес урон по Гончей " + damageHero);
            System.out.println("Гончая повержен.");
        } else {
            this.gonchaya.setHp(this.gonchaya.getHp() - damageHero);
            System.out.println("Герой нанес урон по Гончей " + damageHero);
            System.out.println("Осталось хп у Гончей " + gonchaya.getHp());
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
    private void damageToHeroGonchaya() {
        if (this.gonchaya.getHp() <= 0) {
            return;
        }
        int damageGonchaya = getDamageGonchaya();
        int randomGonchayaAttack = rnd.nextInt(2);
        if (randomGonchayaAttack == 1) {
            System.out.println("Гончая не стала атаковать");
            return;
        }
        if (this.hero.getHp() <= damageGonchaya) {
            this.hero.setHp(0);
            System.out.println("Гончая нанесла урона герою " + damageGonchaya);
            System.out.println("Герой повержен.");
        } else {
            this.hero.setHp(this.hero.getHp() - damageGonchaya);
            System.out.println("Гончая атакует и наносит урон герою " + damageGonchaya);
            System.out.println("Осталось хп у героя " + hero.getHp());
        }
    }

    private int getDamageHero() {
        return this.hero.getStrength() + this.hero.getWeapon() - this.dragon.getDefence();
    }

    private int getDamageDragon() {
        return this.dragon.getStrength() - this.hero.getDefence();
    }
    private int getDamageGonchaya() {
        return this.gonchaya.getStrength() - this.hero.getDefence();
    }
}
