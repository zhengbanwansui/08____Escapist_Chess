package Mysql;

import Game.RandNum;
import Game.String3;

public class test {
    public static void main(String[] args) {

        int bossRandNum = RandNum.randNum(1,JDBC.queryTabRowNum("boss"));
        String3 S3 = JDBC.queryTab1234("boss", bossRandNum);
        S3.show();

    }
}
