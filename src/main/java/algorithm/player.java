package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class player {
    private String name;
    private TreeSet<Integer> handPokerNum = new TreeSet<Integer>();
    private ArrayList<String> handPoker = new ArrayList<String>();
    private int winWater;

    public player(String name) {
        this.name = name;
    }

    public ArrayList<String> getHandPoker() {
        return handPoker;
    }

    public TreeSet<Integer> getHandPokerNum() {
        return handPokerNum;
    }

    public int getWinWater() {
        return winWater;
    }

    public void setWinWater(int winWater) {
        this.winWater = winWater;
    }


    public void lookPoker(HashMap<Integer,String> hm)
    {
        System.out.print(this.name + "的牌是：");
        for (Integer key : handPokerNum) {
            handPoker.add(hm.get(key));
        }
        //不能直接temp = handpoker ,对temp进行操作时也会改变handpoker,handpoker的引用给了temp;
        ArrayList<String> temp = new ArrayList<String>();
        for (String s : handPoker){
            temp.add(s);
        }
        for (int i = 0 ; i< temp.size();i++){
            if (temp.get(i).equals("&￥")) temp.set(i,"&10");
            else if (temp.get(i).equals("$￥")) temp.set(i,"$10");
            else if (temp.get(i).equals("#￥")) temp.set(i,"#10");
            else if (temp.get(i).equals("*￥")) temp.set(i,"*10");
        }
        System.out.println(temp);
    }
}
