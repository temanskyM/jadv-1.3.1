public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread user = new Thread(new Box());
        user.setName("User");

        Thread comp = new Thread(new Box());
        comp.setName("Computer");

        user.start();
        comp.start();

        user.join();
        System.out.println("Работа окончена");
    }
}
