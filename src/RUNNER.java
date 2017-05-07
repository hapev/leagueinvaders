
import javax.swing.JFrame;

public class RUNNER {

	JFrame john;
	int height = 800;
	int width = 500;
	gamePanel GamePanel;

	public void setup() {

		john.setVisible(true);
		john.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		john.add(GamePanel);
		GamePanel.startGame();

	}

	public RUNNER() {
		GamePanel = new gamePanel();
		john = new JFrame();
		john.setSize(width, height);
		john.addKeyListener(GamePanel);
		setup();

	}

	public static void main(String[] args) {
		RUNNER Object = new RUNNER();
		Object.setup();

	}
}
