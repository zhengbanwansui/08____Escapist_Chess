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
                unitDown.get(i).add(new unit(1, 100, 50, "1狗.png", true) );
            }
        }
        for(int i=2; i<3; i++){
            unitDown.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitDown.get(i).add(new unit(1, 500, 100, "1兔子.png", true) );
            }
        }
        for(int i=3; i<4; i++){
            unitDown.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitDown.get(i).add(new unit(1, 20, 50, "1球.png", true) );
            }
        }
        for(int i=4; i<6; i++){
            unitDown.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitDown.get(i).add(new unit(3, 50, 10, "3香蕉.png", true) );
            }
        }
    }

    public unit buildPlayer(ArrayList<ArrayList<unit>> unitDown, int x, int y){

        unitDown.get(3).get(2).name = "2路飞.png";
        unitDown.get(3).get(2).atk = 5;
        unitDown.get(3).get(2).hp = 1000;
        unitDown.get(3).get(2).type = 2;
        unitDown.get(3).get(2).visible = true;
        return unitDown.get(3).get(2);

    }
}
