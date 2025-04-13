// Codigo feito pra outra atividade


public class FilaAtendimento {
    // Classe interna para representar um nó da lista
    class No {
        String id;
        String nome;
        String motivo;
        No proximo; // Referência para o próximo nó

        // Construtor do nó
        No(String id,String nome,String motivo) {
            this.id = id;
            this.nome = nome;
            this.motivo = motivo;
            this.proximo = null;
        }
    }

    No inicio = null; // aponta pro inicio
    No fim = null; // aponta pro final
    // Método para inserir um elemento no final da lista
    public void insereFila(String id,String nome,String motivo) {
        No novoNo = new No( id, nome,motivo); // Cria um novo nó com o elemento fornecido
        System.out.println("Inserindo Atendimento Id:"+id+"-"+nome +"-"+ motivo);
        if (fim == null) {
            // Caso a lista esteja vazia, o início aponta para o novo nó
            inicio = novoNo; // inicio e fim são iguais no primeiro insert correto?
            fim = novoNo;
        } else {
            // Caso contrário, percorre a lista até o final
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }

    public void verificarFila(){
        if (inicio == null){
            System.out.println("Fila vazia.Nada pra remover");
            return; 
        }
    }

    // -------------------------------------------------------------------------------------
    // fazer este metodo de alguma maneira
    // -------------------------------------------------------------------------------------
    public void removerFila(){
        // fazer o metodo verificar null funcionar
        if (inicio == null) {
            System.out.println("Fila vazia. Nada para remover.");
            return;
        }

        // System.out.println("Removendo ID: " + id+" "+nome+" "+motivo);
        if (inicio == null){
            System.out.println("Filha Vazia");
        }
        inicio = inicio.proximo; // Agora o inicio é o proximo no depois do inicio
        if (inicio == null){
            fim = null; // quando zerar a fila tem que ferar o final pra n se perder
        }
    }


    // Método para exibir os elementos da lista (para teste)
    public void exibeFila() {
        No atual = inicio;
        System.out.println("Fila Atual: ");
        while (atual != null) {
            System.out.println("Id:"+atual.id+"-"+atual.nome +"-"+atual.motivo);
            atual = atual.proximo; // Move para o próximo nó
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();

        fila.exibeFila(); // 

        System.out.println("Rodando Fila");

        fila.insereFila("CLI001", "Maria Silva", "Dúvida sobre produto");
        fila.insereFila("CLI002", "João Souza", "Reclamação de serviço");
        fila.insereFila("CLI003", "Ana Costa", "Solicitação de reembolso");
        fila.insereFila("CLI004", "Pedro Alves", "Informações de entrega");
        fila.insereFila("CLI005", "Carla Dias", "Agendamento de visita");
        fila.insereFila("CLI006", "Lucas Martins", "Alteração de pedido");
        fila.insereFila("CLI007", "Patrícia Rocha", "Cancelamento de contrato");
        fila.insereFila("CLI008", "Rafael Lima", "Renovação de assinatura");
        fila.insereFila("CLI009", "Fernanda Gomes", "Suporte para instalação");
        fila.insereFila("CLI010", "Carlos Eduardo", "Pedido de orçamento");

        // Exibindo os elementos da lista
        fila.exibeFila(); // 
    }
}


