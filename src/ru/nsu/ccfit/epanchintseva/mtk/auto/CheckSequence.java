package ru.nsu.ccfit.epanchintseva.mtk.auto;

import java.io.BufferedReader;
import java.io.IOException;

public class CheckSequence implements Runnable{

    BufferedReader reader;
    CreateAuto auto;

    CheckSequence(BufferedReader reader, CreateAuto auto){
        this.reader = reader;
        this.auto = auto;
        this.run();
    }

    @Override
    public void run() {
        int state;
        String cur;
        try {
            while ((cur = reader.readLine()) != null){
                state = 1;
                for (int i = 0; i < cur.length(); i++){
                    state = auto.auto.get(state + cur.substring(i,i));
                }
                if(auto.fin.contains(Integer.valueOf(state))){
                    System.out.println(state + " is final state\n");
                } else {
                    System.out.println(state + " not final state\n");
                }
            }
        } catch (IOException ignored){

        }
    }
}
