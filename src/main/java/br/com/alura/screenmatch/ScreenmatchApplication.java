package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();
		var endereco = "https://www.omdbapi.com/?t=gilmore+girls&apikey=78f566ba";
		var json = consumoAPI.obterDados(endereco);

		ConverteDados conversor = new ConverteDados();
		DadosSerie serie = conversor.obterDados(json,DadosSerie.class);
		System.out.println(serie);

		endereco = "https://www.omdbapi.com/?t=gilmore+girls&Season=1&Episode=2&apikey=78f566ba";
		json = consumoAPI.obterDados(endereco);
		DadosEpisodio episodio = conversor.obterDados(json,DadosEpisodio.class);
		System.out.println(episodio);
	}
}
