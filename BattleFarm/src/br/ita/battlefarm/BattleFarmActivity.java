package br.ita.battlefarm;

import android.app.Activity;
import android.os.Bundle;

/* Esta classe servirá como classe de lógica de jogo no primeiro Sprint.
 * Desta maneira, esta classe deve receber comandos de jogadas dos objetos
 * que representam os jogadores, deve processá-los, e deve repassar as informações
 * necessárias para a camada de visualização, ou seja, o tabuleiro. 
 * */ 
public class BattleFarmActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}