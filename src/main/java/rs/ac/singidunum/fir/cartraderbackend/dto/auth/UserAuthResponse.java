package rs.ac.singidunum.fir.cartraderbackend.dto.auth;

public class UserAuthResponse {
    private String token;
    private String email;
    private long userId;

    public UserAuthResponse() {
    }

    public UserAuthResponse(String token, String email, long userId) {
        this.token = token;
        this.email = email;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
