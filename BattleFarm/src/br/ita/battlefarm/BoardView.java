package br.ita.battlefarm;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/*
 * Esta classe ser� a entidade que representar� um tabuleiro, podendo ser do jogador,
 * ou podendo ser do advers�rio. Desta maneira, ela deve ser configur�vel para, se
 * for o tabuleiro do jogador, mostrar a posi��o dos animais e indicar quais dessas
 * posi��es j� foram atingidas pelo advers�rio e, quando for o tabuleiro do advers�rio,
 * deve indicar as posi��es em que j� foram jogadas, e quais delas foram jogadas acertadas
 * ou tiros em falso.
 * 
 * Esta tamb�m ser� a classe respons�vel por rodar anima��es de uma posi��o sendo atingida,
 * ou de qualquer outra coisa que envolva alguma anima��o sobre o tabuleiro.
 * 
 * Ainda, como a sele��o de posi��es das jogadas ir� funcionar com um toque na tela, esta
 * classe ser� respons�vel por ler informa��es de toque do jogador e repassar para a entidade
 * que implementa a interface de jogador como sendo o usu�rio do programa.
 * */
//TODO: Setar view para funcionar junto com layout

public class BoardView extends View {

	//Defini��o de par�metros de objetos na tela
	//TODO: Par�metros configur�veis pelo construtor
	private int mBoardSize;
	private int mBoardW;
	private int mBoardH;
	private int mTileSize;
	private int mNumTilesY = 20;
	private int mNumTilesX = 10;
	private int mOffSet = 10;
	
	private int[][] tilesHit;
	
	private OnTouchListener uiListener = new BoardTouchListener();

	public BoardView(Context context) {
		super(context);
		initBoardView();
	}
	public BoardView(Context context, AttributeSet attrs, int defStyle) {
    	super(context, attrs, defStyle);
    	initBoardView();
    }
	public BoardView(Context context, AttributeSet attrs) {
    	super(context, attrs);
    	initBoardView();
    }

	private void initBoardView() {
		setOnTouchListener(uiListener);
		tilesHit = new int[mNumTilesY][mNumTilesX];
		for(int i=0; i<mNumTilesY; i++){
			for(int j=0; j<mNumTilesX; j++){
				tilesHit[i][j] = 0;
			}
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawARGB(255, 0, 0, 0);
		Paint p = new Paint();
		p.setARGB(255, 255, 255, 255);
		//Desenhando linhas
		for(int i = 0; i<=mNumTilesY; i++){
			canvas.drawLine(mOffSet, mOffSet + mTileSize*i, 
					mOffSet+mTileSize*mNumTilesX, mOffSet + mTileSize*i, p);
		}
		//Desenhando colunas
		for(int i = 0; i<=mNumTilesX; i++){
			canvas.drawLine(mOffSet + mTileSize*i, mOffSet, mOffSet + mTileSize*i, 
					mOffSet+mTileSize*mNumTilesY, p);
		}
		//Desenhando casas atingidas
		for(int i = 0; i<mNumTilesY; i++){
			for(int j = 0; j<mNumTilesX; j++){
				if(tilesHit[i][j] != 0){
					canvas.drawCircle(mOffSet + (j+0.5f)*mTileSize, mOffSet + 
							(i+0.5f)*mTileSize, 0.5f*mTileSize, p);
				}
			}
		}
		
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		this.mBoardW = w-2*mOffSet;
		this.mBoardH = h-2*mOffSet;
		this.mTileSize = Math.min(mBoardH/mNumTilesY, mBoardW/mNumTilesX);
	}
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if(Math.min(widthMeasureSpec, heightMeasureSpec)<100000000){
			setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
		}
		else{
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}
		
	}
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
	}

	private class BoardTouchListener implements OnTouchListener{
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			switch(event.getAction()){
			case MotionEvent.ACTION_UP:
				int j = (int) Math.floor((event.getX()-mOffSet)/mTileSize);
				int i = (int) Math.floor((event.getY()-mOffSet)/mTileSize);
				try{
					tilesHit[i][j] = 1;
					invalidate();
				}
				catch(IndexOutOfBoundsException e){
					
				}
				break;
			}
			return true;
		}
		
	}

}
