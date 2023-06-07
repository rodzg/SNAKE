import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TelaGrafica extends JPanel implements ActionListener, KeyListener {
    private static final int ALTURA = 500;
    private static final int LARGURA = 500;
    private final Snake snake;
    private Maca maca;
    private Timer timer;
    private boolean jogoEmAndamento;
    private boolean fimDePartida;
    private int macasColetadas;

    public TelaGrafica() {
        setPreferredSize(new Dimension(LARGURA, ALTURA));
        setBackground(Color.BLACK);
        snake = new Snake(50, 50, 10);
        maca = new Maca(10);
        timer = new Timer(100, this);
        jogoEmAndamento = true;
        fimDePartida = false;
        macasColetadas = 0;
        addKeyListener(this);
        setFocusable(true);
    }

    public static int getLargura() {
        return LARGURA;
    }

    public static int getAltura() {
        return ALTURA;
    }

    public void iniciarJogo() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jogoEmAndamento) {
            snake.mover();
            verificarColisaoComMaca();
            verificarFimDePartida();
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (jogoEmAndamento) {
            g.setColor(Color.BLUE);
            for (Segmento segmento : snake.getSegmentos()) {
                g.fillRect(segmento.getX(), segmento.getY(), snake.getTamanhoSegmento(), snake.getTamanhoSegmento());
            }
            g.setColor(Color.GREEN);
            g.fillRect(maca.getX(), maca.getY(), maca.getTamanho(), maca.getTamanho());
            exibirContadorMacas(g);
        } else if (fimDePartida) {
            exibirTelaFimDePartida(g);
        }
    }

    private void verificarColisaoComMaca() {
        if (snake.atingiuMaca(maca)) {
            snake.aumentarTamanho();
            maca.gerarPosicaoAleatoria();
            macasColetadas++;
        }
    }

    private void verificarFimDePartida() {
        if (snake.atingiuProprioCorpo() || snake.atingiuLimiteTela()) {
            jogoEmAndamento = false;
            fimDePartida = true;
        }
    }

    private void exibirTelaFimDePartida(Graphics g) {
        String mensagem = "Fim da partida!";
        String totalMacas = "Total de maçãs coletadas: " + macasColetadas;

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(mensagem, 180, 220);
        g.drawString(totalMacas, 150, 250);
    }

    private void exibirContadorMacas(Graphics g) {
        String contador = "Maçãs: " + macasColetadas;

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(contador, getWidth() / 2 - 50, 30);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (jogoEmAndamento) {
            switch (key) {
                case KeyEvent.VK_LEFT:
                    snake.setDirecao(Snake.Direcao.ESQUERDA);
                    break;
                case KeyEvent.VK_RIGHT:
                    snake.setDirecao(Snake.Direcao.DIREITA);
                    break;
                case KeyEvent.VK_UP:
                    snake.setDirecao(Snake.Direcao.CIMA);
                    break;
                case KeyEvent.VK_DOWN:
                    snake.setDirecao(Snake.Direcao.BAIXO);
                    break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TelaGrafica tela = new TelaGrafica();
        frame.add(tela);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        tela.iniciarJogo();
    }
}
