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
    // 可见性
    public boolean visible;

    public unit(int type, int hp, int atk, String name, boolean visible) {
        this.type = type;
        this.hp = hp;
        this.atk = atk;
        this.name = name;
        this.visible = visible;
    }
}
