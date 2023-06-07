import java.awt.Color;
import java.awt.Graphics;

public class Segmento {
    private int x;
    private int y;

    public Segmento(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void desenhar(Graphics g, int tamanhoSegmento) {
        g.setColor(Color.RED);
        g.fillRect(x, y, tamanhoSegmento, tamanhoSegmento);
    }
}
