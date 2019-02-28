package Game;

import Windows.AutoBGJpanel;
import Windows.Win;
import Windows.unit;

import java.util.ArrayList;

public class BattleGround {

    int hp1;
    int atk1;
    String name1;
    int hp2;
    int atk2;
    String name2;

    public BattleGround(int hp1, int atk1, String name1, int hp2, int atk2, String name2) {
        this.hp1 = hp1;
        this.atk1 = atk1;
        this.name1 = name1;
        this.hp2 = hp2;
        this.atk2 = atk2;
        this.name2 = name2;
    }

    private void lerpMove(AutoBGJpanel mother, AutoBGJpanel child, String drc, int moveLength) {

    }

    public void fight(Win win, unit playerUnit, int targetX, int targetY, ArrayList<ArrayList<unit>> unitDown) {
        System.out.println("|||||||||-----开始fight-----|||||||||");
        win.battleGround.setVisible(true);
        for(int turns = 1;hp1 > 0 && hp2 > 0; turns++) {
            if(turns % 2 == 1){
                System.out.println("主角攻击回合 " + hp1 + " " + hp2);
                hp2 -= atk1;
                try{Thread.sleep(500);}catch(Exception e){e.getStackTrace();}
            }
            else{
                System.out.println("敌人攻击回合 " + hp1 + " " + hp2);
                hp1 -= atk2;
                try{Thread.sleep(500);}catch(Exception e){e.getStackTrace();}
            }
        }
        if(hp1 <= 0){
            System.out.println("敌人Win!");
            win.defeatUI.setVisible(true);
            try{Thread.sleep(2000);}catch(Exception e){e.getStackTrace();}
            win.defeatUI.setVisible(false);
            win.battleGround.setVisible(false);
            playerUnit.hp = 9 * playerUnit.hp / 10;
        }
        else{
            System.out.println("主角Win!");
            win.winUI.setVisible(true);
            try{Thread.sleep(2000);}catch(Exception e){e.getStackTrace();}
            win.winUI.setVisible(false);
            win.battleGround.setVisible(false);
            // 敌人消失
            unitDown.get(targetX).get(targetY).visible =false;
            win.jpDown.get(targetX).get(targetY).setVisible(false);
            // 主角血量变少
            playerUnit.hp = hp1;
        }
        System.out.println("|||||||||-----结束fight-----|||||||||");
    }

}
