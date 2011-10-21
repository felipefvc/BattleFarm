package br.ita.battlefarm;

import android.content.Context;
import android.view.View;

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

public class BoardView extends View {

	public BoardView(Context context) {
		super(context);
	}

}
