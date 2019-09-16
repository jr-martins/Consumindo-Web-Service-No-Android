

package com.example.cep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cep.model.CEP;
import com.example.cep.service.HTTPService;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etCep = findViewById(R.id.etMain_cep);
        final TextView tvRespsota = findViewById(R.id.tvMain_resposta);

        Button botao = findViewById(R.id.btnMain_buscarCep);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etCep.getText().toString().length() > 0 && !etCep.getText().toString().equals("")
                        && etCep.getText().toString().length() == 8){
                    HTTPService service = new HTTPService(etCep.getText().toString());
                    try {
                        CEP resposta = service.execute().get();
                        tvRespsota.setText(resposta.toString());

                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }



            }
        });



    }
}
