public class PilhaSolicitação {
    // ID da solicitação, descrição, data e hora)
    class No {
        int id;
        String descricao;
        float data;
        float hora;
        No proximo; // Referência para o próximo nó

        // Construtor do nó
        No(int id,String descricao,float data, float hora) {
            this.id = id;
            this.descricao = descricao;
            this.data = data;
            this.hora = hora;
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
    public void insereElemento(int id,String descricao,float data, float hora) {
        No novoNo = new No(id,descricao,data,hora); // Cria um novo nó com os dados

        if (topo == null) {
            // Caso a lista esteja vazia, o início aponta para o novo nó
            topo = novoNo;
        } else {
            // Caso contrário, percorre a lista até o final
            System.out.println("Inserindo solicitação Id:"+id+" as "+hora+" do dia "+data);
            No atual = topo;
            topo = novoNo;
            novoNo.proximo = atual;// Insere o novo nó no final da pilha
        }
    }

    // Atualizar esta função pra percorrer a pilha toda em busca de um ID pra remover este id (pelo menos foi oq entendi)
    public void removerPorId(int removerID) {
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
            System.out.println("Removendo ID: " + atual.proximo.id);
            atual.proximo = atual.proximo.proximo; // pula o nó com o ID
        }
    }
    

    // Método para exibir os elementos da lista (para teste)
    public void exibePilha() {
        No atual = topo;
        System.out.println("Pilha Atual: ");
        while (atual != null) {
            //System.out.print(atual.descricao + " ");
            System.out.println("Id:"+atual.id+" Descrição:"+atual.descricao+" Hora:"+atual.hora+" Data:"+atual.data);
            atual = atual.proximo; // Move para o próximo nó
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PilhaSolicitação pilha = new PilhaSolicitação();
        int contadorID = 0;

        System.out.println("RODANDO PILHA");

        // Inserindo elementos na lista
        pilha.insereElemento(contadorID + 1 ,"Teste1", 11.09f, 09.45f);
        contadorID += 1; // fazer esse contador melhor no Main
        pilha.insereElemento(contadorID + 1,"Teste2",09.11f,03f);

        
        // Exibindo os elementos da pilha
        pilha.exibePilha(); 
        pilha.removerPorId(2);
        pilha.removerPorId(3);
        pilha.exibePilha();
    }
}



