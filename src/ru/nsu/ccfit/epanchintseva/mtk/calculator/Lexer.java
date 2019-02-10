package ru.nsu.ccfit.epanchintseva.mtk.calculator;

import java.io.IOException;
import java.io.Reader;

class Lexer {
    private Reader reader;
    Lexeme currentLexeme;
    private int curr;

    Lexer(Reader reader) {
        this.reader = reader;
        currentLexeme = new Lexeme();
    }

    Lexeme getLexeme() throws IOException, LexerException {

        if (curr == 0) {
            curr = reader.read();
        }
        currentLexeme.lexemeText.delete(0, currentLexeme.lexemeText.length());
        currentLexeme.lexemeText.append((char) curr);

        while (Character.isSpaceChar(curr)) {
            curr = reader.read();
        }
        if (curr == -1) {
            currentLexeme.type = LexemeType.EOF;
            return currentLexeme;
        }

        switch ((char) curr) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9': {
                currentLexeme.type = LexemeType.NUMBER;
                while (Character.isDigit(curr)) {
                    curr = reader.read();
                    if(Character.isDigit(curr)) {
                        currentLexeme.lexemeText.append((char) curr);
                    }
                }
                break;
            }
            case '+': {
                currentLexeme.type = LexemeType.PLUS;
                curr = 0;
                break;
            }
            case '-': {
                currentLexeme.type = LexemeType.MINUS;
                curr = 0;
                break;
            }
            case '*':
            case '/': {
                currentLexeme.type = LexemeType.MULTIPLY_DIVIDE;
                curr = 0;
                break;
            }
            case '(': {
                currentLexeme.type = LexemeType.LEFT_BRACKET;
                curr = 0;
                break;
            }
            case ')': {
                currentLexeme.type = LexemeType.RIGHT_BRACKET;
                curr = 0;
                break;
            }
            case '^': {
                currentLexeme.type = LexemeType.DEGREE;
                curr = 0;
                break;
            }
            default:
                throw new LexerException();
        }
        return currentLexeme;
    }
}
