import java.util.Random;

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
    public void startHeroAttack(Dragon dragon){
        Random random = new Random();
        int probablityAtackHero = random.nextInt(((3-1)+1)+1);
        if (probablityAtackHero >= 0){
            int damage = this.strenth+this.orugie- dragon.getDefence();
            dragon.setHp(dragon.getHp()-damage);
            System.out.println("После атаки Hero "+ "у Dragon осталось : " + dragon.getHp());
        }else if (probablityAtackHero < 0){
            System.out.println("К сожалению Hero промазал");
        }else {
            System.out.println("Произошла системная ошибка, подождите");
        }
    }
}
