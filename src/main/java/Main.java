import algorithm.Operation;
import algorithm.dealer;
import algorithm.player;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //洗牌
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        String[] colors = {"$", "&", "*", "#"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "￥", "J", "Q", "K", "A"};

        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                String pocker = color.concat(number);
                hm.put(index, pocker);
                arr.add(index);
                index++;
            }
        }
        Collections.shuffle(arr);

        Network.init();
        NetworkTest.login();
        String handPoker = NetworkTest.card;
        System.out.println(handPoker);

//        player player1 = new player("Yasuo");
//        player player2 = new player("Zed");
//        player player3 = new player("Rivven");
//        player player4 = new player("Leesin");
//
//        dealer d = new dealer();
//        d.fapai(player1,player2,player3,player4,arr);
//
//        Operation op1 = new Operation();
////      player1.lookPoker(hm);
//        op1.countPoker(player1.getHandPoker());
//        op1.judgeCardType(5,0);
//        op1.judgeCardType(5,1);
//        op1.judgeCardType(3,2);
//        op1.addColor(player1.getHandPoker());
//        op1.play();

















//        Operation op2 = new Operation();
//        player2.lookPoker(hm);
//        op2.countPoker(player2.getHandPoker());
//        op2.judgeCardType(5,0);
//        op2.judgeCardType(5,1);
//        op2.judgeCardType(3,2);
//        op2.addColor(player2.getHandPoker());
//        op2.play();
//
//        Operation op3 = new Operation();
//        player3.lookPoker(hm);
//        op3.countPoker(player3.getHandPoker());
//        op3.judgeCardType(5,0);
//        op3.judgeCardType(5,1);
//        op3.judgeCardType(3,2);
//        op3.addColor(player3.getHandPoker());
//        op3.play();
//
//        Operation op4 = new Operation();
//        player4.lookPoker(hm);
//        op4.countPoker(player4.getHandPoker());
//        op4.judgeCardType(5,0);
//        op4.judgeCardType(5,1);
//        op4.judgeCardType(3,2);
//        op4.addColor(player4.getHandPoker());
//        op4.play();

    }
}

