package xyz.clzly.keen.process.abstruct;

import xyz.clzly.keen.process.entity.LeaveInfo;

/**
 * 领导抽象类
 */
public abstract class Leader {

    protected String name;//姓名
    protected Leader nextLeader;//责任链上的后继对象
    
    public Leader(String name){
        this.name = name;
    }

    
    /**
     * 设置责任链上的后继对象
     */
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }
    
    
    /**
     * 处理业务的核心方法
     */
    public abstract void handleLeave(LeaveInfo leaveInfo);
    
}