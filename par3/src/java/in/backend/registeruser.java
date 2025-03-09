package in.backend;
import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServlet;
@WebServlet("/registeruser")
public class registeruser extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException{
 String name = request.getParameter("name");
 String birthdate = request.getParameter("birthdate");
 String email = request.getParameter("email");
 String phone_no = request.getParameter("phone_no");

 try {
 Class.forName("com.mysql.cj.jdbc.Driver");
 Connection connection =
DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root",
"chirag@123");
 String sql = "INSERT INTO users (name, birthdate, email, phone_no) VALUES (?, ?, ?,?)";
 PreparedStatement statement = connection.prepareStatement(sql);
 statement.setString(1, name);
 statement.setString(2, birthdate);
 statement.setString(3, email);
 statement.setString(4, phone_no);
 statement.executeUpdate();
 response.sendRedirect("displayusers");
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
}