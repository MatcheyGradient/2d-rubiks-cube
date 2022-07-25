import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.WHITE;
import static java.awt.Color.black;

public class Window extends JPanel implements ActionListener {

    MainCube maincube;
    Timer timer;

    public Window(){
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(black);
        this.setFocusable(true);
        this.addKeyListener(new KeyListener());
        maincube = new MainCube();
        timer = new Timer(1, this);
        start();
    }

    public void start() {
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }

    public void draw(Graphics g){
        maincube.render(g);

        g.setColor(WHITE);
        g.setFont(new Font("dircep", Font.PLAIN, 20));

        g.drawLine(0, 360, 600, 360);
        g.drawString("Top CW: 'W'", 20, 405);
        g.drawString("Front CW: 'S'", 20, 430);
        g.drawString("Left CW: 'A'", 20, 455);
        g.drawString("Right CW: 'D'", 20, 480);
        g.drawString("Bottom CW: 'Z'", 20, 505);
        g.drawString("Back CW: 'F'", 20, 530);
        g.drawString("Reset Cube: 'T'", 20, 555);
        g.drawString("Rotate Right: 'R'", 20, 580);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}