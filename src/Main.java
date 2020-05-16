public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> array = new ArrayStack<Integer>();
        for (int i = 0; i < 10; i++) {
            array.push(i);
        }
        System.out.println(array);
        array.pop();
        System.out.println(array);
    }
}