import java.util.Random;
import java.util.Scanner;
public class Hero {
    private int hp;
    private int defence;
    private int strenth;
    private int orugie;
    private int shit;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public Hero(int hp, int defence, int strenth, int orugie, int shit){
        this.hp = hp;
        this.defence = defence;
        this.strenth = strenth;
        this.orugie = orugie;
        this.shit = shit;
    }
    public void startHeroForGonchaya(Gonchaya gonchaya){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int probablityAtackHero = random.nextInt(((3-1)+1)+1);
        System.out.println("Введите цифру для дальнейших деиствий 1:Атаковать 2:Ничего не делать 3:Защищаться");
        int choice = scanner.nextInt();
        scanner.close();
        switch (choice){
            case 1:
                if (probablityAtackHero >= 0){
                    int damage = this.strenth+this.orugie-gonchaya.getDefence();
                    gonchaya.setHp(gonchaya.getHp()-damage);
                    System.out.println("После атаки Hero в "+(this.strenth+this.orugie)+ "у Dragon осталось : " + gonchaya.getHp());
                }else if (probablityAtackHero < 0){
                    System.out.println("К сожалению Hero промазал");
                }else {
                    System.out.println("Произошла системная ошибка, подождите");
                }
                break;
            case 2:
                System.out.println("Герой решил ничего не делать");
                break;
            case 3:
                this.defence+= this.shit;
                break;
            default:
                System.out.println("Введите только вышеуказанные числа");
                break;
        }

    }
    public void startHeroAttack(Dragon dragon){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int probablityAtackHero = random.nextInt(((3-1)+1)+1);
        System.out.println("Введите цифру для дальнейших деиствий 1:Атаковать 2:Ничего не делать 3:Защищаться");
        int choice = scanner.nextInt();
        scanner.close();
        switch (choice){
            case 1:
                if (probablityAtackHero >= 0){
                    int damage = this.strenth+this.orugie- dragon.getDefence();
                    dragon.setHp(dragon.getHp()-damage);
                    System.out.println("После атаки Hero в "+(this.strenth+this.orugie)+ "у Dragon осталось : " + dragon.getHp());
                }else if (probablityAtackHero < 0){
                    System.out.println("К сожалению Hero промазал");
                }else {
                    System.out.println("Произошла системная ошибка, подождите");
                }
                break;
            case 2:
                System.out.println("Герой решил ничего не делать");
                break;
            case 3:
                this.defence+= this.shit;
                break;
            default:
                System.out.println("Введите только вышеуказанные числа");
                break;
        }

    }
}
