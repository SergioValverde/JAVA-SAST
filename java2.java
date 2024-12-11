// Proyecto: VulnerableJavaApp
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Base64;
import org.json.simple.JSONObject;

public class VulnerableJavaApp {
    // Vulnerabilidad 1: Hardcoded API Key
    private static final String API_KEY = "sk-1234567890abcdefghijklmnopqrstuvwxyz";
    
    // Vulnerabilidad 2: SQL Injection
    public void vulnerableSQLQuery(String username) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb");
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        conn.createStatement().executeQuery(query);
    }
    
    // Vulnerabilidad 3: Insecure Deserialization
    public void insecureDeserialization(String jsonData) {
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonData);
    }
    
    // Vulnerabilidad 4: Sensitive Data Exposure
    public String decodeCredentials(String encodedCredentials) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        return new String(decodedBytes);
    }
    
    // Vulnerabilidad 5: Weak Cryptography
    public String weakEncryption(String data) {
        // Ejemplo de método de encriptación débil
        return data.replace('a', 'z');
    }
}
