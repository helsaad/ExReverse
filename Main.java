package language.Threads;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import static language.Threads.Main.EOF;

public class Main {

    public static final String EOF= "EOF";
    public static void main(String[] args) {

        List<String>buffer = new ArrayList<String>();
        ReentrantLock bufferlock = new ReentrantLock();
        Thread Producer = new Thread(new language.Threads.Producer(buffer,bufferlock));
        Producer.setName(ThreadColor.ANSI_CYAN + "Producer Thread: ");
        Thread Consumer1 = new Thread(new language.Threads.Producer(buffer,bufferlock));
        Consumer1.setName(ThreadColor.ANSI_BLUE + "Consumer One Thread: ");
        Thread Consumer2 = new Thread(new language.Threads.Producer(buffer,bufferlock));
        Consumer2.setName(ThreadColor.ANSI_PURPlE + "Consumer Two Thread: ");
        Thread Consumer3 = new Thread(new language.Threads.Producer(buffer,bufferlock));
        Consumer3.setName(ThreadColor.ANSI_GREEN + "Consumer Three Thread: ");

        Producer.start();
        Consumer1.start();
        Consumer2.start();
        Consumer3.start();


}
}
