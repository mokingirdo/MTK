package ru.nsu.ccfit.epanchintseva.mtk.auto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GetInput {
    public static void main(String[] args) {
        try {
            BufferedReader auto = new BufferedReader(new FileReader(args[0]));
            BufferedReader sequence = new BufferedReader(new FileReader(args[1]));
            new CheckSequence(sequence, new CreateAuto(auto));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
