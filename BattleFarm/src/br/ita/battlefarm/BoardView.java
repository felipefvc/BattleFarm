package br.ita.battlefarm;

import android.content.Context;
import android.view.View;

/*
 * Esta classe será a entidade que representará um tabuleiro, podendo ser do jogador,
 * ou podendo ser do adversário. Desta maneira, ela deve ser configurável para, se
 * for o tabuleiro do jogador, mostrar a posição dos animais e indicar quais dessas
 * posições já foram atingidas pelo adversário e, quando for o tabuleiro do adversário,
 * deve indicar as posições em que já foram jogadas, e quais delas foram jogadas acertadas
 * ou tiros em falso.
 * 
 * Esta também será a classe responsável por rodar animações de uma posição sendo atingida,
 * ou de qualquer outra coisa que envolva alguma animação sobre o tabuleiro.
 * 
 * Ainda, como a seleção de posições das jogadas irá funcionar com um toque na tela, esta
 * classe será responsável por ler informações de toque do jogador e repassar para a entidade
 * que implementa a interface de jogador como sendo o usuário do programa.
 * */

public class BoardView extends View {

	public BoardView(Context context) {
		super(context);
	}

}
