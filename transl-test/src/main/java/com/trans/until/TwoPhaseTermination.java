package com.trans.until;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ZouJiaJun
 * @Title: TwoPhaseTermination
 * @Package: com.trans.until
 * @Description:
 * @Date: 2022/8/2 - 15:05
 */

public class TwoPhaseTermination {
    private Thread monitor;
    private volatile Integer size;

    public TwoPhaseTermination() {
    }

    public void start(List<Object> list){
        monitor = new Thread(()->{
            for (int i = 0; i < 10; i++){
                Thread currentThread = Thread.currentThread();
                if(currentThread.isInterrupted()){
                    System.out.println("数据满了！");
                    break;
                }
                try {
                    list.add(i);
                    size = list.size();
                    System.out.println(size);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    currentThread.interrupt();
                }
            }

        });
        monitor.start();
    }

    public void stop(){
        while (true){
            if(size == 5){
                monitor.interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination termination = new TwoPhaseTermination();
        ArrayList<Object> list = new ArrayList<>();
        termination.start(list);
        TimeUnit.SECONDS.sleep(1);
        termination.stop();
    }
}
