package bankaccount;

import java.util.Scanner;

public class ContaTerminal {

    static int numero;
    static String agencia;
    public static String name = "YOHANAM SILVA"; // default name
    private double saldo;
    static boolean erro, loop, validation;
    static String teste;
    
    public static void main(String[] args) throws Exception {
        
        loop = true;
        validation = true;

        try (Scanner scanner = new Scanner(System.in)) {

            int opicao = 0;

            while (loop) {

                erro = false;

                if (validation) {

                    System.out.println("Por favor, digite o número da conta (apenas os digitos):");
                    
                    try {
                        numero = scanner.nextInt();
                    } catch (Exception e) {
                        erro = true;
                        System.out.println("Conta incorreta! Por favor, digite corretamente os digitos numéricos da sua conta. " + e.getMessage());
                    }

                    System.out.println("Por favor, digite o número da agência:");
                    
                    try {
                        agencia = scanner.next();
                    } catch (Exception e) {
                        erro = true;
                        System.out.println("Agência incorreta! Por favor, digite corretamente o código da sua agência. " + e.getMessage());
                    }
                }

                if (erro) {

                    System.out.println("Deseja tentar novamente (digite 1 para sim e 0 para não)?");

                    teste = scanner.next();

                    if (teste.equals("1") || teste.equals("0")) 

                        switch (Integer.parseInt(teste)) {

                            case 1:
                                System.out.println("Ótimo! Então, vamos tentar novamente.");
                                break;
                            case 0:
                                System.out.println("Ahh, ok. Tudo bem então, até mais.");
                                loop = false;
                                break;

                        } 

                    } else {

                        System.out.println("Perdão, não entendi o que você selecionou. Então, vamos tentar novamente.");

                    } 
                
                } else {

                    System.out.println("Olá " + getName() + "! Por favor, escolha uma das opções abaixo (digitando apenas o número da escolha):");

                    System.out.println("1 - Consultar saldo");
                    
                }
            }
        }
    }

    protected double getSaldo() {
        return this.saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
