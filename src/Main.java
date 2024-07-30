import java.util.Random;
public class Main {
    public static void main(String[] args) {
            Random random = new Random();
            int probablityDragonOrGonchaya = random.nextInt(2);
            if (probablityDragonOrGonchaya<=1){
                startGame();
            }else {
                startGameGonchaya();
            }
    }
    public static void startGameGonchaya(){
        Hero hero = new Hero(1000, 100, 120, 250, 150);
        Gonchaya gonchaya = new Gonchaya(2500, 1000, 250, 50);
        //////////////////////////
        for (int i=0; i<15; i++){
            if (gonchaya.getHp()>0 && hero.getHp() > 0){
                hero.startHeroForGonchaya(gonchaya);
                gonchaya.startGonchayaAttack(hero);
            }else if (gonchaya.getHp()<0){
                System.out.println("Игра закончена победил Hero");
                break;
            }else if(hero.getHp() < 0){
                System.out.println("Игра закончена победил Gonchaya");
                break;
            }
        }
    }
    public static void startGame(){
        Hero hero = new Hero(1000, 100, 120, 250, 150);
        Dragon dragon = new Dragon(2000, 120, 150, 0);
        //while (true){//}
        for (int i=0; i<15; i++){
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

