package test;


import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameState extends BasicGameState {

	private ArrayList<Circle> balls;
	private Circle mouseBall;
	private int timePassed;
	private Random random;
	private int score;

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		balls = new ArrayList<Circle>();
		mouseBall = new Circle(0, 0, 20);
		timePassed = 0;
		random = new Random();
		score = 0;

	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		if (container.getInput().isKeyPressed(Input.KEY_A)) {
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}

		mouseBall.setCenterX(container.getInput().getMouseX());
		mouseBall.setCenterY(container.getInput().getMouseY());

		timePassed += delta;
		if (timePassed > 500) {
			timePassed = 0;
			balls.add(new Circle(random.nextFloat()*800, 100, 10));
		}

		for (Circle ball : balls) {
			ball.setCenterY(ball.getCenterY() + (delta / 5f));
		}
	
		for(int i = balls.size()-1; i>=0; i--){
			Circle c = balls.get(i);
			if(c.getCenterY()>610){
				balls.remove(i);
				SetupClass.lives--;
				if(SetupClass.lives == 0){
					sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
				}
			}else if(c.intersects(mouseBall)){
				balls.remove(i);
				SetupClass.score++;
			}
		}
	}

	public void render(GameContainer container, StateBasedGame arg1, Graphics g) throws SlickException {
		g.setColor(org.newdawn.slick.Color.yellow);
		g.fill(mouseBall);
		g.drawString("Score: " + SetupClass.score, 50, 50);
		g.drawString("Current balls: " + balls.size(), 200, 50);
		g.drawString("lives left: " + SetupClass.lives, 500, 50);

		for (Circle ball : balls) {
			g.setColor(org.newdawn.slick.Color.red);
			g.fill(ball);
		}
		
	
		
	}

	@Override
	public int getID() {
		return 0;
	}

}
