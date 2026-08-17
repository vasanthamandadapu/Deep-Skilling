public class BuilderTest {

    public static void main(String[] args) {

        Computers computers1 = new Computers.Builder()
                .setCPU("Intel i5")
                .setRAM(8)
                .setStorage(512)
                .build();

        Computers computers2 = new Computers.Builder()
                .setCPU("Intel i7")
                .setRAM(16)
                .setStorage(1024)
                .build();

        System.out.println("Computer 1 Details:");
        computers1.display();

        System.out.println("Computer 2 Details:");
        computers2.display();
    }
}