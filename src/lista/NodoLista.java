package lista;

import domain.Produto;

public class NodoLista {

    public Produto elemento;
    public NodoLista proximo;


    public NodoLista(Produto elemento){
        this.elemento = elemento;
        this.proximo = null;
    }
}
