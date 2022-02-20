import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class Menu extends JFrame implements KeyListener {

	protected JLayeredPane layeredPaneWindow = new JLayeredPane();;
	protected JLayeredPane layeredPanePlayMain = new JLayeredPane();
	protected JLayeredPane objectsLayer = new JLayeredPane();
	protected JLayeredPane pauseLayer = new JLayeredPane();
	protected JPanel welcomePage = new JPanel();
	protected JPanel playPage = new JPanel();

	protected JPanel creditPage = new JPanel();
	protected JPanel howToPlayPage = new JPanel();
	protected JPanel rankPage = new JPanel();
	protected MapGenerator game;
	protected GamePlay gamePlay;

	protected int[] scores = { 1500, 2010, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	protected int scoresCount = 2;

	Menu() {

		this.setTitle("Brick Breaker"); // sets title for this window
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // when exit it close program
		this.setResizable(false); // prevent from resize
		this.setBounds(100, 100, 1041, 806); // set dimension of window
		this.setVisible(true); // making visable

		this.addKeyListener(this);
		this.setFocusable(true);
		requestFocus();

		ImageIcon imageWindow = new ImageIcon("IconWindow.png"); // create an icon
		this.setIconImage(imageWindow.getImage()); // change icon of this
		this.getContentPane().setBackground(new Color(123, 50, 250)); // change color of background

		SetFrameLayered(); // For arrange the layer
		SetwelcomePage();
		SetplayPage();
		SetcreditPage();
		SethowToPlayPage();
		SetrankPage();

	}

	void SetFrameLayered() {

		layeredPaneWindow.setBounds(0, 0, 1024, 768);
		this.getContentPane().add(layeredPaneWindow);
		layeredPaneWindow.setLayout(new CardLayout(0, 0));

	}

	void SetwelcomePage() {
		layeredPaneWindow.add(welcomePage, "name_11042372678903");
		WelcomePage();

	}

	private void WelcomePage() {
		JLayeredPane welcompagelayer = new JLayeredPane();
		welcomePage.setLayout(new CardLayout(0, 0));
		welcomePage.add(welcompagelayer, "TomtooChily");
		// welcomePage.setBackground(new Color(59,147,195));

		JLabel backGrounWelcomePage = new JLabel("");
		Image backGrounWelcomePageImg = new ImageIcon(this.getClass().getResource("/menuImg/welcomepage.jpeg"))
				.getImage();
		backGrounWelcomePage.setIcon(new ImageIcon(backGrounWelcomePageImg));
		backGrounWelcomePage.setBounds(0, 0, 1024, 768);
		welcompagelayer.setLayer(backGrounWelcomePage, -1);
		welcompagelayer.add(backGrounWelcomePage);

		JButton btnPlayButton = new JButton("Play ");
		btnPlayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(playPage);
				gamePlay.setPlay(true);
				gamePlay.gameStart();
			}
		});
		btnPlayButton.setBackground(new Color(255, 255, 255));
		btnPlayButton.setForeground(new Color(255, 127, 80));
		btnPlayButton.setFont(new Font("Impact", Font.PLAIN, 39));
		btnPlayButton.setIcon(null);
		btnPlayButton.setBounds(215, 520, 220, 66);
		welcompagelayer.setLayer(btnPlayButton, 1);
		welcompagelayer.add(btnPlayButton);

		JButton btnHowToPlayButton_1 = new JButton("Instruction");
		btnHowToPlayButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(howToPlayPage);

			}
		});
		btnHowToPlayButton_1.setForeground(new Color(255, 127, 80));
		btnHowToPlayButton_1.setFont(new Font("Impact", Font.PLAIN, 39));
		btnHowToPlayButton_1.setBackground(new Color(255, 255, 255));
		btnHowToPlayButton_1.setBounds(560, 520, 220, 66);
		welcompagelayer.setLayer(btnHowToPlayButton_1, 1);
		welcompagelayer.add(btnHowToPlayButton_1);

		JButton btnRankButton_3 = new JButton("Score");
		btnRankButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(rankPage);
			}
		});
		btnRankButton_3.setForeground(new Color(255, 127, 80));
		btnRankButton_3.setFont(new Font("Impact", Font.PLAIN, 39));
		btnRankButton_3.setBackground(new Color(255, 255, 255));
		btnRankButton_3.setBounds(215, 600, 220, 66);
		welcompagelayer.setLayer(btnRankButton_3, 1);
		welcompagelayer.add(btnRankButton_3);

		JButton Credit = new JButton("Creators");
		Credit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(creditPage);

			}
		});
		Credit.setForeground(new Color(255, 127, 80));
		Credit.setFont(new Font("Impact", Font.PLAIN, 39));
		Credit.setBackground(new Color(255, 255, 255));
		Credit.setBounds(560, 600, 220, 66);
		welcompagelayer.setLayer(Credit, 1);
		welcompagelayer.add(Credit);

	}

	void SetplayPage() {
		layeredPaneWindow.add(playPage, "name_11080247442967");
		PlayPage(playPage);
		playPage.setLayout(new CardLayout(0, 0));

	}

	private void PlayPage(JPanel playPage2) {

		playPage.add(layeredPanePlayMain, "name_12416736726395");
		layeredPanePlayMain.setLayout(new CardLayout(0, 0));

		JPanel Play = new JPanel();
		layeredPanePlayMain.add(Play, "name_12194452026096");

		Play.setLayout(new CardLayout(0, 0));
		Play.add(objectsLayer, "name_12384523584802");

		game = new MapGenerator(objectsLayer);
		gamePlay = new GamePlay(game, playPage);

	}

	void SetcreditPage() {
		layeredPaneWindow.add(creditPage, "name_11081959535026");
		creditPage.setLayout(null);
		creditPage.setBackground(new Color(59, 147, 195));
		CreditPage();

	}

	private void CreditPage() {
		JLabel backGroundCreditPage = new JLabel("");
		Image backGroundCreditPageImg = new ImageIcon(this.getClass().getResource("/menuImg/credit.PNG")).getImage();
		backGroundCreditPage.setIcon(new ImageIcon(backGroundCreditPageImg));
		backGroundCreditPage.setBounds(25, 0, 1024, 700);
		creditPage.add(backGroundCreditPage);

		JButton goBackMenu = new JButton("MENU");
		goBackMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(welcomePage);
			}
		});
		goBackMenu.setBounds(10, 709, 160, 48);
		creditPage.add(goBackMenu);

		goBackMenu.setBackground(new Color(255, 255, 255));
		goBackMenu.setForeground(new Color(255, 127, 80));
		goBackMenu.setFont(new Font("Impact", Font.PLAIN, 39));
		goBackMenu.setIcon(null);

	}

	void SethowToPlayPage() {
		layeredPaneWindow.add(howToPlayPage, "name_11089071986467");
		HowToPlayPage();
		howToPlayPage.setLayout(null);
		howToPlayPage.setBackground(new Color(59, 147, 195));

	}

	private void HowToPlayPage() {
		JLabel backGroundHowToPlayPage = new JLabel("");
		Image backGroundHowToPlayPageImg = new ImageIcon(this.getClass().getResource("/menuImg/instructor.jpeg"))
				.getImage();
		backGroundHowToPlayPage.setIcon(new ImageIcon(backGroundHowToPlayPageImg));
		backGroundHowToPlayPage.setBounds(125, 0, 1024, 700);
		howToPlayPage.add(backGroundHowToPlayPage);

		JButton goBackMenu = new JButton("MENU");
		goBackMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(welcomePage);
			}
		});

		goBackMenu.setBounds(10, 709, 160, 48);
		howToPlayPage.add(goBackMenu);

		goBackMenu.setBackground(new Color(255, 255, 255));
		goBackMenu.setForeground(new Color(255, 127, 80));
		goBackMenu.setFont(new Font("Impact", Font.PLAIN, 39));
		goBackMenu.setIcon(null);

	}

	void SetrankPage() {
		layeredPaneWindow.add(rankPage, "name_11091327342604");
		RankPage();
		rankPage.setLayout(null);
		rankPage.setBackground(new Color(59, 147, 195));

	}

	private void RankPage() {
		JButton goBackMenu = new JButton("MENU");
		goBackMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(welcomePage);
			}
		});

		goBackMenu.setBackground(new Color(255, 255, 255));
		goBackMenu.setForeground(new Color(255, 127, 80));
		goBackMenu.setFont(new Font("Impact", Font.PLAIN, 39));
		goBackMenu.setIcon(null);
		goBackMenu.setBounds(10, 709, 160, 48);
		rankPage.add(goBackMenu);

		for (int i = 0; i < scoresCount; i++) {
			String buf = "The " + (i + 1) + ". score is " + scores[i];
			JLabel sss = new JLabel(buf);

			sss.setBounds(400, 50 * i, 200, 500);
			sss.setForeground(new Color(255, 127, 80));
			sss.setFont(new Font("Impact", Font.PLAIN, 22));
			rankPage.add(sss);

		}

	}

	public void switchPanels(JPanel panel) {
		layeredPaneWindow.removeAll();
		layeredPaneWindow.add(panel);
		layeredPaneWindow.repaint();
		layeredPaneWindow.revalidate();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (gamePlay.isPlay()) {

			if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
				gamePlay.moveLeft();
				gamePlay.spedUpBallLeft = true;

			}

			else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
				gamePlay.moveRight();
				gamePlay.spedUpBallRight = true;

			} else if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				gamePlay.setPlay(false);
				game.drawPausePanel();

				// pausePanel.setVisible(true);
			}

		} else {
			if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ESCAPE) {

				game.deletePausePanel();
				game.deletePausePanel0Life();
				game.deletePausePanel1Life();
				game.deletePausePanel2Life();

				if (gamePlay.life == -1) {

					this.switchPanels(welcomePage);
					objectsLayer.removeAll();

					scores[scoresCount] = gamePlay.getScore();
					scoresCount += 1;
					rankPage.removeAll();
					RankPage();

					game = new MapGenerator(objectsLayer);
					gamePlay = new GamePlay(game, playPage);

				} else {
					gamePlay.setPlay(true);
					gamePlay.gameStart();
				}

			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {

			gamePlay.spedUpBallLeft = false;

		}

		if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {

			gamePlay.spedUpBallRight = false;
		}

	}

}
