/*
 *@author:Gustavo Rodrigues Santos Silva
 * RA: 1110481922011
 */
package br.com.gustavorssbr.mostrardadospessoa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.com.gustavorssbr.mostrardadospessoa.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private EditText etCpf;
    private EditText etNome;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCpf = findViewById(R.id.etCpf);
        etNome = findViewById(R.id.etNome);
        Button btnExibir = findViewById(R.id.btnExibir);

        btnExibir.setOnClickListener(op -> validar());
    }

    private void validar() {
        Bundle bundle = new Bundle();

        bundle.putString("0", "Rio Grande do Sul");
        bundle.putString("1", "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins");
        bundle.putString("2", "Pará, Amazonas, Acre, Amapá, Rondônia e Roraima");
        bundle.putString("3", "Ceará, Maranhão e Piauí");
        bundle.putString("4", "Pernambuco, Rio Grande do Norte, Paraíba e Alagoas");
        bundle.putString("5", "Bahia e Sergipe");
        bundle.putString("6", "Minas Gerais");
        bundle.putString("7", "Rio de Janeiro e Espírito Santo");
        bundle.putString("8", "São Paulo");
        bundle.putString("9", "Paraná e Santa Catarina");
        bundle.putString("cpf", etCpf.getText().toString());
        bundle.putString("nome", etNome.getText().toString());

        Pessoa pessoa = new Pessoa(etNome.getText().toString(), etCpf.getText().toString());

        String localidade = bundle.getString(pessoa.capturarNonoDigito());

        bundle.putString("localidade", localidade);
        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent i = new Intent(this, SaidaActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}