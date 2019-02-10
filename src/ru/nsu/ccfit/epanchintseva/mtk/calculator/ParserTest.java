package ru.nsu.ccfit.epanchintseva.mtk.calculator;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
   void parseExpression() throws Exception {
        StringReader reader = new StringReader("24601 + 10 - 600     -4000");
        Parser parser = new Parser(reader);
        assertEquals(20011, parser.parseExpression());
    }

    @Test
     void parseTerm() throws Exception {
        StringReader reader = new StringReader("2*3*4*5/6");
        Parser parser = new Parser(reader);
        assertEquals(20, parser.parseTerm());
    }

    @Test
   void parseFactor() throws Exception {
        StringReader reader = new StringReader("3^2^2");
        Parser parser = new Parser(reader);
        assertEquals(81, parser.parseFactor());
    }

    @Test
     void parsePower() throws Exception {
        StringReader reader = new StringReader("-6867967");
        Parser parser = new Parser(reader);
        assertEquals(-6867967, parser.parsePower());
    }

    @Test
     void parseAtom() throws Exception {
        StringReader reader = new StringReader("((-5)*2^(20-10)+20)");
        Parser parser = new Parser(reader);
        assertEquals(-5100, parser.parseAtom());
    }
}