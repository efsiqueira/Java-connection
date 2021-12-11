package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Leao;

public class AdicionarLeao extends JFrame{
    JLabel lNomeLeao;
    JLabel lAlimentacao;
    JLabel lVisitantes;
    JLabel lDescricaoJaula;
    JTextField tNomeLeao;
    JTextField tAlimentacao;
    JTextField tVisitantes;
    JTextField tDescricaoJaula;
    JButton bInserir = new JButton("Inserir");
    JButton bCancelar = new JButton("Cancelar");

    public AdicionarLeao() {
        lNomeLeao = new JLabel("Nome do leão", JLabel.LEFT);
        lAlimentacao = new JLabel("Alimentação do leão", JLabel.LEFT);
        lVisitantes = new JLabel("Visitantes do leão", JLabel.LEFT);
        lDescricaoJaula = new JLabel("Descrição da jaula", JLabel.LEFT);

        tNomeLeao = new JTextField(20);
        tAlimentacao = new JTextField(20);
        tVisitantes = new JTextField(20);
        tDescricaoJaula = new JTextField(20);

        // Ação de inserir o leão
        ActionListener inserirLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonConfirmaActionPerformed(e);
            }
        };
        bInserir.addActionListener(inserirLeaoAction);

        // Ação de cancelar a adição
        ActionListener cancelarLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonCancelaActionPerformed(e);
            }
        };
        bCancelar.addActionListener(cancelarLeaoAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));

        pane.add(lNomeLeao);
        pane.add(tNomeLeao);
        pane.add(lAlimentacao);
        pane.add(tAlimentacao);
        pane.add(lVisitantes);
        pane.add(tVisitantes);
        pane.add(lDescricaoJaula);
        pane.add(tDescricaoJaula);
        pane.add(bInserir);
        pane.add(bCancelar);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(250, 260);
        this.setVisible(true);
    }

    private void buttonConfirmaActionPerformed(ActionEvent e) {
        Leao.insertLeao(
            new Leao(
                this.tNomeLeao.getText(),
                this.tDescricaoJaula.getText(),
                Integer.parseInt(this.tAlimentacao.getText()),
                Integer.parseInt(this.tVisitantes.getText())
            )
        );
        JOptionPane.showMessageDialog(
            null, 
            "Dados inseridos com Sucesso!"
        );
        this.tNomeLeao.setText("");
        this.tDescricaoJaula.setText("");
        this.tAlimentacao.setText("");
        this.tVisitantes.setText("");
    }

    private void buttonCancelaActionPerformed(ActionEvent e) {
        this.dispose();
    }
    
}
