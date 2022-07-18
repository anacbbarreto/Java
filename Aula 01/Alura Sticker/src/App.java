import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {
       
         // fazer uma conexão HTTP e buscar os top 250 filmes
         String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
         URI endereco = URI.create(url);
         var client = HttpClient.newHttpClient();
         var request = HttpRequest.newBuilder(endereco).GET().build();
         final HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
         String body = response.body();
 
         // extrair só os dados que interessam (titulo, poster, classificação)
         var parser = new JsonParser();
         List<Map<String, String>> listaDeFilmes = parser.parse(body);
 
         // exibir e manipular os dados 
         for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("Filme: " + filme.get("title"));
             System.out.println("Imagem: " + filme.get("image"));
             System.out.println("Nota: " + filme.get("imDbRating"));
             System.out.println();
         }
     }
    }
