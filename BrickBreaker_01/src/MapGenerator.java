import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MapGenerator {

	File audioFile = new File("/BrickBreaker_01/musicEffects");

	protected ArrayList<Integer> BrickImageLoader = new ArrayList<Integer>();

	protected JLayeredPane objectsLayer = new JLayeredPane();

	private JLabel player = new JLabel("");

	private Image player1Img = new ImageIcon(this.getClass().getResource("/player/50-Breakout-Tiles.png")).getImage();
	private Image player2Img = new ImageIcon(this.getClass().getResource("/player/51-Breakout-Tiles.png")).getImage();
	private Image player3Img = new ImageIcon(this.getClass().getResource("/player/52-Breakout-Tiles.png")).getImage();
	private Image player4Img = new ImageIcon(this.getClass().getResource("/player/53-Breakout-Tiles.png")).getImage();
	private Image player5Img = new ImageIcon(this.getClass().getResource("/player/54-Breakout-Tiles.png")).getImage();
	private Image player6Img = new ImageIcon(this.getClass().getResource("/player/55-Breakout-Tiles.png")).getImage();
	private int iForPlayerEffect = 0;
	Random rand = new Random();

	private JLabel ball = new JLabel("");
	private Image ballImg = new ImageIcon(this.getClass().getResource("/player/ballPlayer.png")).getImage();

	private JLabel life1 = new JLabel("");
	private JLabel life2 = new JLabel("");
	private JLabel life3 = new JLabel("");
	private Image liffeImg = new ImageIcon(this.getClass().getResource("/player/lifePlayer.png")).getImage();

	public ArrayList<JLabel> bricks = new ArrayList<JLabel>();

	private Image brick1Img = new ImageIcon(this.getClass().getResource("/bricks/01-Breakout-Tiles.png")).getImage();
	private Image brick2Img = new ImageIcon(this.getClass().getResource("/bricks/02-Breakout-Tiles.png")).getImage();
	private Image brick3Img = new ImageIcon(this.getClass().getResource("/bricks/03-Breakout-Tiles.png")).getImage();
	private Image brick4Img = new ImageIcon(this.getClass().getResource("/bricks/04-Breakout-Tiles.png")).getImage();
	private Image brick5Img = new ImageIcon(this.getClass().getResource("/bricks/05-Breakout-Tiles.png")).getImage();
	private Image brick6Img = new ImageIcon(this.getClass().getResource("/bricks/06-Breakout-Tiles.png")).getImage();
	private Image brick7Img = new ImageIcon(this.getClass().getResource("/bricks/07-Breakout-Tiles.png")).getImage();
	private Image brick8Img = new ImageIcon(this.getClass().getResource("/bricks/08-Breakout-Tiles.png")).getImage();
	private Image brick9Img = new ImageIcon(this.getClass().getResource("/bricks/09-Breakout-Tiles.png")).getImage();
	private Image brick10Img = new ImageIcon(this.getClass().getResource("/bricks/10-Breakout-Tiles.png")).getImage();
	private Image brick11Img = new ImageIcon(this.getClass().getResource("/bricks/11-Breakout-Tiles.png")).getImage();
	private Image brick12Img = new ImageIcon(this.getClass().getResource("/bricks/12-Breakout-Tiles.png")).getImage();
	private Image brick13Img = new ImageIcon(this.getClass().getResource("/bricks/13-Breakout-Tiles.png")).getImage();
	private Image brick14Img = new ImageIcon(this.getClass().getResource("/bricks/14-Breakout-Tiles.png")).getImage();
	private Image brick15Img = new ImageIcon(this.getClass().getResource("/bricks/15-Breakout-Tiles.png")).getImage();
	private Image brick16Img = new ImageIcon(this.getClass().getResource("/bricks/16-Breakout-Tiles.png")).getImage();
	private Image brick17Img = new ImageIcon(this.getClass().getResource("/bricks/17-Breakout-Tiles.png")).getImage();
	private Image brick18Img = new ImageIcon(this.getClass().getResource("/bricks/18-Breakout-Tiles.png")).getImage();
	private Image brick19Img = new ImageIcon(this.getClass().getResource("/bricks/19-Breakout-Tiles.png")).getImage();
	private Image brick20Img = new ImageIcon(this.getClass().getResource("/bricks/20-Breakout-Tiles.png")).getImage();

	JLabel effect = new JLabel("");
	JLabel drops = new JLabel("");

	JLabel scoreMenu;
	final String scoreText = "Score: ";

	JLabel backGroundPlay1 = new JLabel("");
	Image backGroundPlay1Img = new ImageIcon(this.getClass().getResource("/backGround/bckGnd1.png")).getImage();
	Image backGroundPlay2Img = new ImageIcon(this.getClass().getResource("/backGround/bckGnd2.jpg")).getImage();
	Image backGroundPlay3Img = new ImageIcon(this.getClass().getResource("/backGround/bckGnd3.jpg")).getImage();
	Image backGroundPlay4Img = new ImageIcon(this.getClass().getResource("/backGround/bckGnd4.jpg")).getImage();

	JLabel backGroundPause = new JLabel("");
	Image backGroundPauseImg = new ImageIcon(this.getClass().getResource("/backGround/gamePaused.png")).getImage();

	JLabel backGroundPaused0 = new JLabel("");
	Image gamePaused0Life = new ImageIcon(this.getClass().getResource("/backGround/gamePaused0Life.png")).getImage();

	JLabel backGroundPaused1 = new JLabel("");
	Image gamePaused1Life = new ImageIcon(this.getClass().getResource("/backGround/gamePaused1Life.png")).getImage();

	JLabel backGroundPaused2 = new JLabel("");
	Image gamePaused2Life = new ImageIcon(this.getClass().getResource("/backGround/gamePaused2Life.png")).getImage();

	protected final int brickWidth = 96;
	protected final int brickHeight = 32;

	public MapGenerator(JLayeredPane objectsLayer) {
		this.objectsLayer = objectsLayer;

	}

	public void imageLoader1() {

		player.setIcon(new ImageIcon(player1Img));

		ball.setIcon(new ImageIcon(ballImg));

		backGroundPause.setIcon(new ImageIcon(backGroundPauseImg));

		backGroundPaused0.setIcon(new ImageIcon(gamePaused0Life));
		backGroundPaused1.setIcon(new ImageIcon(gamePaused1Life));
		backGroundPaused2.setIcon(new ImageIcon(gamePaused2Life));

		life1.setIcon(new ImageIcon(liffeImg));
		life2.setIcon(new ImageIcon(liffeImg));
		life3.setIcon(new ImageIcon(liffeImg));

		createLevel1();

	}

	public JLayeredPane getObjectsLayer() {
		return objectsLayer;
	}

	public void setObjectsLayer(JLayeredPane objectsLayer) {
		this.objectsLayer = objectsLayer;
	}

	public JLabel getPlayer() {
		return player;
	}

	public void setPlayer(JLabel player) {
		this.player = player;
	}

	public ArrayList<JLabel> getBricks() {
		return bricks;
	}

	public void setBricks(ArrayList<JLabel> bricks) {
		this.bricks = bricks;
	}

	public JLabel getEffect() {
		return effect;
	}

	public void setEffect(JLabel effect) {
		this.effect = effect;
	}

	public JLabel getDrops() {
		return drops;
	}

	public void setDrops(JLabel drops) {
		this.drops = drops;
	}

	public JLabel getBackGroundPlay1() {
		return backGroundPlay1;
	}

	public void setBackGroundPlay1(JLabel backGroundPlay1) {
		this.backGroundPlay1 = backGroundPlay1;
	}

	public Image getBackGroundPlay1Img() {
		return backGroundPlay1Img;
	}

	public void setBackGroundPlay1Img(Image backGroundPlay1Img) {
		this.backGroundPlay1Img = backGroundPlay1Img;
	}

	public int getBrickWidth() {
		return brickWidth;
	}

	public ArrayList<Integer> getBrickImageLoader() {
		return BrickImageLoader;
	}

	public int getBrickHeight() {
		return brickHeight;
	}

	private void createLevel1() {
		drawBackGround();
		drawFullLife();

		for (int i = 100; i < 920; i += 144) {
			for (int j = 64; j < 400; j += 70) {
				int a = rand.nextInt(19) + 1;
				BrickImageLoader.add(a);
				bricks.add(drawBrick(i, j, a));

			}

		}

		drawPlayer(600, 720);
		drawBall(600, 600);

		scoreMenu = new JLabel("Score: 0");
		scoreMenu.setFont(new Font("Batang", Font.PLAIN, 12));
		scoreMenu.setForeground(Color.WHITE);
		scoreMenu.setBounds(820, 0, 60, 32);
		objectsLayer.add(scoreMenu);
		objectsLayer.setLayer(scoreMenu, 1);

	}

	private void drawFullLife() {

		objectsLayer.setLayer(life1, 1);
		life1.setBounds(900, 5, 32, 29);
		objectsLayer.add(life1);

		objectsLayer.setLayer(life2, 1);
		life2.setBounds(940, 5, 32, 29);
		objectsLayer.add(life2);

		objectsLayer.setLayer(life3, 1);
		life3.setBounds(980, 5, 32, 29);
		objectsLayer.add(life3);

	}

	public boolean CheckBrick(int numb) {
		int a = BrickImageLoader.get(numb);
		if ((a % 2) == 1) {
			JLabel brickI = drawBrick(bricks.get(numb).getX(), bricks.get(numb).getY(), a + 1);
			objectsLayer.remove(bricks.get(numb));
			bricks.set(numb, null);
			bricks.add(numb, brickI);
			BrickImageLoader.add(numb, a + 1);
			return false;
		}

		return true;

	}

	public void drawScore(int ScoreNumb) {
		scoreMenu.setText(scoreText + ScoreNumb);
		objectsLayer.repaint();

	}

	public void drawPausePanel() {

		objectsLayer.setLayer(backGroundPause, 2);
		backGroundPause.setBounds(112, -110, 800, 800);
		objectsLayer.add(backGroundPause);

	}

	public void deletePausePanel() {
		objectsLayer.remove(backGroundPause);
		objectsLayer.repaint();

	}

	public void drawPausePanel2Life() {

		objectsLayer.remove(life1);
		objectsLayer.repaint();

		objectsLayer.setLayer(backGroundPaused2, 2);
		backGroundPaused2.setBounds(112, -110, 800, 800);
		objectsLayer.add(backGroundPaused2);

	}

	public void deletePausePanel2Life() {

		objectsLayer.remove(backGroundPaused2);
		objectsLayer.repaint();

	}

	public void drawPausePanel1Life() {

		objectsLayer.remove(life2);
		objectsLayer.repaint();

		objectsLayer.setLayer(backGroundPaused1, 2);
		backGroundPaused1.setBounds(112, -110, 800, 800);
		objectsLayer.add(backGroundPaused1);

	}

	public void deletePausePanel1Life() {

		objectsLayer.remove(backGroundPaused1);
		objectsLayer.repaint();

	}

	public void drawPausePanel0Life() {

		objectsLayer.remove(life3);
		objectsLayer.repaint();

		objectsLayer.setLayer(backGroundPaused0, 2);
		backGroundPaused0.setBounds(112, -110, 800, 800);
		objectsLayer.add(backGroundPaused0);

	}

	public void deletePausePanel0Life() {

		objectsLayer.remove(backGroundPaused0);
		objectsLayer.repaint();

	}

	private void drawBackGround() {

		int aaaa = rand.nextInt(4);

		if (aaaa == 0)
			backGroundPlay1.setIcon(new ImageIcon(backGroundPlay1Img));
		else if (aaaa == 1)
			backGroundPlay1.setIcon(new ImageIcon(backGroundPlay2Img));
		else if (aaaa == 2)
			backGroundPlay1.setIcon(new ImageIcon(backGroundPlay3Img));
		else
			backGroundPlay1.setIcon(new ImageIcon(backGroundPlay4Img));

		objectsLayer.setLayer(backGroundPlay1, -1);
		backGroundPlay1.setBounds(0, 0, 1024, 768);
		objectsLayer.add(backGroundPlay1);

	}

	private void drawDrops() {
		objectsLayer.setLayer(drops, 1);
		drops.setBounds(0, 0, 46, 14);
		objectsLayer.add(drops);

	}

	private JLabel drawBrick(int X, int Y, int brickType) {
		JLabel brickII = new JLabel();
		switch (brickType) {
		case 1:

			brickII.setIcon(new ImageIcon(brick1Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 2:

			brickII.setIcon(new ImageIcon(brick2Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 3:

			brickII.setIcon(new ImageIcon(brick3Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 4:

			brickII.setIcon(new ImageIcon(brick4Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 5:

			brickII.setIcon(new ImageIcon(brick5Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 6:

			brickII.setIcon(new ImageIcon(brick6Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 7:

			brickII.setIcon(new ImageIcon(brick7Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 8:

			brickII.setIcon(new ImageIcon(brick8Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 9:

			brickII.setIcon(new ImageIcon(brick9Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 10:

			brickII.setIcon(new ImageIcon(brick10Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 11:

			brickII.setIcon(new ImageIcon(brick11Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 12:

			brickII.setIcon(new ImageIcon(brick12Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 13:

			brickII.setIcon(new ImageIcon(brick13Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 14:

			brickII.setIcon(new ImageIcon(brick14Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 15:

			brickII.setIcon(new ImageIcon(brick15Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 16:

			brickII.setIcon(new ImageIcon(brick16Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 17:

			brickII.setIcon(new ImageIcon(brick17Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 18:

			brickII.setIcon(new ImageIcon(brick18Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 19:

			brickII.setIcon(new ImageIcon(brick19Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;
		case 20:

			brickII.setIcon(new ImageIcon(brick20Img));
			objectsLayer.setLayer(brickII, 0);
			brickII.setBounds(X, Y, brickWidth, brickHeight);
			objectsLayer.add(brickII);
			break;

		default:
			System.out.println("error in brick creat");
			break;

		}
		return brickII;

	}

	void drawBall(int X, int Y) {

		player.setIcon(new ImageIcon(player1Img));
		objectsLayer.setLayer(ball, 0);
		ball.setBounds(X, Y, 32, 32);
		objectsLayer.add(ball);
		// objectsLayer.repaint();

	}

	void drawPlayer(int X, int Y) {

		objectsLayer.setLayer(player, 0);
		player.setBounds(X, Y, 121, 32);
		objectsLayer.add(player);

	}

	void updateEffect() {

		iForPlayerEffect = rand.nextInt(3);
		if (iForPlayerEffect == 0)
			player.setIcon(new ImageIcon(player1Img));
		if (iForPlayerEffect == 1)
			player.setIcon(new ImageIcon(player2Img));
		if (iForPlayerEffect == 2)
			player.setIcon(new ImageIcon(player3Img));

	}

	private void drawEffect() {
		objectsLayer.setLayer(effect, 1);
		effect.setBounds(0, 0, 46, 14);
		objectsLayer.add(effect);

	}

	private void setBrickValue() {
		// TODO Auto-generated method stub

	}

	public JLabel getBall() {
		return ball;
	}

	public void setBall(JLabel ball) {
		this.ball = ball;
	}

	public Image getBallImg() {
		return ballImg;
	}

	public void setBallImg(Image ballImg) {
		this.ballImg = ballImg;
	}

	public Image getBrick1Img() {
		return brick1Img;
	}

	public void setBrick1Img(Image brick1Img) {
		this.brick1Img = brick1Img;
	}

	public Image getBrick2Img() {
		return brick2Img;
	}

	public void setBrick2Img(Image brick2Img) {
		this.brick2Img = brick2Img;
	}

	public Image getBrick3Img() {
		return brick3Img;
	}

	public void setBrick3Img(Image brick3Img) {
		this.brick3Img = brick3Img;
	}

	public Image getBrick4Img() {
		return brick4Img;
	}

	public void setBrick4Img(Image brick4Img) {
		this.brick4Img = brick4Img;
	}

	public Image getBrick5Img() {
		return brick5Img;
	}

	public void setBrick5Img(Image brick5Img) {
		this.brick5Img = brick5Img;
	}

	public Image getBrick6Img() {
		return brick6Img;
	}

	public void setBrick6Img(Image brick6Img) {
		this.brick6Img = brick6Img;
	}

	public Image getBrick7Img() {
		return brick7Img;
	}

	public void setBrick7Img(Image brick7Img) {
		this.brick7Img = brick7Img;
	}

	public Image getBrick8Img() {
		return brick8Img;
	}

	public void setBrick8Img(Image brick8Img) {
		this.brick8Img = brick8Img;
	}

	public Image getBrick9Img() {
		return brick9Img;
	}

	public void setBrick9Img(Image brick9Img) {
		this.brick9Img = brick9Img;
	}

	public Image getBrick10Img() {
		return brick10Img;
	}

	public void setBrick10Img(Image brick10Img) {
		this.brick10Img = brick10Img;
	}

	public Image getBrick11Img() {
		return brick11Img;
	}

	public void setBrick11Img(Image brick11Img) {
		this.brick11Img = brick11Img;
	}

	public Image getBrick12Img() {
		return brick12Img;
	}

	public void setBrick12Img(Image brick12Img) {
		this.brick12Img = brick12Img;
	}

	public Image getBrick13Img() {
		return brick13Img;
	}

	public void setBrick13Img(Image brick13Img) {
		this.brick13Img = brick13Img;
	}

	public Image getBrick14Img() {
		return brick14Img;
	}

	public void setBrick14Img(Image brick14Img) {
		this.brick14Img = brick14Img;
	}

	public Image getBrick15Img() {
		return brick15Img;
	}

	public void setBrick15Img(Image brick15Img) {
		this.brick15Img = brick15Img;
	}

	public Image getBrick16Img() {
		return brick16Img;
	}

	public void setBrick16Img(Image brick16Img) {
		this.brick16Img = brick16Img;
	}

	public Image getBrick17Img() {
		return brick17Img;
	}

	public void setBrick17Img(Image brick17Img) {
		this.brick17Img = brick17Img;
	}

	public Image getBrick18Img() {
		return brick18Img;
	}

	public void setBrick18Img(Image brick18Img) {
		this.brick18Img = brick18Img;
	}

	public Image getBrick19Img() {
		return brick19Img;
	}

	public void setBrick19Img(Image brick19Img) {
		this.brick19Img = brick19Img;
	}

	public Image getBrick20Img() {
		return brick20Img;
	}

	public void setBrick20Img(Image brick20Img) {
		this.brick20Img = brick20Img;
	}

}
