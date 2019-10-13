public class LoginResponse {
    int status;
    Data data;
    static class Data {
        int user_id;
        String token;
    }
}