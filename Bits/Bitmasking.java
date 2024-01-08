public class Bitmasking {
    private int bitmask;

    public Bitmasking() {
        this.bitmask = 0;
    }

    public void add(int x) {
        bitmask = bitmask | (1 << x);
    }

    public void remove(int x) {
        bitmask = bitmask & ~(1 << x);
    }

    public void print() {
        System.out.print("Set: ");

        for (int i = 0; i < 32; i++) {
            if ((bitmask & (1 << i)) != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Bitmasking set = new Bitmasking();

        set.add(1);
        set.add(7);
        set.add(3);

        set.print();

        set.remove(3);

        set.print();
    }
}
