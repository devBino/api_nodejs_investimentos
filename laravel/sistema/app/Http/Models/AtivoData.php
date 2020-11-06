<?php
namespace App\Http\Models;

use App\Http\Contracts\ApiRestCrud;
use Illuminate\Support\Facades\Redis;
/**
 * @author Fernando Bino
 * @see Classe deve extenter a ModelData para estrategicamente preparar os parametros para chamada da Api
 * o metodo setParams() deve ser executado antes de chamar qualquer outro metodo da classe mae ModelData
*/
class AtivoData extends ModelData{

    protected static $recurso   = "ativos";
    protected static $arrCampos = [
        'id'=>'id',
        'cpNomeAtivo'=>'nmAtivo',
        'cpValor'=>'vlAtivo',
        'cpTipo'=>'cdTipo',
        'cpTaxaAdministracao'=>'taxaAdmin',
        'cpTaxaCustodia'=>'taxaCustodia',
        'cpTaxaPerformace'=>'taxaPerformace'
    ];

    public static function setParams(){
        parent::$url        = Redis::get('URL_MAIN') . self::$recurso . "/";
        parent::$arrCampos  = self::$arrCampos;
    }    

}