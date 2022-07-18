import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        final HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //inicio do programa
        System.out.println("\u001b[37m \u001b[44m Imersão Java - Alura \u001b[m");
        System.out.println("\u001b[37m \u001b[44m     Aula 01          \u001b[m");
        System.out.println();




        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //Menu principal
               Scanner scan = new Scanner (System.in);
             System.out.println("\u001b[37m \u001b[46m               Menu                 \u001b[m");
             System.out.print("\u001b[37m \u001b[46m  \u001b[m");
        System.out.print("Opção 1 - Ver os 250 filmes     ");
        System.out.print("\u001b[37m \u001b[46m \n\u001b[m");

        System.out.print("\u001b[37m \u001b[46m  \u001b[m");
        System.out.print("Opção 2 - Escolher filme por nota");
        System.out.print("\u001b[37m\u001b[46m \n\u001b[m");

        System.out.print("\u001b[37m \u001b[46m  \u001b[m");
        System.out.print("Opção 3 - Sair                  ");
        System.out.print("\u001b[37m \u001b[46m \n\u001b[m");

        System.out.println("\u001b[37m \u001b[46m                                    \u001b[m");
        System.out.println();
        System.out.print("Digite uma opção: ");
        int opcao = scan.nextInt();
     System.out.println(opcao);

     switch (opcao) {
        case 1:
            System.out.println("\nOpção todos os filmes");
               
         // exibir os filmes
         for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("rank: " + filme.get("rank"));
             System.out.println("Filme: " + filme.get("title"));
             System.out.println("Imagem: " + filme.get("image"));
             System.out.println("Nota: " + filme.get("imDbRating"));
             System.out.println();
         }

            break;

        case 2:
            System.out.println("\nOpção filmes por nota\n");
            System.out.print("Digite a nota: ");
            float notausuario = scan.nextFloat();
            
                for (Map<String,String> filme : listaDeFilmes) {
                    
                    //converte a nota de String para float
                    String Nota =  filme.get("imDbRating");
                    float valor = Float.parseFloat(Nota);
                
                    //compara a nota 
                    if( valor >= notausuario){
                    //traz os filmes dentro da nota
                     System.out.println("Filme: " + filme.get("title"));
                     System.out.println("Imagem: " + filme.get("image"));
                     System.out.println("Nota: " + filme.get("imDbRating"));
                     System.out.println();
                 }   

            }
                          
            break;
        

        case 3:
            System.out.print("\nAté logo!");
            scan.close();        
            break;
            
        default:
            System.out.print("\nOpção Inválida!");
            break;     
        }
    


       

              
         } 

     }
    