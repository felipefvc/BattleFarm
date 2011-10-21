package br.ita.battlefarm;

import android.app.Activity;
import android.os.Bundle;

/* Esta classe servir� como classe de l�gica de jogo no primeiro Sprint.
 * Desta maneira, esta classe deve receber comandos de jogadas dos objetos
 * que representam os jogadores, deve process�-los, e deve repassar as informa��es
 * necess�rias para a camada de visualiza��o, ou seja, o tabuleiro. 
 * */ 
public class BattleFarmActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}