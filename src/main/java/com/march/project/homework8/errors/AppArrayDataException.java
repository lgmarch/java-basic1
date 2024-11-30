package com.march.project.homework8.errors;

public class AppArrayDataException extends Exception {
    private final int line;
    private final int column;
    public AppArrayDataException(String msg, int line, int column) {
        super(msg);
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}
