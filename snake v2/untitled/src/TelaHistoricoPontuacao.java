import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaHistoricoPontuacao {
    private List<Integer> pontuacoes;

    public TelaHistoricoPontuacao(List<Integer> pontuacoes) {
        this.pontuacoes = pontuacoes;
    }

    public void exibir() {
        JFrame frame = new JFrame("Histórico de Pontuação");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        Font fonte = new Font("Arial", Font.BOLD, 20);
        for (int i = 0; i < pontuacoes.size(); i++) {
            JLabel partidaLabel = new JLabel("Partida " + (i + 1) + ": " + pontuacoes.get(i) + " maçã(s)");
            partidaLabel.setFont(fonte);
            partidaLabel.setForeground(Color.WHITE);
            panel.add(partidaLabel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        frame.getContentPane().add(scrollPane);

        frame.setPreferredSize(new Dimension(300, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
