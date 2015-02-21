package com.mycompany.mygame3;


import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import java.util.*;

public class MyGdxGame implements ApplicationListener
{
    SpriteBatch batch;
	OrthographicCamera camera;
	TextureRegion ballTexture , ballTexture2 , ballTexture3 , ballTexture4 ,  ballTexture5, ballTexture6 , ballTexture7;
	TextureRegion backgroundTexture;
	TextureRegion mi4;
	int count;
	List<TextureRegion>ballTextures;
	List<Vector2>ballPositions222;
	List<Vector2>ballVelocitys;
	float time;
	Vector2 ballPosition , ballPosition2 , ballPosition3, ballPosition4, ballPosition5, ballPosition6 ,ballPosition7; 
	Vector2 ballVelocity , ballVelocity2 , ballVelocity3 ,ballVelocity4 , ballVelocity5 , ballVelocity6 , ballVelocity7;
    double rx, ry;
	BitmapFont font; 
    String str;
	int xx; 
	mih m1;
	List<mih>lm1;
    @Override
    public void create()
	{
		camera = new OrthographicCamera();
		configureCamera();
        batch = new SpriteBatch();
		count = 200;
		font = new BitmapFont();
        
		//rx = new java.util.Random();
		Texture texture = new Texture(Gdx.files.internal("mih4.png"));
		Texture tmihh4 = new Texture(Gdx.files.internal("mihh4.png"));
		Texture tmihh6 = new Texture(Gdx.files.internal("mih6.png"));
		mi4 = new TextureRegion(tmihh4,0,0,256,256);
		//ballTextures = new ArrayList<TextureRegion>();
		//for (int i=1 ; i<count ; i++) {
		//	ballTextures.add(new TextureRegion(texture,0,0,256,256));
		//}


		Texture texture2 = new Texture(Gdx.files.internal("Back2.jpg"));
		backgroundTexture = new TextureRegion(texture2, 0, 0, 2048, 563);

		//ballPositions222 = new ArrayList<Vector2>();
		//for (int i=1; i<count; i++){
		//	ballPosition = new Vector2(i*20,i);
		//	ballPositions222.add(ballPosition);
		//}

		//ballVelocitys = new ArrayList<Vector2>();
		//for (int i=1 ; i<count ; i++){
		//	ballVelocitys.add(new Vector2(i*0,i*0));
		//}
		
		//m1 = new mih(new TextureRegion(texture,0,0,256,256),new Vector2(400,400),new Vector2(0,0));
        
		lm1 = new ArrayList<mih>();
		for (int i =1 ; i<count ; i++){
			double xd = new Random().nextFloat() * 1000; float xf = (float) xd;
			double yd = new Random().nextFloat() * 500;  float yf = (float) yd;
			double zd = new Random().nextInt() * 0.000000007; int zi = -4 + (int) zd;
			//mih (TextureRegion miha,
			//     TextureRegion miha1,
			//     TextureRegion miha2,
			//     TextureRegion miha3,
			//     Vector2 ballPosition,
			//     Vector2 ballVelocity,
			//     Float msizex,Float msizey,int angle){			
			lm1.add(new mih(new TextureRegion(texture,0,0,256,256),
			                new TextureRegion(texture,0,0,256,256),
					        new TextureRegion(tmihh4,0,0,256,256),
					        new TextureRegion(tmihh6,0,0,256,256),
					        new Vector2(300+i,300),
							new Vector2(0,0),
							120f,120f,i,zi));
		}
    }

    @Override
    public void render()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);
        //------------------------------------------------------------
		batch.begin();
		//batch.draw(backgroundTexture ,0,0,1000,500);
		batch.draw(backgroundTexture ,0,0,0,0,1000,500,1,1,0);
		
		
		//str = Gdx.input.getAccelerometerZ() + "";
		str = (new Random().nextInt() * 0.00000001) + "";
        
		if (Gdx.input.isTouched()){
		    for(int ii = 1; ii< count-1 ; ii++){
			    lm1.get(ii).eventm(Gdx.input.getX(), Gdx.input.getY());
		    }
		}	
		for(int i =1 ; i <count -1 ; i++){
			batch.draw(lm1.get(i).miha,lm1.get(i).ballPosition.x,lm1.get(i).ballPosition.y,0,0,lm1.get(i).msizex,lm1.get(i).msizey,1,1,lm1.get(i).angle);
		}
		font.draw(batch,str + " " , camera.position.x - 10, 30);   
		batch.end();
		
		
        //------------------------------------------------------------
        time += Gdx.graphics.getDeltaTime();
		if (time > 2)
		{
			for (int i=1;i<count -1;i++){
				lm1.get(i).renderState();	
				lm1.get(i).phisica(Gdx.input.getAccelerometerX(),Gdx.input.getAccelerometerY(), Gdx.input.getAccelerometerZ());
//				for (int iii=1;iii<count-1;iii++){
//					
//					if (lm1.get(i) != lm1.get(iii)){
//						
//					
//					int result = lm1.get(i).interaction(lm1.get(iii).ballPosition.x, 
//					                                    lm1.get(iii).ballPosition.y, 
//										                lm1.get(iii).ballVelocity.x,
//										                lm1.get(iii).ballVelocity.y);
//					//if (result ==
//					//	lm1.get(iii).ballVelocity.x = lm1.get(iii).ballVelocity.x - lm1.get(i).ballVelocity.x;
//					//	lm1.get(iii).ballVelocity.y = lm1.get(iii).ballVelocity.y - lm1.get(i).ballVelocity.y;
//					//}
//					}
//				}
					
			}
		}
    }

	private void configureCamera()
	{
		
		//if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
			camera.setToOrtho(false, 800, 800 * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
		//else
		//	camera.setToOrtho(false, 800 * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), 800);
	}

	@Override
    public void dispose()
	{
        batch.dispose();
    }

    @Override
    public void resize(int width, int height)
	{
	//	configureCamera();
    }

    @Override
    public void pause()
	{
    }

    @Override
    public void resume()
	{
    }
}

