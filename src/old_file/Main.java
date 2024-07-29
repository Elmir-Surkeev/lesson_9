package old_file;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import old_file.Dragon;
import old_file.Hero;

import java.util.Random;
public class Main {
    public static void main(String[] args) {
        //while (true){
            startGame();
            startGame();
            startGame();
            startGame();
        //}
    }
    public static void startGame(){
        Dragon dragon = new Dragon(2000, 120, 150, 0);
        Hero hero = new Hero(1000, 100, 120, 250, 150);
        Random random = new Random();

        int probablityAtackHero = random.nextInt(((3-1)+1)+1);
            if (probablityAtackHero >1){
                dragon.attackHero(hero);
            }else{
                System.out.println("Герой промазал, ждем ответного удара от Дракона");
            }
    }
}