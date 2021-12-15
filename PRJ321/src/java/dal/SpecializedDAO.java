package dal;

import db.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SpecializedDAO {

    public String getCodeSpecialized(int specializedId) throws Exception {
        Connection con = null;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            Statement stmt = con.createStatement();
            String sql = "SELECT code FROM Specialized WHERE id = '" + specializedId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String code = rs.getString(1);
                return code;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
