// Codigo feito pra outra atividade, vamos usar como base

public class Pilha {
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

    No topo = null; // Referência para o primeiro nó da lista

    // Método para inserir um elemento no final da lista
    public void insereElemento(int elemento) {
        No novoNo = new No(elemento); // Cria um novo nó com o elemento fornecido

        if (topo == null) {
            // Caso a lista esteja vazia, o início aponta para o novo nó
            topo = novoNo;
        } else {
            // Caso contrário, percorre a lista até o final
            System.out.println("Inserindo elemento: "+ elemento);
            No atual = topo;
            //while (atual.proximo != null) {
            // JOptionPane.showMessageDialog(null, atual); // ??????????????
            //atual = atual.proximo; // Avança para o próximo nó
            //}
            topo = novoNo;
            novoNo.proximo = atual;// Insere o novo nó no final da lista
        }
    }
    public void removerTopo(){
        int removido = topo.dado;
        System.out.println("Removendo elemento: " +removido);
        topo = topo.proximo;
    }
    // topo = topo.proximo  // LOGICA REMOÇÂO

    // Método para exibir os elementos da lista (para teste)
    public void exibeLista() {
        No atual = topo;
        System.out.print("Pilha Atual: ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo; // Move para o próximo nó
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Pilha lista = new Pilha();
        System.out.println("RODANDO PILHA");

        // Inserindo elementos na lista
        lista.insereElemento(10);
        lista.insereElemento(20);
        lista.insereElemento(30);
        lista.removerTopo();

        // Exibindo os elementos da lista
        lista.exibeLista(); // Deve exibir: Lista: 10 20 30
    }
}


