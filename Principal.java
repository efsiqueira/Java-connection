import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        
        // Criação dos objetos das classes
        /*Padaria padariaUm = new Padaria (1, "Padaria Alfa", "01/01/1995", 1, "89320-452", "Rua José Manoel Voluz", "772", "Sítio Cercado", "Curitiba", "07:30 às 19:00");
        Padaria padariaDois = new Padaria (2, "Padaria Anita", "10/10/2017", 2, "89478-791", "Rua Anita", "222", "Anita Garibaldi", "Joinville", "08:00 às 18:00");
        Padaria padariaTres = new Padaria (3, "Padaria Helena", "02/07/2004", 3, "89521-785", "Rua Monsenhor Gercino", "1000", "João Costa", "Joinville", "07:30 às 19:30");

        Mercado mercadoUm = new Mercado(1, "Mercado Del Piero", "05/04/1995", 4, "89421-542", "Rua Getulio Vargas", "144", "Anita Garibaldi", "Joinville", "Costela de porco, Alcatra e Linguiça toscana");
        Mercado mercadoDois = new Mercado(2, "Mercado da Vila", "08/11/2017", 5, "89325-915", "Rua Paraíba", "752", "Anita Garibaldi", "Joinville", "Leite Parmalat, Achocolatado Nescau e Biscoito Negresco");
        Mercado mercadoTres = new Mercado(3, "Mercado Bosque", "17/02/2011", 6, "89142-126", "Rua Albano Schmidt", "815", "Boa Vista", "Joinville", "Fralda Pampers, Lenço Umidecido e Leite Nan");

        Chef chefUm = new Chef (1, "Érick Jacquin", "84562139805", "09/12/1964", "Pão de queijo");
        Chef chefDois = new Chef (2, "Henrique Fogaça", "14536789564", "11/04/1974", "Bolinho de carne");
        Chef chefTres = new Chef (3, "Paola Carosella", "25893641781", "30/10/1972", "Pastel assado");

        Cliente clienteUm = new Cliente(1, "Eduardo Siqueira", "19535785246", "05/01/2000", "(47) 9 9999-9999");
        Cliente clienteDois = new Cliente(2, "Antonio Pereira", "75412359752", "13/08/1994", "(47) 9 9970-7070");
        Cliente clienteTres = new Cliente(3, "Marcos Costa", "45168925934", "31/10/1997", "(41) 9 9891-1234");

        Receita receitaUm = new Receita(1, "Sonho", "Junte os ingredientes, acrescente farinha, adicione ovos e misture, divida a massa em bolinhas, leve a geladeira, asse por 20 mintuos", 6, 25.00, chefUm);
        Receita receitaDois = new Receita(2, "Bolo de aipim", "Bata os ingredientes no liquidificador, despeje numa tigela e adicione fermento, misture até a massa ficar homogenea, asse por 40 minutos", 4, 30.00, chefUm);
        Receita receitaTres = new Receita(3, "Pão de queijo", "Bata os ingredientes no liquidificador, acrescente queijo a gosto, bata até ficar homogeneo, despeje numa forma e leve para assar, asse por 40 minutos", 5, 4.00, chefUm);
        Receita receitaQuatro = new Receita(4, "Salgadinho", "Misture os ingredientes numa tigela, mexa bem, leve na geladeira por 30 minutos, estique a massa e faça bolinhas, frite em fogo médio", 5, 5.50, chefDois);
        Receita receitaCinco = new Receita(5, "Bolo de milho", "Bata o milho por 1 minuto, acrescente margarina e leite, bata até a massa ficar homogenea, adicione fubá e fermento, leve para assar por 40 minutos, desenforme", 6, 30.00, chefDois);
        Receita receitaSeis = new Receita(6, "Bolinho de carne", "Tempere a carne, forme bolinhas, frite por 20 minutos", 3, 7.00, chefDois);
        Receita receitaSete = new Receita(7, "Pão de forma", "Dissolva o fermento no açucar e acrescente sal, acrescente farinha, deixe a massa descansar por 1h, coloque na forma, leve para assar por 30 minutos", 5, 10.00, chefTres);
        Receita receitaOito = new Receita(8, "Pastel frito", "Adicione os ingredientes numa bacia, amasse bem até que a massa fique consistente, deixe descansar por 15 minutos, modele os pastéis, frite", 5, 6.00, chefTres);
        Receita receitaNove = new Receita(9, "Pastel assado", "Misture os ingredientes, mexa até a massa ficar homogenea, rechear os pastéis, pincelar os pastéis com gema, levar ao forno para assar", 5, 6.00, chefTres);
        Receita receitaDez = new Receita(10, "Bolinho de chuva", "Misture os ingredientes, mexa até a massa ficar homogenea, coloque para fritar, retire e coloque açúcar por cima", 4, 6.00, chefDois);
        Receita receitaOnze = new Receita(11, "Bolo de abacaxi", "Misture os ingredientes, mexa até a massa ficar homogenea, recheie, enfeite, coloque a cobertura", 5, 35.00, chefUm);
        Receita receitaDoze = new Receita(12, "Kibe", "Misture os ingredientes, mexa até a massa ficar homogenea, coloque para fritar, retire após 3 minutos", 4, 6.00, chefDois);
        Receita receitaTreze = new Receita(13, "Torta alemã", "Misture os ingredientes, mexa até a massa ficar homogenea, monte a torta, coloque a cobertura", 4, 20.00, chefTres);
        Receita receitaQuatorze = new Receita(14, "Torta salgada", "Misture os ingredientes, mexa até a massa ficar homogenea, recheie, coloque para assar", 5, 20.00, chefUm);
        Receita receitaQuinze = new Receita(15, "Bananada", "Misture os ingredientes, mexa até a massa ficar homogenea, recheie com banana, coloque para fritar, retire e coloque açúcar por cima", 5, 5.25, chefDois);
        Receita receitaDezesseis = new Receita(16, "Risoles", "Misture os ingredientes, coloque o recheio, coloque para fritar, retire após 3 minutos", 4, 7.00, chefTres);
        Receita receitaDezessete = new Receita(17, "Coxinha", "Misture os ingredientes, coloque o recheio, coloque para fritar, retire após 3 minutos", 4, 7.00, chefUm);
        Receita receitaDezoito = new Receita(18, "Croassonho", "Misture os ingredientes, mexa até a massa ficar homogenea, coloque o recheio, asse até dourar", 4, 6.00, chefDois);
        Receita receitaDezenove = new Receita(19, "Chineque", "Misture os ingredientes, mexa até a massa ficar homogenea, coloque a farofa, asse até dourar", 4, 3.25, chefTres);
        Receita receitaVinte = new Receita(20, "Cuca", "Misture os ingredientes, mexa até a massa ficar homogenea, recheie, asse até dourar", 4, 15.00, chefUm);

        // Atribuindo as receitas aos respectivos clientes, chefs, padarias e mercados.
        clienteUm.setReceitas(receitaUm);
        clienteUm.setReceitas(receitaDois);
        clienteUm.setReceitas(receitaTres);
        clienteUm.setReceitas(receitaQuatro);
        clienteUm.setReceitas(receitaOnze);
        clienteUm.setReceitas(receitaDoze);
        clienteUm.setReceitas(receitaTreze);
        clienteUm.setReceitas(receitaQuatorze);
        clienteUm.setReceitas(receitaQuinze);
        clienteUm.setReceitas(receitaVinte);
        clienteDois.setReceitas(receitaCinco);
        clienteDois.setReceitas(receitaSeis);
        clienteDois.setReceitas(receitaSete);
        clienteDois.setReceitas(receitaQuinze);
        clienteDois.setReceitas(receitaDezesseis);
        clienteDois.setReceitas(receitaDezessete);
        clienteDois.setReceitas(receitaUm);
        clienteDois.setReceitas(receitaNove);
        clienteDois.setReceitas(receitaDez);
        clienteDois.setReceitas(receitaTreze);
        clienteTres.setReceitas(receitaOito);
        clienteTres.setReceitas(receitaNove);
        clienteTres.setReceitas(receitaDez);
        clienteTres.setReceitas(receitaDezoito);
        clienteTres.setReceitas(receitaDezenove);
        clienteTres.setReceitas(receitaVinte);
        clienteTres.setReceitas(receitaCinco);
        clienteTres.setReceitas(receitaTres);
        clienteTres.setReceitas(receitaQuatorze);
        clienteTres.setReceitas(receitaOnze);

        padariaUm.setReceitas(receitaUm);
        padariaUm.setReceitas(receitaDois);
        padariaUm.setReceitas(receitaTres);
        padariaUm.setReceitas(receitaQuatro);
        padariaDois.setReceitas(receitaCinco);
        padariaDois.setReceitas(receitaSeis);
        padariaDois.setReceitas(receitaSete);
        padariaTres.setReceitas(receitaOito);
        padariaTres.setReceitas(receitaNove);
        padariaTres.setReceitas(receitaDez);

        mercadoUm.setReceitas(receitaUm);
        mercadoUm.setReceitas(receitaDois);
        mercadoUm.setReceitas(receitaTres);
        mercadoUm.setReceitas(receitaQuatro);
        mercadoDois.setReceitas(receitaCinco);
        mercadoDois.setReceitas(receitaSeis);
        mercadoDois.setReceitas(receitaSete);
        mercadoTres.setReceitas(receitaOito);
        mercadoTres.setReceitas(receitaNove);
        mercadoTres.setReceitas(receitaDez);

        // Printando as entidades.
        System.out.println();
        System.out.println("==================== CLIENTES ====================");
        System.out.println(clienteUm);
        System.out.println();
        System.out.println(clienteDois);
        System.out.println();
        System.out.println(clienteTres);
        

        System.out.println();
        System.out.println("==================== CHEFS ====================");
        System.out.println(chefUm);
        System.out.println();
        System.out.println(chefDois);
        System.out.println();
        System.out.println(chefTres);

        System.out.println();
        System.out.println("==================== PADARIAS ====================");
        System.out.println(padariaUm);
        System.out.println();
        System.out.println(padariaDois);
        System.out.println();
        System.out.println(padariaTres);

        System.out.println();
        System.out.println("==================== MERCADOS ====================");
        System.out.println(mercadoUm);
        System.out.println();
        System.out.println(mercadoDois);
        System.out.println();
        System.out.println(mercadoTres);*/
        int menu = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\n==== MENU ====\n");
            System.out.println("1. Select Chefs");
            System.out.println("2. Insert Chefs");
            System.out.println("3. Update Chefs");
            System.out.println("4. Delete Chefs");
            System.out.println("\nDigite a opção desejada: ");
            try {
                menu = scan.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            switch (menu) {
                case 1:
                    try {
                        Chef.SelectChef();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 2:
                    try {
                        Chef.InsertChef(
                            Chef.getChefInsert()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        Chef.updateChefSt(
                            Chef.getChefUpdate()
                        );
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        Chef.deleteChefSt(
                            Chef.getChef()
                        );
                    } catch (Exception e) {
                        //TODO: handle exception
                    }
                    break;

                default:
                    break;
            }

        } while (menu != 0);
        scan.close();
    }
}
