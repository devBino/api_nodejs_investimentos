<?php
namespace App\Http\Models;

use App\Http\Contracts\ApiRestCrud;
use Illuminate\Support\Facades\Redis;

/**
 * @author Fernando Bino
 * @see Classe deve extenter direto a Model, essa classe não necessita implementar ApiRestCrud,
 * devido acessar um recusto da API que retorna cotações dos ativos da B3
*/
class CotacaoData extends Model{

    protected static $recurso       = "cotacao";
    
    public static function consultarCotacao($ativo){

        $urlParam      = Redis::get('URL_MAIN') . self::$recurso . "/" . $ativo;
        parent::prepareExecuteApi($urlParam);
        $dadosCotacao   = parent::execute();

        return $dadosCotacao;
    }
    

}