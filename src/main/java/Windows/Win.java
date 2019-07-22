package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import static java.awt.font.TextAttribute.FONT;

public class Win extends JFrame implements ActionListener {

    public BGJPanel rootPanel;    // 根面板
    private MVJPanel jpTop;        // 拖动标题栏
    private JButton small,out;     // 最小化最大化按钮
    public JPanel map;            // 地图位置范围
    public JButton btn;           // 开始游戏
    public JLabel jLabelHp, jLabelAtk, jLabelName;
    public JLabel jLabelHpValue, jLabelAtkValue, jLabelNameValue;
    public String direction = "中";
    public boolean startGame = false; // 按开始游戏之后变成true
    public AutoBGJpanel battleGround, winUI, defeatUI, p1UI, p2UI; // 战场, 胜利图标, 失败图标
    public AutoBGJpanel exitDoorJPanel; // 出口贴图
    public AutoBGJpanel gamePassJPanel; // 通关贴图
    public boolean exitDoorJPanelVisible = false; // 默认为false击败boss后改为true

    public ArrayList<ArrayList<AutoBGJpanel>> jpUp = new ArrayList<>();         // 战争迷雾2d
    public ArrayList<ArrayList<AutoBGJpanel>> jpDown = new ArrayList<>();       // 生物物品2d

    public Win() {
        // 去掉上面的窗口栏
        this.setUndecorated(true);
        initInside();
        setSize(1000,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400,200);
    }

