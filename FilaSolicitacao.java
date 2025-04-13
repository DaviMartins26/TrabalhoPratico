// Codigo feito pra outra atividade


public class FilaSolicitacao {
    // Classe interna para representar um nó da lista
    class No {
        int dado; // Valor armazenado no nó
        No proximo; // Referência para o próximo nó

        // Construtor do nó
        No(int elemento) {
            this.dado = elemento;
            this.proximo = null;
        }
    }

    No inicio = null; // aponta pro inicio
    No fim = null; // aponta pro final
    // Método para inserir um elemento no final da lista
    public void insereFila(int elemento) {
        No novoNo = new No(elemento); // Cria um novo nó com o elemento fornecido
        System.out.println("Inserindo elemento: "+ elemento);
        if (fim == null) {
            // Caso a lista esteja vazia, o início aponta para o novo nó
            inicio = novoNo; // inicio e fim são iguais no primeiro insert correto?
            fim = novoNo;
        } else {
            // Caso contrário, percorre a lista até o final
            //No atual = topo;
            fim.proximo = novoNo;
            //while (atual.proximo != null) {
            // JOptionPane.showMessageDialog(null, atual); // ??????????????
            //atual = atual.proximo; // Avança para o próximo nó
            //}
            //topo = novoNo;
            //novoNo.proximo = atual;// Insere o novo nó no final da lista
            fim = novoNo;
        }
    }
    public void removerFila(){
        //topo = topo.proximo;
        int removido = inicio.dado;
        System.out.println("Removendo elemento: " +removido);
        if (inicio == null){
            System.out.println("Filha Vazia");
        }
        inicio = inicio.proximo; // Agora o inicio é o proximo no depois do inicio
        if (inicio == null){
            fim = null; // quando zerar a fila tem que ferar o final pra n se perder
        }
    }
    // topo = topo.proximo  // LOGICA REMOÇÂO da pilhja

    // Método para exibir os elementos da lista (para teste)
    public void exibeFila() {
        No atual = inicio;
        System.out.print("Fila Atual: ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo; // Move para o próximo nó
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        System.out.println("Roddando Fila");

        // Inserindo elementos na lista
        fila.insereFila(10);
        fila.insereFila(20);
        fila.insereFila(30);
        fila.removerFila();

        // Exibindo os elementos da lista
        fila.exibeFila(); // Deve exibir: Lista: 10 20 30
    }
}


