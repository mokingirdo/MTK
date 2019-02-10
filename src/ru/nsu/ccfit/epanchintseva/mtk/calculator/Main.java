package ru.nsu.ccfit.epanchintseva.mtk.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\yule2\\IdeaProjects\\Calculator\\src\\ru\\nsu\\ccfit\\epanchintseva\\mtk\\calculator\\input.txt"));
            Lexer lexer = new Lexer(reader);
            while (lexer.getLexeme() != null) {
                System.out.println(lexer.currentLexeme.type + "  " + lexer.currentLexeme.lexemeText + '\n');
            }
        } catch (IOException | LexerException e) {
            e.getMessage();
        }
    }
}