class mih{
	TextureRegion miha, miha1,miha2, miha3;
	int count,lag;
	int state ,tmpstate,angle , speed_angle;
	float time;
	Vector2 ballPosition, ballPosition2;
	Vector2 ballVelocity;
	Float msizex ,msizey ;
	
	
    double rx, ry;
	BitmapFont font;
	mih (TextureRegion miha,
	     TextureRegion miha1,
		 TextureRegion miha2,
		 TextureRegion miha3,
		 Vector2 ballPosition,
		 Vector2 ballVelocity,
		 Float msizex,
		 Float msizey,
		 int angle,
		 int speed_angle){
			 
		this.miha = miha;
		this.miha1= miha1;
		this.miha2= miha2;
		this.miha3= miha3;
		this.msizex = msizex;
		this.msizey = msizey;
		this.state = 2;
		this.tmpstate = 2;
		this.angle = angle;
		this.lag = 0;
		this.speed_angle = speed_angle;
		
		this.ballPosition  = ballPosition;
		this.ballVelocity  = ballVelocity;
		this.ballPosition2 = new Vector2(this.ballPosition.x,this.ballPosition.y);
	}
	public void phisica(Float xx , Float yy , Float zz){
	    
		
		this.msizex = 12 * zz;
		this.msizey = 12 * zz;
		if (this.state !=3){
				
		//this.msizex = 50 +this.ballPosition.x;	
		//this.msizey = 150 +this.ballPosition.y;		
		if (this.state == 1) {
		   
			if (this.ballPosition.x != this.ballPosition2.x){
				this.ballVelocity.x = (this.ballPosition2.x - this.ballPosition.x)*3;
				this.ballVelocity.y = (this.ballPosition2.y - this.ballPosition.y)*3;
			}	
			
			this.ballPosition.add(new Vector2(this.ballVelocity.x * Gdx.graphics.getDeltaTime(),this.ballVelocity.y * Gdx.graphics.getDeltaTime()));
		    this.ballVelocity.y = this.ballVelocity.y - (xx * Gdx.graphics.getDeltaTime() * 100);
			this.ballVelocity.x = this.ballVelocity.x + (yy * Gdx.graphics.getDeltaTime() * 100);
		    this.angle = this.angle + this.speed_angle;
			
			this.ballPosition2.x = this.ballPosition.x;
			this.ballPosition2.y = this.ballPosition.y;
		}	
		
			this.state =1;
		
		if (this.ballPosition.y < 0 && this.ballVelocity.y<0){
			this.ballVelocity.y =- 0.7f * this.ballVelocity.y;
		//	this.state =3;
		}
		if (this.ballPosition.x > 700 && this.ballVelocity.x>0){
			this.ballVelocity.x =-0.7f * this.ballVelocity.x;
		//	this.state =3;
		}
		if (this.ballPosition.x < 0 && this.ballVelocity.x<0){
			this.ballVelocity.x =-0.7f * this.ballVelocity.x;
		//	this.state =3;
		}
		
		
		}
	}
	
	public void eventm(int x , int y){
		Float yy = (Gdx.graphics.getHeight() -y) *0.6f;
		Float xx = (x*0.6f) -20;
		if ((xx -10 < this.ballPosition.x) &&(xx +10 > this.ballPosition.x) && (this.state!=3))
			{ 
				 //this.ballVelocity.y = 500;
				 //this.ballVelocity.x += 40;
				 //this.state = 2;
		         //this.ballPosition.y = (Gdx.graphics.getHeight() -y) *0.6f;
			}
		if ((xx -40 < this.ballPosition.x) &&(xx + 40 > this.ballPosition.x) &&
	       (yy -50 < this.ballPosition.y) &&(yy +30 > this.ballPosition.y))
		{
			//this.ballVelocity.y = 0;
			//this.ballVelocity.x += 0;
			//this.state = 3;
			this.ballPosition.x = xx;
			this.ballPosition.y = yy;
			this.state =2;
		}		
	}
	public int interaction(Float xx , Float yy,Float vxx, Float vyy){
		if (lag <= 0){
		    if ((xx -40 < this.ballPosition.x) &&(xx + 40 > this.ballPosition.x) &&
			    (yy -50 < this.ballPosition.y) &&(yy + 30 > this.ballPosition.y))
		    {
			    if(this.ballVelocity.x < 0 && this.ballVelocity.y < 0){
					Float deltay = Math.abs((Math.abs(this.ballVelocity.y) - Math.abs(vyy)));
					Float deltax = Math.abs((Math.abs(this.ballVelocity.x) - Math.abs(vxx)));
					
					if (this.ballPosition.y > vyy){
						this.ballVelocity.y = this.ballVelocity.y + deltay;
					} else {
						this.ballVelocity.y = this.ballVelocity.y - deltay;
					}
					
					if (this.ballPosition.x > vxx){
						this.ballVelocity.x = this.ballVelocity.x + deltax;
					} else {
						this.ballVelocity.x = this.ballVelocity.x - deltax;
					}
					
					
				}
				
				
			    //this.state = 2;
				this.lag = 4;
		   	    return 1;
		    }
		}
		//this.state = 1;
	    this.lag = this.lag -1;
		return 0;
		
	}
	public void renderState(){
		if (this.state == 1) {
			this.miha = this.miha1;
		}else if(this.state ==2){
			this.miha = this.miha2;
		}else if(this.state ==3){
			this.miha = this.miha3;
		}	
	}	
}

