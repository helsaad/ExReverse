package language.Threads;

import java.util.List;
import java.util.Random;

public class Consumer implements Runnable {
    private List<String> buffer;

    public Consumer(List <String> buffer) {this.buffer =buffer;}

    @Override
    public void run() {
        while (true){
            synchronized (buffer){
                if (buffer.isEmpty()){
                    continue;
                }
                if (buffer.get(0).equals(language.Threads.Main.EOF)){
                    System.out.println(Thread.currentThread().getName() + "Exiting");
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName() + language.Threads.Producer.reverse(buffer.remove(0)));
                try{
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                }catch (InterruptedException e){
                    System.out.println(Thread.currentThread().getName()+ "Interrupted");
                }
                }
            }
        }
    }
}
