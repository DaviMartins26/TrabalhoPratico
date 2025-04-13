public class PilhaSolicitacao {
    // ID da solicitação, descrição, data e hora)
    class No {
        String id;
        String descricao;
        String dataHora;
        No proximo; // Referência para o próximo nó

        // Construtor do nó
        No(String id,String descricao,String dataHora) {
            this.id = id;
            this.descricao = descricao;
            this.dataHora = dataHora;
            this.proximo = null;
        }
    }

    No topo = null; // Referência para o primeiro nó da lista


    // Metodo para verificar se a Pilha esta vazia
    public void verificarVazio() {
        if (topo == null) {
            System.out.println("Pilha Vazia");
        } else {
            System.out.println("Pilha com elementos");
        }
    }
    

    // Método para inserir um elemento no final da lista
    public void insereSolicitacao(String id,String descricao,String dataHora) {
        No novoNo = new No(id,descricao,dataHora); // Cria um novo nó com os dados

        if (topo == null) {
            // Caso a lista esteja vazia, o início aponta para o novo nó
            topo = novoNo;
        } else {
            // Caso contrário, percorre a lista até o final
            System.out.println("Inserindo solicitação Id:"+id+":"+descricao +" "+ dataHora);
            No atual = topo;
            topo = novoNo;
            novoNo.proximo = atual;// Insere o novo nó no final da pilha
        }
    }

    // Atualizar esta função pra percorrer a pilha toda em busca de um ID pra remover este id (pelo menos foi oq entendi)
    public void removerPorId(String removerID) {
        // não consegui chamar o metodo verficarVazio, java fica reclamando
        if (topo == null) {
            System.out.println("Pilha vazia. Nada para remover.");
            return;
        }
        // Caso o ID esteja no topo
        if (topo.id == removerID) {
            System.out.println("Removendo o ID no topo: " + topo.id);
            topo = topo.proximo;
            return;
        }
    
        // Caso o ID não esteja no topo
        No atual = topo;
        while (atual.proximo != null && atual.proximo.id != removerID) {
            atual = atual.proximo;
        }
    
        if (atual.proximo == null) {
            System.out.println("ID não encontrado na pilha.");
        } else {
            System.out.println("Removendo ID: " + atual.proximo.id+" "+atual.proximo.descricao+" "+atual.proximo.dataHora);
            atual.proximo = atual.proximo.proximo; // pula o nó com o ID
        }
    }
    

    // Método para exibir os elementos da lista (para teste)
    public void exibePilha() {
        No atual = topo;
        System.out.println("Pilha Atual: ");
        while (atual != null) {
            System.out.println("Id:"+atual.id +" "+atual.descricao+" "+atual.dataHora);
            atual = atual.proximo; // Move para o próximo nó
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PilhaSolicitacao pilha = new PilhaSolicitacao();
  
        System.out.println("RODANDO PILHA");

        // Inserindo elementos na lista
        // se for fazer manual a inserção, vamos precisar pensar em uma logica pra controlar esses REQ
        //int reg = 001;
        //System.out.println(reg);
        //System.out.println(reg+1);
        pilha.insereSolicitacao("REQ001", "Instalação de software", "2024-08-20 10:30");
        pilha.insereSolicitacao("REQ002", "Manutenção preventiva", "2024-08-20 11:00");
        pilha.insereSolicitacao("REQ003", "Atualização de sistema", "2024-08-20 11:30");
        pilha.insereSolicitacao("REQ004", "Suporte técnico", "2024-08-20 12:00");
        pilha.insereSolicitacao("REQ005", "Troca de equipamento", "2024-08-20 12:30");
        pilha.insereSolicitacao("REQ006", "Consulta de garantia", "2024-08-20 13:00");
        pilha.insereSolicitacao("REQ007", "Reparo de impressora", "2024-08-20 13:30");
        pilha.insereSolicitacao("REQ008", "Configuração de rede", "2024-08-20 14:00");
        pilha.insereSolicitacao("REQ009", "Restauração de dados", "2024-08-20 14:30");
        pilha.insereSolicitacao("REQ010", "Consulta técnica", "2024-08-20 15:00");

     
        
        // Exibindo os elementos da pilha
        pilha.exibePilha(); 
        pilha.removerPorId("REQ003");
        pilha.removerPorId("REQ200"); // informando REQ INEXISTENTE
        pilha.exibePilha();
    }
}




