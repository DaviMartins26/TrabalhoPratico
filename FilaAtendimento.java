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
            
        }else{ System.out.println("Fila com Elementos");}
    }

    // -------------------------------------------------------------------------------------
    // Esse metodo de comparação pode quebrar, pq to comparando strings com ==
    // -------------------------------------------------------------------------------------
    public void removerFila(String removerID){
        // fazer o metodo verificar null funcionar
        verificarFila(); // aparentemete funciona

        // caso so haja um elemento a remover
        if (removerID == inicio.id){
            System.out.println("\"Removendo ID: \" + inicio.id + \" \" + inicio.nome + \" \" + inicio.motivo");
            inicio = inicio.proximo;
            if (inicio == null) fim = null; // faz a fila ficar null novamente 
            return;
        }

        No atual = inicio; // colocando isso aqui para de dar erro

        while (true) {
            // caso chega no fim e não achar
            if (atual.proximo == null){
                System.out.println("ID" + " " + removerID + " " + "não presente na Fila");
                return;
            }
            // procura o que for igual, e garante que o proximo não é null
            // pq se for null é o fim da fila
            if(atual.proximo.id == removerID && atual.proximo != null){
                System.out.println("Removendo ID: " + atual.proximo.id + " " + atual.proximo.nome + " " + atual.proximo.motivo);
                atual.proximo = atual.proximo.proximo; // faz o proximo ser o proximo do atual(isso pode acontecer infinitamente)
                if (atual.proximo == null) fim = atual; // assim o no é removido da fila
                return;
            }


            atual = atual.proximo; // manda o atual pro proximo caso não entre nos IF acima
        }
        
    }


    // Método para exibir os elementos da lista (para teste)
    public void exibeFila() {
        // fazer o metodo verificar null funcionar
        verificarFila(); // aparentemete funciona

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
        fila.removerFila("CLI007");
        fila.removerFila("CLI015"); // elemento não presente na Fila

        fila.exibeFila(); // 
    }
}