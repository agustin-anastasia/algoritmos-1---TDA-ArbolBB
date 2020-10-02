public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();

        arbol.insertar(new TElementoAB(10, null));
        arbol.insertar(new TElementoAB(1, null));
        arbol.insertar(new TElementoAB(84, null));
        arbol.insertar(new TElementoAB(20, null));
        arbol.insertar(new TElementoAB(45, null));
        arbol.insertar(new TElementoAB(23, null));
        arbol.insertar(new TElementoAB(7, null));
        arbol.insertar(new TElementoAB(100, null));

        System.out.println(arbol.obtenerNivel(23));
        System.out.println("cantidad de hojas: " + arbol.obtenerCantidadHojas());

        System.out.println(arbol.inOrden());
        System.out.println("altura: " + arbol.obtenerAltura());
        System.out.println("tamaño: " + arbol.obtenerTamanio());
                      
        Lista<String> lista = arbol.inorden();
        System.out.println(lista.imprimir("-"));
        
        
        
    }

}
