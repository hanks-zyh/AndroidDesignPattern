package com.hanks.androiddesignpattern.charpter11;
/**
 * Created by hanks on 15-12-18.
 */
public class FallCommand implements Command {
    TetriMachine tetriMachine;

    public FallCommand(TetriMachine tetriMachine) {
        this.tetriMachine = tetriMachine;
    }

    @Override public void executed() {
        tetriMachine.fastToBottom();
    }
}

