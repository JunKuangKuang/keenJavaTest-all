package xyz.clzly.keen.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
* @Author JunKuang
* @time
* */

public class FileUtils {
    int depth = 0;
    String path = null;
    List<String> listAll = new LinkedList<String>();
    List<String> listFilters =new ArrayList<String>();
    StringBuffer stringBuffer=new StringBuffer();

    public List<String> getFilesNameByPath() {
        File file = new File(this.path);
        if (!file.isDirectory()) {
            // 如果该路径是文件，返回空对象
            return new LinkedList<String>();
        } else {
            this.depth = -1;
            stringBuffer.setLength(0);
            return this.getFilesName(file, this.depth);
        }
    }

    /*
    * 请参看例子
    * resources/images/傲娇.jpg 对应 /傲娇.jpg
    * /resources/images/Hexo历险记之一总述/Hexo历险记之一总述.png 对应 /Hexo历险记之一总述/Hexo历险记之一总述.png
    * */
    public List<String> getFilesName(File f, int depth) {
        if (!f.isDirectory()) {
            // 如果是文件
            // System.out.println(f.getPath());
            String[] split = f.getPath().split("/");

            for (int i = 1; i <=depth; i++) {
                    stringBuffer.append("/"+split[split.length-1-i]);
            }
            stringBuffer.append("/"+f.getName());
            //
            if(!listFilters.contains(stringBuffer.toString().split("/")[1])){
                listAll.add(stringBuffer.toString());
            }
            stringBuffer.setLength(0);
        } else {
            // 如果是目录，简单过滤掉.DS文件
            File[] fs = f.listFiles((File dir, String name)->{
                if(name.charAt(0)=='.'){
                    return false;
                }
                // 不能再这里过滤，否则会丢失子目录
                // return name.endsWith("png")||name.endsWith("jpg");
                return true;
            });
            depth++;
            for (int i = 0; i < fs.length; ++i) {
                getFilesName(fs[i],depth);
            }
        }
        return listAll;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean setList_filters(String str) {
       return this.listFilters.add(str);
    }
}