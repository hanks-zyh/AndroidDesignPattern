package com.hanks.androiddesignpattern.charpter11;
/**
 * Created by hanks on 15-12-18.
 */
public class RightCommand implements Command {
    TetriMachine tetriMachine;

    public RightCommand(TetriMachine tetriMachine) {
        this.tetriMachine = tetriMachine;
    }

    @Override public void executed() {
        tetriMachine.toRight();
    }
}
