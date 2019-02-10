package ru.nsu.ccfit.epanchintseva.mtk.calculator;

import java.io.IOException;
import java.io.StringReader;

public class Main {
    public static void main(String[] args) {
        try {
            LexerTest test1 = new LexerTest();
            test1.getLexeme();
            ParserTest test2 = new ParserTest();
            test2.parseExpression();
            test2.parseTerm();
            test2.parseFactor();
            test2.parsePower();
            test2.parseAtom();
            StringReader reader = new StringReader("((-5)*2^(20-10)+20)/100");
            Parser parser = new Parser(reader);
            int temp = parser.parseExpression();
            System.out.println(temp);
        } catch (IOException | LexerException | ParserException e) {
            e.getMessage();
        }
        catch (Exception ignored){
        }
    }
}
