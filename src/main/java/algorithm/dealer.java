package algorithm;

import java.util.ArrayList;

public class dealer {

    public void fapai(player player1,player player2,player player3,player player4,ArrayList<Integer> arr){

        for (int x = 0 ; x < arr.size();x++){
            if( x % 4 == 0 ) player1.getHandPokerNum().add(arr.get(x));
            else if ( x % 4 == 1) player2.getHandPokerNum().add(arr.get(x));
            else if ( x % 4 == 2) player3.getHandPokerNum().add(arr.get(x));
            else if ( x % 4 == 3) player4.getHandPokerNum().add(arr.get(x));
        }
    }
}
