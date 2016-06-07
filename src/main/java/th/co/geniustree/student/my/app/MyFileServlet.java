/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.student.my.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author best
 */
public class MyFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        byte[] buffer = new byte[1024];
        File file = new File(name);
        FileInputStream fis = new FileInputStream(file);
        resp.setHeader("Content-Disposition", "attachment; filename=" + name);
        resp.setContentLength((int) file.length());
        OutputStream os = resp.getOutputStream();

        int byteRead = 0;
        while ((byteRead = fis.read(buffer)) > 0) {
            os.write(buffer, 0, byteRead);

        }

        os.close();
        fis.close();

    }

}
