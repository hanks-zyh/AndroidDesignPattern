package com.hanks.androiddesignpattern.charpter11;
/**
 * Created by hanks on 15-12-18.
 */
public class TransfromCommand implements Command {
    TetriMachine tetriMachine;

    public TransfromCommand(TetriMachine tetriMachine) {
        this.tetriMachine = tetriMachine;
    }

    @Override public void executed() {
        tetriMachine.transform();
    }
}
