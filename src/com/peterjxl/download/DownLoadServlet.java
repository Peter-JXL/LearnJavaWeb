package com.peterjxl.download;

import com.peterjxl.util.DownLoadUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downLoadServlet")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取请求参数
        String fileName = req.getParameter("fileName");

        // 2. 使用字节输入流加载文件进内存
        // 2.1 找到文件真实路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + fileName);
        // 2.2 使用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        // 3. 设置响应头
        // 3.1 设置响应头：content-type
        String mimeType = servletContext.getMimeType(fileName);
        resp.setHeader("content-type", mimeType);
        // 3.2 设置响应头打开方式：content-disposition

        // 解决中文文件名问题
        // 3.3 获取user-agent请求头：
        String agent = req.getHeader("user-agent");
        fileName = DownLoadUtils.getFileName(agent, fileName);
        resp.setHeader("content-disposition", "attachment;filename=" + fileName);
        // 4. 将输入流的数据，输出到response的输出流
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ( -1 != (len = fis.read(buff))){
            sos.write(buff, 0, len);
        }
        fis.close();
    }
}
