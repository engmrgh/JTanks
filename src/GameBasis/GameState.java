package GameBasis; /*** In The Name of Allah ***/

import PlayerTank;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This class holds the state of game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameState {

    public int locX, locY;

    public boolean gameOver;

    private boolean keyUP, keyDOWN, keyRIGHT, keyLEFT;
    private boolean mousePress;
    private int mouseX, mouseY;
    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;

    public GameState() {
        locX = 100;
        locY = 100;
        PlayerTank.init(this,100,100);

        gameOver = false;

        keyUP = false;
        keyDOWN = false;
        keyRIGHT = false;
        keyLEFT = false;
        //
        mousePress = false;
        mouseX = 0;
        mouseY = 0;
        //
        keyHandler = new KeyHandler();
        mouseHandler = new MouseHandler();
    }


    /**
     * The method which updates the game state.
     */
    public void update() {

		if (keyUP)
			locY -= 8;
		if (keyDOWN)
			locY += 8;
		if (keyLEFT)
			locX -= 8;
		if (keyRIGHT)
			locX += 8;

		locX = Math.max(locX, 0);
//		locX = Math.min(locX, GameBasis.GameFrame.GAME_WIDTH - (int)tankWidth);
		locY = Math.max(locY, 0);
//		locY = Math.min(locY, GameBasis.GameFrame.GAME_HEIGHT - (int)tankHeight);
    }


    public KeyListener getKeyListener() {
        return keyHandler;
    }

    public MouseListener getMouseListener() {
        return mouseHandler;
    }

    public MouseMotionListener getMouseMotionListener() {
        return mouseHandler;
    }
//
//
    /**
     * The keyboard handler.
     */
    class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_UP:
				    playerTank.rotateTank(true);
					keyUP = true;
					break;
				case KeyEvent.VK_DOWN:
				    PlayerTank.playerTank.rotateTank(true);
					keyDOWN = true;
					break;
				case KeyEvent.VK_LEFT:
                    PlayerTank.playerTank.rotateTank(false);
                    keyLEFT = true;
					break;
				case KeyEvent.VK_RIGHT:
                    PlayerTank.playerTank.rotateTank(false);
                    keyRIGHT = true;
					break;
				case KeyEvent.VK_ESCAPE:
					gameOver = true;
					break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_UP:
					keyUP = false;
					break;
				case KeyEvent.VK_DOWN:
					keyDOWN = false;
					break;
				case KeyEvent.VK_LEFT:
					keyLEFT = false;
					break;
				case KeyEvent.VK_RIGHT:
					keyRIGHT = false;
					break;
			}
		}

	}

	/**
	 * The mouse handler.
	 */
	class MouseHandler extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getButton() == 3){
//                System.out.println("click right");
			    playerTank.switchGun();
            }else if(e.getButton() == 1){
                playerTank.fire(mouseX = e.getX(),mouseY = e.getY());
                mousePress = true;
            }
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			mousePress = false;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			mouseX = e.getX();
			mouseY = e.getY();
		}
    }

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}
}


