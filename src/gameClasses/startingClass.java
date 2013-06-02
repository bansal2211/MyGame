package gameClasses;
import java.applet.AudioClip;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;



public class startingClass extends Applet implements Runnable, KeyListener {
	
	enum GameState {
		Running, Dead;
	}
	public static AudioClip burstSound, collectSound;
	
	GameState state= GameState.Running;

    private static Robot robot;
    private static Basket myBasket;
    
    int ballonTimer = 0, endTime = 2000;
    //public static Heliboy hb, hb2;
    public static int basketScore=0, ballonScore=0;
    
    
    private int maxBallons= 50;
    
    public static int random_minX=150;
    public static int random_maxX=710;
    
    private Font font = new Font(null, Font.BOLD, 10);
    private Image image, currentSprite, character, character2, character3,
            characterDown, characterJumped, background, heliboy, heliboy2,
            heliboy3, heliboy4, heliboy5, basket, arrow, arrowRobot, ballonImage, ballonBottomImage;

    public static Image tilegrassTop, tilegrassBot, tilegrassLeft,
            tilegrassRight, tiledirt;

    private Graphics second;
    private URL base;
    private static Background bg1, bg2;
    //private Animation anim, hanim;

    
    private static ArrayList<Ballon> Ballon_Objects = new ArrayList<Ballon>();
    private static ArrayList<BallonBottom> Ballon_Bottom_Objects = new ArrayList<BallonBottom>();

