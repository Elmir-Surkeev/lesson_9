//import java.util.Random;
//
//public class Dragon {
//    public int getHp() {
//        return hp;
//    }
//
//    public void setHp(int hp) {
//
//        this.hp = hp;
//    }
//
//    public int getDefence() {
//        return defence;
//    }
//
//    public void setDefence(int defence) {
//        this.defence = defence;
//    }
//
//    private int hp;
//    private int defence;
//    private int strenth;
//    private int orugie;
//    public Dragon(int hp, int defence, int strenth, int orugie){
//        this.hp = hp;
//        this.defence = defence;
//        this.strenth = strenth;
//        this.orugie = orugie;
//    }
//
//    public void startDragonAttack(Hero hero){
//        Random random = new Random();
//        int probablityAtackHero = random.nextInt(2);
//        if (probablityAtackHero>0){
//            int damage = this.strenth+this.orugie- hero.getDefence();
//            hero.setHp(hero.getHp()-damage);
//            System.out.println("После атаки Dragon в "+(this.strenth+this.orugie)+ "у Hero осталось : " + hero.getHp());
//        }else if(probablityAtackHero<=0){
//            System.out.println("Dragon  решил не атаковать");
//        }
//    }
//}