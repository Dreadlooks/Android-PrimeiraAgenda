package neidemaria.com.br.dao;

import java.util.ArrayList;
import java.util.List;

import neidemaria.com.br.model.Aluno;

public class AlunoDao {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    //Copia da lista de alunos, porque se alguem modificar fora, nao muda dentro
    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
