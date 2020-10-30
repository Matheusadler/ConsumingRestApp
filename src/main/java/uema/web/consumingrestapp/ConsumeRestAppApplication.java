package uema.web.consumingrestapp;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import uema.web.consumingrestapp.entity.NaturezaCargo;
import uema.web.consumingrestapp.entity.Servidores;
import uema.web.consumingrestapp.entity.Unidade;
import uema.web.consumingrestapp.repository.NaturezaCargoRepository;
import uema.web.consumingrestapp.repository.ServidoresRepository;
import uema.web.consumingrestapp.repository.UnidadeRepository;

import java.net.URL;
import java.util.List;


@SpringBootApplication
public class ConsumeRestAppApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumeRestAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumeRestAppApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, ServidoresRepository servidoresRepository, NaturezaCargoRepository naturezaCargoRepository, UnidadeRepository unidadeRepository) throws Exception {

        return args -> {

            // ============== ENTES ==============
			/*Entes[] entes  = restTemplate.getForObject("http://app.tce.ma.gov.br:8889/tce/api/entes", Entes[].class);

			for (Entes ente : entes) {
				entesRepository.save(new Entes(ente.getEnteId(), ente.getNome(), ente.getOrgaos()));
			}*/

            //URL jsonUrl = new URL("http://app.tce.ma.gov.br:8889/tce/api/entes");
            //ObjectMapper mapper = new ObjectMapper();
            //Entes[] entes = mapper.readValue(jsonUrl, Entes[].class);


            // ============== SERVIDORES ==============
            URL jsonUrl = new URL("http://app.tce.ma.gov.br:80/tce/api/servidores/2100055");

            final JsonFactory factory = new JsonFactory();
            final JsonParser parser = factory.createParser(jsonUrl);

            // avança o stream até chegar no array
            while (parser.nextToken() != JsonToken.START_ARRAY) {
                parser.nextToken();
            }

            final ObjectMapper objectMapper = new ObjectMapper();

            final List<Servidores> servidores = objectMapper.readValue(parser, new TypeReference<List<Servidores>>() {});

            for (Servidores servidor : servidores) {
                ObjectMapper mapper = new ObjectMapper();
                NaturezaCargo naturezaCargo = mapper.readValue(servidor.getNaturezaCargo().toString(), NaturezaCargo.class);
                Unidade unidade = mapper.readValue(servidor.getUnidade().toString(), Unidade.class);


                servidoresRepository.save(new Servidores(servidor.getServidorId(), servidor.getNome(), servidor.getCargo(),  servidor.getCnpj(),
                        servidor.getCpf(), servidor.getMes(), servidor.getAno(), servidor.getValorBruto(),
                        naturezaCargo, unidade,
                        servidor.getAcumulos(), servidor.getValorBrutoTotal(), servidor.getNomeUnidadeLotacao()));
            }


            // ============== FORNECEDORES ==============
            //ResponseEntity<Fornecedores[]> fornecedores = restTemplate.getForEntity("http://app.tce.ma.gov.br:8889/tce/api/fornecedores?filtro=20005", Fornecedores[].class);
            //ObjectMapper mapper = new ObjectMapper();
//
            //for(Fornecedores fornecedor : fornecedores.getBody()){
            //	//System.out.println(fornecedor.getNome());
            //	Socios socio = mapper.readValue(fornecedor.getSocios().toString(), Socios.class);
            //	fornecedoresRepository.save(new Fornecedores(fornecedor.getFornecedorId(), fornecedor.getNome(), fornecedor.getCpfCnpj(), socio.getId()));
            //}

            // ============== CONTRATOS ==============
            //URL jsonUrl = new URL("http://app.tce.ma.gov.br:80/tce/api/contratos");
//
            //final JsonFactory factory = new JsonFactory();
            //final JsonParser parser = factory.createParser(jsonUrl);
//
            //// avança o stream até chegar no array
            //while (parser.nextToken() != JsonToken.START_ARRAY) {
            //    parser.nextToken();
            //}
//
            //final ObjectMapper objectMapper = new ObjectMapper();
//
            //final List<Contratos> contratos = objectMapper.readValue(parser, new TypeReference<List<Contratos>>() {});
//
            //for (Contratos contrato : contratos) {
            //
//
            //	//System.out.println(contrato.getUnidade());
            //	Fornecedores fornecedor = objectMapper.readValue(contrato.getFornecedor().toString(), Fornecedores.class);
            //	Unidade unidade = objectMapper.readValue(contrato.getUnidade().toString(), Unidade.class);
            //	System.out.println(unidade.getNome());
//
            //}
        };
    }
}
