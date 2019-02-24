package ru.nsu.ccfit.epanchintseva.mtk.auto;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateAuto implements Runnable{

    Map<String, Integer> auto;
    Set<Integer> fin;
    BufferedReader reader;

    CreateAuto(BufferedReader reader){
        this.reader = reader;
        auto = new HashMap<>();
        fin = new HashSet<>();
        this.run();
    }


    @Override
    public void run() {
        String cur;
        try {
            while ((cur = reader.readLine()) != null){
                if(cur.length() > 1) {
                    auto.put(cur.substring(0,1), Integer.parseInt(cur.substring(2)));
                } else{
                    fin.add(Integer.parseInt(cur));
                }
            }
        } catch (IOException ignored){

        }
    }
}
