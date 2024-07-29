import java.util.Random;
public class Main {
    public static void main(String[] args) {
            startGame();
    }
    public static void startGame(){
        Hero hero = new Hero(1000, 100, 120, 250, 150);
        Dragon dragon = new Dragon(2000, 120, 150, 0);
        while (true){
            if (dragon.getHp()>0 && hero.getHp() > 0){
                hero.startHeroAttack(dragon);
                dragon.startDragonAttack(hero);
            }else if (dragon.getHp()<0){
                System.out.println("Игра закончена победил Hero");
                break;
            }else if(hero.getHp() < 0){
                System.out.println("Игра закончена победил Dragon");
                break;
            }
        }
    }
}

