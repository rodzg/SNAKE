import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Maca {
    private int x;
    private int y;
    private int tamanho;

    public Maca(int tamanho) {
        this.tamanho = tamanho;
        gerarPosicaoAleatoria();
    }

    public void gerarPosicaoAleatoria() {
        Random random = new Random();
        int maxX = (int) (Math.floor(500 / tamanho) - 1);
        int maxY = (int) (Math.floor(500 / tamanho) - 1);
        x = random.nextInt(maxX) * tamanho;
        y = random.nextInt(maxY) * tamanho;
    }

    public void desenhar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, tamanho, tamanho);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTamanho() {
        return tamanho;
    }
}
