package view;


import javax.swing.*;
import model.Leao;

import java.awt.*;
import java.awt.event.*;

public class MostrarLeao extends JFrame{
    JLabel lIdLeao;
    JLabel lNomeLeao;
    JLabel lAlimentacao;
    JLabel lData;
    JLabel lDetalhes;
    JLabel lVisitantes;
    JLabel lDescricaoJaula;
    JTextField tIdLeao;
    JTextField tNomeLeao;
    JTextField tAlimentacao;
    JTextField tData;
    JTextField tDetalhes;
    JTextField tVisitantes;
    JTextField tDescricaoJaula;
    JButton bOkLeao = new JButton("OK");

    public MostrarLeao(Leao leao) {
        lIdLeao = new JLabel("Id do leão", JLabel.LEFT);
        lNomeLeao = new JLabel("Nome do leão", JLabel.LEFT);
        lAlimentacao = new JLabel("Alimentação do leão", JLabel.LEFT);
        lData = new JLabel("Data do inicio", JLabel.LEFT);
        lDetalhes = new JLabel("Detalhes da alimentação", JLabel.LEFT);
        lVisitantes = new JLabel("Visitantes do leão", JLabel.LEFT);
        lDescricaoJaula = new JLabel("Descrição da jaula", JLabel.LEFT);

        tIdLeao = new JTextField(25);
        tNomeLeao = new JTextField(25);
        tAlimentacao = new JTextField(25);
        tData = new JTextField(25);
        tDetalhes = new JTextField(25);
        tVisitantes = new JTextField(25);
        tDescricaoJaula = new JTextField(25);
        
        ActionListener okLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOkActionPerformed(e);
            }
        };
        bOkLeao.addActionListener(okLeaoAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));

        pane.add(lIdLeao);
        pane.add(tIdLeao);
        pane.add(lNomeLeao);
        pane.add(tNomeLeao);
        pane.add(lAlimentacao);
        pane.add(tAlimentacao);
        pane.add(lData);
        pane.add(tData);
        pane.add(lDetalhes);
        pane.add(tDetalhes);
        pane.add(lVisitantes);
        pane.add(tVisitantes);
        pane.add(lDescricaoJaula);
        pane.add(tDescricaoJaula);
        pane.add(bOkLeao);

        tIdLeao.setText(Integer.toString(leao.getId()));
        tNomeLeao.setText(leao.getNome());
        tAlimentacao.setText(Integer.toString(leao.getAlimentacao()));
        tVisitantes.setText(Integer.toString(leao.getVisitantes()));
        tDescricaoJaula.setText(leao.getJaula().getDescricao());

        tIdLeao.setEditable(false);
        tNomeLeao.setEditable(false);
        tAlimentacao.setEditable(false);
        tVisitantes.setEditable(false);
        tDescricaoJaula.setEditable(false);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(305,400);
        this.setVisible(true);
    }

    private void buttonOkActionPerformed(ActionEvent e) {
        this.dispose();
    }
}
