package gerenciadordetarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeTarefas {

    private static ArrayList<Tarefa> lista = new ArrayList<Tarefa>();
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        boolean rodando = true;
        
        while(rodando){
            System.out.println("[1] Mostrar tarefas");
            System.out.println("[2] Mostrar tarefas concluidas");
            System.out.println("[3] Mostrar tarefas pendentes");
            System.out.println("[4] Adicionar tarefa");
            System.out.println("[5] Concluir tarefa");
            System.out.println("[6] Remover tarefa");
            System.out.println("[7] Sair");
            System.out.print("Selecione a opção desejada: ");
            
            String opcao = scanner.nextLine();
            
            switch (opcao){
                case "1":{
                    System.out.println("-----TAREFAS-----");
                    
                    if(lista.isEmpty()){
                        System.out.println("Lista de tarefas vazia");
                    }
                    for(int i=0; i < lista.size(); i++){
                        Tarefa tarefa = lista.get(i);
                        System.out.println("Tarefa " + (i + 1));
                        System.out.println("\tTitulo: " + tarefa.getTitulo());
                    }
                    break;
                }
                case "2":{
                    System.out.println("-----TAREFAS CONCLUIDAS-----");
                    
                    ArrayList<Tarefa> concluidas = new ArrayList<>();
                    
                    for(Tarefa tarefa: lista){
                        if(tarefa.isConcluida()){
                            concluidas.add(tarefa);
                        }
                    }
                    if(concluidas.isEmpty()){
                        System.out.println("Nenhuma tarefa concluida");
                    }
                    for (int i = 0; i < concluidas.size(); i++) {
                        Tarefa tarefa = concluidas.get(i);
                        System.out.println("Tarefa " + i);
                        System.out.println("\tTitulo: " + tarefa.getTitulo());
                        
                    }
                    break;
                }
                case "3":{
                    System.out.println("-----TAREFAS PENDENTES-----");
                    
                    ArrayList<Tarefa> pendentes = new ArrayList<>();
                    
                    for(Tarefa tarefa: lista){
                        if(!tarefa.isConcluida()){
                            pendentes.add(tarefa);
                        }
                    }
                    if(pendentes.isEmpty()){
                        System.out.println("Não existe tarefas para serem feitas");
                    }
                    for (int i = 0; i < pendentes.size(); i++) {
                        Tarefa tarefa = pendentes.get(i);
                        System.out.println("Tarefa " + i);
                        System.out.println("\tTitulo: " + tarefa.getTitulo());
                        
                    }
                    break;
                }
                case "4":{
                    System.out.println("-----NOVA TAREFA-----");
                    
                    System.out.println("Digite o titulo: ");
                    String titulo = scanner.nextLine();
                    
                    lista.add(new Tarefa(titulo));
                    System.out.println("Tarefa adicionada");
                    break;
                }
                case "5":{
                    System.out.println("-----CONCLUIR TAREFA-----");
                    ArrayList<Tarefa> pendente = new ArrayList<>();
                    
                    for(Tarefa tarefa : lista){
                        if (!tarefa.isConcluida()) {
                            pendente.add(tarefa);                            
                        }
                    }
                    if(pendente.isEmpty()){
                        System.out.println("Lista de tarefas vazia");
                    }
                    System.out.println("Escolha a tarefa para ser concluida: ");
                    for (int i = 0; i < pendente.size(); i++) {
                        System.out.println("[" + i + "]" + lista.get(i).getTitulo());                        
                    }
                    System.out.println("Digite o numero da tarefa para concluir: ");
                    int numero = Integer.parseInt(scanner.nextLine());
                    scanner.nextLine();
                    
                    if (numero >= 0 && numero < pendente.size()) {
                        Tarefa tarefaConcluida = pendente.get(numero);
                        tarefaConcluida.setConcluida(true);
                        System.out.println("Tarefa concluida!");
                    }
                    else{
                        System.out.println("Numero da tarefa invalido");
                    }
                    break;
                }
                case "6":{
                    System.out.println("-----REMOVER TAREFA-----");
                    if (lista.isEmpty()) {
                        System.out.println("Lista de tarefas vazia");
                    }
                    else{
                        System.out.println("Tarefas:");
                        
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println("[" + i + "]" + lista.get(i).getTitulo()); 
                        }
                        System.out.println("Digite o numero da tarefa para remover: ");
                        int numero = Integer.parseInt(scanner.nextLine());
                        if (numero >= 0 && numero < lista.size()) {
                            lista.remove(numero);
                            System.out.println("Tarefa removida!");
                        }
                        else{
                            System.out.println("Numero da tarefa invalido");
                        }
                    }
                    break;
                }
                case "7":{
                    rodando = false;
                    System.out.println("Programa encerrado!");
                    break;
                }
                default:{
                    System.out.println("Opcao invalida!");
                    break;
                }
            }           
            
        }
                
    }
    
}
