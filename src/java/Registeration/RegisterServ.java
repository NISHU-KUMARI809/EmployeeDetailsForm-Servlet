package Registeration;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegisterServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        //out.println("<h1>Employee details</h1>");
        String name=request.getParameter("txt1");
        String password=request.getParameter("txt2");
        String mob=request.getParameter("txt3");
        String country=request.getParameter("txt4");
        String email=request.getParameter("txt5");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_Detail","root","Nishu@123456");
            PreparedStatement ps=con.prepareStatement("insert into registerEmployee values(?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2, password);
            ps.setString(3,mob);
            ps.setString(4, country);
            ps.setString(5, email);
            int count=ps.executeUpdate();
            if(count>0){
                out.println("You are successfully registered");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
//        out.println("<h3>Name:"+name+"</h3>");
//        out.println("<h3>Password:"+password+"</h3>");
//        out.println("<h3>Mobile number:"+mob+"</h3>");
//        out.println("<h3>Country:"+country+"</h3>");
//        out.println("<h3>Email:"+email+"</h3>");

    }
}
