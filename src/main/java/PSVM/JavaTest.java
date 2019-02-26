package PSVM;

import Game.MapBuilder;
import Windows.Win;
import Windows.unit;

import java.util.ArrayList;

public class JavaTest {

    public static void main(String[] args) {
        // 图形界面
        Win win = new Win();
        // 战争迷雾单位
        ArrayList<ArrayList<unit>> unitUp = new ArrayList<>();
        // 生物物品单位
        ArrayList<ArrayList<unit>> unitDown = new ArrayList<>();
        // 地图生成器
        MapBuilder mapBuilder = new MapBuilder();
        // 生成战争迷雾unit
        mapBuilder.buildUp(unitUp);
        // 生成物品敌人unit
        mapBuilder.buildDown(unitDown);
        // 人物头顶迷雾透明
        mapBuilder.buildPlayer(unitDown);
        // 根据unit生成战争迷雾2d和物品敌人2d
        win.drawUp(unitUp);
        win.drawDown(unitDown);
        win.jpUp.get(3).get(2).setVisible(false);
        // Map不可见
        win.map.setVisible(false);
        // 窗口可见
        win.setVisible(true);
        //--------------------------------------------初始化完毕---------------------------------------------------
        int playerX = 3;
        int playerY = 2;
        while(! win.startGame){
            System.out.println("没开始游戏等待中" + win.getRootPane().isFocusable());
            try{Thread.sleep(500);}catch(Exception e){e.getStackTrace();}
        }
        System.out.println("按键归位");
        win.direction = "中";
        win.requestFocus();
        while(true){
            // 防卡死
            System.out.println("游戏开始后循环中" + win.getRootPane().isFocusable());
            try{Thread.sleep(500);}catch(Exception e){e.getStackTrace();}
            while( ! win.direction.equals("中") ) {
                System.out.println("人物向"+win.direction+"移动了");
                win.direction = "中";
            }
        }
    }

}
