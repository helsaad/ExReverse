package language.Threads;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

public class Producer implements Runnable{
    private List<String> buffer;
    public ReentrantLock bufferLock;

    public Producer(List<String> buffer,ReentrantLock bufferLock){
        this.buffer= buffer;
        this.bufferLock =bufferLock;
    }
    public void run(){
        String StrName[] ={"Texas", "Oklahoma", "New Orleans", "California", "New York", "New Hampshire", "Maine",
                "Virginia", "Florida", "Illinois", "North Carolina", "Washington", "New Mexico", "Alaska", "Hawaii"};
        Random random = new Random();
        for (String stringName : StrName){
            synchronized (buffer){
                buffer.add(stringName);
                try{
                    Thread.sleep(random.nextInt(1000));
                }catch (InterruptedException e){
                }
            }
            System.out.println(Thread.currentThread().getName()+ "Reversing..." + reverse(stringName));
        }
        System.out.println(Thread.currentThread().getName()+ "Reversing..."+ reverse(language.Threads.Main.EOF));
        synchronized (buffer){
            buffer.add(language.Threads.Main.EOF);
        }
    }
    public static String reverse(String set){
        return new StringBuffer(set).reverse().toString();
    }
}

