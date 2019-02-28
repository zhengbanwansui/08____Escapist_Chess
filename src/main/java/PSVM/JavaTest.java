package PSVM;

import Game.BattleGround;
import Game.MapBuilder;
import Windows.AutoBGJpanel;
import Windows.Win;
import Windows.unit;

import javax.swing.*;
import java.util.ArrayList;

public class JavaTest {

    public static void main(String[] args) {
        // 图形界面
        Win win = new Win();
        // 出生点
        int playerRandomX = 3;
        int playerRandomY = 2;
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
        // 生成可操控角色playerUnit
        unit playerUnit = mapBuilder.buildPlayer(unitDown, playerRandomX, playerRandomY);
        // 根据unitUp和unitDown生成战争迷雾2d和物品敌人2d
        win.drawUp(unitUp);
        win.drawDown(unitDown);
        // 可操控角色2d引用
        AutoBGJpanel playerJPanel = win.jpDown.get(playerRandomX).get(playerRandomY);
        // 人物头顶迷雾散开
        unitUp.get(playerRandomX).get(playerRandomY).visible = false;
        win.jpUp.get(playerRandomX).get(playerRandomY).setVisible(false);
        // Map不可见
        win.map.setVisible(false);
        // 窗口可见
        win.setVisible(true);
        //--------------------------------------------初始化完毕---------------------------------------------------
        int playerX = playerRandomX;
        int playerY = playerRandomY;
        int targetX = 99999;
        int targetY = 99999;

        while(! win.startGame){ try{System.out.println("没开始游戏等待中");Thread.sleep(100);}catch(Exception e){e.getStackTrace();} }
        // 按键归位
        win.direction = "中";
        // 人物属性面板初始化
        win.jLabelNameValue.setText(playerUnit.name);
        win.jLabelHpValue.setText(String.valueOf(playerUnit.hp));
        win.jLabelAtkValue.setText(String.valueOf(playerUnit.atk));
        while(true){
            // 防卡死
            try{Thread.sleep(50);}catch(Exception e){e.getStackTrace();}
            // 检测按键动作
            while( ! win.direction.equals("中") ) {
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
                // 撞墙 无法移动 break
                if (targetX>5 || targetX<0 || targetY>5 || targetY<0){
                    System.out.println("撞墙 无法移动");
                    break;
                }
                // 撞雾 不动 迷雾散开 break
                if (unitUp.get(targetX).get(targetY).visible) {
                    System.out.println("撞雾 不动 迷雾散开");
                    unitUp.get(targetX).get(targetY).visible = false;
                    win.jpUp.get(targetX).get(targetY).setVisible(false);
                    break;
                }
                // 撞奖励物品 加属性 设置不可见 动 break
                if ( unitDown.get(targetX).get(targetY).visible && unitDown.get(targetX).get(targetY).type == 3 ) {
                    System.out.println("撞奖励物品 加属性 物品消失 移动");
                    playerUnit.hp += unitDown.get(targetX).get(targetY).hp;  // 加属性
                    playerUnit.atk += unitDown.get(targetX).get(targetY).atk;// 加属性
                    unitDown.get(targetX).get(targetY).visible = false;      // 设置不可见
                    win.jpDown.get(targetX).get(targetY).setVisible(false);  // 设置不可见
                    playerX = targetX;// 人物移动
                    playerY = targetY;// 人物移动
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
                    win.jLabelAtkValue.setText( String.valueOf(playerUnit.atk) ); // 更新人物属性面板
                    win.jLabelHpValue.setText( String.valueOf(playerUnit.hp) );   // 更新人物属性面板
                    break;
                }
                // 撞空气直接移动 撞出生点直接移动 break
                if ( ! unitDown.get(targetX).get(targetY).visible || unitDown.get(targetX).get(targetY).type == 2) {
                    System.out.println("撞空气直接移动");
                    playerX = targetX;// 人物移动
                    playerY = targetY;// 人物移动
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
                // 撞怪物 战斗 break
                if ( unitDown.get(targetX).get(targetY).visible && unitDown.get(targetX).get(targetY).type == 1 ) {
                    System.out.println("撞怪物 战斗 break");

                    // 开辟战场
                    BattleGround BG = new BattleGround(playerUnit.hp, playerUnit.atk, playerUnit.name,
                    unitDown.get(targetX).get(targetY).hp,
                    unitDown.get(targetX).get(targetY).atk,
                    unitDown.get(targetX).get(targetY).name);

                    // 开始战斗
                    BG.fight(win, playerUnit, targetX, targetY, unitDown);

                    win.jLabelAtkValue.setText( String.valueOf(playerUnit.atk) ); // 更新人物属性
                    win.jLabelHpValue.setText( String.valueOf(playerUnit.hp) );   // 更新人物属性

                    break;
                }
            }
        }
    }

}
