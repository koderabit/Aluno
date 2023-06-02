package koderabit.aluno;

import javax.swing.SwingUtilities;

public class AlunoMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AlunoView alunoView = new AlunoView();
            alunoView.setVisible(true);
        });
    }
}
