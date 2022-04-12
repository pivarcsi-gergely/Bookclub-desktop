package hu.petrik.bookclubdesktop;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class DB {
    private final String URL = "jdbc:mysql://localhost/vizsga_konyvklub";
    private Connection conn;
    public DB() throws SQLException {
        conn = DriverManager.getConnection(URL, "root", "");
    }

    public List<Member> getMembers(List<Member> membersList) throws SQLException {
        String query = "SELECT * FROM members";
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            membersList.add(new Member(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getDate(4).toLocalDate(), resultSet.getBoolean(5)));
        }
        return membersList;
    }
}
