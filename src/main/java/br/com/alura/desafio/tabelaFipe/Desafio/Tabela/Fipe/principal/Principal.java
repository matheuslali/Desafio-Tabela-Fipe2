package br.com.alura.desafio.tabelaFipe.Desafio.Tabela.Fipe.principal;

import br.com.alura.desafio.tabelaFipe.Desafio.Tabela.Fipe.domain.model.TipoVeiculo;
import br.com.alura.desafio.tabelaFipe.Desafio.Tabela.Fipe.service.ApiService;
import br.com.alura.desafio.tabelaFipe.Desafio.Tabela.Fipe.service.ConvertDados;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ApiService apiService = new ApiService();
    private ConvertDados convertDados = new ConvertDados();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
        System.out.println("Digite o tipo de veiculo desejado: Carro, Moto ou Caminhão");
        var tipoVeiculo = leitura.nextLine().toLowerCase();
        try{
        if(tipoVeiculo.contains("car")){
            tipoVeiculo = "carros";
        } else if (tipoVeiculo.contains("mot")) {
            tipoVeiculo = "motos";
        }else if (tipoVeiculo.contains("cam")){
            tipoVeiculo = "caminhoes";
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex + " Tipo de veiculo invalido, por favor digite, Carro, Moto ou Caminhão");
        }

        var json = apiService.consume(ENDERECO + tipoVeiculo + "/marcas");
        var dadosTipoVeiculo = convertDados.obterLista(json, TipoVeiculo.class);

        dadosTipoVeiculo.stream().sorted(Comparator.comparing(TipoVeiculo::nome)).forEach(d -> System.out.println("("+ d.codigo() + ") - " + d.nome()));

//        System.out.println("Digite o codigo da marca que deseja: ");
//        var marcaEscolhida = leitura.nextInt();
//        leitura.nextLine();


        }


    }