    private void initInside() {
        // rootPanel为根容器 绝对布局
        rootPanel = new BGJPanel();
        rootPanel.setLayout(null);
        // 初始化个性化窗口
        initWindowsSelfStyle();
        // 初始化主人公信息显示面板
        this.initPlayerValueShowSystem();
        // 地图区域 6x6 每格70像素x70像素
        map = new JPanel();
        map.setBounds(480,130,420,420);
        map.setLayout(null);
        map.setBackground(Color.white);
        // 战场UI
        this.initBattleGroundGUI();
        // 出口
        exitDoorJPanel = new AutoBGJpanel("出口.png");
        exitDoorJPanel.setBounds(480,130,70,70);
        exitDoorJPanel.setVisible(false);
        // 通关
        gamePassJPanel = new AutoBGJpanel("通关.png");
        gamePassJPanel.setBounds(400,90,600,550);
        gamePassJPanel.setVisible(false);
        // 按钮
        btn = new JButton("开始游戏");
        btn.setBounds(100,130,120,30);
        btn.addActionListener(this);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int code = e.getKeyCode();
                // 上38 下40 左37 右39
                System.out.println("你按 KeyCode = " + code);
                switch(code){
                    case 38:
                        direction = "上";
                        break;
                    case 40:
                        direction = "下";
                        break;
                    case 37:
                        direction = "左";
                        break;
                    case 39:
                        direction = "右";
                        break;
                    default:
                        System.out.println("错误按键");
                }
            }
        });
        this.setFocusable(true);
        // 面板组合
        this.add(rootPanel);
        rootPanel.add(jpTop);
        rootPanel.add(gamePassJPanel);
        rootPanel.add(battleGround);
        rootPanel.add(map);
        rootPanel.add(btn);
        rootPanel.add(jLabelName);
        rootPanel.add(jLabelHp);
        rootPanel.add(jLabelAtk);
        rootPanel.add(jLabelNameValue);
        rootPanel.add(jLabelHpValue);
        rootPanel.add(jLabelAtkValue);
        rootPanel.add(exitDoorJPanel);
        jpTop.add(small);
        jpTop.add(out);
        battleGround.add(winUI);
        battleGround.add(defeatUI);
        battleGround.add(p1UI);
        battleGround.add(p2UI);
    }

    private void initBattleGroundGUI() {
        battleGround = new AutoBGJpanel("战场.png");
        battleGround.setBounds(490, 160,400, 300);
        battleGround.setLayout(null);
        battleGround.setVisible(false);

        winUI = new AutoBGJpanel("战斗胜利.png");
        winUI.setBounds(100,100,200,100);
        winUI.setVisible(false);

        defeatUI = new AutoBGJpanel("战斗失败.png");
        defeatUI.setBounds(100,100,200,100);
        defeatUI.setVisible(false);

        p1UI = new AutoBGJpanel("0云.png");
        p1UI.setBounds(10,120,70,70);

        p2UI = new AutoBGJpanel("0云.png");
        p2UI.setBounds(320,120,70,70);
    }

    private void initPlayerValueShowSystem() {
        jLabelName = new JLabel("人物");
        jLabelName.setBounds(920, 60, 100, 100);
        jLabelName.setFont(new java.awt.Font("黑体", 1, 20));
        jLabelHp = new JLabel("血量");
        jLabelHp.setBounds(920, 120, 100, 100);
        jLabelHp.setFont(new java.awt.Font("黑体", 1, 20));
        jLabelAtk = new JLabel("攻击");
        jLabelAtk.setBounds(920, 180, 100, 100);
        jLabelAtk.setFont(new java.awt.Font("黑体", 1, 20));
        jLabelNameValue = new JLabel("nameNULL");
        jLabelNameValue.setBounds(940, 90, 100, 100);
        jLabelNameValue.setFont(new java.awt.Font("黑体", 1, 22));
        jLabelHpValue = new JLabel("hpNULL");
        jLabelHpValue.setBounds(940, 150, 100, 100);
        jLabelHpValue.setFont(new java.awt.Font("黑体", 1, 22));
        jLabelAtkValue = new JLabel("atkNULL");
        jLabelAtkValue.setBounds(940, 210, 100, 100);
        jLabelAtkValue.setFont(new java.awt.Font("黑体", 1, 22));
    }

    private void initWindowsSelfStyle() {
        // 可拖拽顶栏
        jpTop = new MVJPanel();
        jpTop.setDragable(this);
        jpTop.setBounds(0,0,1000,100);
        jpTop.setOpaque(false);
        jpTop.setLayout(null);
        // 最小化按钮
        small = new JButton(new ImageIcon(new FilePath().filePath("small.png")));
        small.setBounds(955,2,20,20);
        small.addActionListener(this);
        // 最大化按钮
        out   = new JButton(new ImageIcon(new FilePath().filePath("out.png")));
        out  .setBounds(978,2,20,20);
        out  .addActionListener(this);
    }

    public void drawUp(ArrayList<ArrayList<unit>> unitUp) {
        for(int i=0; i<6; i++){
            jpUp.add(new ArrayList<AutoBGJpanel>());
            for(int j=0; j<6; j++){
                AutoBGJpanel auto = new AutoBGJpanel(unitUp.get(i).get(j).name);
                auto.setBounds(5 + i * 70, 5 + j * 70, 60, 60);
                auto.setVisible(unitUp.get(i).get(j).visible);
                map.add(auto);
                jpUp.get(i).add(auto);
            }
        }
    }

    public void drawDown(ArrayList<ArrayList<unit>> unitDown) {
        for(int i=0; i<6; i++){
            jpDown.add(new ArrayList<AutoBGJpanel>());
            for(int j=0; j<6; j++){
                AutoBGJpanel auto = new AutoBGJpanel(unitDown.get(i).get(j).name);
                auto.setBounds(5 + i * 70, 5 + j * 70, 60, 60);
                auto.setVisible(unitDown.get(i).get(j).visible);
                map.add(auto);
                jpDown.get(i).add(auto);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == small){
            this.setExtendedState(ICONIFIED);
            this.requestFocus();
        }
        if(e.getSource() == out  ){
            System.exit(0);
        }
        if(e.getSource() == btn){
            System.out.println("检测到btn按键了");
            // 初始化全部变量
            //2@^%*^TYUF&T*GFT(*GYF(^Y(D^*GYRFYUGH)(&*R(FTYUy一大堆代码
            // 初始化完毕重启游戏
            MapsetVisible(true);
            startGame = true;
            this.requestFocus();
        }
    }

    public void setLocationExitDoorJPanel(int x, int y){
        // 480 , 130
        exitDoorJPanel.setLocation(exitDoorJPanel.getX() + x * 70, exitDoorJPanel.getY() + y * 70);
        exitDoorJPanel.updateUI();
    }

    public void MapsetVisible(boolean b){
        map.setVisible(true);
    }
}
