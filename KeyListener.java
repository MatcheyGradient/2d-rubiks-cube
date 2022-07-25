import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent event) {
        switch(event.getKeyCode()) {
            case KeyEvent.VK_A:
                MainCube.leftCW();
                break;
            case KeyEvent.VK_W:
                MainCube.topCW();
                break;
            case KeyEvent.VK_S:
                MainCube.frontCW();
                break;
            case KeyEvent.VK_Z:
                MainCube.bottomCW();
                break;
            case KeyEvent.VK_D:
                MainCube.rightCW();
                break;
            case KeyEvent.VK_F:
                MainCube.backCW();
                break;
            case KeyEvent.VK_R:
                MainCube.rotateCubeRight();
                break;
            case KeyEvent.VK_T:
                MainCube.resetCube();
                break;
        }
    }
}
