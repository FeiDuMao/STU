import org.junit.jupiter.api.Test;

public class MathResolve {


    @Test
    public void resolve() {
        for (int i = 1; i < 2001; i++) {
            if (isPrime(i) && isPrime(2001 - i)) {
                System.out.println("result = " + i * (2001 - i));
                break;
            }
        }
    }

   @Test
    public void resolve2() {


        for (int i = 1; i < 2001; i++) {
            if (isPrime(i) && isPrime(2001 - i)) {
                System.out.println("result = " + i * (2001 - i));
                break;
            }
        }
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
