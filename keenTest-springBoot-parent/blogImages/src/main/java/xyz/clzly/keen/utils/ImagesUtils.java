package xyz.clzly.keen.utils;

import com.idrsolutions.image.JDeli;
import com.idrsolutions.image.png.PngCompressor;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.tomcat.util.codec.binary.Base64;
import org.jpedal.parser.image.utils.ConvertMaskToImage;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

@Component
public class ImagesUtils {
    private static String warterImagePath = "/Volumes/KeenMacPlus/Blog/0keen/source/images/theme-stun/junkuang-32x32.jpg";

    public static void compressPNGImage(String inPath, String outPath) {
        try {
            File file = new File(inPath); // 源文件
            File outfile = new File(outPath); // 目标输出文件，可与源文件一致，一致会覆盖
            PngCompressor.compress(file, outfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void compressPNGImage(String path) {
        try {
            File file = new File(path); // 源文件,与目标文件一致，会覆盖
            PngCompressor.compress(file, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void watermarkPNGImage(String inPath, String outPath) {
        BufferedImage read = null;
        Positions positions = Positions.BOTTOM_RIGHT;

        try {
            read = ImageIO.read(new File(warterImagePath));
            // watermark 参数 1.位置 2.水印图片 3.透明度
            Thumbnails.of(inPath)
                    .scale(1.0f)
                    .watermark(Positions.CENTER_RIGHT, read, 0.25f)
                    .toFile(outPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Thumbnails.Builder<BufferedImage> watermarkImage(BufferedImage images, BufferedImage watermark) {
        return Thumbnails.of(images)
                .scale(1.0f)
                .watermark(Positions.CENTER_RIGHT, watermark, 0.25f);
    }

    /**
     * @param bufferedImage 图片对象
     * @param imageWidth    宽
     * @param imageHeight   高
     * @return boolean true：符合要求
     * @description 校验图片比例
     */
    public static boolean checkImageScale(BufferedImage bufferedImage, int imageWidth, int imageHeight) throws IOException {

        Boolean result = false;

        if (imageHeight > 0
                && imageHeight > 0
                && bufferedImage!=null
                && imageWidth < bufferedImage.getWidth() * 2
                && imageHeight < bufferedImage.getHeight() * 2) {
            result = true;
        }
        return result;
    }


    /**
     * @param path 图片路径
     * @return java.lang.String base64字符串
     * @description 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     */
    public static String imgToBase64Str(String path) throws IOException {
        byte[] data = null;
        // 读取图片字节数组
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //返回Base64编码过的字节数组字符串
        return Base64.encodeBase64String(data);
    }


    /**
     * 按比例对图片进行缩放
     *
     * @param scale 图片根据比例缩放
     * @throws IOException
     */
    public static BufferedImage zoomByScale(BufferedImage bufferedImage, double scale) throws IOException {

        //获取图片的长和宽
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        //获取缩放后的长和宽
        int _width = (int) (scale * width);
        int _height = (int) (scale * height);

        //获取缩放后的Image对象
        Image _img = bufferedImage.getScaledInstance(_width, _height, Image.SCALE_DEFAULT);

        //新建一个和Image对象相同大小的画布:BufferedImage.TYPE_INT_ARGB
        BufferedImage image = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_ARGB);
        //获取画笔
        Graphics2D graphics = image.createGraphics();
        //将Image对象画在画布上,最后一个参数,ImageObserver:接收有关 Image 信息通知的异步更新接口,没用到直接传空
        graphics.drawImage(_img, 0, 0, null);
        //释放资源
        graphics.dispose();

        return image;

    }

    public static String getWarterImagePath() {
        return warterImagePath;
    }
}