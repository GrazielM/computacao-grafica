package br.com.anhembi.cco.computacaografica.aula2.cena;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

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
    //Estabelece as coordenadas do SRU (Sistema de Referencia do Universo)
    xMin = yMin = zMin = -1;
    xMax = yMax = zMax = 1;
  }

  @Override
  public void display(GLAutoDrawable drawable) {
    //obtem o contexto Opengl
    GL2 gl = drawable.getGL().getGL2();
    //define a cor da janela (R, G, G, alpha)
    gl.glClearColor(0, 0, 0, 1);
    //limpa a janela com a cor especificada
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
    gl.glLoadIdentity(); //lê a matriz identidade
        
        /*
            desenho da cena        
        *
        */

//    exercicioUm(gl);
//    exercicioDois(gl);
    exercicioTres(gl);

    gl.glFlush();
  }

  private void exercicioTres(GL2 tela) {
    //Linha X
    tela.glBegin(tela.GL_LINES);
    tela.glColor3f(1,0,0);
    tela.glVertex2f(0,0);
    tela.glVertex2f(1,0);
    tela.glEnd();

    //Linha Y
    tela.glBegin(tela.GL_LINES);
    tela.glColor3f(0,1,0);
    tela.glVertex2f(0,0);
    tela.glVertex2f(0,1);
    tela.glEnd();

    //Linha Z
    tela.glBegin(tela.GL_LINES);
    tela.glColor3f(0,0,1);
    tela.glVertex2f(0,0);
    tela.glVertex2f(-1,-1);
    tela.glEnd();

    //Pontos
    tela.glBegin(tela.GL_POINTS);
    tela.glColor3f(1,1,0);
    tela.glVertex2f(-0.9f, 0.9f);
    tela.glVertex2f(-0.8f, 0.9f);
    tela.glVertex2f(-0.9f, 0.8f);
    tela.glVertex2f(-0.8f, 0.8f);
    tela.glEnd();

    //LooP
    tela.glBegin(tela.GL_LINE_LOOP);
    tela.glColor3f(0,1,1);
    tela.glVertex2f(-0.2f,0.2f);
    tela.glVertex2f(-0.2f,0.5f);
    tela.glVertex2f(-0.3f,0.4f);
    tela.glVertex2f(-0.4f,0.5f);
    tela.glVertex2f(-0.5f,0.3f);
    tela.glVertex2f(-0.4f,0.2f);
    tela.glVertex2f(-0.3f,0.3f);
    tela.glVertex2f(-0.2f,0.2f);
    tela.glEnd();

    //Poligono
    tela.glBegin(tela.GL_POLYGON);
    tela.glColor3f(1,0.5f,0);
    tela.glVertex2f(-0.5f, -0.2f);
    tela.glVertex2f(-0.7f, -0.1f);
    tela.glVertex2f(-0.9f, -0.4f);
    tela.glVertex2f(-0.3f, -0.5f);
    tela.glVertex2f(-0.2f, -0.1f);
    tela.glEnd();

    //Escada
    tela.glBegin(tela.GL_QUADS);
    tela.glColor3f(0,1,0.5f);
    //Quad 1
    tela.glVertex2f(0.9f, 0.1f);
    tela.glVertex2f(0.9f, 0.2f);
    tela.glVertex2f(0.8f, 0.2f);
    tela.glVertex2f(0.8f, 0.1f);
    //Quad 2
    tela.glVertex2f(0.8f, 0.2f);
    tela.glVertex2f(0.8f, 0.3f);
    tela.glVertex2f(0.7f, 0.3f);
    tela.glVertex2f(0.7f, 0.2f);
    //Quad 2
    tela.glVertex2f(0.7f, 0.3f);
    tela.glVertex2f(0.7f, 0.4f);
    tela.glVertex2f(0.6f, 0.4f);
    tela.glVertex2f(0.6f, 0.3f);
    tela.glEnd();

    // Triangulo deformado
    tela.glBegin(tela.GL_TRIANGLE_FAN);
    tela.glColor3f(0, 0.5f, 1);
    tela.glVertex2f(0.2f, -0.9f);
    tela.glVertex2f(0.2f, -0.5f);
    tela.glVertex2f(0.5f, -0.4f);
    tela.glVertex2f(0.6f, -0.6f);
    tela.glVertex2f(0.8f, -0.7f);
    tela.glVertex2f(0.7f, -0.8f);
    tela.glEnd();
  }

  private void exercicioUm(GL2 gl) {
//    Desenha um ponto
    gl.glBegin(gl.GL_POINTS);
    gl.glColor3f(1, 0, 0);
    gl.glVertex2f(0, 0);
    gl.glColor3f(0, 1, 0);
    gl.glVertex2f(-0.3f, 0);
    gl.glColor3f(0, 0, 1);
    gl.glVertex2f(0, -0.3f);
    gl.glColor3f(1, 0, 1);
    gl.glVertex2f(-0.3f, -0.3f);
    gl.glEnd();
//    aumenta a expessura do ponto
    gl.glBegin(gl.GL_POINT_SIZE);
    gl.glPointSize(10);
    gl.glEnd();
  }


  private void exercicioDois(GL2 gl) {
//    Desenha uma linha
    gl.glBegin(gl.GL_LINES);
    gl.glColor3f(1, 1, 0);
    gl.glVertex2f(0.9f, 0.9f);
    gl.glVertex2f(0.1f, 0.1f);
    gl.glEnd();
//    Aumenta a expessura da linha
    gl.glBegin(gl.GL_LINE_WIDTH);
    gl.glLineWidth(5);
    gl.glEnd();
  }

  @Override
  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    //obtem o contexto grafico Opengl
    GL2 gl = drawable.getGL().getGL2();

    //evita a divisão por zero
    if (height == 0) height = 1;
    //calcula a proporção da janela (aspect ratio) da nova janela
    float aspect = (float) width / height;

    //seta o viewport para abranger a janela inteira
    gl.glViewport(0, 0, width, height);

    //ativa a matriz de projeção
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity(); //lê a matriz identidade

    //Projeção ortogonal
    //true:   aspect >= 1 configura a altura de -1 para 1 : com largura maior
    //false:  aspect < 1 configura a largura de -1 para 1 : com altura maior
    if (width >= height)
      gl.glOrtho(xMin * aspect, xMax * aspect, yMin, yMax, zMin, zMax);
    else
      gl.glOrtho(xMin, xMax, yMin / aspect, yMax / aspect, zMin, zMax);

    //ativa a matriz de modelagem
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity(); //lê a matriz identidade
    System.out.println("Reshape: " + width + ", " + height);
  }

  @Override
  public void dispose(GLAutoDrawable drawable) {
  }
}
