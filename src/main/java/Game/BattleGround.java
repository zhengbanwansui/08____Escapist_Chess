package Game;

import Windows.AutoBGJpanel;
import Windows.Win;
import Windows.unit;

import java.util.ArrayList;

public class BattleGround {

    private int hp1;
    private int atk1;
    private String name1;
    private int hp2;
    private int atk2;
    private String name2;

    public BattleGround(int hp1, int atk1, String name1, int hp2, int atk2, String name2) {
        this.hp1 = hp1;
        this.atk1 = atk1;
        this.name1 = name1;
        this.hp2 = hp2;
        this.atk2 = atk2;
        this.name2 = name2;
    }

    // 战斗界面里的攻击移动
    private static void lerpMove(AutoBGJpanel player, String playerName, AutoBGJpanel emeny, String emenyName, String drc, int moveLength) {
        for(int i=0; i<40; i++){
            //try{Thread.sleep(200);}catch(Exception e){e.getStackTrace();}
            switch (drc) {
                case "左":
                    if (i < 20) {
                        emeny.setLocation(emeny.getX() - moveLength/20, emeny.getY());
                        try{Thread.sleep(i);}catch(Exception e){e.getStackTrace();}
                        if (i == 15) {
                            // 主角受击
                            player.paintComponentSelfChoosePic("受击.png");
                            player.updateUI();
                        }
                    }else{
                        emeny.setLocation(emeny.getX() + moveLength/20, emeny.getY());
                        try{Thread.sleep(i-20);}catch(Exception e){e.getStackTrace();}
                        if (i == 25) {
                            // 主角受击消失
                            player.paintComponentSelfChoosePic(playerName);
                            player.updateUI();
                        }
                    }
                    break;
                case "右":
                    if (i < 20) {
                        player.setLocation(player.getX() + moveLength/20, player.getY());
                        try{Thread.sleep(i);}catch(Exception e){e.getStackTrace();}
                        if (i == 15) {
                            // 敌人受击
                            emeny.paintComponentSelfChoosePic("受击.png");
                            emeny.updateUI();
                        }
                    }else{
                        player.setLocation(player.getX() - moveLength/20, player.getY());
                        try{Thread.sleep(i-20);}catch(Exception e){e.getStackTrace();}
                        if (i == 25) {
                            // 敌人受击消失
                            emeny.paintComponentSelfChoosePic(emenyName);
                            emeny.updateUI();
                        }
                    }
                    break;
            }
        }
    }

    // 地图内的移动
    public static void lerpMoveInMap(AutoBGJpanel player, String drc) {
        for(int i=0; i<35; i++){
            switch (drc) {
                case "上":
                    player.setLocation(player.getX(), player.getY() - 2);
                    break;
                case "下":
                    player.setLocation(player.getX(), player.getY() + 2);
                    break;
                case "左":
                    player.setLocation(player.getX() - 2, player.getY());
                    break;
                case "右":
                    player.setLocation(player.getX() + 2, player.getY());
                    break;
            }
            try{Thread.sleep(3);}catch(Exception e){e.getStackTrace();}
        }
    }

    public boolean fight(Win win, unit playerUnit, unit enemyUnit, int targetX, int targetY, ArrayList<ArrayList<unit>> unitDown) {
        System.out.println("|||||||||-----开始fight-----|||||||||");
        // 生成战场
        win.battleGround.setVisible(true);
        // 主角上场
        win.p1UI.paintComponentSelfChoosePic(playerUnit.name);
        // 敌人上场
        win.p2UI.paintComponentSelfChoosePic(enemyUnit.name);
        for(int turns = 1;hp1 > 0 && hp2 > 0; turns++) {
            if(turns % 2 == 1){
                System.out.println("主角攻击回合 " + hp1 + " " + hp2);
                hp2 -= atk1;
                lerpMove(win.p1UI, playerUnit.name, win.p2UI, enemyUnit.name,"右", 200);
            }
            else{
                System.out.println("敌人攻击回合 " + hp1 + " " + hp2);
                hp1 -= atk2;
                lerpMove(win.p1UI, playerUnit.name, win.p2UI, enemyUnit.name, "左", 200);
            }
        }
        if(hp1 <= 0){
            System.out.println("敌人Win!");
            win.defeatUI.setVisible(true);
            try{Thread.sleep(1200);}catch(Exception e){e.getStackTrace();}
            win.defeatUI.setVisible(false);
            win.battleGround.setVisible(false);
            playerUnit.hp = 9 * playerUnit.hp / 10;
            System.out.println("|||||||||-----结束fight-----|||||||||");
            return false;
        }
        else{
            System.out.println("主角Win!");
            win.winUI.setVisible(true);
            try{Thread.sleep(1200);}catch(Exception e){e.getStackTrace();}
            win.winUI.setVisible(false);
            win.battleGround.setVisible(false);
            // 敌人消失
            unitDown.get(targetX).get(targetY).visible =false;
            win.jpDown.get(targetX).get(targetY).setVisible(false);
            // 主角血量变少
            playerUnit.hp = hp1;
            System.out.println("|||||||||-----结束fight-----|||||||||");
            return true;
        }
    }

}
