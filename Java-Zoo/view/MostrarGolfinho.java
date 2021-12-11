package view;

import javax.swing.*;

import model.Golfinho;
import java.awt.*;
import java.awt.event.*;

public class MostrarGolfinho extends JFrame {
    JLabel lIdGolfinho;
    JLabel lNomeGolfinho;
    JLabel lTreinamento;
    JLabel lDescricaoJaula;
    JTextField tIdGolfinho;
    JTextField tNomeGolfinho;
    JTextField tTreinamento;
    JTextField tDescricaoJaula;
    JButton bOkLeao = new JButton("OK");

    public MostrarGolfinho(Golfinho golfinho) {
        lIdGolfinho = new JLabel("Id do golfinho", JLabel.LEFT);
        lNomeGolfinho = new JLabel("Nome do golfinho", JLabel.LEFT);
        lTreinamento = new JLabel("Alimentação do golfinho", JLabel.LEFT);
        lDescricaoJaula = new JLabel("Descrição da jaula", JLabel.LEFT);

        tIdGolfinho = new JTextField(15);
        tNomeGolfinho = new JTextField(15);
        tTreinamento = new JTextField(15);
        tDescricaoJaula = new JTextField(15);

        ActionListener okGolfinhoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOkActionPerformed(e);
            }
        };
        bOkLeao.addActionListener(okGolfinhoAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));

        pane.add(lIdGolfinho);
        pane.add(tIdGolfinho);
        pane.add(lNomeGolfinho);
        pane.add(tNomeGolfinho);
        pane.add(lTreinamento);
        pane.add(tTreinamento);
        pane.add(lDescricaoJaula);
        pane.add(tDescricaoJaula);
        pane.add(bOkLeao);

        tIdGolfinho.setText(Integer.toString(golfinho.getId()));
        tNomeGolfinho.setText(golfinho.getNome());
        tTreinamento.setText(Integer.toString(golfinho.getTreinamento()));
        tDescricaoJaula.setText(golfinho.getJaula().getDescricao());

        tIdGolfinho.setEditable(false);
        tNomeGolfinho.setEditable(false);
        tTreinamento.setEditable(false);
        tDescricaoJaula.setEditable(false);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(195,305);
        this.setVisible(true);
    }

    private void buttonOkActionPerformed(ActionEvent e) {
        this.dispose();
    }
}
