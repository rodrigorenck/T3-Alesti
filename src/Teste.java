import domain.Produto;
import lista.ListaProdutos;

public class Teste {

    public static void main(String[] args) {

        var p1 = new Produto(1);
        var p2 = new Produto(2);
        var p3 = new Produto(3);
        var p4 = new Produto(4);
        var p5 = new Produto(5);

        var lista = new ListaProdutos();

        lista.add(p1);
        lista.add(p5);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p4);

        System.out.println(lista);
        System.out.println(lista.getQuantidade());
    }
}
