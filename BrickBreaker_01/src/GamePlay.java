import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class GamePlay {

	private boolean play = false;
	private int score = 0;
	int movementStep = 20;

	boolean spedUpBallRight = false;
	boolean spedUpBallLeft = false;
	boolean moveQuick = false;
	boolean allBrickEnd = false;

	private Timer timer;
	private int delay = 8;

	private int playerX = 310;
	final private int playery = 720;

	private int ballposX = 100;
	private int ballposY = 400;
	private int ballXdir = -1;
	private int ballYdir = -2;

	private MapGenerator map;
	private JPanel mapJpanel;

	public int life = 2;

	public GamePlay(MapGenerator map, JPanel playPage) {
		this.map = map;
		this.mapJpanel = playPage;
		GamePlayStart();

	}

	public void GamePlayStart() {
		map.imageLoader1();
		this.map.getBricks().size();

	}

	public void gameStart() {

		if (play) {
			timer = new Timer();
			timer.schedule(new TimerTask() {

				public void run() {
					this.timerEvent();
				}

				private void timerEvent() {
					playerMovements();
					ballMovements();
					checkBricks();
					stopGameCheck();
				}

				private void stopGameCheck() {
					if (play) {

					} else {
						timer.cancel();
						timer = null;
					}

				}

			}, 0, delay);
		}

	}

	@SuppressWarnings({ "ErrorÝnBallMovement", "deprecation" })
	private void ballMovements() {
		this.map.getBall().move(ballposX, ballposY);
		this.mapJpanel.repaint();

		ballposX -= ballXdir;
		ballposY -= ballYdir;

		if (ballposX + 32 >= 1024) {
			ballXdir = -ballXdir;
		} else if (ballposY + 32 >= 768 || ballposY < -10 || ballposX < -10 || ballposX > 1030) {

			this.setPlay(false);
			if (life == 2) {
				map.drawPausePanel2Life();
				ballposX = 100;
				ballposY = 400;
				ballXdir = -1;
				ballYdir = -2;
				playerX = 310;
				life--;

			} else if (life == 1) {
				map.drawPausePanel1Life();
				ballposX = 100;
				ballposY = 400;
				ballXdir = -1;
				ballYdir = -2;
				playerX = 310;
				life--;

			} else if (life == 0) {
				map.drawPausePanel0Life();
				life--;

			}

			// System.out.println("game ends");
		} else if (ballposX <= 0) {
			ballXdir = -ballXdir;
		} else if (ballposY <= 0) {
			ballYdir = -ballYdir;
		}

	}

	private void checkBricks() {
		allBrickEnd = true;

		for (int i = 0; i < this.map.getBricks().size(); i++) {

			if (this.map.getBricks().get(i) != null) {
				allBrickEnd = false;
				int topLeftX = this.map.getBricks().get(i).getX();
				int topLeftY = this.map.getBricks().get(i).getY();
				int width = this.map.getBricks().get(i).getWidth();
				int height = this.map.getBricks().get(i).getHeight();

				if (topLeftX <= ballposX + 32 && topLeftY <= ballposY + 32 && topLeftX + width >= ballposX
						&& topLeftY + height >= ballposY) {

					// System.out.println("collison");
					// this.map.getBricks().get(i).disable();

					if (topLeftX == ballposX + 32 || topLeftX + width == ballposX) {
						ballXdir = -ballXdir;
					} else if (topLeftY + height == ballposY || topLeftY == ballposY + 32) {
						ballYdir = -ballYdir;
					}

					if (this.map.CheckBrick(i)) {
						this.map.getObjectsLayer().remove(this.map.getBricks().get(i));
						this.map.getBricks().set(i, null);
						score += 15;
						map.drawScore(score);

					} else {
						score += 10;
						map.drawScore(score);
						break;
					}

				}
			}

		}

		if (allBrickEnd) {

			this.setPlay(false);

			JLayeredPane push = map.getObjectsLayer();
			push.removeAll();

			this.map.getBricks().clear();
			this.map.getBrickImageLoader().clear();
			map.imageLoader1();

			// needs to be chancge

			ballposX = 100;
			ballposY = 400;
			ballXdir = -1;
			playerX = 310;
			score += 100;
			delay -= 1;

			if (3 > life)
				life++;

			if (life == 2) {
				map.drawPausePanel2Life();

			} else if (life == 1) {
				map.drawPausePanel2Life();
				map.drawPausePanel1Life();
			}

			map.deletePausePanel();
			map.deletePausePanel0Life();
			map.deletePausePanel1Life();
			map.deletePausePanel2Life();

			map.drawPausePanel();
			map.drawScore(score);

			map.getObjectsLayer().repaint();

		}

	}

	@SuppressWarnings("PlayererrorGamplay")
	private void playerMovements() {

		this.map.getPlayer().move(playerX, playery);
		// this.map.drawPlayer(playerX, playery);
		if (ballposY % 10 == 0) {

			this.map.updateEffect();

			if (moveQuick) {
				if (spedUpBallLeft) {
					if (playerX <= 0)
						playerX = 0;
					else
						playerX -= movementStep;

				} else if (spedUpBallRight) {
					if (playerX >= 903)
						playerX = 903;
					else
						playerX += movementStep;

				}

			}

		}

		int topLeftplayerX = this.map.getPlayer().getX();
		int playerwidth = this.map.getPlayer().getWidth();

		if (ballposY + 26 > playery && topLeftplayerX <= ballposX + 32 && topLeftplayerX + playerwidth >= ballposX) {
			ballYdir = -ballYdir;

			if (spedUpBallLeft) {
				if (ballXdir < 0) {
					ballXdir -= 1;
				} else
					ballXdir += 1;
			}
			if (spedUpBallRight) {
				if (ballXdir < 0) {
					ballXdir += 1;
				} else
					ballXdir -= 1;

			}
		}

		moveQuick = true;

	}

	public void moveLeft() {
		moveQuick = false;
		if (playerX <= 0)
			playerX = 0;
		else
			playerX -= movementStep;

	}

	public void moveRight() {
		moveQuick = false;
		if (playerX >= 903)
			playerX = 903;
		else
			playerX += movementStep;

	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public int getBallposX() {
		return ballposX;
	}

	public void setBallposX(int ballposX) {
		this.ballposX = ballposX;
	}

	public int getBallposY() {
		return ballposY;
	}

	public void setBallposY(int ballposY) {
		this.ballposY = ballposY;
	}

	public int getBallXdir() {
		return ballXdir;
	}

	public void setBallXdir(int ballXdir) {
		this.ballXdir = ballXdir;
	}

	public int getBallYdir() {
		return ballYdir;
	}

	public void setBallYdir(int ballYdir) {
		this.ballYdir = ballYdir;
	}

	public MapGenerator getMap() {
		return map;
	}

	public void setMap(MapGenerator map) {
		this.map = map;
	}

	public JPanel getMapJpanel() {
		return mapJpanel;
	}

	public void setMapJpanel(JPanel mapJpanel) {
		this.mapJpanel = mapJpanel;
	}

	public boolean isSpedUpBallRight() {
		return spedUpBallRight;
	}

	public void setSpedUpBallRight(boolean spedUpBallRight) {
		this.spedUpBallRight = spedUpBallRight;
	}

	public boolean isSpedUpBallLeft() {
		return spedUpBallLeft;
	}

	public void setSpedUpBallLeft(boolean spedUpBallLeft) {
		this.spedUpBallLeft = spedUpBallLeft;
	}
}
