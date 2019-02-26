package Windows;

import javax.swing.*;
import java.awt.*;

public class AutoBGJpanel extends JPanel {
    ImageIcon icon;
    Image img;
    public AutoBGJpanel(String tempstr) {
        icon = new ImageIcon(new FilePath().filePath(tempstr));
        img=icon.getImage();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //下面这行是为了背景图片可以跟随窗口自行调整大小，可以自己设置成固定大小
        g.drawImage(img, 0, 0,this.getWidth(), this.getHeight(), this);
    }
}
