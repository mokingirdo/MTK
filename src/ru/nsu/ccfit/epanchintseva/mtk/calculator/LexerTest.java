package ru.nsu.ccfit.epanchintseva.mtk.calculator;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @org.junit.Test
    public void getLexeme() throws Exception {
        Lexer lexer;
        Lexeme  lexeme;
        //Space
        StringReader readerSpace = new StringReader("    (");
        lexer = new Lexer(readerSpace);
        lexeme = lexer.getLexeme();
        assertEquals(LexemeType.LEFT_BRACKET, lexeme.type);
        //EOF
        lexeme = lexer.getLexeme();
        assertEquals(LexemeType.EOF, lexeme.type);
        //Lexeme
        StringReader readerLex = new StringReader("(102345^+   /  -*       )");
        lexer = new Lexer(readerLex);
        lexeme = lexer.getLexeme();
        assertEquals("(", lexeme.lexemeText.toString());
        assertEquals(LexemeType.LEFT_BRACKET, lexeme.type);
        lexeme = lexer.getLexeme();
        assertEquals("102345", lexeme.lexemeText.toString());
        assertEquals(LexemeType.NUMBER, lexeme.type);
        lexeme = lexer.getLexeme();
        assertEquals("^", lexeme.lexemeText.toString());
        assertEquals(LexemeType.DEGREE, lexeme.type);
        lexeme = lexer.getLexeme();
        assertEquals("+", lexeme.lexemeText.toString());
        assertEquals(LexemeType.PLUS, lexeme.type);
        lexeme = lexer.getLexeme();
        assertEquals("/", lexeme.lexemeText.toString());
        assertEquals(LexemeType.MULTIPLY_DIVIDE, lexeme.type);
        lexeme = lexer.getLexeme();
        assertEquals("-", lexeme.lexemeText.toString());
        assertEquals(LexemeType.MINUS, lexeme.type);
        lexeme = lexer.getLexeme();
        assertEquals("*", lexeme.lexemeText.toString());
        assertEquals(LexemeType.MULTIPLY_DIVIDE, lexeme.type);
        lexeme = lexer.getLexeme();
        assertEquals(")", lexeme.lexemeText.toString());
        assertEquals(LexemeType.RIGHT_BRACKET, lexeme.type);
    }

}