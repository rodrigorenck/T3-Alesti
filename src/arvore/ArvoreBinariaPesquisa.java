package arvore;

import domain.Produto;
import lista.ListaProdutos;

public class ArvoreBinariaPesquisa {
    private NodoArvore raiz;
    private int quantidade;
    private int operacoes;

    public ArvoreBinariaPesquisa(){
        raiz = null;
        quantidade = 0;
    }


    public void add(Produto elemento){
        NodoArvore novo = new NodoArvore(elemento);
        if(raiz == null){
            raiz = novo;
            quantidade++;
            return;
        }
        NodoArvore aux = raiz;
        while(true){
            if(elemento.getCodigo() > aux.elemento.getCodigo()){
                if(aux.direita == null){
                    aux.direita = novo;
                    novo.pai = aux;
                    quantidade++;
                    return;
                }
                aux = aux.direita;
            }
            if(elemento.getCodigo() <= aux.elemento.getCodigo()){
                if(aux.esquerda == null){
                    aux.esquerda = novo;
                    novo.pai = aux;
                    quantidade++;
                    return;
                }
                aux = aux.esquerda;
            }
        }
    }

    public ListaProdutos caminharPreOrdem(){
        var caminho = new ListaProdutos();
        preOrdemRecursivo(caminho, raiz);
        return caminho;
    }

    private void preOrdemRecursivo(ListaProdutos caminho, NodoArvore nodo) {
        caminho.add(nodo.elemento);
        if(nodo.esquerda != null){
            preOrdemRecursivo(caminho, nodo.esquerda);
        }
        if(nodo.direita != null){
            preOrdemRecursivo(caminho, nodo.direita);
        }
    }


//    public boolean existe(int idProduto) {
//        NodoArvore nodo = raiz;
//        if(nodo.elemento.getCodigo() == idProduto){
//            return true;
//        }
//        while(nodo != null){
//            if(codigo  nodo.elemento.getCodigo()){
//                nodo = nodo.esquerda;
//            }else{
//                nodo = nodo.direita;
//            }
////            nodo = codigo < nodo.elemento.getCodigo() ? nodo.esquerda : nodo.direita;
//        }
//        return nodo.elemento;        return lista.existe(idProduto);
//    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto busca(int codigo) {
        ListaProdutos lista = caminharPreOrdem();
        return lista.busca(codigo);
    }

    public Produto get(int codigo){
        if(codigo> quantidade){
            return null;
        }
        NodoArvore nodo = raiz;
        while(nodo != null && nodo.elemento.getCodigo() != codigo){
            operacoes++;
            if(codigo < nodo.elemento.getCodigo()){
                nodo = nodo.esquerda;
            }else{
                nodo = nodo.direita;
            }
//            nodo = codigo < nodo.elemento.getCodigo() ? nodo.esquerda : nodo.direita;
        }
        return nodo.elemento;
    }

    public int getOperacoes() {
        return operacoes;
    }

    public NodoArvore getRaiz() {
        return raiz;
    }

    public int altura(NodoArvore nodo) {
       if(nodo == null){
           return  -1;
       }
       int esq = altura(nodo.esquerda);
       int dir = altura(nodo.direita);
       if(esq>dir) return esq + 1;
       return dir + 1;
    }
}
