package trabalhoFinal;

import java.util.Locale;
import java.util.Scanner;
public class trabFinal {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Informe a quantidade de clientes: ");
		int quantidade=sc.nextInt();
		
		String [] nome=new String[quantidade];
		String [] telefone= new String[quantidade];
		int [] tipo = new int[quantidade];
		int [] minutos= new int  [quantidade];
		
		// parte 1 - Leitura dos dados do cliente
		
		int clientes=1;
		for (int i = 0; i < quantidade; i++) {
			sc.nextLine();
			System.out.println("");
			System.out.println("Dados do "+clientes+"o. cliente:");
			System.out.print("Nome: " );
			nome[i]=sc.nextLine();
			System.out.print("Telefone: ");
			telefone[i]=sc.next();
			System.out.print("Tipo: ");
			tipo[i]=sc.nextInt();
			System.out.print("Minutos: ");
			minutos[i]=sc.nextInt();
			clientes++;
		}
		
		// parte 2 - Leitura  do preço basico de cada tipo de compra
	
		double[] [] mat= new double [3][2];
		int type=0;
		System.out.println("");
		System.out.println("Informe o preco basico e excedente de cada tipo de conta:");
		
		for (int i = 0; i < 3; i++) {
			System.out.print("Tipo "+type+": ");
			type++;
			
			for (int j = 0; j < 2; j++) {
				
				mat[i][j]=sc.nextDouble();
				
			}
		
		}
		
		// parte 3 - Calculo do relatorio de clientes
				
		double []  valorConta=new double [quantidade];
		for (int i = 0; i < quantidade; i++) {
	
				
				if (tipo[i]==0 && minutos[i]<=90) {
					
					valorConta[i]=mat[0][0];
					
					
				}
				else if (tipo[i]==0 && minutos[i]>90) {
					valorConta[i]= (minutos[i] - 90)*mat[0][1] + mat[0][0];
				}
				
				else if (tipo[i]==1 && minutos[i]<=90) {
					valorConta[i]=mat[1][0];
				}
				
				else if (tipo[i]==1 && minutos[i]>90) {
					valorConta[i]= (minutos[i] - 90)*mat[1][1] + mat[1][0];
				}
				
				else if (tipo[i]==2 && minutos[i]<=90) {
					valorConta[i]=mat[2][0] ;
				}
				

				else if (tipo[i]==2 && minutos[i]>90) {
					valorConta[i]= (minutos[i] - 90)*mat[2][1] + mat[2][0];
				}
		}
		
		// parte 4 - calculo da receita total
		double receitaTotal=0;
		for (int i = 0; i < quantidade; i++) {
			receitaTotal+=valorConta[i];
			
		}
		
		// parte 5 - calculo da conta mais barata
		double contaMaisBarata=9999;
		String nomeBarato="";
		String telefoneBarato="";
		for (int i = 0; i < quantidade; i++) {
			
			if (valorConta[i]<contaMaisBarata) {
				
				contaMaisBarata=valorConta[i];
				nomeBarato=nome[i];
				telefoneBarato=telefone[i];
			}
			
		}
		// parte 6 - calculo da média de minutos consumidos por clientes de conta tipo 1.
		int mediaTipo1=0,contTipo1=0,media=0;
		for (int i = 0; i < quantidade; i++) {
			
			if (tipo[i]==1) {
				
				mediaTipo1+=minutos[i];
				contTipo1++;
				media=mediaTipo1/contTipo1;
			}
			
		}
		// parte 7 - Calculo da quantidade de clientes que consumiu acima de 120 minutos.
		int contMinutos=0;
		for (int i = 0; i < quantidade; i++) {
			
			if (minutos[i] >120) {
				contMinutos++;
				
			}
			
		}	
		// Parte 8 - Calculo da porcentagem de clientes tipo 2
		int contTipo2=0;
		double porcentagemTipo2=0;
		for (int i = 0; i < quantidade; i++) {
			if (tipo[i] == 2) {
				
				contTipo2++;
				porcentagemTipo2= (contTipo2*100)/quantidade;
				
			}
		}
		
		
		
		// parte 9 - menu de opções
		
		int opcao=0;
		do {
			System.out.println();
			System.out.println("MENU DE OPCOES:");
			System.out.println("1) Relatorio de clientes");	
			System.out.println("2) A receita total");		
			System.out.println("3) Conta foi mais barata");			
			System.out.println("4) Consumo medio de clientes tipo 1.");			
			System.out.println("5) Clientes que consumiram acima de 120 pulsos.");		
			System.out.println("6) A porcentagem de clientes tipo 2");		
			System.out.println("7) Sair");			
			System.out.print("Informe uma opcao: ");
			opcao=sc.nextInt();
			System.out.println();
			
			// opção 1
			if (opcao==1) {
				
				
				for (int i = 0; i < quantidade; i++) {
					System.out.print(nome[i]+", "+telefone[i]+", Tipo " + tipo[i]+", Minutos: " + minutos[i] +", ");
					System.out.printf("Conta = R$ %.2f%n", valorConta[i]);
				}
				
			}
			// opção 2
			else if (opcao==2) {
				
					System.out.printf("A receita total = R$ %.2f%n" ,receitaTotal);
				
			
			}
			// opção 3
			else if (opcao==3) {
				System.out.println("Conta mais barata foi de: "+nomeBarato + ", telefone: " +telefoneBarato);
			}
			
			// opção 4
			else if (opcao==4) {
				System.out.println("O consumo medio de clientes tipo 1 é de: "+media+" Minutos" );
			}
			
			// opção 5
			else if (opcao==5) {
				System.out.println("A quantidade de clientes que consumiu acima de 120 minutos foi de: "+contMinutos + " Clientes");
			}
			// opção 6
			else if (opcao==6) {
				System.out.printf("A porcentagem de clientes tipo 2 é de: %.1f%% %n", porcentagemTipo2);
			}
			
		} while (opcao!=7);
		
		// opção 7
		System.out.println("FIM DO PROGRAMA!");
		sc.close();
		
	}

}
