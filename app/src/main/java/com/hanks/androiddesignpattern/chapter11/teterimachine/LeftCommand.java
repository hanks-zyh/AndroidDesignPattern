package com.hanks.androiddesignpattern.chapter11.teterimachine;
/**
 * Created by hanks on 15-12-18.
 */
public class LeftCommand implements Command {

    TetriMachine tetriMachine;

    public LeftCommand(TetriMachine tetriMachine) {
        this.tetriMachine = tetriMachine;
    }

    @Override public void executed() {

        tetriMachine.toLeft();
    }
}
