package com.example.ccctest.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Yangzhenma {
    public void yangzhenma(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        BufferedImage bi =  new BufferedImage(68,29,BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        Color c = new Color(205,201,201);
        g.setColor(c);
        g.fillRect(0, 0, 68, 29);

        char ch[]="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM123456789".toCharArray();
        Random r = new Random();
        int len = ch.length,index;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<4;i++)
        {
            index=r.nextInt(len);
            g.setColor(new Color(r.nextInt(188),r.nextInt(100),r.nextInt(255)));
            g.drawString(ch[index]+"",(i*15)+3, 18 );
            sb.append(ch[index]);
        }

        request.getSession().setAttribute("piccode",sb.toString() );
        ImageIO.write(bi, "JPG", response.getOutputStream());

    }

}
