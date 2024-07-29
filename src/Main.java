//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
            int probablityAtackHero = random.nextInt(((5555-1)+1)+1);
            if (probablityAtackHero >1){
                Dragon dragon = new Dragon(2000, 120, 150, 0);
                Hero hero = new Hero(100, 100, 125, 250, 150);
                dragon.attackHero(hero);
            }else{
                System.out.println("Герой промазал, ждем ответного удара от Дракона");
            }
    }
}