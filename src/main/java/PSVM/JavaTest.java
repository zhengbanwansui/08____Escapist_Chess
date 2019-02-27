package PSVM;

import Game.MapBuilder;
import Windows.Win;
import Windows.unit;

import javax.swing.*;
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
        // 生成战争迷雾unit unit的visible为true时显示2d图片
        mapBuilder.buildUp(unitUp);
        // 生成物品敌人unit
        mapBuilder.buildDown(unitDown);
        // 生成可操控角色unit
        unit playerUnit = mapBuilder.buildPlayer(unitDown);
        // 人物头顶迷雾散开
        unitUp.get(3).get(2).visible = false;
        // 根据unitUp和unitDown生成战争迷雾2d和物品敌人2d
        win.drawUp(unitUp);
        win.drawDown(unitDown);
        JPanel playerJPanel = win.jpDown.get(3).get(2);
        win.jpUp.get(3).get(2).setVisible(false);
        // Map不可见
        win.map.setVisible(false);
        // 窗口可见
        win.setVisible(true);
        //--------------------------------------------初始化完毕---------------------------------------------------
        int playerHp = 200;
        int playerAtk = 20;
        int playerX = 3;
        int playerY = 2;
        int targetX = 99999;
        int targetY = 99999;
        System.out.println("没开始游戏等待中");
        while(! win.startGame){
            try{Thread.sleep(500);}catch(Exception e){e.getStackTrace();}
        }
        System.out.println("按键归位");
        win.direction = "中";
        while(true){
            // 防卡死
            try{Thread.sleep(50);}catch(Exception e){e.getStackTrace();}
            // 检测按键动作
            while( ! win.direction.equals("中") ) {
                System.out.println("玩家原位 " + playerX + " " + playerY);
                String drc = win.direction;
                win.direction = "中";
                System.out.println("----人物向"+drc+"移动了---------------------------------------------------------");
                switch(drc){
                    case "上" :
                        targetX = playerX;
                        targetY = playerY - 1;
                        break;
                    case "下" :
                        targetX = playerX;
                        targetY = playerY + 1;
                        break;
                    case "左" :
                        targetX = playerX - 1;
                        targetY = playerY;
                        break;
                    case "右" :
                        targetX = playerX + 1;
                        targetY = playerY;
                        break;
                    default :
                        System.out.println("zjx异常 : 重大错误方向出错");
                }
                System.out.println("玩家目标位 " + targetX + " & " + targetY);
                // 撞墙 不动 无操作 break
                if (targetX>5 || targetX<0 || targetY>5 || targetY<0){
                    System.out.println("撞墙 无法移动");
                    break;
                }
                // 撞雾 不动 设置不可见 break
                if (unitUp.get(targetX).get(targetY).visible) {
                    System.out.println("撞雾 不动 设置不可见");
                    unitUp.get(targetX).get(targetY).visible = false;
                    win.jpUp.get(targetX).get(targetY).setVisible(  unitUp.get(targetX).get(targetY).visible  );
                    break;
                }
                // 撞奖励物品 加属性 设置不可见 动 break
                if ( unitDown.get(targetX).get(targetY).visible && unitDown.get(targetX).get(targetY).type == 3 ) {
                    System.out.println("撞奖励物品 加属性 设置不可见 动");
                    playerHp += unitDown.get(targetX).get(targetY).hp;// 加属性
                    playerAtk += unitDown.get(targetX).get(targetY).atk;
                    unitDown.get(targetX).get(targetY).visible = false;// 设置不可见
                    win.jpDown.get(targetX).get(targetY).setVisible(false);
                    playerX = targetX;// 人物移动
                    playerY = targetY;
                    switch(drc) {
                        case "上":
                            playerJPanel.setLocation(playerJPanel.getLocation().x, playerJPanel.getLocation().y - 70);
                            break;
                        case "下":
                            playerJPanel.setLocation(playerJPanel.getLocation().x, playerJPanel.getLocation().y + 70);
                            break;
                        case "左":
                            playerJPanel.setLocation(playerJPanel.getLocation().x - 70, playerJPanel.getLocation().y);
                            break;
                        case "右":
                            playerJPanel.setLocation(playerJPanel.getLocation().x + 70, playerJPanel.getLocation().y);
                            break;
                        default:
                            System.out.println("zjx异常 : 重大错误人物移动");
                    }
                    break;
                }
                // 撞空气直接移动 撞出生点直接移动
                if ( ! unitDown.get(targetX).get(targetY).visible || unitDown.get(targetX).get(targetY).type == 2) {
                    System.out.println("撞空气直接移动");
                    playerX = targetX;// 人物移动
                    playerY = targetY;
                    switch(drc) {
                        case "上":
                            playerJPanel.setLocation(playerJPanel.getLocation().x, playerJPanel.getLocation().y - 70);
                            break;
                        case "下":
                            playerJPanel.setLocation(playerJPanel.getLocation().x, playerJPanel.getLocation().y + 70);
                            break;
                        case "左":
                            playerJPanel.setLocation(playerJPanel.getLocation().x - 70, playerJPanel.getLocation().y);
                            break;
                        case "右":
                            playerJPanel.setLocation(playerJPanel.getLocation().x + 70, playerJPanel.getLocation().y);
                            break;
                        default:
                            System.out.println("zjx异常 : 重大错误人物移动");
                    }
                    break;
                }
            }
        }
    }

}
