package br.com.anhembi.cco.computacaografica.aula4primitivas3d.primitivas.cena;


import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;

import java.awt.*;

/**
 * @author Siabreu
 */
public class Cena implements GLEventListener {
  private float xMin, xMax, yMin, yMax, zMin, zMax;
  private TextRenderer textRenderer;

  public float ang;
  public int op;

  //dados do cubo
  public float size;

  //dados da esfera
  public float radio;
  public int slices;
  public int stacks;

  //dados do cone
  public float height;

  //dados do torus
  public float innerRadius;
  public float outerRadius;
  public int rings;

  //Preenchimento
  public int mode;

  @Override
  public void init(GLAutoDrawable drawable) {
    //dados iniciais da cena
    GL2 gl = drawable.getGL().getGL2();
    //Estabelece as coordenadas do SRU (Sistema de Referencia do Universo)
    xMin = yMin = zMin = -100;
    xMax = yMax = zMax = 100;

    reset();

    textRenderer = new TextRenderer(new Font("Comic Sans MS Negrito", Font.BOLD, 15));
    //Habilita o buffer de profundidade
    gl.glEnable(GL2.GL_DEPTH_TEST);
  }

  public void reset() {
    ang = 0;

    //dados do cubo
    size = 50;

    //dados da esfera
    radio = 50;
    slices = 15;
    stacks = 15;

    //dados do cone
    height = 50;

    //dados do torus
    innerRadius = 10;
    outerRadius = 50;
    rings = 6;

    //preenchimento
    mode = GL2.GL_FILL;
  }

  @Override
  public void display(GLAutoDrawable drawable) {
    //obtem o contexto Opengl
    GL2 gl = drawable.getGL().getGL2();
    //objeto para desenho 3D
    GLUT glut = new GLUT();

    //define a cor da janela (R, G, G, alpha)
    gl.glClearColor(1, 1, 1, 1);
    //limpa a janela com a cor especificada
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity(); //ler a matriz identidade
        
        /*
            desenho da cena        
        *
        */

    //Modo de desenho - os parametros são constantes inteiras
    //int modo =  GL2.GL_FILL; ou GL2.GL_LINE ou GL2.GL_POINT
    gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, mode);

    System.out.println("op = " + op);

    String m = mode == GL2.GL_LINE ? "LINE" : "FILL";

    dadosObjeto(gl, 20, 580, Color.BLACK, "Modo: " + m);

    switch (op) {
      case 1:
        gl.glColor3f(0, 0, 0.8f); //cor do objeto
        gl.glPushMatrix();
        gl.glRotated(ang, 0, 1, 1);
        glut.glutSolidCube(size);
        gl.glPopMatrix();

        dadosObjeto(gl, 390, 580, Color.BLACK, "Objeto: CUBO");
        dadosObjeto(gl, 390, 560, Color.BLACK, "Size: " + size);
        break;
      case 2:
        gl.glColor3f(0, 0, 0.8f); //cor do objeto
        gl.glPushMatrix();
        gl.glRotated(ang, 0, 1, 1);
        glut.glutSolidSphere(radio, slices, stacks);
        gl.glPopMatrix();

        dadosObjeto(gl, 390, 580, Color.BLACK, "Objeto: ESFERA");
        dadosObjeto(gl, 390, 560, Color.BLACK, "Radio: " + radio);
        dadosObjeto(gl, 390, 540, Color.BLACK, "Slices: " + slices);
        dadosObjeto(gl, 390, 520, Color.BLACK, "Stacks: " + stacks);
        break;
      case 3:
        gl.glColor3f(0, 0, 0.8f); //cor do objeto
        gl.glPushMatrix();
        gl.glRotated(ang, 0, 1, 1);
        glut.glutSolidCone(radio, height, slices, stacks);
        gl.glPopMatrix();

        dadosObjeto(gl, 390, 580, Color.BLACK, "Objeto: CONE");
        dadosObjeto(gl, 390, 560, Color.BLACK, "Radio: " + radio);
        dadosObjeto(gl, 390, 540, Color.BLACK, "Slices: " + slices);
        dadosObjeto(gl, 390, 520, Color.BLACK, "Stacks: " + stacks);
        dadosObjeto(gl, 390, 500, Color.BLACK, "Height: " + height);
        break;
      case 4:
        gl.glColor3f(0, 0, 0.8f); //cor do objeto
        gl.glPushMatrix();
        gl.glRotated(ang, 0, 1, 1);
        glut.glutSolidCylinder(radio, height, slices, stacks);
        gl.glPopMatrix();

        dadosObjeto(gl, 390, 580, Color.BLACK, "Objeto: CILINDRO");
        dadosObjeto(gl, 390, 560, Color.BLACK, "Radio: " + radio);
        dadosObjeto(gl, 390, 540, Color.BLACK, "Slices: " + slices);
        dadosObjeto(gl, 390, 520, Color.BLACK, "Stacks: " + stacks);
        dadosObjeto(gl, 390, 500, Color.BLACK, "Height: " + height);
        break;
      case 5:
        gl.glColor3f(0, 0, 0.8f); //cor do objeto
        gl.glPushMatrix();
        gl.glRotated(ang, 0, 1, 1);
        glut.glutSolidTorus(innerRadius, outerRadius, slices, rings);
        gl.glPopMatrix();

        dadosObjeto(gl, 390, 580, Color.BLACK, "Objeto: TORUS");
        dadosObjeto(gl, 390, 560, Color.BLACK, "InnerRadius: " + innerRadius);
        dadosObjeto(gl, 390, 540, Color.BLACK, "OuterRadius: " + outerRadius);
        dadosObjeto(gl, 390, 520, Color.BLACK, "NSides: " + slices);
        dadosObjeto(gl, 390, 500, Color.BLACK, "Rings: " + rings);
        break;
      case 6:
        gl.glColor3f(0, 0, 0.8f); //cor do objeto
        gl.glPushMatrix();
        gl.glRotated(ang, 0, 1, 1);
        glut.glutSolidTeapot(size);
        gl.glPopMatrix();

        dadosObjeto(gl, 390, 580, Color.BLACK, "Objeto: TEAPOT");
        dadosObjeto(gl, 390, 560, Color.BLACK, "Size: " + size);
        break;
    }

    dadosObjeto(gl, 20, 40, Color.RED, "Controles: + - o/O s/S t/T w    r (rotacionar)");
    dadosObjeto(gl, 20, 20, Color.RED, "Objetos: 1 2 3 4 5 6    x (reset)");

    gl.glFlush();
  }

  public void dadosObjeto(GL2 gl, int xPosicao, int yPosicao, Color cor, String frase) {
    gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
    //Retorna a largura e altura da janela
    textRenderer.beginRendering(Renderer.screenWidth, Renderer.screenHeight);
    textRenderer.setColor(cor);
    textRenderer.draw(frase, xPosicao, yPosicao);
    textRenderer.endRendering();
    gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, mode);
  }

  @Override
  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    //obtem o contexto grafico Opengl
    GL2 gl = drawable.getGL().getGL2();

    //evita a divisao por zero
    //if(height == 0) height = 1;
    //calcula a proporcao da janela (aspect ratio) da nova janela
    //float aspect = (float) width / height;

    //seta o viewport para abranger a janela inteira
    //gl.glViewport(0, 0, width, height);

    //ativa a matriz de projecao
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity(); //ler a matriz identidade

    //Projecao ortogonal
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
