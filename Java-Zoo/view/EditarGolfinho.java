package view;

import javax.swing.*;
import model.Golfinho;
import java.awt.*;
import java.awt.event.*;

public class EditarGolfinho extends JFrame {
    JLabel lIdGolfinho;
    JLabel lNomeGolfinho;
    JLabel lTreinamento;
    JTextField tIdGolfinho;
    JTextField tNomeGolfinho;
    JTextField tTreinamento;
    JButton bAlterar = new JButton("Alterar");
    JButton bCancelar = new JButton("Cancelar");

    public EditarGolfinho() {
        lIdGolfinho = new JLabel("Id do golfinho", JLabel.LEFT);
        lNomeGolfinho = new JLabel("Nome do golfinho", JLabel.LEFT);
        lTreinamento = new JLabel("Treinamento do golfinho", JLabel.LEFT);

        tIdGolfinho = new JTextField(20);
        tNomeGolfinho = new JTextField(20);
        tTreinamento = new JTextField(20);

        ActionListener alterarGolfinhoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonAlteraActionPerformed(e);
            }
        };
        bAlterar.addActionListener(alterarGolfinhoAction);

        ActionListener cancelarGolfinhoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCancelaActionPerformed(e);
            }
        };
        bAlterar.addActionListener(cancelarGolfinhoAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));

        pane.add(lIdGolfinho);
        pane.add(tIdGolfinho);
        pane.add(lNomeGolfinho);
        pane.add(tNomeGolfinho);
        pane.add(lTreinamento);
        pane.add(tTreinamento);
        pane.add(bAlterar);
        pane.add(bCancelar);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(250, 260);
        this.setVisible(true);
    }

    private void buttonAlteraActionPerformed(ActionEvent e) {
        Golfinho.updateGolfinho(
            new Golfinho(
                Integer.parseInt(this.tIdGolfinho.getText()),
                this.tNomeGolfinho.getText(),
                Integer.parseInt(this.tTreinamento.getText())
            )
        );
        JOptionPane.showMessageDialog(
            null,
            "Dados alterados com Sucesso!"
        );
    }

    private void buttonCancelaActionPerformed(ActionEvent e) {
        this.dispose();
    }
}
