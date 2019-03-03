package Game;

import Windows.Win;
import Windows.unit;

import java.util.ArrayList;

public class MapBuilder {

    public void buildUp(ArrayList<ArrayList<unit>> unitUp) {
        for(int i=0; i<6; i++){
            unitUp.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitUp.get(i).add(new unit(0, 999, 999, "0云.png", true) );
            }
        }
    }

    public void buildDown(ArrayList<ArrayList<unit>> unitDown) {
        for(int i=0; i<2; i++){
            unitDown.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitDown.get(i).add(new unit(1, 10, 50, "1狗.png", true) );
            }
        }
        for(int i=2; i<3; i++){
            unitDown.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitDown.get(i).add(new unit(1, 10, 10, "1兔子.png", true) );
            }
        }
        for(int i=3; i<4; i++){
            unitDown.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitDown.get(i).add(new unit(1, 10, 50, "1球.png", true) );
            }
        }
        for(int i=4; i<6; i++){
            unitDown.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitDown.get(i).add(new unit(3, 10, 10, "3香蕉.png", true) );
            }
        }
    }

    public unit buildPlayer(ArrayList<ArrayList<unit>> unitDown, int playerX, int playerY){

        unitDown.get(playerX).get(playerY).name = "2路飞.png";
        unitDown.get(playerX).get(playerY).atk = 500;
        unitDown.get(playerX).get(playerY).hp = 1000;
        unitDown.get(playerX).get(playerY).type = 2;
        unitDown.get(playerX).get(playerY).visible = true;
        return unitDown.get(playerX).get(playerY);

    }

    public unit buildBoss (ArrayList<ArrayList<unit>> unitDown, int bossX, int bossY) {
        unitDown.get(bossX).get(bossY).name = "4恐龙小子.png";
        unitDown.get(bossX).get(bossY).atk = 30;
        unitDown.get(bossX).get(bossY).hp = 100;
        unitDown.get(bossX).get(bossY).type = 4;
        unitDown.get(bossX).get(bossY).visible = true;
        return unitDown.get(bossX).get(bossY);
    }
}
