package untitled;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Class3 {

    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {

            String url = "jdbc:mysql://195.19.44.146:3306/user5?useUnicode=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "user5", "user5");
            System.out.println("Connected...!");

            statement = conn.createStatement();
            resultSet = statement.executeQuery("select * from Ekipazh JOIN Rejs ON Rejs_nomer = Rejs.nomer WHERE Rejs.nomer=4");
            int Rejs_nomer = 0;
            int Ekipazh_nomer = 0;
            while (resultSet.next()) {
                Rejs_nomer = resultSet.getInt("Rejs_nomer");
                Ekipazh_nomer = resultSet.getInt("kod");
                System.out.println("Номер Рейса: " + resultSet.getInt("Rejs_nomer") + "; Номер экипажа: " + resultSet.getInt("kod"));
            }

        } catch (Exception e) {

        }

    }
}