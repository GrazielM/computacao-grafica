package br.com.anhembi.cco.computacaografica.aula4primitivas3d.cena3d.input;

import br.com.anhembi.cco.computacaografica.aula4primitivas3d.cena3d.cena.Cena;
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

    if (e.getKeyChar() == 'a')
      System.out.println("Pressionou tecla a");
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

}
