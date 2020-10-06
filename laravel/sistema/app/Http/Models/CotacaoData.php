<?php
namespace App\Http\Models;

use App\Http\Contracts\ApiRestCrud;

/**
 * @author Fernando Bino
 * @see Classe deve extenter direto a Model, essa classe não necessita implementar ApiRestCrud,
 * devido acessar um recusto da API que retorna cotações dos ativos da B3
*/
class CotacaoData extends Model{

    protected static $url       = "http://localhost:3000/cotacao/";
    
    public static function consultarCotacao($ativo){
        $urlParam      = self::$url.$ativo;
        parent::prepareExecuteApi($urlParam);
        $dadosCotacao   = parent::execute();

        return $dadosCotacao;
    }
    

}