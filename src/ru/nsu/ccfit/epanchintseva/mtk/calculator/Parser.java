package ru.nsu.ccfit.epanchintseva.mtk.calculator;

import java.io.IOException;
import java.io.Reader;

class Parser {
    private Lexer lexer;
    private Lexeme current;

    Parser(Reader reader) throws LexerException, IOException {
        lexer = new Lexer(reader);
        current = new Lexeme();
        current = lexer.getLexeme();
    }

    int parseExpression() throws LexerException, IOException, ParserException {
        int sign = 0;
        int temp = this.parseTerm();

        while (current.type == LexemeType.PLUS || current.type == LexemeType.MINUS) {
            if (current.type == LexemeType.PLUS) {
                sign = 1;
            }
            if (current.type == LexemeType.MINUS) {
                sign = -1;
            }
            current = lexer.getLexeme();
            temp += sign * this.parseTerm();
        }
        return temp;
    }

    int parseTerm() throws LexerException, IOException, ParserException {
        int temp = this.parseFactor();

        while (current.type == LexemeType.MULTIPLY_DIVIDE) {
            if (current.lexemeText.charAt(0) == '*') {
                current = lexer.getLexeme();
                temp *= this.parseFactor();
            }
            if (current.lexemeText.charAt(0) == '/') {
                current = lexer.getLexeme();
                temp /= this.parseFactor();
            }
        }
        return temp;
    }

    int parseFactor() throws LexerException, IOException, ParserException {
        int temp = this.parsePower();
        if (current.type == LexemeType.DEGREE) {
            current = lexer.getLexeme();
            return (int) Math.pow(temp, this.parseFactor());
        }
        return temp;
    }

    int parsePower() throws LexerException, IOException, ParserException {
        int sign = 1;
        if (current.type == LexemeType.MINUS) {
            sign = -1;
            current = lexer.getLexeme();
        }
        return sign * this.parseAtom();
    }

    int parseAtom() throws LexerException, IOException, ParserException {
        int temp = 0;
        if (current.type == LexemeType.NUMBER) {
            temp = Integer.valueOf(current.lexemeText.toString());
            current = lexer.getLexeme();
        }
        if (current.type == LexemeType.LEFT_BRACKET) {
            current = lexer.getLexeme();
            temp = parseExpression();
            if (current.type != LexemeType.RIGHT_BRACKET) {
                throw new ParserException();
            }
            current = lexer.getLexeme();
        }

        return temp;
    }
}
