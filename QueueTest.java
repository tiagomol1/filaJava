import java.util.Scanner;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Aluno> q;
        Scanner input = new Scanner(System.in);

        System.out.print("Insira 1 para ObjectQueue e 2 para ArrayQueue: ");
        int op = input.nextInt();

        if (op == 1)
            q = new ObjectQueue<>();
        else if (op == 2)
            q = new ArrayQueue<>();
        else
            throw new RuntimeException("Escolha 1 ou 2");

        q.enqueue(new Aluno(1, "João", 20));
        q.enqueue(new Aluno(2, "José", 20));
        q.enqueue(new Aluno(3, "Julio", 20));
        try { // tente
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            System.out.println(q.dequeue());
            // Erro! fila vazia
            System.out.println(q.dequeue());
        } catch (IndexOutOfBoundsException ex) { // se pegar ....
            System.out.println(ex.getMessage());
        }
        System.out.println("Fim do programa!");
    }
}
