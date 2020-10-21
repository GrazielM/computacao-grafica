package br.com.anhembi.cco.computacaografica.aula4primitivas3d.cena3d.cena;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 * @author Siabreu
 */
public class Cena implements GLEventListener {
  private float xMin, xMax, yMin, yMax, zMin, zMax;
  GLU glu;

  @Override
  public void init(GLAutoDrawable drawable) {
    //dados iniciais da cena
    glu = new GLU();
    GL2 gl = drawable.getGL().getGL2();
    //Estabelece as coordenadas do SRU (Sistema de Referencia do Universo)
    xMin = yMin = zMin = -100;
    xMax = yMax = zMax = 100;

    //Habilita o buffer de profundidade
    gl.glEnable(GL2.GL_DEPTH_TEST);
  }

  @Override
  public void display(GLAutoDrawable drawable) {
    //obtem o contexto Opengl
    GL2 gl = drawable.getGL().getGL2();
    //objeto para desenho 3D
    GLUT glut = new GLUT();

    //define a cor da janela (R, G, G, alpha)
    gl.glClearColor(0, 0, 0, 1);
    //limpa a janela com a cor especificada
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity(); //ler a matriz identidade
        
        /*
            desenho da cena        
        *
        */

    gl.glColor3f(1, 0, 0);

    //desenha um cubo
    glut.glutSolidCube(50);

    gl.glFlush();
  }

  @Override
  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    //obtem o contexto grafico Opengl
    GL2 gl = drawable.getGL().getGL2();

    //evita a divisao por zero
    if (height == 0) height = 1;
    //calcula a proporcao da janela (aspect ratio) da nova janela
    //float aspect = (float) width / height;

    //seta o viewport para abranger a janela inteira
    //gl.glViewport(0, 0, width, height);

    //ativa a matriz de projecao
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity(); //ler a matriz identidade

    //Projeção ortogonal
    //true:   aspect >= 1 configura a altura de -1 para 1 : com largura maior
    //false:  aspect < 1 configura a largura de -1 para 1 : com altura maior
//        if(width >= height)            
//            gl.glOrtho(xMin * aspect, xMax * aspect, yMin, yMax, zMin, zMax);
//        else        
//            gl.glOrtho(xMin, xMax, yMin / aspect, yMax / aspect, zMin, zMax);

    //projecao ortogonal sem a correcao do aspecto
    gl.glOrtho(xMin, xMax, yMin, yMax, zMin, zMax);

    //ativa a matriz de modelagem
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity(); //ler a matriz identidade
    System.out.println("Reshape: " + width + ", " + height);
  }

  @Override
  public void dispose(GLAutoDrawable drawable) {
  }
}
