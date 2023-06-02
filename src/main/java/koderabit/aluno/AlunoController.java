package koderabit.aluno;

import java.util.List;

public class AlunoController {
    private static AlunoDAO dao = new AlunoDAO();
    public static List<Aluno> obterTodos(){
        return dao.obterTodos();
    }
    
    public static void incluir(Aluno aluno){
        dao.incluir(aluno);
    }
}
