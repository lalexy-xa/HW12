import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2 {
    private static Queue<String> queue = new ConcurrentLinkedQueue<String>();
    private static int n = 15;
    static void fizz (int n){
        if(n % 3 == 0 && n % 5 != 0){
            queue.add("fizz");
        }
    }
    static void buzz (int n){
        if(n % 5 == 0 && n % 3 != 0){
            queue.add("buzz");
        }
    }

    static void fizzbuzz(int n){
        if(n % 3 == 0 && n % 5 == 0){
            queue.add("fizzbuzz");
        }
    }

    static  void  number(){
        System.out.println(queue);
    }
    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= n; i++){
            final int k = i;
            Thread A = new Thread(() -> fizz(k));
            A.start();
            A.join();
            Thread B = new Thread(() -> buzz(k));
            B.start();
            B.join();
            Thread C = new Thread(() -> fizzbuzz(k));
            C.start();
            C.join();

            if(queue.size() < i){
                queue.add(String.valueOf(i));
            }
        }

        Thread D = new Thread(() -> number());
        D.start();
    }
}
