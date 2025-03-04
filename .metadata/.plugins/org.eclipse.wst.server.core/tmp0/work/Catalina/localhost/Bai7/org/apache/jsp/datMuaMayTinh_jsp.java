/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.96
 * Generated at: 2025-03-04 20:07:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class datMuaMayTinh_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js\" integrity=\"sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js\" integrity=\"sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

		// Radio button => name
		String processor = request.getParameter("processor");
		String ram = request.getParameter("ram");
		double processorPrice = 0;
		double ramPrice = 0;
		double monitorPrice = 0;
		double accessoriesPrice = 0;
		double totalAmount = 0;
		if(processor != null){
			if(processor.equals("CoreI9")){
				processorPrice = 5000000;
			}else if(processor.equals("CoreI7")){
				processorPrice = 4000000;
			}else if(processor.equals("CoreI5")){
				processorPrice = 3000000;
			}
			totalAmount += processorPrice;
		}
		
		if(ram != null){
			if(ram.equals("8GB")){
				ramPrice = 500000;
			}else if(ram.equals("16GB")){
				ramPrice = 1200000;
			}
		totalAmount += ramPrice;
		}
		
		//Checkbox => name
		String monitor = request.getParameter("monitor");
		if(monitor != null){
			monitorPrice += 1500000;
		}
		//Select String [] mang =  getParameterValues("ten");
		
		String[] accessories = request.getParameterValues("accessories");
		if(accessories != null){
		for(String option: accessories){
			if(option.equals("Camera")){
				accessoriesPrice = 800000;
			}else if(option.equals("Printer")){
				accessoriesPrice = 1500000;
			}else if(option.equals("Scanner")){
				accessoriesPrice = 1500000;
			}
		}
			totalAmount += accessoriesPrice;
		}
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<h1>HOÁ ĐƠN</h1>\r\n");
      out.write("	<table class=\"table\">\r\n");
      out.write("	  <thead>\r\n");
      out.write("	    <tr>\r\n");
      out.write("	      <th scope=\"col\">Tên sản phẩm</th>\r\n");
      out.write("	      <th scope=\"col\">Giá tiền</th>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	  </thead>\r\n");
      out.write("	  <tbody>\r\n");
      out.write("	  ");
 if(processor != null){ 
      out.write("\r\n");
      out.write("	    <tr>\r\n");
      out.write("	      <td>");
      out.print( processor );
      out.write("</td>\r\n");
      out.write("	      <td>");
      out.print( processorPrice );
      out.write("</td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    ");
 } 
      out.write("\r\n");
      out.write("	    ");
 if(ram != null){ 
      out.write("\r\n");
      out.write("	    <tr>\r\n");
      out.write("	      <td>");
      out.print( ram );
      out.write("</td>\r\n");
      out.write("	      <td>");
      out.print( ramPrice );
      out.write("</td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    ");
 } 
      out.write("\r\n");
      out.write("	    ");
 if(monitor != null){ 
      out.write("\r\n");
      out.write("	    <tr>\r\n");
      out.write("	      <td>");
      out.print( monitor );
      out.write("</td>\r\n");
      out.write("	      <td>");
      out.print( monitorPrice );
      out.write("</td>\r\n");
      out.write("	    </tr>\r\n");
      out.write("	    ");
 } 
      out.write("\r\n");
      out.write("	    ");

	    	if(accessories != null){
			for(String option: accessories){
				if(option.equals("Camera")){
					accessoriesPrice = 800000;
				}else if(option.equals("Printer")){
					accessoriesPrice = 1500000;
				}else if(option.equals("Scanner")){
					accessoriesPrice = 1500000;
				}
				
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>");
      out.print( option );
      out.write("</td> \r\n");
      out.write("					<td>");
      out.print( accessoriesPrice );
      out.write("</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");

			}
	    	}
			
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td>Tổng:</td>\r\n");
      out.write("				<td>");
      out.print( totalAmount );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("	  </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
