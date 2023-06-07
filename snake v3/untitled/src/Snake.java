import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Segmento> segmentos;
    private int tamanhoSegmento;
    private Direcao direcao;
    private int macasColetadas;

    public Snake(int x, int y, int tamanhoSegmento) {
        segmentos = new ArrayList<>();
        segmentos.add(new Segmento(x, y));
        this.tamanhoSegmento = tamanhoSegmento;
        this.direcao = Direcao.DIREITA;
        this.macasColetadas = 0;
    }

    public List<Segmento> getSegmentos() {
        return segmentos;
    }

    public int getTamanhoSegmento() {
        return tamanhoSegmento;
    }

    public int getMacasColetadas() {
        return macasColetadas;
    }

    public void mover() {
        Segmento cabeca = segmentos.get(0);
        int x = cabeca.getX();
        int y = cabeca.getY();

        switch (direcao) {
            case DIREITA:
                x += tamanhoSegmento;
                break;
            case ESQUERDA:
                x -= tamanhoSegmento;
                break;
            case CIMA:
                y -= tamanhoSegmento;
                break;
            case BAIXO:
                y += tamanhoSegmento;
                break;
        }

        // Verifica se a cobra se encontrou com ela mesma
        for (int i = 1; i < segmentos.size(); i++) {
            Segmento segmento = segmentos.get(i);
            if (x == segmento.getX() && y == segmento.getY()) {
                exibirTelaFimDePartida();
                return; // Encerra a execução do método mover
            }
        }

        // Verifica se a cobra se encontrou com o limite da tela
        if (x < 0 || y < 0 || x >= TelaGrafica.getLargura() || y >= TelaGrafica.getAltura()) {
            exibirTelaFimDePartida();
            return; // Encerra a execução do método mover
        }

        segmentos.add(0, new Segmento(x, y));
        segmentos.remove(segmentos.size() - 1);
    }

    public void setDirecao(Direcao direcao) {
        // Evita que a cobra reverta sua direção para trás
        if (this.direcao == Direcao.DIREITA && direcao == Direcao.ESQUERDA ||
                this.direcao == Direcao.ESQUERDA && direcao == Direcao.DIREITA ||
                this.direcao == Direcao.CIMA && direcao == Direcao.BAIXO ||
                this.direcao == Direcao.BAIXO && direcao == Direcao.CIMA) {
            return;
        }

        this.direcao = direcao;
    }

    public void aumentarTamanho() {
        Segmento ultimoSegmento = segmentos.get(segmentos.size() - 1);
        int x = ultimoSegmento.getX();
        int y = ultimoSegmento.getY();

        // Adiciona um novo segmento na mesma posição do último segmento
        segmentos.add(new Segmento(x, y));
    }

    public boolean atingiuMaca(Maca maca) {
        int xSnake = segmentos.get(0).getX();
        int ySnake = segmentos.get(0).getY();
        int xMaca = maca.getX();
        int yMaca = maca.getY();

        if (xSnake == xMaca && ySnake == yMaca) {
            aumentarTamanho(); // Aumenta o tamanho da cobra quando atinge a maçã
            macasColetadas++; // Incrementa o contador de maçãs coletadas
            return true;
        }

        return false;
    }

    private void exibirTelaFimDePartida() {
        TelaFimDePartida telaFimDePartida = new TelaFimDePartida(macasColetadas);
        telaFimDePartida.exibir();
    }

    public boolean atingiuProprioCorpo() {
        return false;
    }

    public boolean atingiuLimiteTela() {
        return false;
    }

    enum Direcao {
        DIREITA, ESQUERDA, CIMA, BAIXO
    }
}
