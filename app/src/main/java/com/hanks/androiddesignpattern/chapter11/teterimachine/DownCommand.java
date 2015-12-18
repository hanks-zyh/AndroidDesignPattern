package com.hanks.androiddesignpattern.chapter11.teterimachine;
/**
 * Created by hanks on 15-12-18.
 */
public class DownCommand implements Command {
    TetriMachine tetriMachine;

    public DownCommand(TetriMachine tetriMachine) {
        this.tetriMachine = tetriMachine;
    }

    @Override public void executed() {
        tetriMachine.toDown();
    }
}
