package learn.erweima;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ReadQrCode {
    public static void main(String[] args) {
        try {
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            File file = new File("D:/qrcode.png");
            BufferedImage image = ImageIO.read(file);
            //定义二维码参数
            Map hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET,"utf-8");

            //获取读取二维码结果
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Result result = multiFormatReader.decode(binaryBitmap, hints);

            System.out.println("读取二维码： " + result.toString());
            System.out.println("二维码格式： " + result.getBarcodeFormat());
            System.out.println("二维码内容： " + result.getText());
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
