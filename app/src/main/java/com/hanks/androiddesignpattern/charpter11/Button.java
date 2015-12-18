package com.hanks.androiddesignpattern.charpter11;
/**
 * Created by hanks on 15-12-18.
 */
public class Button {
    private LeftCommand      leftCommand;
    private RightCommand     rightCommand;
    private DownCommand      downCommand;
    private FallCommand      fallCommand;
    private TransfromCommand transfromCommand;

    public void setLeftCommand(LeftCommand leftCommand) {
        this.leftCommand = leftCommand;
    }

    public void setRightCommand(RightCommand rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void setDownCommand(DownCommand downCommand) {
        this.downCommand = downCommand;
    }

    public void setFallCommand(FallCommand fallCommand) {
        this.fallCommand = fallCommand;
    }

    public void setTransfromCommand(TransfromCommand transfromCommand) {
        this.transfromCommand = transfromCommand;
    }

    public void toLeft() {
        leftCommand.executed();
    }

    public void toRight() {
        rightCommand.executed();
    }

    public void toDown() {
        downCommand.executed();
    }

    public void fall() {
        fallCommand.executed();
    }

    public void transform() {
        transfromCommand.executed();
    }

}
