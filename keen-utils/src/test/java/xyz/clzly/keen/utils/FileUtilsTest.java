package xyz.clzly.keen.utils;

import org.junit.Test;

import java.util.List;

public class FileUtilsTest {

    @Test
    public void getFilesNameByPath() {
        FileUtils fileUtils = new FileUtils();
        fileUtils.setPath("/Volumes/KeenMacPlus/Projects/javaWeb/keenJavaTest-all/keenTest-springBoot-parent/blogImages/src/main/resources/images");
        fileUtils.setList_filters("Hexo历险记之一总述");
        List<String> filesNameByPath = fileUtils.getFilesNameByPath();
        System.out.println(filesNameByPath);
    }
}