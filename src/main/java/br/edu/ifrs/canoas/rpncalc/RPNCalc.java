package br.edu.ifrs.canoas.rpncalc;

import java.util.Stack;

public class RPNCalc {
    public static void main(String[] args) {
        Stack<Double> pilha = new Stack<>();
        Engine engine = new Engine(pilha);
        Tokenizer tokenizer = new Tokenizer(engine.operacoesValidas());

        engine.limparTela();
        engine.ajuda();
        engine.atualizarTela();
        while (engine.estaRodando()) {
            Token tk = tokenizer.getToken();
            engine.limparTela();
            switch (tk.getTipo()) {
                case OPERACAO:
                    engine.operar(tk.getOperacao());
                    break;
                case OPERANDO:
                    engine.operando(tk.getValor());
                    break;
                default:
                    throw new RuntimeException("Não deveria acontecer!");
            }
            engine.atualizarTela();
        }
        System.out.println("Tchauzinho!");
    }
}
