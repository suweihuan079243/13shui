import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import algorithm.*;

import java.util.ArrayList;
import java.util.List;

public class NetworkTest {
    static String token;
    static String card;
    static int gameId;

    public static void main(String[] args) {
        Network.init();
        login();

    }

    private static void submit() {
        ArrayList<String> handPoker = out.resort(card);
        Operation op = new Operation();
        op.countPoker(handPoker);
        op.judgeCardType(5,0);
        op.judgeCardType(5,1);
        op.judgeCardType(3,2);
        op.addColor(handPoker);
        op.play();
        List<String> cards = new ArrayList<>();
        String front ="";
        String middle ="";
        String behand ="";

         for (int i=0;i<op.getFront_f().size();i++)
         {
             front += op.getFront_f().get(i);
             if (i != op.getFront_f().size()-1){
                 front += " ";
             }
         }
        for (int i=0;i<op.getBehand_f().size();i++)
        {
            behand += op.getBehand_f().get(i);
            if (i != op.getBehand_f().size()-1){
                behand += " ";
            }
        }
        for (int i=0;i<op.getMiddle_f().size();i++)
        {
            middle += op.getMiddle_f().get(i);
            if (i != op.getMiddle_f().size()-1){
                middle += " ";
            }
        }
        System.out.println(front);
        System.out.println(middle);
        System.out.println(behand);
        cards.add(front);
        cards.add(middle);
        cards.add(behand) ;

        Network.api.submit(token,new SubmitRequest(gameId,cards)).enqueue(new Callback<SubmitResponse>() {
            @Override
            public void onResponse(Call<SubmitResponse> call, Response<SubmitResponse> response) {

            }

            @Override
            public void onFailure(Call<SubmitResponse> call, Throwable t) {

            }
        });
    }

    private static void open() {
        Network.api.open(token).enqueue(new Callback<OpenResponse>() {
            @Override
            public void onResponse(Call<OpenResponse> call, Response<OpenResponse> response) {
                OpenResponse.Data data = response.body().data;
                card = data.card;
                gameId = data.id;
                System.out.println(card);
                submit();
            }

            @Override
            public void onFailure(Call<OpenResponse> call, Throwable t) {

            }
        });
    }

    public static void login() {
        Network.api.login(new UserDto("cwb12345","cwb12345")).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                token = (response.body().data.token);
                open();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    private static void register() {
        Network.api.register(new UserDto("cwb12345","cwb12345")).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
//                System.out.println(response.body().data.msg);
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });
    }
}
