package koderabit.aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class AlunoView extends JFrame {
    private JTextField textFieldNome;
    private JTextField textFieldMatricula;
    private JTextField textFieldAnoMatricula;
    private JTextArea textArea;

    public AlunoView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setTitle("Cadastro de Alunos");
        setSize(500, 500);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblNome = new JLabel("Nome:");
        panel.add(lblNome);

        textFieldNome = new JTextField();
        panel.add(textFieldNome);

        JLabel lblMatricula = new JLabel("Matrícula:");
        panel.add(lblMatricula);

        textFieldMatricula = new JTextField();
        panel.add(textFieldMatricula);

        JLabel lblAnoMatricula = new JLabel("Ano de Matrícula:");
        panel.add(lblAnoMatricula);

        textFieldAnoMatricula = new JTextField();
        panel.add(textFieldAnoMatricula);

        JButton btnIncluir = new JButton("Incluir");
        JButton btnConsultar = new JButton("Consultar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        buttonPanel.add(btnIncluir);
        buttonPanel.add(btnConsultar);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(380, 200));

        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);

        btnIncluir.addActionListener((ActionEvent e) -> {
            String nome = textFieldNome.getText();
            String matricula = textFieldMatricula.getText();
            int anoMatricula = Integer.parseInt(textFieldAnoMatricula.getText());
            
            Aluno aluno = new Aluno(nome, matricula, anoMatricula);
            AlunoController.incluir(aluno);
            limparCampos();
            exibirMensagem("Aluno incluído com sucesso!");
        });

        btnConsultar.addActionListener((ActionEvent e) -> {
            List<Aluno> alunos = AlunoController.obterTodos();
            exibirAlunos(alunos);
        });
    }

    private void limparCampos() {
        textFieldNome.setText("");
        textFieldMatricula.setText("");
        textFieldAnoMatricula.setText("");
    }

    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }

    private void exibirAlunos(List<Aluno> alunos) {
        StringBuilder sb = new StringBuilder();
        for (Aluno aluno : alunos) {
            sb.append("Nome: ").append(aluno.nome).append("\n");
            sb.append("Matrícula: ").append(aluno.matricula).append("\n");
            sb.append("Ano de Matrícula: ").append(aluno.ano_matricula).append("\n\n");
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AlunoView alunoView = new AlunoView();
            alunoView.setVisible(true);
        });
    }
}