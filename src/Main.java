public class Main {
    public static void main(String[] args) {
        Dragon dragon = new Dragon(2000, 200, 150);
        Hero hero = new Hero(1000, 100, 120, 250, 150);
        Action action = new Action(dragon, hero);
        action.startGame();
    }
}
