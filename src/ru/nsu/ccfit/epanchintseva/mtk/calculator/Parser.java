package ru.nsu.ccfit.epanchintseva.mtk.calculator;

import java.io.Reader;

class Parser {
    private Lexer lexer;
    private Lexeme current;

    Parser(Reader reader){
        lexer = new Lexer(reader);
        current = new Lexeme();
    }
}
