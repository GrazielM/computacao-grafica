package br.com.anhembi.cco.computacaografica.aula5.luzdifusa.input;

import br.com.anhembi.cco.computacaografica.aula5.luzdifusa.cena.Cena;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GL2;

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

    switch (e.getKeyChar()) {
      case 'r':
        cena.angulo += 45;
        break;
      case 't':
        cena.tonalizacao = cena.tonalizacao == GL2.GL_SMOOTH ? GL2.GL_FLAT : GL2.GL_SMOOTH;
        break;
      case 'l':
        cena.liga = !cena.liga;
        System.out.println(cena.liga);
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

}
