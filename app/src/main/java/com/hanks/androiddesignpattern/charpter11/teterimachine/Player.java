package com.hanks.androiddesignpattern.charpter11.teterimachine;
/**
 * Created by hanks on 15-12-18.
 */
public class Player {
    public void main() {
        TetriMachine tetriMachine = new TetriMachine();

        LeftCommand leftCommand = new LeftCommand(tetriMachine);
        RightCommand rightCommand = new RightCommand(tetriMachine);
        DownCommand downCommand = new DownCommand(tetriMachine);
        FallCommand fallCommand = new FallCommand(tetriMachine);
        TransfromCommand transfromCommand = new TransfromCommand(tetriMachine);

        Button button = new Button();
        button.setLeftCommand(leftCommand);
        button.setRightCommand(rightCommand);
        button.setDownCommand(downCommand);
        button.setFallCommand(fallCommand);
        button.setTransfromCommand(transfromCommand);

        button.toLeft();
        button.toRight();
        button.toDown();
        button.fall();
        button.transform();
    }
}
