package view;


import javax.swing.*;

import model.Leao;

import java.awt.*;

public class MostrarLeao extends JFrame{
    JLabel lIdLeao;
    JLabel lNomeLeao;
    JLabel lAlimentacao;
    JLabel lVisitantes;
    JLabel lDescricaoJaula;
    JTextField tIdLeao;
    JTextField tNomeLeao;
    JTextField tAlimentacao;
    JTextField tVisitantes;
    JTextField tDescricaoJaula;

    public MostrarLeao(Leao leao) {
        lIdLeao = new JLabel("Id do leão", JLabel.LEFT);
        lNomeLeao = new JLabel("Nome do leão", JLabel.LEFT);
        lAlimentacao = new JLabel("Alimentação do leão", JLabel.LEFT);
        lVisitantes = new JLabel("Visitantes do leão", JLabel.LEFT);
        lDescricaoJaula = new JLabel("Descrição da jaula", JLabel.LEFT);

        tIdLeao = new JTextField(5);
        tNomeLeao = new JTextField(20);
        tAlimentacao = new JTextField(5);
        tVisitantes = new JTextField(5);
        tDescricaoJaula = new JTextField(20);
        
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
        pane.add(lDescricaoJaula);
        pane.add(tDescricaoJaula);

        leao.setId(Integer.parseInt(tIdLeao.getText()));
        leao.setNome(tNomeLeao.getText());
        leao.setAlimentacao(Integer.parseInt(tAlimentacao.getText()));
        leao.setVisitantes(Integer.parseInt(tVisitantes.getText()));

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(250,260);
        this.setVisible(true);
    }
}
