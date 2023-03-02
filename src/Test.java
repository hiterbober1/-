import javax.naming.OperationNotSupportedException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        while (true) {
            int input = k.nextInt();

            if (input != 0) {
                try {
                    throw new OperationNotSupportedException();
                } catch (OperationNotSupportedException e) {
                    System.out.println("bebra");
                }
            }
        }
    }
}
