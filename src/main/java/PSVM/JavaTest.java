package PSVM;

import Game.BattleGround;
import Game.MapBuilder;
import Game.RandNum;
import Windows.AutoBGJpanel;
import Windows.Win;
import Windows.unit;
import java.util.ArrayList;

import static Game.MapBuilder.playerId;

public class JavaTest {

    public static void main(String[] args) {
        // 图形界面
        Win win = new Win();
        // 随机出生点, 随机boss位置, 随机出口位置
        int playerRandomX = RandNum.randNum(1, 4);
        int playerRandomY = RandNum.randNum(1, 4);
        int bossRandomDrc = RandNum.randNum(1, 4);
        int bossRandomPOS = RandNum.randNum(0, 4);
        int bossX = 999, bossY = 999, exitX = 999, exitY = 999;
        switch (bossRandomDrc) {
            case 1:
                bossX = bossRandomPOS;
                bossY = 0;
                exitX = bossX;
                exitY = bossY - 1;
                break;
            case 2:
                bossX = 5;
                bossY = bossRandomPOS;
                exitX = bossX + 1;
                exitY = bossY;
                break;
            case 3:
                bossX = bossRandomPOS + 1;
                bossY = 5;
                exitX = bossX;
                exitY = bossY + 1;
                break;
            case 4:
                bossX = 0;
                bossY = bossRandomPOS + 1;
                exitX = bossX - 1;
                exitY = bossY;
                break;
        }
        System.out.println("Boss位置(" + bossX + " , " + bossY + ")  (" + exitX + " , " + exitY + ")");
        win.setLocationExitDoorJPanel(exitX, exitY);
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
        // 生成Boss 生成出口
        unit boss = mapBuilder.buildBoss(unitDown, bossX, bossY);
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

        System.out.println("初始化完成 准备开始游戏");

        while(! win.startGame){ try{Thread.sleep(100);}catch(Exception e){e.getStackTrace();} }
        // 按键归位
        win.direction = "中";
        // 人物属性面板初始化
        win.jLabelNameValue.setText(playerUnit.name);
        win.jLabelHpValue.setText(String.valueOf(playerUnit.hp));
        win.jLabelAtkValue.setText(String.valueOf(playerUnit.atk));
        boolean gameIsWin = false;
        while( ! gameIsWin){
            // 防卡死
            try{Thread.sleep(20);}catch(Exception e){e.getStackTrace();}
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
                // 击败boss后 boss消失 出口JPanel为显示状态 玩家的target坐标是出口坐标 则显示游戏胜利图片 此时map隐藏起来 其他if条件关闭
                if (win.exitDoorJPanelVisible && targetX == exitX && targetY == exitY) {
                    win.gamePassJPanel.setVisible(true);
                    win.gamePassJPanel.updateUI();
                    win.map.setVisible(false);
                    win.map.updateUI();
                    win.exitDoorJPanel.setVisible(false);
                    win.exitDoorJPanel.updateUI();
                    gameIsWin = true;
                    System.out.println("||||||||------恭喜通关-----||||||||");
                    break;
                }
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
                // 撞奖励物品 加属性 设置不可见 移动 break
                if ( unitDown.get(targetX).get(targetY).visible && unitDown.get(targetX).get(targetY).type == 3 ) {
                    System.out.println("撞奖励物品 加属性 物品消失 移动");
                    playerUnit.hp += unitDown.get(targetX).get(targetY).hp;  // 加属性
                    playerUnit.atk += unitDown.get(targetX).get(targetY).atk;// 加属性
                    unitDown.get(targetX).get(targetY).visible = false;      // 设置不可见
                    win.jpDown.get(targetX).get(targetY).setVisible(false);  // 设置不可见
                    playerX = targetX;// 人物移动
                    playerY = targetY;// 人物移动
                    BattleGround.lerpMoveInMap(playerJPanel, drc);
                    win.jLabelAtkValue.setText( String.valueOf(playerUnit.atk) ); // 更新人物属性面板
                    win.jLabelHpValue.setText( String.valueOf(playerUnit.hp) );   // 更新人物属性面板
                    break;
                }
                // 撞空气直接移动 撞出生点直接移动 break
                if ( ! unitDown.get(targetX).get(targetY).visible || unitDown.get(targetX).get(targetY).type == 2) {
                    System.out.println("撞空气直接移动");
                    playerX = targetX;// 人物移动
                    playerY = targetY;// 人物移动
                    BattleGround.lerpMoveInMap(playerJPanel, drc);
                    break;
                }
                // 撞怪物&&Boss 战斗 break
                if ( unitDown.get(targetX).get(targetY).visible && unitDown.get(targetX).get(targetY).type == 1 ||
                     unitDown.get(targetX).get(targetY).visible && unitDown.get(targetX).get(targetY).type == 4 ) {
                    System.out.println("撞怪物&&Boss 战斗 break");

                    // 开辟战场
                    BattleGround BG = new BattleGround(playerUnit.hp, playerUnit.atk, playerUnit.name,
                    unitDown.get(targetX).get(targetY).hp,
                    unitDown.get(targetX).get(targetY).atk,
                    unitDown.get(targetX).get(targetY).name);

                    // 开始战斗
                    boolean bol = BG.fight(win, playerUnit, unitDown.get(targetX).get(targetY), targetX, targetY, unitDown,playerId);

                    // 击败boss显示出口
                    if (bol && unitDown.get(targetX).get(targetY).type == 4) {
                        win.exitDoorJPanel.setVisible(true);
                        win.exitDoorJPanel.updateUI();
                        win.exitDoorJPanelVisible = true;
                        System.out.println("{{{{{{显示}}}}}}}}------>>>出口 坐标X:"+win.exitDoorJPanel.getX()+"坐标Y:" +win.exitDoorJPanel.getY());
                    }

                    win.jLabelAtkValue.setText( String.valueOf(playerUnit.atk) ); // 更新人物属性
                    win.jLabelHpValue.setText( String.valueOf(playerUnit.hp) );   // 更新人物属性

                    break;
                }
            }
        }
        System.out.println("游戏运行完了, 总循环while被break掉了");
    }


}
