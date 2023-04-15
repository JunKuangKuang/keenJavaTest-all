package xyz.clzly.keen.process;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import xyz.clzly.keen.MainApplication;
import xyz.clzly.keen.utils.FileUtils;
import xyz.clzly.keen.utils.ImagesUtils;
import xyz.clzly.keen.utils.MemoryUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class BlogHandler {
    private String blogRootPath;
    private String blogImagesRootPath;
    private static Logger logger = LoggerFactory.getLogger(BlogHandler.class);

    public String getBlogRootPath() {
        return blogRootPath;
    }

    public void setBlogRootPath(String blogRootPath) {
        this.blogRootPath = blogRootPath;
    }

    public String getBlogImagesRootPath() {
        return blogImagesRootPath;
    }

    public void setBlogImagesRootPath(String blogImagesRootPath) {
        this.blogImagesRootPath = blogImagesRootPath;
    }

    private List<String> getImagesPartPathName(String path) {
        FileUtils fileUtils = new FileUtils();

        fileUtils.setPath(path);

        fileUtils.setList_filters("keenImages");
        fileUtils.setList_filters("theme-stun");
        fileUtils.setList_filters("index");
        fileUtils.setList_filters("icons");
        fileUtils.setList_filters("background-image");

        return fileUtils.getFilesNameByPath();
    }

    public Boolean dealImages() {
        if (StringUtils.isEmpty(blogImagesRootPath) || StringUtils.isEmpty(blogRootPath)) {
            logger.error("blogImagesRootPath或者blogRootPath为空！");
            return false;
        }

        List<String> imagesPartPathNameList = getImagesPartPathName(blogRootPath + blogImagesRootPath);
        BufferedImage warterImage = null;

        try {
            warterImage = ImageIO.read(new File(ImagesUtils.getWarterImagePath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (warterImage == null) {
                return false;
            }
        }

        BufferedImage image = null;
        String type = "";
        File file = null;
        for (String s : imagesPartPathNameList) {
            type = s.substring(s.lastIndexOf('.') + 1);
            if (type.equals("svg")||type.equals("blob")) {
                continue;
            }
            try {
                file = new File(blogRootPath + blogImagesRootPath + s);
                image = ImageIO.read(file);
                if (ImagesUtils.checkImageScale(image, warterImage.getWidth(), warterImage.getHeight())) {
                    logger.info(file.getAbsolutePath());
                    // MemoryUtils.getJVMMemory();
                    Thumbnails.Builder<BufferedImage> res = ImagesUtils.watermarkImage(image, warterImage);
                    switch(type)
                    {
                        case "png" :
                            res.toFile(blogRootPath + blogImagesRootPath + s);
                            // ImagesUtils.compressPNGImage(blogRootPath + blogImagesRootPath + s);
                            break;
                        case "jpg" :
                            res.outputQuality(0.9f)
                                    .toFile(blogRootPath + blogImagesRootPath + s);
                            break;
                        default :
                            logger.warn(file.getAbsolutePath()+"类型是："+type);
                            res.toFile(blogRootPath + blogImagesRootPath + s);

                    }
                    // MemoryUtils.getJVMMemory();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        return true;
    }
}