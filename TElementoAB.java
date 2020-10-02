
public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        String temporal = "";
        if (hijoIzq != null) {
            temporal += hijoIzq.inOrden();
        }
        temporal += getEtiqueta().toString() + "-";
        if (hijoDer != null) {
            temporal += hijoDer.inOrden();
        }
        return temporal;
    }

    @Override
    public void inOrden(Lista<T> unaLista) {
        String[] resultado = this.inOrden().split("-");
        for (String elemento : resultado){
            Nodo<T> elem = new Nodo<>(elemento, null);
            unaLista.insertar(elem);
        }
//        unaLista.imprimir("-");
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public int obtenerAltura() {
        int a = -1;
        int b = -1;
        
        if(hijoIzq != null){
            a = hijoIzq.obtenerAltura();
        }
        if(hijoDer != null){
            b = hijoDer.obtenerAltura();
        }
        return Math.max(a, b)+1;
    }

    @Override
    public int obtenerTamanio() {
        int tamanioIzq = 0;
        int tamanioDer = 0;
        int tamanio = 0;
        if(hijoIzq != null){
            tamanioIzq = hijoIzq.obtenerTamanio();
        }
        if(hijoDer != null){
            tamanioDer = hijoDer.obtenerTamanio();
        }
        tamanio = tamanioIzq + tamanioDer;
        return tamanio + 1;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return 0;
        }
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return (hijoIzq.obtenerNivel(unaEtiqueta) + 1);
            }
            return -1;
        } else {
            if (unaEtiqueta.compareTo(etiqueta) > 0) {
                if (hijoDer != null) {
                    return (hijoDer.obtenerNivel(unaEtiqueta) + 1);
                }
                return -1;
            }
            return -1;
        }
    }

    @Override
    public int obtenerCantidadHojas() {
        int resultado = 0;
        if (hijoIzq == null && hijoDer == null){
            return 1;
        }
        if (hijoIzq != null){
            resultado = hijoIzq.obtenerCantidadHojas() + resultado;
        }
        if(hijoDer != null){
            resultado = hijoDer.obtenerCantidadHojas() + resultado;
        }
        return resultado;
    }

}
