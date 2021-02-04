package com.two.controller;

import com.two.entity.Department;
import com.two.service.impl.DepartmentServicImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String dno = request.getParameter("dno");
        String after_dname = request.getParameter("after_dno");
        String dname = request.getParameter("dname");
        DepartmentServicImpl departmentServic = new DepartmentServicImpl();
        List<Department> departments = departmentServic.selectAll();
        //删除
        if (dno != null && after_dname == null && dname == null) {
            int delete = departmentServic.delete(dno);
            String info = null;
            PrintWriter out = response.getWriter();
            if (delete == 1) {
                info = "成功删除" + dno + "号院系！";
            } else {
                info = "错误：删除院系失败！";
            }
            out.write("<div class='error'>");
            out.write("<div>" + info + "</div>");
            out.write("</div>");
            out.flush();
            out.close();
        } else if (dno != null && after_dname != null) {
            //更新

            int update = departmentServic.update(after_dname, dno);
            String info = null;
            PrintWriter out = response.getWriter();
            if (update == 1) {
                info = dno + "号系修改成功！";
            } else {
                info = "错误：修改院系失败!";
            }
            out.write("<div class='error'>");
            out.write("<div>" + info + "</div>");
            out.write("</div>");
            out.flush();
            out.close();
        } else if (dname != null&&dno!=null) {//添加院系
            int add = departmentServic.add(dno, dname);
            String info = null;
            PrintWriter out = response.getWriter();
            if (add == 1) {
                info = dno + "添加成功";
            } else {
                info = "错误：添加失败";
            }
            out.write("<div class='error'>");
            out.write("<div>" + info + "</div>");
            out.write("</div>");
            out.flush();
            out.close();
        } else  if (departments != null&& after_dname == null && dname == null) {//查看院系
            PrintWriter out = response.getWriter();
            // 输出结果

            out.write("<div class='all'>");
            out.write("<div><span>系编号</span><span>系名</span></div>");
            for (Department department : departments) {
                out.write("<div>");
                out.write("<span>" + department.getDno() + "</span>");
                out.write("<span>" + department.getDname() + "</span>");
                out.write("</div>");
            }
            out.write("</div>");

            out.flush();
            out.close();
        }

    }
}


