package algorithm;

import java.util.ArrayList;

public class Operation {
    /**
     * a1的值为手牌中重复一次(单张牌)的牌，a2的值为手牌中重复二次(对牌)的牌，
     * a3的值为手牌中重复三次(三张)的牌，a4的值为手牌中重复四次(炸弹)的牌。
     */
    private StringBuffer a1 = new StringBuffer();
    private StringBuffer a2 = new StringBuffer();
    private StringBuffer a3 = new StringBuffer();
    private StringBuffer a4 = new StringBuffer();

    private StringBuffer c1 = new StringBuffer(); //放♠
    private StringBuffer c2 = new StringBuffer(); //放♦
    private StringBuffer c3 = new StringBuffer(); //放♣
    private StringBuffer c4 = new StringBuffer(); //放♥

    private ArrayList<String> numList = new ArrayList<>(); //花色去掉后的手牌
    private ArrayList<String> front = new ArrayList<>();//前墩
    private ArrayList<String> middle = new ArrayList<>();//中墩
    private ArrayList<String> behand = new ArrayList<>();//后墩

    private ArrayList<String> frontColor = new ArrayList<>();//带花色的前墩
    private ArrayList<String> middleColor = new ArrayList<>();//带花色中墩
    private ArrayList<String> behandColor  = new ArrayList<>();//带花色的后墩

    private ArrayList<String> behand_f = new ArrayList<>();
    private ArrayList<String> middle_f = new ArrayList<>();
    private ArrayList<String> front_f = new ArrayList<>();

    public ArrayList<String> getBehand_f() {
        return behand_f;
    }

    public ArrayList<String> getMiddle_f() {
        return middle_f;
    }

    public ArrayList<String> getFront_f() {
        return front_f;
    }

    private int flag1 = 0; //后墩牌型
    private int flag2 = 0; //中墩牌型

    //把相同花色的牌放一起
    public void countColor(ArrayList<String> handPoker)
    {
        for(String s : handPoker)
        {
            char c = s.toCharArray()[0];
            if(c == '$')  c1.append(s.substring(1));
            else if (c == '#') c2.append(s.substring(1));
            else if (c == '*') c3.append(s.substring(1));
            else if (c == '&') c4.append(s.substring(1));
        }
    }
    //把花色去掉，统计牌型
    public void countPoker(ArrayList<String> handPoker)
    {
        countColor(handPoker);
        for(String str : handPoker){
            str = str.substring(1);
            numList.add(str);
        }
        int index = 0;
        while (true) {
            if ( index < numList.size() - 3 && numList.get(index).equals(numList.get(index + 3)) ) {
                a4.append(numList.get(index));
                index = index + 4;
            } else if (index < numList.size() - 2 && numList.get(index).equals(numList.get(index + 2))) {
                a3.append(numList.get(index));
                index = index + 3;
            } else if (index < numList.size() - 1 && numList.get(index).equals(numList.get(index + 1))) {
                a2.append(numList.get(index));
                index = index + 2;
            } else {
                a1.append(numList.get(index));
                index = index + 1;
            }
            if (index >= 13) break;
        }
        System.out.print(a1+",");
        System.out.print(a2+",");
        System.out.print(a3+",");
        System.out.println(a4);
    }

