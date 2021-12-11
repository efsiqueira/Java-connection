package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Golfinho;

public class AdicionarGolfinho extends JFrame {
    JLabel lNomeGolfinho;
    JLabel lTreinamento;
    JLabel lDescricaoJaula;
    JTextField tNomeGolfinho;
    JTextField tTreinamento;
    JTextField tDescricaoJaula;
    JButton bInserir = new JButton("Inserir");
    JButton bCancelar = new JButton("Cancelar");

    public AdicionarGolfinho() {
        lNomeGolfinho = new JLabel("Nome do golfinho", JLabel.LEFT);
        lTreinamento = new JLabel("Treinamento do golfinho", JLabel.LEFT);
        lDescricaoJaula = new JLabel("Descrição da jaula", JLabel.LEFT);

        tNomeGolfinho = new JTextField(20);
        tTreinamento = new JTextField(20);
        tDescricaoJaula = new JTextField(20);

        // Ação de inserir o golfinho
        ActionListener inserirGolfinhoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonConfirmaActionPerformed(e);
            }
        };
        bInserir.addActionListener(inserirGolfinhoAction);

        // Ação de cancelar a adição
        ActionListener cancelarGolfinhoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCancelaActionPerformed(e);
            }
        };
        bCancelar.addActionListener(cancelarGolfinhoAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));

        pane.add(lNomeGolfinho);
        pane.add(tNomeGolfinho);
        pane.add(lTreinamento);
        pane.add(tTreinamento);
        pane.add(lDescricaoJaula);
        pane.add(tDescricaoJaula);
        pane.add(bInserir);
        pane.add(bCancelar);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(250, 260);
        this.setVisible(true);
    }

    private void buttonConfirmaActionPerformed(ActionEvent e) {
        Golfinho.insertGolfinho(
            new Golfinho(
                this.tNomeGolfinho.getText(),
                this.tDescricaoJaula.getText(),
                Integer.parseInt(this.tTreinamento.getText())
            )
        );
        JOptionPane.showMessageDialog(
            null, 
            "Dados inseridos com Sucesso!"
        );
        this.tNomeGolfinho.setText("");
        this.tDescricaoJaula.setText("");
        this.tTreinamento.setText("");
    }

    private void buttonCancelaActionPerformed(ActionEvent e) {
        this.dispose();
    }
}
