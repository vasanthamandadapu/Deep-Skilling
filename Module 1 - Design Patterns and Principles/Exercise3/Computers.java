public class Computers {

    private String CPU;
    private int RAM;
    private int Storage;

    // Private Constructor
    private Computers(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }

    public void display() {
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM + " GB");
        System.out.println("Storage: " + Storage + " GB");
        System.out.println();
    }

    // Static Nested Builder Class
    public static class Builder {

        private String CPU;
        private int RAM;
        private int Storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int Storage) {
            this.Storage = Storage;
            return this;
        }

        public Computers build() {
            return new Computers(this);
        }
    }
}