    //判断普通牌型
    public void judgeCardType(int size,int flag)
    {
        //前墩牌型判断
        if(size == 3)
        {
            //三条
            if (a3.length() != 0){
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
            }
            //一对
            else if(a2.length() != 0){
                out(a2.charAt(0),flag);
                out(a2.charAt(0),flag);
                out(a1.charAt(0),flag);
            }
            //散牌
            else{
                out(a1.charAt(0),flag);
                out(a1.charAt(1),flag);
                out(a1.charAt(2),flag);
            }
        }
        if(size == 5)
        {
            //判断同花顺
            if (a1.length() >= 5 && judge(a1.toString())!=0 && judgeColor(c1.toString())!=0 )
            {
                if (judge(a1.toString())==1 && flag==0) {
                    behand.add("2");behand.add("3");behand.add("4");behand.add("5");behand.add("6");
                }
                else if(judge(a1.toString())==2 && flag==0) {
                    behand.add("3");behand.add("4");behand.add("5");behand.add("6");behand.add("7");
                }
                else if(judge(a1.toString())==3 && flag==0) {
                    behand.add("4");behand.add("5");behand.add("6");behand.add("7");behand.add("8");
                }
                else if(judge(a1.toString())==4 && flag==0) {
                    behand.add("5");behand.add("6");behand.add("7");behand.add("8");behand.add("9");
                }
                else if(judge(a1.toString())==5 && flag==0) {
                    behand.add("6");behand.add("7");behand.add("8");behand.add("9");behand.add("￥");
                }
                else if(judge(a1.toString())==6 && flag==0) {
                    behand.add("7");behand.add("8");behand.add("9");behand.add("￥");behand.add("J");
                }
                else if(judge(a1.toString())==7 && flag==0) {
                    behand.add("8");behand.add("9");behand.add("￥");behand.add("J");behand.add("Q");
                }
                else if(judge(a1.toString())==8 && flag==0) {
                    behand.add("9");behand.add("￥");behand.add("J");behand.add("Q");behand.add("K");
                }
                else if(judge(a1.toString())==9 && flag==0) {
                    behand.add("￥");behand.add("J");behand.add("Q");behand.add("K");behand.add("A");
                }

                else if(judge(a1.toString())==1 && flag==1) {
                    middle.add("2");middle.add("3");middle.add("4");middle.add("5");middle.add("6");
                }
                else if(judge(a1.toString())==2 && flag==1) {
                    middle.add("3");middle.add("4");middle.add("5");middle.add("6");middle.add("7");
                }
                else if(judge(a1.toString())==3 && flag==1) {
                    middle.add("4");middle.add("5");middle.add("6");middle.add("7");middle.add("8");
                }
                else if(judge(a1.toString())==4 && flag==1) {
                    middle.add("5");middle.add("6");middle.add("7");middle.add("8");middle.add("9");
                }
                else if(judge(a1.toString())==5 && flag==1) {
                    middle.add("6");middle.add("7");middle.add("8");middle.add("9");middle.add("￥");
                }
                else if(judge(a1.toString())==6 && flag==1) {
                    middle.add("7");middle.add("8");middle.add("9");middle.add("￥");middle.add("J");
                }
                else if(judge(a1.toString())==7 && flag==1) {
                    middle.add("8");middle.add("9");middle.add("￥");middle.add("J");middle.add("Q");
                }
                else if(judge(a1.toString())==8 && flag==1) {
                    middle.add("9");middle.add("￥");middle.add("J");middle.add("Q");middle.add("K");
                }
                else if(judge(a1.toString())==9 && flag==1) {
                    middle.add("￥");middle.add("J");middle.add("Q");middle.add("K");middle.add("A");
                }
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);


            }
            //判断炸弹
            else if(a4.length() != 0 && a1.length() != 0) {
                out(a4.charAt(0)==1?10:a4.charAt(0),flag);
                out(a4.charAt(0)==1?10:a4.charAt(0),flag);
                out(a4.charAt(0)==1?10:a4.charAt(0),flag);
                out(a4.charAt(0)==1?10:a4.charAt(0),flag);
                out(a1.charAt(0)==1?10:a1.charAt(0),flag);
                a4.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=1;
                else if(flag ==1) flag2=1;
            }
            //判断葫芦
            else if(a3.length() != 0 && a2.length() != 0)
            {
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a2.charAt(0),flag);
                out(a2.charAt(0),flag);
                a3.deleteCharAt(0);
                a2.deleteCharAt(0);
                if (flag == 0) flag1=2;
                else if(flag ==1) flag2=2;
            }
            //判断同花
            else if(a1.length() >= 5 && c1.toString().contains(a1.toString())){
                out(a1.charAt(0),flag);
                out(a1.charAt(1),flag);
                out(a1.charAt(2),flag);
                out(a1.charAt(3),flag);
                out(a1.charAt(4),flag);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=7;
                else if(flag ==1) flag2=7;
            }
            //判断顺子(问题：只能从单张牌堆里面选顺子)
            else if(a1.length() >= 5 && judge(a1.toString())!=0)
            {
                if (judge(a1.toString())==1 && flag==0) {
                    behand.add("2");behand.add("3");behand.add("4");behand.add("5");behand.add("6");
                }
                else if(judge(a1.toString())==2 && flag==0) {
                    behand.add("3");behand.add("4");behand.add("5");behand.add("6");behand.add("7");
                }
                else if(judge(a1.toString())==3 && flag==0) {
                    behand.add("4");behand.add("5");behand.add("6");behand.add("7");behand.add("8");
                }
                else if(judge(a1.toString())==4 && flag==0) {
                    behand.add("5");behand.add("6");behand.add("7");behand.add("8");behand.add("9");
                }
                else if(judge(a1.toString())==5 && flag==0) {
                    behand.add("6");behand.add("7");behand.add("8");behand.add("9");behand.add("￥");
                }
                else if(judge(a1.toString())==6 && flag==0) {
                    behand.add("7");behand.add("8");behand.add("9");behand.add("￥");behand.add("J");
                }
                else if(judge(a1.toString())==7 && flag==0) {
                    behand.add("8");behand.add("9");behand.add("￥");behand.add("J");behand.add("Q");
                }
                else if(judge(a1.toString())==8 && flag==0) {
                    behand.add("9");behand.add("￥");behand.add("J");behand.add("Q");behand.add("K");
                }
                else if(judge(a1.toString())==9 && flag==0) {
                    behand.add("￥");behand.add("J");behand.add("Q");behand.add("K");behand.add("A");
                }

                else if(judge(a1.toString())==1 && flag==1) {
                    middle.add("2");middle.add("3");middle.add("4");middle.add("5");middle.add("6");
                }
                else if(judge(a1.toString())==2 && flag==1) {
                    middle.add("3");middle.add("4");middle.add("5");middle.add("6");middle.add("7");
                }
                else if(judge(a1.toString())==3 && flag==1) {
                    middle.add("4");middle.add("5");middle.add("6");middle.add("7");middle.add("8");
                }
                else if(judge(a1.toString())==4 && flag==1) {
                    middle.add("5");middle.add("6");middle.add("7");middle.add("8");middle.add("9");
                }
                else if(judge(a1.toString())==5 && flag==1) {
                    middle.add("6");middle.add("7");middle.add("8");middle.add("9");middle.add("￥");
                }
                else if(judge(a1.toString())==6 && flag==1) {
                    middle.add("7");middle.add("8");middle.add("9");middle.add("￥");middle.add("J");
                }
                else if(judge(a1.toString())==7 && flag==1) {
                    middle.add("8");middle.add("9");middle.add("￥");middle.add("J");middle.add("Q");
                }
                else if(judge(a1.toString())==8 && flag==1) {
                    middle.add("9");middle.add("￥");middle.add("J");middle.add("Q");middle.add("K");
                }
                else if(judge(a1.toString())==9 && flag==1) {
                    middle.add("￥");middle.add("J");middle.add("Q");middle.add("K");middle.add("A");
                }
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
            }
            //判断三条
            else if(a3.length() != 0 && a1.length() >= 2 ){
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a1.charAt(0),flag);
                out(a1.charAt(1),flag);
                a3.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=3;
                else if(flag ==1) flag2=3;
            }
            //判断二对
            else if(a2.length() >= 2 && a1.length() != 0 ){
                out(a2.charAt(0),flag);
                out(a2.charAt(0),flag);
                out(a2.charAt(1),flag);
                out(a2.charAt(1),flag);
                out(a1.charAt(0),flag);
                a2.deleteCharAt(0);
                a2.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=4;
                else if(flag ==1) flag2=4;
            }
            //判断一对
            else if(a2.length()!=0 && a1.length()>=3){
                out(a2.charAt(0),flag);
                out(a2.charAt(0),flag);
                out(a1.charAt(0),flag);
                out(a1.charAt(1),flag);
                out(a1.charAt(2),flag);
                a2.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=5;
                else if(flag ==1) flag2=5;
            }
            //判断五张散牌
            else if(a1.length() >=5)
            {
                out(a1.charAt(0),flag);
                out(a1.charAt(1),flag);
                out(a1.charAt(2),flag);
                out(a1.charAt(3),flag);
                out(a1.charAt(4),flag);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=6;
                else if(flag ==1) flag2=6;
            }
        }
    }
    //判断顺子
    private int judge(String str)
    {
        if(str.contains("23456")) return 1;
        else if(str.contains("34567")) return 2;
        else if(str.contains("45678")) return 3;
        else if(str.contains("56789")) return 4;
        else if(str.contains("678910")) return 5;
        else if(str.contains("78910J")) return 6;
        else if(str.contains("8910JQ")) return 7;
        else if(str.contains("910JQK")) return 8;
        else if(str.contains("10JQKA")) return 9;
        else return 0;
    }
    //判断同花顺
    private int judgeColor(String str)
    {
        if(str.contains("23456")) return 1;
        else if(str.contains("34567")) return 2;
        else if(str.contains("45678")) return 3;
        else if(str.contains("56789")) return 4;
        else if(str.contains("678910")) return 5;
        else if(str.contains("78910J")) return 6;
        else if(str.contains("8910JQ")) return 7;
        else if(str.contains("910JQK")) return 8;
        else if(str.contains("10JQKA")) return 9;
        else return 0;
    }

    //添加花色
    public void addColor(ArrayList<String> handPoker)
    {
        for (String s : behand)
        {
            for (String str : handPoker)
            {
                if(s.equals(str.substring(1)))
                {
                    behandColor.add(str);
                    handPoker.remove(str);
                    break;
                }
            }
        }
        for (String s : middle)
        {
            for (String str : handPoker)
            {
                if(s.equals(str.substring(1)))
                {
                    middleColor.add(str);
                    handPoker.remove(str);
                    break;
                }
            }
        }
        for (String s : front)
        {
            for (String str : handPoker)
            {
                if(s.equals(str.substring(1)))
                {
                    frontColor.add(str);
                    handPoker.remove(str);
                    break;
                }
            }
        }
    }

    //存牌
    private void out(char c,int flag)
    {
        //存后墩牌
        if(flag == 0)
        {
            behand.add(Character.toString(c));
        }
        //存中墩牌
        else if(flag == 1){
             middle.add(Character.toString(c));
        }
        //存前墩牌
        else if(flag == 2){
             front.add(Character.toString(c));
        }
    }
    //改变十的表示形式
    private ArrayList<String> changeTen(ArrayList<String> al)
    {
        ArrayList<String> temp = new ArrayList<String>();
        for (String s : al){
            temp.add(s);
        }
        for (int i = 0 ; i< temp.size();i++){
            if (temp.get(i).equals("&￥")) temp.set(i,"&10");
            else if (temp.get(i).equals("$￥")) temp.set(i,"$10");
            else if (temp.get(i).equals("#￥")) temp.set(i,"#10");
            else if (temp.get(i).equals("*￥")) temp.set(i,"*10");
        }
        return temp;
    }
    //出牌
    public void play()
    {
        for (String s : behandColor)
        {
            behand_f.add(s);
        }
        for (String s : middleColor)
        {
            middle_f.add(s);
        }
        for (String s : frontColor)
        {
            front_f.add(s);
        }
        if (flag1 == flag2){
            String str1 = behand.toString();
            String str2 = middle.toString();
            if(str1.compareTo(str2) < 0) {
                behand_f = new ArrayList<>();
                middle_f = new ArrayList<>();
                for (String s : behandColor)
                {
                    middle_f.add(s);
                }
                for (String s : middleColor)
                {
                    behand_f.add(s);
                }
          }
        }
        behand_f = changeTen(behand_f);
        middle_f = changeTen(middle_f);
        front_f = changeTen(front_f);
        System.out.println("后墩是：" + behand_f);
        System.out.println("中墩是：" + middle_f);
        System.out.println("前墩是：" + front_f);
    }

}
