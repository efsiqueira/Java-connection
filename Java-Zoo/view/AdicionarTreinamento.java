package view;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.swing.*;

import model.Treinamento;

public class AdicionarTreinamento extends JFrame {
    JLabel lIdGolfinho;
    JLabel lData;
    JLabel lDetalhes;
    JTextField tIdGolinho;
    JTextField tData;
    JTextField tDetalhes;
    JButton bInserir = new JButton("Inserir");
    JButton bCancelar = new JButton("Cancelar");
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public AdicionarTreinamento() {
        lIdGolfinho = new JLabel("Id do golfinho", JLabel.LEFT);
        lData = new JLabel("Data do inicio", JLabel.LEFT);
        lDetalhes = new JLabel("Detalhes do treinamento", JLabel.LEFT);

        tIdGolinho = new JTextField(20);
        tData = new JTextField(20);
        tDetalhes = new JTextField(20);

        ActionListener inserirTreinamentoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonInsereActionPerformed(e);
            }
        };
        bInserir.addActionListener(inserirTreinamentoAction);

        ActionListener cancelarTreinamentoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCancelaActionPerformed(e);
            }
        };
        bCancelar.addActionListener(cancelarTreinamentoAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));

        pane.add(lIdGolfinho);
        pane.add(tIdGolinho);
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
        Treinamento.insertTreinamento(
            new Treinamento(
                Integer.parseInt(this.tIdGolinho.getText()),
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
