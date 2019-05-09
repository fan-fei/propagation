package propagation;

@FunctionalInterface
interface AddOperation {
    void add(int a, int b);
}

@FunctionalInterface
interface SubtractOperation {
    void subtract(int a, int b);
}

public class Calculation {

    public void add(AddOperation addOperation, int a, int b) {
        addOperation.add(a, b);
    }

    public void subtract(AddOperation addOperation, int a, int b) {
        addOperation.add(a, b);
    }

    public static void main(String[] args) {
        Calculation myClass = new Calculation();

        myClass.add((a, b) -> System.out.println(a + b), 3, 4);
        myClass.subtract((a, b) -> System.out.println(a - b), 3, 4);

    }
}