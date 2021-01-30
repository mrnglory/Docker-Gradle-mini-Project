// App.java
// 아래의 코드는 가장 기본적인 connection java code입니다.

import java.sql.*;


public class Connector {
    public static void main(String[] args) {
        Connection con = null;

        String server = "172.17.0.2:3306";  // 본인의 wsl 서버 ip를 삽입
        String database = "practice";
        String user_name = "root";
        String password = "mariadb";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" Driver loading error : " + e.getMessage());
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://" +
                    server + "/" +
                    database +
                    "?useSSL=false", user_name, password); // SSL 실행 확인
            System.out.println("Connection Success!");
        } catch(SQLException e) {
            System.err.println("Error :" + e.getMessage());
            e.printStackTrace();
        }

        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }
}