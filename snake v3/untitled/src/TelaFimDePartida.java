import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaFimDePartida {
    private int totalMacasColetadas;

    public TelaFimDePartida(int totalMacasColetadas) {
        this.totalMacasColetadas = totalMacasColetadas;
    }

    public void exibir() {
        JFrame frame = new JFrame("Fim da partida");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);

        Font fonte = new Font("Arial", Font.BOLD, 20);

        JLabel mensagemLabel = new JLabel("Fim da partida!");
        mensagemLabel.setFont(fonte);
        mensagemLabel.setForeground(Color.WHITE);
        panel.add(mensagemLabel);

        JLabel macasLabel = new JLabel("Total de maçãs coletadas: " + totalMacasColetadas);
        macasLabel.setFont(fonte);
        macasLabel.setForeground(Color.WHITE);
        panel.add(macasLabel);

        JButton historicoButton = new JButton("Histórico");
        historicoButton.setFont(fonte);
        historicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarHistorico();
            }
        });
        panel.add(historicoButton);

        frame.getContentPane().add(panel);

        frame.setPreferredSize(new Dimension(300, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void mostrarHistorico() {
        // Lógica para obter o histórico de pontuação do jogador
        List<Integer> historico = obterHistoricoPontuacao();

        TelaHistoricoPontuacao telaHistorico = new TelaHistoricoPontuacao(historico);
        telaHistorico.exibir();
    }

    private List<Integer> obterHistoricoPontuacao() {
        // Lógica para obter o histórico de pontuação do jogador
        // Retorna uma lista de pontuações
        List<Integer> historicoPontuacao = new ArrayList<>();
        historicoPontuacao.add(10); // Exemplo de pontuação da partida 1
        historicoPontuacao.add(15); // Exemplo de pontuação da partida 2
        historicoPontuacao.add(8);  // Exemplo de pontuação da partida 3
        return historicoPontuacao;
    }
}


