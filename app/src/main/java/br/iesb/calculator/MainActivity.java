package br.iesb.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int i = 0;
    int count = 0;
    Double[] valor;
    Double result = 0.0;
    String operator;
    static int INVALID = 999999999;
    TextView telaResultado;
    boolean dot = false;
    int decimal = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final TextView tela = findViewById(R.id.txtResult);
        //tela.setText("0123456789");

        valor = new Double[2];
        valor[0] = 0.0;
        valor[1] = 0.0;
        telaResultado = findViewById(R.id.txtResult);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnPlusUltraa: operator = "sum";
                proximoNumero();
                break;
            case R.id.btnSubZero: operator = "sub";
                proximoNumero();
                break;
            case R.id.btnSamuraiX: operator = "mult";
                proximoNumero();
                break;
            case R.id.btnDiv: operator = "div";
                proximoNumero();
                break;
            case R.id.btnEqual: calcular();
                count = 0;
                break;
            case R.id.btnThanos: del(i);
                break;
            case R.id.btnDot: dot = true;
                break;
        }
        if(count<9){
            switch (view.getId()){
                case R.id.btn0:
                    if(!dot)
                        valor[i] = (valor[i]*10);
                    else {
                        valor[i] = valor[i]+0*Math.pow(0.1,decimal);
                        decimal++;
                    }
                    count++;
                    break;
                case R.id.btn1:
                    if(!dot)
                        valor[i] = (valor[i]*10)+1;
                    else {
                        valor[i] = valor[i]+1*Math.pow(0.1,decimal);
                        decimal++;
                    }
                    count++;
                    break;
                case R.id.btn2:
                    if(!dot)
                       valor[i] = (valor[i]*10)+2;
                    else {
                        valor[i] = valor[i]+2*Math.pow(0.1,decimal);
                        decimal++;
                        }
                    count++;
                    break;
                case R.id.btn3:
                    if(!dot)
                        valor[i] = (valor[i]*10)+3;
                    else {
                        valor[i] = valor[i]+3*Math.pow(0.1,decimal);
                        decimal++;
                    }
                    count++;
                    break;
                case R.id.btn4:
                    if(!dot)
                        valor[i] = (valor[i]*10)+4;
                    else {
                        valor[i] = valor[i]+4*Math.pow(0.1,decimal);
                        decimal++;
                    }
                    count++;
                    break;
                case R.id.btn5:
                    if(!dot)
                        valor[i] = (valor[i]*10)+5;
                    else {
                        valor[i] = valor[i]+5*Math.pow(0.1,decimal);
                        decimal++;
                    }
                    count++;
                    break;
                case R.id.btn6:
                    if(!dot)
                        valor[i] = (valor[i]*10)+6;
                    else {
                        valor[i] = valor[i]+6*Math.pow(0.1,decimal);
                        decimal++;
                    }
                    count++;
                    break;
                case R.id.btn7:
                    if(!dot)
                        valor[i] = (valor[i]*10)+7;
                    else {
                        valor[i] = valor[i]+7*Math.pow(0.1,decimal);
                        decimal++;
                    }
                    count++;
                    break;
                case R.id.btn8:
                    if(!dot)
                        valor[i] = (valor[i]*10)+8;
                    else {
                        valor[i] = valor[i]+8*Math.pow(0.1,decimal);
                        decimal++;
                    }
                    count++;
                    break;
                case R.id.btn9:
                    if(!dot)
                        valor[i] = (valor[i]*10)+9;
                    else {
                        valor[i] = valor[i]+9*Math.pow(0.1,decimal);
                        decimal++;
                    }
                    count++;
                    break;
            }
        }

        visor();
        result = 0.0;
    }

    private void calcular(){
        switch (operator){
            //Executa as operações e sai do switch
            case "sum": result = (valor[0] + valor[1]); break;
            case "sub": result = valor[0] - valor[1]; break;
            case "mult": result = valor[0] * valor[1]; break;
            case "div": result = valor[0] / valor[1]; break;
        }
        //Se for um valor inválido
        if (result<INVALID) {
            valor[0] = result;  //Para executar mais operações
            valor[1] = 0.0;      //Passa para o segundo valor
            i = 1;
        }
    }

    private void visor(){
        if (result != 0 && result<INVALID){                   //Se o valor total for válido
            String tela = String.valueOf(result);
            telaResultado.setText(tela);
        }else if (result>INVALID){                           //Se o valor total for inválido
            String tela = "ERROR";
            telaResultado.setText(tela);
        } else {                                            //Se ainda não foi calculado o resultado
            String tela = String.valueOf(valor[i]);
            telaResultado.setText(tela);
        }
    }


    private void del(int i){
        String tmp = String.valueOf(valor[i]);
        if (valor[i] > 0) {
            if(!dot){
                tmp = tmp.substring (0, tmp.length() - 3);
            }else {
                tmp = tmp.substring (0, tmp.length() - 1);
            }
            count--;
        }
        if (tmp.isEmpty())
            tmp = "0";
        valor[i] = Double.parseDouble(tmp);
        visor();
    }

    //Passa o para a próxima posição do vetor
    private void proximoNumero(){
        decimal = 1;
        dot = false;
        count = 0;  //Zera a quantidade de Números
        i = 1;      //Passa para o primeiro numero do vetor
    }

}


