package br.com.anhembi.cco.computacaografica.aula5.zbuffer.input;

import br.com.anhembi.cco.computacaografica.aula5.zbuffer.cena.Cena;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

/**
 * @author Siabreu
 */
public class KeyBoard implements KeyListener {
  private final Cena cena;

  public KeyBoard(Cena cena) {
    this.cena = cena;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println("Key pressed: " + e.getKeyCode());
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
      System.exit(0);

    if (e.getKeyChar() == 'r')
      cena.angulo += 45;

    if (e.getKeyChar() == 'z')
      cena.zbuffer = !cena.zbuffer;
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

}
