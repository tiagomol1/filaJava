
// Queue vai ser parametrizada com um tipo T
public class ObjectQueue<T> implements Queue<T> {
    // ref. primeiro item
    private Node<T> first;
    // ref. último item
    private Node<T> last;

    // item (nó) - classe interna (nested class)
    // POJO - Plain old java object
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Construtor
    public ObjectQueue() {
        first = null;
        last = null;
    }

    // vazia?
    public boolean isEmpty() {
        return (first == null && last == null);
    }

    // enfileirar
    public void enqueue(T data) {
        // criar a casinha
        Node<T> aux = new Node<>(data);

        // se a fila estiver vazia
        if (isEmpty()) {
            last = aux;
            first = aux;
        } else {
            last.next = aux;
            last = aux;
        }
    }

    // desenfileirar
    public T dequeue() {
        Node<T> aux; // etiqueta auxiliar
        T data; // valor retornado ao usuário

        if (isEmpty()) { // não pode desenfileirar! erro!
            throw new IndexOutOfBoundsException("Fila vazia! Impossível desenfileirar!");
        }

        // se não for vazia
        aux = first;  // etiqueta auxiliar aponta para o primeiro nó
        first = first.next; // primeiro aponta para o segundo
        aux.next = null; // desconecto o auxiliar da fila
        data = aux.data; // obter o valor para retornar

        // se a fila ficou vazia
        if (first == null) {
            last = null; // último também deve apontar para null
        }

        return data;
    }
}
