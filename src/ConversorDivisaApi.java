import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorDivisaApi {

    public Divisa convertirDivisas(String divisaObtener,
                                   String cambioDivisa,
                                   double valorDivisa){

        HttpClient client = HttpClient.newHttpClient();

        URI uriURL = URI.create("https://v6.exchangerate-api.com/v6/3a69b5edb8ddf6da29c3d943/pair/" + divisaObtener +"/"+ cambioDivisa +"/" + valorDivisa);
        HttpRequest request = HttpRequest.newBuilder().uri(uriURL).build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Gson().fromJson(response.body(), Divisa.class);
    }


}
