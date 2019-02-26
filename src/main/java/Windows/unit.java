package Windows;

public class unit {
    // 单位类型
    public int type;
    // 生命
    public int hp;
    // 攻击力
    public int atk;
    // 名字
    public String name;

    public unit(int type, int hp, int atk, String name) {
        this.type = type;
        this.hp = hp;
        this.atk = atk;
        this.name = name;
    }
}