    @Override
    public void init() {

        setSize(800, 480);
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("Q-Bot Alpha");
        frame.setResizable(false);
        
       
        try {
            base = getDocumentBase();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Image Setups
        character = getImage(base, "data/character.png");
        
        arrowRobot = getImage(base, "data/ArrowRobot.png");
        character2 = getImage(base, "data/character2.png");
        character3 = getImage(base, "data/character3.png");

        characterDown = getImage(base, "data/down.png");
        characterJumped = getImage(base, "data/jumped.png");

        heliboy = getImage(base, "data/heliboy.png");
        heliboy2 = getImage(base, "data/heliboy2.png");
        heliboy3 = getImage(base, "data/heliboy3.png");
        heliboy4 = getImage(base, "data/heliboy4.png");
        heliboy5 = getImage(base, "data/heliboy5.png");

        background = getImage(base, "data/background.png");

        tiledirt = getImage(base, "data/tiledirt.png");
        tilegrassTop = getImage(base, "data/tilegrasstop.png");
        tilegrassBot = getImage(base, "data/tilegrassbot.png");
        tilegrassLeft = getImage(base, "data/tilegrassleft.png");
        tilegrassRight = getImage(base, "data/tilegrassright.png");
        
        basket = getImage(base, "data/basket.jpg");
        arrow = getImage(base, "data/smallArrow.png");
        
        ballonImage = getImage(base, "data/ballon.jpg");
        
        ballonBottomImage = getImage(base, "data/ballonBottom.png");
        
        burstSound = getAudioClip( getDocumentBase(), "data/burst.wav" );
        collectSound = getAudioClip( getDocumentBase(), "data/collect.wav" );
        /*anim = new Animation();
        anim.addFrame(character, 1250);
        anim.addFrame(character2, 50);
        anim.addFrame(character3, 50);
        anim.addFrame(character2, 50);

        hanim = new Animation();
        hanim.addFrame(heliboy, 100);
        hanim.addFrame(heliboy2, 100);
        hanim.addFrame(heliboy3, 100);
        hanim.addFrame(heliboy4, 100);
        hanim.addFrame(heliboy5, 100);
        hanim.addFrame(heliboy4, 100);
        hanim.addFrame(heliboy3, 100);
        hanim.addFrame(heliboy2, 100);*/

        //currentSprite = anim.getImage();
    }

    @Override
    public void start() {
        bg1 = new Background(0, 0);
        //bg2 = new Background(2160, 0);
        robot = new Robot();
        myBasket = new Basket();
        // Initialize Tiles
        try {
            loadMap("data/map1.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       /* hb = new Heliboy(340, 360);
        hb2 = new Heliboy(700, 360);*/

        Thread thread = new Thread(this);
        thread.start();
    }

    private void loadMap(String filename) throws IOException {
        /*ArrayList lines = new ArrayList();
        int width = 0;
        int height = 0;

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        while (true) {
            String line = reader.readLine();
            // no more lines to read
            if (line == null) {
                reader.close();
                break;
            }

            if (!line.startsWith("!")) {
                lines.add(line);
                width = Math.max(width, line.length());

            }
        }
        height = lines.size();

        for (int j = 0; j < 12; j++) {
            String line = (String) lines.get(j);
            for (int i = 0; i < width; i++) {

                if (i < line.length()) {
                    char ch = line.charAt(i);
                    Tile t = new Tile(i, j, Character.getNumericValue(ch));
                    tilearray.add(t);
                }

            }
        }*/

    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    
    public void run() {
       if (state== GameState.Running){
    	while (true) {
            robot.update();
            myBasket.update();
            if(maxBallons > 0){
            	addBallons(15);
            }
            /*if (robot.isJumped()) {
                currentSprite = characterJumped;
            } else if (robot.isJumped() == false && robot.isDucked() == false) {
                currentSprite = anim.getImage();
            }*/

            ArrayList projectiles = robot.getProjectiles();
            for (int i = 0; i < projectiles.size(); i++) {
                Projectile p = (Projectile) projectiles.get(i);
                if (p.isVisible() == true) {
                    p.update();
                } else {
                    projectiles.remove(i);
                }
            }
            for (int i = 0; i < Ballon_Bottom_Objects.size(); i++) {
                Ballon_Bottom_Objects.get(i).update();
            }
            for (int i = 0; i < Ballon_Objects.size(); i++) {
                Ballon_Objects.get(i).update();
            }
            

           // updateTiles();
            //hb.update();
            //hb2.update();
           // bg1.update();
            //bg2.update();
            //animate();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*if (robot.getCenterY()>500){
            	state= GameState.Dead;
            }*/
        }
       }
    }

    public void animate() {
        /*anim.update(10);
        hanim.update(50);*/
    }

    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            second = image.getGraphics();
        }

        second.setColor(getBackground());
        second.fillRect(0, 0, getWidth(), getHeight());
        second.setColor(getForeground());
        paint(second);

        g.drawImage(image, 0, 0, this);

    }

    @Override
    public void paint(Graphics g) {
        if(state== GameState.Running){
    	//g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
        //g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
       // paintTiles(g);

        ArrayList projectiles = robot.getProjectiles();
        for (int i = 0; i < projectiles.size(); i++) {
            Projectile p = (Projectile) projectiles.get(i);
            g.setColor(Color.BLACK);
            g.fillRect(p.getX(), p.getY(), 35, 2);
            
        
        }
        for (int i = 0; i < Ballon_Objects.size(); i++) {
            Ballon bb= Ballon_Objects.get (i);
            if (bb.isVisible == true)
        	g.drawImage(ballonImage, bb.getCenterX()-28, bb.getCenterY()-35, this );
            else
            	{
            	Ballon_Objects.remove(i);
            
            	
            	}
            
            System.out.println(""+Ballon_Objects.size());
        }
        
        for (int i = 0; i < Ballon_Bottom_Objects.size(); i++) {
            BallonBottom bottom= Ballon_Bottom_Objects.get(i);
            if (bottom.isVisible == true)
        	g.drawImage(ballonBottomImage, bottom.getCenterX()-10, bottom.getCenterY()+13, this );
            else
            	{
            	Ballon_Bottom_Objects.remove(i);
            	
            	}
            
            System.out.println("BallonBottom:"+Ballon_Bottom_Objects.size());
        }

        /*g.drawImage(character, robot.getCenterX() - 61,
                robot.getCenterY() - 63, this);
        */
        g.drawImage(arrowRobot, robot.getCenterX() - 51,
                robot.getCenterY() - 50, this);
        g.drawImage(basket, myBasket.getCenterX() - 54,
                myBasket.getCenterY() - 20, this);
        
        /*g.drawImage(hanim.getImage(), hb.getCenterX() - 48,
                hb.getCenterY() - 48, this);
        g.drawImage(hanim.getImage(), hb2.getCenterX() - 48,
                hb2.getCenterY() - 48, this);*/
        
        
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.clearRect(10, 440, 90, 50);
        g.drawString("Basket : "+Integer.toString(basketScore/24), 10, 440);
        g.drawString("Ballons: "+Integer.toString(ballonScore), 10, 470);
    }
        else if (state== GameState.Dead){
        	g.setColor(Color.BLACK);
        	g.fillRect(0, 0, 800, 480);
        	g.setColor(Color.WHITE);
        	g.drawString("Dead", 360, 240);
        }
   }

    private void updateTiles() {

        /*for (int i = 0; i < tilearray.size(); i++) {
            Tile t = (Tile) tilearray.get(i);
            t.update();
        }*/

    }

    private void paintTiles(Graphics g) {
        /*for (int i = 0; i < tilearray.size(); i++) {
            Tile t = (Tile) tilearray.get(i);
            g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY(), this);
        }*/
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            robot.moveUp();
           // robot.setMovingUp(true);
            break;

        case KeyEvent.VK_DOWN:
        	robot.moveDown();
            //robot.setMovingDown(true);
            break;

        case KeyEvent.VK_LEFT:
            myBasket.moveLeft();
            
            break;

        case KeyEvent.VK_RIGHT:
            myBasket.moveRight();
            
            break;

            /* case KeyEvent.VK_SPACE:
            robot.jump();
            break;*/

        case KeyEvent.VK_CONTROL:
            if (robot.isReadyToFire()) {
                robot.shoot();
                robot.setReadyToFire(false);
            }
            break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            robot.stopUp();
            break;

        case KeyEvent.VK_DOWN:
            robot.stopDown();
            break;

        case KeyEvent.VK_LEFT:
            myBasket.stopMoving();
            break;

        case KeyEvent.VK_RIGHT:
        	myBasket.stopMoving();
            break;

            /*case KeyEvent.VK_SPACE:
            break;*/

        case KeyEvent.VK_CONTROL:
            robot.setReadyToFire(true);
            break; 

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public static Background getBg1() {
        return bg1;
    }

    public static Background getBg2() {
        return bg2;
    }

    public static Robot getRobot() {
        return robot;
    }

	public static Basket getMyBasket() {
		return myBasket;
	}

	public static void setMyBasket(Basket myBasket) {
		startingClass.myBasket = myBasket;
	}
	private int GenerateRandom(){
		return random_minX + (int)(Math.random()*random_maxX); 
	}

	public static ArrayList<Ballon> getBallon_Objects() {
		return Ballon_Objects;
	}

	public void setBallon_Objects(ArrayList<Ballon> ballon_Objects) {
		Ballon_Objects = ballon_Objects;
	}
	public boolean addBallons(long elapsedTime){
		ballonTimer += elapsedTime;
		if (ballonTimer > endTime){
			Ballon b = new Ballon (GenerateRandom(), 10);
			Ballon_Objects.add(b);
			maxBallons--;
			ballonTimer = 0;
			return true;
			
			
		}
		else return false;
		
	}

	public static ArrayList<BallonBottom> getBallon_Bottom_Objects() {
		return Ballon_Bottom_Objects;
	}

	public static void setBallon_Bottom_Objects(
			ArrayList<BallonBottom> ballon_Bottom_Objects) {
		Ballon_Bottom_Objects = ballon_Bottom_Objects;
	}
	

}