package arvore;

import domain.Produto;

public class NodoArvore {
    public NodoArvore pai;
    public Produto elemento;
    public NodoArvore direita;
    public NodoArvore esquerda;

    public NodoArvore(Produto elemento){
        this.pai = null;
        this.elemento = elemento;
        this.direita = null;
        this.esquerda = null;
    }

    @Override
    public String toString() {
        return "arvore.NodoArvore{" +
                "elemento=" + elemento +
                '}';
    }
}
