import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        TelaGrafica tela = new TelaGrafica();

        JFrame frame = new JFrame("Exemplo de Tela Gráfica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tela);
        frame.pack();
        frame.setVisible(true);

        tela.iniciarJogo();
    }
}
