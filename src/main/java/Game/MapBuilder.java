package Game;

import Mysql.MyJdbc;
import Windows.unit;

import java.util.ArrayList;

public class MapBuilder {

    public static int playerId;

    // 生成迷雾0
    public void buildUp(ArrayList<ArrayList<unit>> unitUp) {
        for(int i=0; i<6; i++){
            unitUp.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitUp.get(i).add(new unit(0, 999, 999, "0云.png", true) );
            }
        }
    }
    // 生成下层地图12345
    public void buildDown(ArrayList<ArrayList<unit>> unitDown) {

        for(int i=0; i<6; i++){
            unitDown.add(new ArrayList<unit>());
            for(int j=0; j<6; j++){
                unitDown.get(i).add(new unit(1, 10, 10, "1球.png", true) );
            }
        }
//##############################随机生成地图##################################################################
    int[] a;
    int num;
    num = 0;
    a = MyJdbc.queryTabMap(RandNum.randNum(1, MyJdbc.queryTabRowNum("map")));
    for(int i=0; i<3;i++){
        for(int j=0; j<3; j++){
            switch(a[num]){
                case 1:
                    String3 S3 = MyJdbc.queryTab1234("monster", RandNum.randNum(1, MyJdbc.queryTabRowNum("monster")));
                    unitDown.get(i).get(j).name = "1" + S3.str1 + ".png";
                    unitDown.get(i).get(j).hp = Integer.valueOf(S3.str2);
                    unitDown.get(i).get(j).atk = Integer.valueOf(S3.str3);
                    unitDown.get(i).get(j).type = 1;
                    break;
                case 3:
                    String3 S4 = MyJdbc.queryTab1234("item", RandNum.randNum(1, MyJdbc.queryTabRowNum("item")));
                    unitDown.get(i).get(j).name = "3" + S4.str1 + ".png";
                    unitDown.get(i).get(j).hp = Integer.valueOf(S4.str2);
                    unitDown.get(i).get(j).atk = Integer.valueOf(S4.str3);
                    unitDown.get(i).get(j).type = 3;
                    break;
                case 5:
                    unitDown.get(i).get(j).type = 5;
                    unitDown.get(i).get(j).visible = false;
                    break;
            }
            num++;
        }
    }

    num = 0;
    a = MyJdbc.queryTabMap(RandNum.randNum(1, MyJdbc.queryTabRowNum("map")));
    for(int i=3; i<6;i++){
        for(int j=0; j<3; j++){
            switch(a[num]){
                case 1:
                    String3 S3 = MyJdbc.queryTab1234("monster", RandNum.randNum(1, MyJdbc.queryTabRowNum("monster")));
                    unitDown.get(i).get(j).name = "1" + S3.str1 + ".png";
                    unitDown.get(i).get(j).hp = Integer.valueOf(S3.str2);
                    unitDown.get(i).get(j).atk = Integer.valueOf(S3.str3);
                    unitDown.get(i).get(j).type = 1;
                    break;
                case 3:
                    String3 S4 = MyJdbc.queryTab1234("item", RandNum.randNum(1, MyJdbc.queryTabRowNum("item")));
                    unitDown.get(i).get(j).name = "3" + S4.str1 + ".png";
                    unitDown.get(i).get(j).hp = Integer.valueOf(S4.str2);
                    unitDown.get(i).get(j).atk = Integer.valueOf(S4.str3);
                    unitDown.get(i).get(j).type = 3;
                    break;
                case 5:
                    unitDown.get(i).get(j).type = 5;
                    unitDown.get(i).get(j).visible = false;
                    break;
            }
            num++;
        }
    }

    num = 0;
    a = MyJdbc.queryTabMap(RandNum.randNum(1, MyJdbc.queryTabRowNum("map")));
    for(int i=0; i<3;i++){
        for(int j=3; j<6; j++){
            switch(a[num]){
                case 1:
                    String3 S3 = MyJdbc.queryTab1234("monster", RandNum.randNum(1, MyJdbc.queryTabRowNum("monster")));
                    unitDown.get(i).get(j).name = "1" + S3.str1 + ".png";
                    unitDown.get(i).get(j).hp = Integer.valueOf(S3.str2);
                    unitDown.get(i).get(j).atk = Integer.valueOf(S3.str3);
                    unitDown.get(i).get(j).type = 1;
                    break;
                case 3:
                    String3 S4 = MyJdbc.queryTab1234("item", RandNum.randNum(1, MyJdbc.queryTabRowNum("item")));
                    unitDown.get(i).get(j).name = "3" + S4.str1 + ".png";
                    unitDown.get(i).get(j).hp = Integer.valueOf(S4.str2);
                    unitDown.get(i).get(j).atk = Integer.valueOf(S4.str3);
                    unitDown.get(i).get(j).type = 3;
                    break;
                case 5:
                    unitDown.get(i).get(j).type = 5;
                    unitDown.get(i).get(j).visible = false;
                    break;
            }
            num++;
        }
    }

    num = 0;
    a = MyJdbc.queryTabMap(RandNum.randNum(1, MyJdbc.queryTabRowNum("map")));
    for(int i=3; i<6;i++){
        for(int j=3; j<6; j++){
            switch(a[num]){
                case 1:
                    String3 S3 = MyJdbc.queryTab1234("monster", RandNum.randNum(1, MyJdbc.queryTabRowNum("monster")));
                    unitDown.get(i).get(j).name = "1" + S3.str1 + ".png";
                    unitDown.get(i).get(j).hp = Integer.valueOf(S3.str2);
                    unitDown.get(i).get(j).atk = Integer.valueOf(S3.str3);
                    unitDown.get(i).get(j).type = 1;
                    break;
                case 3:
                    String3 S4 = MyJdbc.queryTab1234("item", RandNum.randNum(1, MyJdbc.queryTabRowNum("item")));
                    unitDown.get(i).get(j).name = "3" + S4.str1 + ".png";
                    unitDown.get(i).get(j).hp = Integer.valueOf(S4.str2);
                    unitDown.get(i).get(j).atk = Integer.valueOf(S4.str3);
                    unitDown.get(i).get(j).type = 3;
                    break;
                case 5:
                    unitDown.get(i).get(j).type = 5;
                    unitDown.get(i).get(j).visible = false;
                    break;
            }
            num++;
        }
    }


//##############################随机生成地图##################################################################
    }

    public unit buildPlayer(ArrayList<ArrayList<unit>> unitDown, int playerX, int playerY){

        playerId = RandNum.randNum(1, MyJdbc.queryTabRowNum("player"));
        String3 S3 = MyJdbc.queryTab1234("player", playerId);
        unitDown.get(playerX).get(playerY).name = "2" + S3.str1 + ".png";
        unitDown.get(playerX).get(playerY).hp = Integer.valueOf(S3.str2);
        unitDown.get(playerX).get(playerY).atk = Integer.valueOf(S3.str3);
        unitDown.get(playerX).get(playerY).type = 2;
        unitDown.get(playerX).get(playerY).visible = true;
        return unitDown.get(playerX).get(playerY);

    }

    public unit buildBoss (ArrayList<ArrayList<unit>> unitDown, int bossX, int bossY) {

        String3 S3 = MyJdbc.queryTab1234("boss", RandNum.randNum(1, MyJdbc.queryTabRowNum("boss")));
        unitDown.get(bossX).get(bossY).name = "4" + S3.str1 + ".png";
        unitDown.get(bossX).get(bossY).hp = Integer.valueOf(S3.str2);
        unitDown.get(bossX).get(bossY).atk = Integer.valueOf(S3.str3);
        unitDown.get(bossX).get(bossY).type = 4;
        unitDown.get(bossX).get(bossY).visible = true;
        return unitDown.get(bossX).get(bossY);
    }
}
