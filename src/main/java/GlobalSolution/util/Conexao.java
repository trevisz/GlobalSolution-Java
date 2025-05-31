package GlobalSolution.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521/orcl   ";
    private static final String USER = "rm560263";
    private static final String PASSWORD = "251005";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
