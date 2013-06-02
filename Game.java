import java.util.ArrayList;
import java.awt.event.*;

public class Game implements KeyListener {

	ArrayList<Actor> actors;
	ArrayList<Thing> things;
	Player player;

	boolean[] keysPressed;

	double c; // This is the speed of light.

	public Game() {
		c = 300000000;

		actors = new ArrayList<Actor>();
		things = new ArrayList<Thing>();
		player = new Player(0,0);
		actors.add(player);

		actors.add(new TestActor(100,100));

		keysPressed = new boolean[4];
	}

	public void tick() {
		for (Actor a : actors)
			a.update();
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W: keysPressed[0] = true; break;
			case KeyEvent.VK_A: keysPressed[1] = true; break;
			case KeyEvent.VK_S: keysPressed[2] = true; break;
			case KeyEvent.VK_D: keysPressed[3] = true; break;
			case KeyEvent.VK_Q: Main.mainComponent.stop();
		}
	}

	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W: keysPressed[0] = false; break;
			case KeyEvent.VK_A: keysPressed[1] = false; break;
			case KeyEvent.VK_S: keysPressed[2] = false; break;
			case KeyEvent.VK_D: keysPressed[3] = false; break;
		}
	}

	public void keyTyped(KeyEvent e) {}
}
