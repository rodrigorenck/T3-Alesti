package lista;

import domain.Produto;

//lista simplesmente encadeada
public class ListaProdutos {

    private NodoLista inicio;
    private NodoLista fim;
    private int quantidade;
    private int operacoes;

    public ListaProdutos(){
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    public void add(Produto produto){
        NodoLista novo = new NodoLista(produto);

        if(isEmpty()){
            inicio = novo;
        }else{
            NodoLista aux = fim;
            aux.proximo = novo;
        }
        fim = novo;
        quantidade++;
    }

    public void remove(int codigo){
        NodoLista paux1 = inicio;
        NodoLista paux = inicio;

        if(isEmpty()){
            throw new ListaVaziaException();
        }
        if(!existe(codigo)){
            System.out.println("Elemento nao econtrado");
            return;
        }
        //se o elemento for o primeiro
        if(inicio.elemento.getCodigo() == codigo){
            inicio = inicio.proximo;
            quantidade--;
            return;
        }
        while (paux.proximo != null) {
            //remove do fim
            if (paux.proximo.proximo == null) {
                paux.proximo = null;
                fim = paux;
                quantidade--;
                return;
            }
            //remove do meio
            if (paux.proximo.elemento.getCodigo() == codigo) {
                NodoLista elementoParaRemover = paux.proximo;
                paux.proximo = elementoParaRemover.proximo; //aponta para o cara depois do elemento
                quantidade--;
                return;
            }
            //vai para o proximo elemento
            paux = paux.proximo;
        }
    }

    public boolean existe(int codigo){
        NodoLista paux = inicio;

        if (fim.elemento.getCodigo() == codigo) {
            return true;
        }
        while(paux.proximo != null){
            if (paux.elemento.getCodigo() == codigo) {
                return true;
            }
            paux = paux.proximo;
        }
        return false;
    }


    public boolean isEmpty(){
        return quantidade == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        NodoLista paux = inicio;
        while (paux != null) {
            sb.append(paux.elemento).append(" ");
            paux = paux.proximo; // avanca para proximo nodo
        }
        sb.append("]");
        return sb.toString();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getOperacoes() {
        return operacoes;
    }

    public Produto busca(int codigo) {
        NodoLista paux = inicio;

        if (fim.elemento.getCodigo() == codigo) {
            operacoes++;
            return fim.elemento;
        }
        while(paux.proximo != null){
            operacoes++;
            if (paux.elemento.getCodigo() == codigo) {
                return paux.elemento;
            }
            paux = paux.proximo;
        }
        //se nao econtrar devolvemos null
        return null;
    }
}
