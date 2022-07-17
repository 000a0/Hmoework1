package homework1;

//import homework1.Lost;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        testOfSort();
        testOfSelect();
    }

    public static void sortLost(Lost[] lostArray){
        //冒泡
        for (int i = 0; i < lostArray.length-1; i++) {
            for (int j = 0; j < lostArray.length-1-i; j++) {
                if (lostArray[j].time.isAfter(lostArray[j+1].time)) {
                    Lost temp=lostArray[j];
                    lostArray[j]=lostArray[j+1];
                    lostArray[j+1]=temp;
                }
            }
        }

    }


    //按关键字——失物领取地点搜索
    public static Lost selectByKeyword(Lost[] lostArray, String keyword){
        for(int i = 0;i < lostArray.length;i++){
            if(lostArray[i].location.equals(keyword)){
                System.out.println("已找到失物");
                return lostArray[i];
            }
        }
        System.out.println("未搜索到失物");
        return null;

    }

    public static void testOfSort(){
        //初始化失物对象数组
        Lost lostThings [] = new Lost[5];

        for(int i=0;i<lostThings.length;i++)
            lostThings[i]=new Lost();

        //数据例子
        lostThings[0].time = LocalDateTime.of(2022,4,15,12,21);
        lostThings[1].time = LocalDateTime.of(2022,8,13,14,50);
        lostThings[2].time = LocalDateTime.of(2021,1,15,19,52);
        lostThings[3].time = LocalDateTime.of(2022,4,15,6,10);
        lostThings[4].time = LocalDateTime.of(2021,6,13,22,2);

        //测试
        sortLost(lostThings);

        //输出经过排序的时间
        for(int i = 0;i < lostThings.length;i++) {
            System.out.println(lostThings[i].time);
        }

    }

    public static void testOfSelect(){
        //初始化
        Lost lostThings [] = new Lost[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入地点");
        String keyWord = scanner.nextLine();
        for(int i=0;i<lostThings.length;i++) {
            lostThings[i] = new Lost();
        }

        //举例
        lostThings[0].location = "实验楼";
        lostThings[1].location = "三教";
        lostThings[2].location = "四教";
        lostThings[3].location = "五教";
        lostThings[4].location = "八教";

        //测试
        selectByKeyword(lostThings,keyWord);


    }
}

