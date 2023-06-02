package koderabit.aluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection getConnection() throws Exception{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/ESCOLA2", "escola2", "escola2");
    }
    
    public List<Aluno> obterTodos(){
        ArrayList<Aluno> lista = new ArrayList<>();
        try(Connection c1 = getConnection()){
            ResultSet r1 = c1.createStatement().executeQuery("SELECT * FROM ALUNO ORDER BY NOME");
        
        while (r1.next()){
            lista.add(new Aluno(r1.getString("NOME"), r1.getString("MATRICULA"),r1.getInt("ANO_MATRICULA")));
        }
        }catch (Exception ex) { }
            return lista;
    }
    
    public void incluir(Aluno a){
        try(Connection c1 = getConnection()){
            PreparedStatement ps = c1.prepareStatement("INSERT INTO ALUNO VALUES(?, ?, ?)");
            ps.setString(1, a.nome);
            ps.setString(2, a.matricula);
            ps.setInt(3, a.ano_matricula);
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){}
    }   
  
}

