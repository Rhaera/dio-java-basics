package bankaccount;

import java.util.Scanner;

public class ContaTerminal {

    static int numero;
    static String agencia;
    public static String name = "YOHANAM SILVA"; // default name
    private static double saldo;
    static boolean erro, loop, validation;
    static String teste;
    
    public static void main(String[] args) throws Exception {
        
        loop = true;
        validation = true;

        try (Scanner scanner = new Scanner(System.in)) {

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

                    if (teste.equals("1") || teste.equals("0")) {

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

                    validation = false;

                    System.out.println("Olá " + getName() + "! Por favor, escolha uma das opções abaixo (digitando apenas o número da escolha):");

                    System.out.println("1 - Consultar saldo");
                    System.out.println("2 - Alterar nome do titular");
                    System.out.println("3 - Efetuar saque");
                    System.out.println("4 - Efetuar depósito");
                    System.out.println("5 - Sair");

                    teste = scanner.next();

                    switch (teste.trim()) {

                        case "1":
                            System.out.println("Saldo: " + getSaldo());
                            break;
                        case "2": 
                            System.out.println("Digite o nome que deseja colocar:");
                            setName(scanner.next());
                            break;
                        case "3":
                            System.out.println("Quanto deseja sacar?");
                            try {
                                sacar(scanner.nextInt());                         
                            } catch (Exception e) {
                                System.out.println("Ops! Valor inválido. Por favor, tente novamente.");
                            }
                            break;
                        case "4": 
                            System.out.println("Quanto deseja depositar?");
                            try {
                                depositar(scanner.nextDouble());                         
                            } catch (Exception e) {
                                System.out.println("Ops! Valor inválido. Por favor, tente novamente.");
                            }
                            break;
                        case "5":
                            System.out.println("Tudo bem, até breve!");
                            loop = false;
                            break;
                        default:
                            System.out.println("Opção inválida! Por favor, digite uma opção válida.");
                            break;
                    }
                }
            }
        }
    }

    protected static void sacar(double saque) {
        
        if (saldo >= saque) saldo -= saque; else System.out.println("Saldo insuficiente!");
        
    }

    protected static void depositar(double valor) {
        saldo += valor;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ContaTerminal.name = name;
    }
}
