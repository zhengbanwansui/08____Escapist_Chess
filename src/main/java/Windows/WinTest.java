package Windows;

import javax.swing.*;

public class WinTest extends JFrame {
    JPanel jp = new JPanel();
    public WinTest(){
        setSize(1800,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400,200);
        this.add(jp);
        jp.setLayout(null);
        this.setVisible(true);
    }
    public void draw() {
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                //AutoBGJpanel auto = new AutoBGJpanel(mapUp.get(i).get(j).name);
                JLabel auto = new JLabel("迷雾");
                auto.setBounds(/*480+*/i*70, /*130+*/j*70, 60, 60);
                jp.add(auto);
            }
        }
    }
}
