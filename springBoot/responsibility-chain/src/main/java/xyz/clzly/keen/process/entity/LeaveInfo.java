package xyz.clzly.keen.process.entity;

/**
 * 封装请假的基本信息类
 */
public class LeaveInfo {
    
    private String empName;
    private int leaveDays;
    private String reason;
    
    public LeaveInfo(String empName, int leaveDays, String reason) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }
    
    public String getEmpName() {
        return empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    
    public int getLeaveDays() {
        return leaveDays;
    }
    
    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
}