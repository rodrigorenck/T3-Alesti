package arvore;

import domain.Produto;
import lista.ListaProdutos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {

    Scanner scInt = new Scanner(System.in);
    ListaProdutos lista = new ListaProdutos();
    ArvoreBinariaPesquisa arvore = new ArvoreBinariaPesquisa();

    public void run() {
        menu();
        int opcao = scInt.nextInt();
        switch (opcao) {
            case 1:
                carregar("Produtos_50.csv");
                break;
            case 2:
                carregar("Produtos_1000.csv");
                break;
            case 3:
                carregar("Produtos_10000.csv");
                break;
            case 4:
                carregar("Produtos_100000.csv");
        }

        System.out.println("\nTotal de elementos na lista: " + lista.getQuantidade());
        System.out.println("Total de elementos na arvore: " + arvore.getQuantidade());
        try {
            System.out.println("Altura da arvore: " + arvore.altura(arvore.getRaiz()));
        } catch (StackOverflowError e) {
            System.out.println("Opa! Arvore muito grande para descobrir a altura!");
        }

        int codigo;
        do {
            System.out.println("\n[CONSULTAS]");
            System.out.println("Digite [-1] para encerrar o programa");
            System.out.print("Informe o codigo do produto que deseja encontrar: ");
            codigo = scInt.nextInt();
            if (codigo == -1) {
                System.out.println("Fim do programa!");
                return;
            }
            System.out.println("\n[ARVORE]");
            Produto pArvore = arvore.get(codigo);
            if (pArvore != null) {
                System.out.println("Produto encontrado: " + pArvore);
                System.out.println("Total de operacoes: " + arvore.getOperacoes());
            } else {
                System.out.println("Produto nao econtrado na arvore!");
            }
            System.out.println("\n[LISTA]");
            Produto pBusca = lista.busca(codigo);
            if (pBusca != null) {
                System.out.println("Produto encontrado: " + pBusca);
                System.out.println("Total de operacoes: " + lista.getOperacoes());
            } else {
                System.out.println("Produto nao econtrado na lista!");
            }
        } while (codigo != -1);
    }

    private void carregar(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String linha = reader.readLine();
            linha = reader.readLine(); //descartamos a primeira linha
            while (linha != null) {
                Produto produto = parse(linha);
                System.out.println(produto.getCodigo());
                lista.add(produto);
                arvore.add(produto);
                linha = reader.readLine();
            }
            System.out.println("Arquivo carregado com sucesso!");
        } catch (IOException e) {
            System.out.println("Arquivo nao econtrado!");
        }

    }

    private Produto parse(String linha) {
        String[] atributos = linha.split(",");
        return new Produto(Integer.parseInt(atributos[0]), atributos[1], atributos[2], Double.parseDouble(atributos[3]));
    }


    private void menu() {
        System.out.println("Informe o arquivo que deseja ler: ");
        System.out.println("[1] Produtos 50");
        System.out.println("[2] Produtos 1000");
        System.out.println("[3] Produtos 10000");
        System.out.println("[4] Produtos 100000");
        System.out.println("[5] Sair");
        System.out.print("Sua resposta: ");
    }
}
