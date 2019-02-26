package Game;

import Windows.Win;
import Windows.unit;

import java.util.ArrayList;

public class MapBuilder {

    public void buildUp(ArrayList<ArrayList<unit>> unitUp) {
        for(int i=0; i<6; i++){
            unitUp.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitUp.get(i).add(new unit(0, 30, 2, "0云.png") );
            }
        }
    }

    public void buildDown(ArrayList<ArrayList<unit>> unitDown) {
        for(int i=0; i<6; i++){
            unitDown.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitDown.get(i).add(new unit(0, 30, 2, "1狗.png") );
            }
        }
    }

    public void buildPlayer(ArrayList<ArrayList<unit>> unitDown){
        int x = 3;
        int y = 2;
        unitDown.get(3).get(2).name = "2路飞.png";
        unitDown.get(3).get(2).atk = 5;
        unitDown.get(3).get(2).hp = 1000;
        unitDown.get(3).get(2).type = 2;
    }


}
