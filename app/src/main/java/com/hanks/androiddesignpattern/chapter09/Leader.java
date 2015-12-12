package com.hanks.androiddesignpattern.chapter09;
/**
 * 责任链模式
 * Created by hanks on 15-12-12.
 */
public abstract class Leader {

    protected Leader nextLeader;

    public final void handleRequest(int money) {
        if (money < limit()) { // 自身能处理
            handle(money);
        } else { // 交给下一个节点处理
            if (nextLeader != null) {
                nextLeader.handleRequest(money);
            }
        }
    }

    protected abstract void handle(int money);

    protected abstract int limit();
}
