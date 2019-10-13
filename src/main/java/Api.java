import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @POST("auth/register")
    Call<RegisterResponse> register(@Body UserDto user);

    @POST("auth/login")
    Call<LoginResponse> login(@Body UserDto user);

    @POST("game/open")
    Call<OpenResponse> open(@Header("X-Auth-Token") String token);

    @POST("game/submit")
    Call<SubmitResponse> submit(@Header("X-Auth-Token") String token,@Body SubmitRequest request);

}
