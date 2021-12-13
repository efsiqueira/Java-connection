package view;

import javax.swing.*;
import model.Leao;
import java.awt.*;
import java.awt.event.*;

public class EditarLeao extends JFrame {
    JLabel lIdLeao;
    JLabel lNomeLeao;
    JLabel lAlimentacao;
    JLabel lVisitantes;
    JTextField tIdLeao;
    JTextField tNomeLeao;
    JTextField tAlimentacao;
    JTextField tVisitantes;
    JButton bAlterar = new JButton("Alterar");
    JButton bAlimentacao = new JButton("Alimentação");
    JButton bCancelar = new JButton("Cancelar");

    public EditarLeao() {
        lIdLeao = new JLabel("Id do leão", JLabel.LEFT);
        lNomeLeao = new JLabel("Nome do leão", JLabel.LEFT);
        lAlimentacao = new JLabel("Alimentação do leão", JLabel.LEFT);
        lVisitantes = new JLabel("Visitantes do leão", JLabel.LEFT);

        tIdLeao = new JTextField(25);
        tNomeLeao = new JTextField(25);
        tAlimentacao = new JTextField(25);
        tVisitantes = new JTextField(25);

        ActionListener alterarLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonAlteraActionPerformed(e);
            }
        };
        bAlterar.addActionListener(alterarLeaoAction);

        ActionListener alimLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonAlimentacaoActionPerformed(e);
            }
        };
        bAlimentacao.addActionListener(alimLeaoAction);

        ActionListener cancelarLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCancelaActionPerformed(e);
            }
        };
        bCancelar.addActionListener(cancelarLeaoAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));

        pane.add(lIdLeao);
        pane.add(tIdLeao);
        pane.add(lNomeLeao);
        pane.add(tNomeLeao);
        pane.add(lAlimentacao);
        pane.add(tAlimentacao);
        pane.add(lVisitantes);
        pane.add(tVisitantes);
        pane.add(bAlterar);
        pane.add(bAlimentacao);
        pane.add(bCancelar);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);

    }

    private void buttonAlteraActionPerformed(ActionEvent e) {
        Leao.updateLeao(
            new Leao(
                Integer.parseInt(this.tIdLeao.getText()),
                this.tNomeLeao.getText(),
                Integer.parseInt(this.tAlimentacao.getText()),
                Integer.parseInt(this.tVisitantes.getText())
            )
        );
        JOptionPane.showMessageDialog(
            null,
            "Dados alterados com Sucesso!"
        );
    }

    private void buttonAlimentacaoActionPerformed(ActionEvent e) {
        new AdicionarAlimentacao();
    }

    private void buttonCancelaActionPerformed(ActionEvent e) {
        this.dispose();
    }
}
