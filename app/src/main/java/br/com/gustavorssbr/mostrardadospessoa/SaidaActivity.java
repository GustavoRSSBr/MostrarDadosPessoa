package br.com.gustavorssbr.mostrardadospessoa;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.com.gustavorssbr.mostrardadospessoa.model.Pessoa;

public class SaidaActivity extends AppCompatActivity {

    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvSaida = findViewById(R.id.tvSaida);
        tvSaida.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        pessoa = new Pessoa(bundle.getString("nome"), bundle.getString("cpf"));

        tvSaida.setText(pessoa.getNome()+"\n"+pessoa.getCpf()+"\n"+bundle.getString("localidade"));

        btnVoltar.setOnClickListener(op -> voltar());

    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}