package neidemaria.com.br.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import neidemaria.com.br.R;
import neidemaria.com.br.dao.AlunoDao;

//AppCompatActivity é bom, pois da suporte as outras versões do android e matem a appbar com o titulo do projeto(Padrão nome do projeto)
public class ListaAlunosActivity extends AppCompatActivity {

    private final AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Fala quem é a view do projeto
        setContentView(R.layout.activity_lista_alunos);

        //Altera o titulo que aparece na appbar
        setTitle("Lista de Alunos");


        configuraBotao();

        //Toast.makeText(this, "Eae Fedidos", Toast.LENGTH_LONG).show();
    }

    private void configuraBotao() {
        findViewById(R.id.floatingActionButton5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormulario();
            }
        });
    }

    private void abreFormulario() {
        startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {

        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_alunos_lista_de_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}
