import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class TelaGrafica extends JFrame {
    private Snake snake;
    private Maca maca;
    private Timer timer;

    public TelaGrafica() {
        // Configurações da janela
        setTitle("Exemplo de Tela Gráfica");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define a cor de fundo como preta
        getContentPane().setBackground(Color.BLACK);

        // Cria uma instância da classe Snake com velocidade 10
        snake = new Snake(50, 50, 100, 10);

        // Cria uma instância da classe Maca com tamanho 10
        maca = new Maca(10);

        // Cria um Timer para atualizar a posição da Snake a cada intervalo de tempo
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.moverDireita(); // Movimento automático para a direita
                verificarColisaoComMaca();
                repaint(); // Redesenha a tela
            }
        });

        // Adiciona um KeyListener para capturar eventos de teclado
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Move a Snake com base na tecla pressionada
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        snake.moverEsquerda();
                        break;
                    case KeyEvent.VK_RIGHT:
                        snake.moverDireita();
                        break;
                    case KeyEvent.VK_UP:
                        snake.moverCima();
                        break;
                    case KeyEvent.VK_DOWN:
                        snake.moverBaixo();
                        break;
                }
                verificarColisaoComMaca();
                repaint(); // Redesenha a tela
            }

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        // Define o foco para a janela para que os eventos de teclado sejam capturados
        setFocusable(true);

        // Inicia o Timer
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Desenha a Snake na posição atual
        g.setColor(Color.RED);
        g.fillRect(snake.getX(), snake.getY(), snake.getLargura(), snake.getAltura());

        // Desenha a Maçã na posição atual
        maca.desenhar(g);
    }

    private void verificarColisaoComMaca() {
        if (snake.getX() == maca.getX() && snake.getY() == maca.getY()) {
            maca.gerarPosicaoAleatoria();
        }
    }

    public static void main(String[] args) {
        // Cria uma instância da tela gráfica
        TelaGrafica tela = new TelaGrafica();

        // Exibe a janela
        tela.setVisible(true);
    }
}
