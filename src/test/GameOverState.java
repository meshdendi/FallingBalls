

package test;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameOverState extends BasicGameState {

	
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
	}
	
	
	public void update(GameContainer container, StateBasedGame sbg, int arg2) throws SlickException {
		
	}

	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		g.drawString("Game Over", 300, 300);
	}



	@Override
	public int getID() {
		return 1;
	}

}
