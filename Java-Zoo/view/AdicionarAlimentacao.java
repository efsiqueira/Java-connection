package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;

import javax.swing.*;

import model.Alimentacao;

public class AdicionarAlimentacao extends JFrame {
    JLabel lIdLeao;
    JLabel lData;
    JLabel lDetalhes;
    JTextField tIdLeao;
    JTextField tData;
    JTextField tDetalhes;
    JButton bInserir = new JButton("Inserir");
    JButton bCancelar = new JButton("Cancelar");

    public AdicionarAlimentacao() {
        lIdLeao = new JLabel("Id do Leao", JLabel.LEFT);
        lData = new JLabel("Data do inicio", JLabel.LEFT);
        lDetalhes = new JLabel("Detalhes da alimentacao", JLabel.LEFT);

        tIdLeao = new JTextField(20);
        tData = new JTextField(20);
        tDetalhes = new JTextField(20);

        ActionListener inserirAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonInsereActionPerformed(e);
            }
        };
        bInserir.addActionListener(inserirAction);

        ActionListener cancelarAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCancelaActionPerformed(e);
            }
        };
        bCancelar.addActionListener(cancelarAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));

        pane.add(lIdLeao);
        pane.add(tIdLeao);
        pane.add(lData);
        pane.add(tData);
        pane.add(lDetalhes);
        pane.add(tDetalhes);
        pane.add(bInserir);
        pane.add(bCancelar);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(250,260);
        this.setVisible(true);
    }

    private void buttonInsereActionPerformed(ActionEvent e) {
        Alimentacao.insertAlimentacao(
            new Alimentacao(
                Integer.parseInt(this.tIdLeao.getText()),
                Date.valueOf(tData.getText()),
                this.tDetalhes.getText()
            )
        );
        JOptionPane.showMessageDialog(
            null, 
            "Dados inseridos com Sucesso!"
        );
    }

    private void buttonCancelaActionPerformed(ActionEvent e) {
        this.dispose();
    }
}
