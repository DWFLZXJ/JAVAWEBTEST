package com.daiwf.web.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet
{
    public HelloServlet() {
        System.out.println("1HelloServlet构造器");
    }

    @Override public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2init");

        System.out.println("2init-username:"+servletConfig.getInitParameter("username"));
        System.out.println("2init-password:"+servletConfig.getInitParameter("password"));


    }

    @Override public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * [这个方法是专门用来处理请求和响应的]
     * [功能详细描述]
     * @version [版本号，2020-06-25]
     * @作者 daiwf
     * @创建时间 2020-06-25
     * @param 
     * @return 
     */
    @Override public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("3、Hello service");
        //想要从servletRequest中获取是get还是post可以去他的子类中去找方法
        //选中ServletRequest F4可以查看
          HttpServletRequest request= (HttpServletRequest) servletRequest;
          if("GET".equals(request.getMethod())) {

              doGet();
          }else {
              doPost();
          }
    }


    public void doGet(){
        System.out.println("GET请求");
    }

    public  void doPost(){
        System.out.println("POST请求");
    }


    @Override public String getServletInfo() {
        return null;
    }

    @Override public void destroy() {
        System.out.println("4、销毁");
    }
}
