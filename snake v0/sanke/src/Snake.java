public class Snake {
    private int x;
    private int y;
    private int largura;
    private int altura;
    private int velocidade;

    public Snake(int x, int y, int lado, int velocidade) {
        this.x = x;
        this.y = y;
        this.largura = lado;
        this.altura = lado;
        this.velocidade = velocidade;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public void moverEsquerda() {
        x -= velocidade;
    }

    public void moverDireita() {
        x += velocidade;
    }

    public void moverCima() {
        y -= velocidade;
    }

    public void moverBaixo() {
        y += velocidade;
    }
}
