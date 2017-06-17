
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class gamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	ArrayList<Integer> presses = new ArrayList<>();
	Font titleFont;
	Rocketship r = new Rocketship(250, 700, 50, 50);
	ObjectManager o = new ObjectManager();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

		repaint();

	}

	public void updateMenuState() {

	}

	public void updateEndState() {

	}

	public void updateGameState() {
		o.update();
		for (int lastPress : presses) {

			if (lastPress == KeyEvent.VK_LEFT) {
				r.x = r.x - 3;
			}
			if (lastPress == KeyEvent.VK_RIGHT) {
				r.x = r.x + 3;
			}
			if (lastPress == KeyEvent.VK_UP) {
				r.y = r.y - 3;
			}
			if (lastPress == KeyEvent.VK_DOWN) {
				r.y = r.y + 3;
			}
			if (lastPress == KeyEvent.VK_SPACE) {
				o.addObject(new Projectile(r.x + 20, r.y, 10, 10));

			}
		}
	}

	public void drawMenuState(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);

		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS", 0, 250);
		g.drawString("CLICK ENTER", 30, 300);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);

		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("U LOST", 175, 250);
	}

	public void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		o.draw(g);

	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	public gamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		o.addObject(r);

	}

	public void startGame() {
		timer.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("asd");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!presses.contains(e.getKeyCode()))
			presses.add(e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("asdasda");
		if (presses.contains(e.getKeyCode()))
		presses.remove((Integer)e.getKeyCode());
	}

}
