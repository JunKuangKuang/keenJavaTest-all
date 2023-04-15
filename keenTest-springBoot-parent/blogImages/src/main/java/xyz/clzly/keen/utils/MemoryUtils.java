package xyz.clzly.keen.utils;


import com.sun.management.OperatingSystemMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.clzly.keen.process.BlogHandler;

import java.lang.management.ManagementFactory;

public class MemoryUtils {

    private static Logger logger = LoggerFactory.getLogger(MemoryUtils.class);
    public static void getJVMMemory() {
        // 虚拟机级内存情况查询
        long vmFree = 0;
        long vmUse = 0;
        long vmTotal = 0;
        long vmMax = 0;
        int byteToMb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        vmTotal = rt.totalMemory() / byteToMb;
        vmFree = rt.freeMemory() / byteToMb;
        vmMax = rt.maxMemory() / byteToMb;
        vmUse = vmTotal - vmFree;
        logger.info("JVM内存已用的空间为：" + vmUse + " MB");
        logger.info("JVM内存的空闲空间为：" + vmFree + " MB");
        logger.info("JVM内存空间总共为：" + vmTotal + " MB");
        logger.info("JVM内存空间最大为：" + vmMax + " MB");
    }

    public static void getOperatingSystemMemory() {

        // 操作系统级内存情况查询
        int byteToMb = 1024 * 1024;
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        String os = System.getProperty("os.name");
        long physicalFree = osmxb.getFreePhysicalMemorySize() / byteToMb;
        long physicalTotal = osmxb.getTotalPhysicalMemorySize() / byteToMb;
        long physicalUse = physicalTotal - physicalFree;
        logger.info("操作系统的版本：" + os);
        logger.info("操作系统物理内存已用的空间为：" + physicalFree + " MB");
        logger.info("操作系统物理内存的空闲空间为：" + physicalUse + " MB");
        logger.info("操作系统总物理内存：" + physicalTotal + " MB");
    }

    public static void getThreadNum() {
        // 获得线程总数
        ThreadGroup parentThread;
        int totalThread = 0;
        for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
                .getParent() != null; parentThread = parentThread.getParent()) {
            totalThread = parentThread.activeCount();
        }
        logger.info("获得线程总数:" + totalThread);

    }

}