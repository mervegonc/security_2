package learn.process.sSecurity;

// Kullanıcı adı ve parola alanlarını içeren LoginRequest sınıfı.
public class LoginRequest {

    private String username;
    private String password;

    // Kullanıcı adı getter ve setter metotları.
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // Parola getter ve setter metotları.
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
