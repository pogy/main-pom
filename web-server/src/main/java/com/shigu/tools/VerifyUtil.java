package com.shigu.tools;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码生成器
 * Created by zhaohongbo on 17/3/2.
 */
public class VerifyUtil {

    /**
     * 得到一张验证码的图
     * @param code
     * @return
     */
    public static BufferedImage creatVerifyImg(String code){
        int width = 56;
        int height = 22;
        int count = 4;
        Random random = new Random();
        int line = 200;

        Font font = new Font("Courier New", 1, width / count);
        BufferedImage image = new BufferedImage(width, height, 1);
        Graphics g = image.getGraphics();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setColor(getRandColor(160, 200));

        int i;
        int x;
        int y;
        for(i = 0; i < line; ++i) {
            x = random.nextInt(width);
            y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        g.setFont(font);

        for(i = 0; i < count; ++i) {
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            x = width / count * i;
            y = (height + font.getSize()) / 2 - 5;
            g.drawString(String.valueOf(code.charAt(i)), x, y);
        }

        g.dispose();
        return image;
//        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    /**
     * 随机颜色
     * @param from
     * @param to
     * @return
     */
    private static Color getRandColor(int from, int to) {
        Random random = new Random();
        if(to > 255) {
            from = 255;
        }

        if(to > 255) {
            to = 255;
        }

        int rang = Math.abs(to - from);
        int r = from + random.nextInt(rang);
        int g = from + random.nextInt(rang);
        int b = from + random.nextInt(rang);
        return new Color(r, g, b);
    }
}
