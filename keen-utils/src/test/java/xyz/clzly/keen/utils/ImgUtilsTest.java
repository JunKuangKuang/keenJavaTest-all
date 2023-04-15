package xyz.clzly.keen.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImgUtilsTest {
    private String imgParent = "/Volumes/KeenMacPlus/Blog/1new/source";

    @Test
    public void compress() {

        ImgUtils.compressPicByQuality(imgParent+"/images/Docker系列二MariaDB/Docker系列二MariaDB.png","/Users/keen/Downloads/1.jpg",1f,0.9f);
    }
}