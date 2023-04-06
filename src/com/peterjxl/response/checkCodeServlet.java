package com.peterjxl.response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class checkCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 第1步，创建图片对象
        int width = 100;    //图片的宽
        int height = 50;    //图片的高
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


        //2.美化图片
        // 2.1 填充背景色
        Graphics g = image.getGraphics();    //画笔对象
        g.setColor(Color.PINK);        //设置画笔颜色为粉红色
        g.fillRect(0, 0, width, height);  //fill是填充的意思，draw是画的意思

        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width - 1,height - 1);  //边框也是有像素
        //用来填充的字符串，从这当中随机取4个
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机坐标
        Random ran = new Random();

        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);//获取随机字符
            //2.3写验证码
            g.drawString(ch + "", width/5*i, height/2);
        }


        //2.4画干扰线
        g.setColor(Color.GREEN);
        //随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);

            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        // 3.将图片输出到页面展示  ImageIO可以输出到任意流去
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
