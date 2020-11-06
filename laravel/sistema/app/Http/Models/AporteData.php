<?php
namespace App\Http\Models;

use App\Http\Contracts\ApiRestCrud;
use Illuminate\Support\Facades\Redis;

/**
 * @author Fernando Bino
 * @see Classe deve extenter a ModelData para estrategicamente preparar os parametros para chamada da Api
 * o metodo setParams() deve ser executado antes de chamar qualquer outro metodo da classe mae ModelData
*/
class AporteData extends ModelData{

    protected static $recurso   = "aportes";
    protected static $arrCampos = [
        'id'=>'id',
        'cpAtivo'=>'cdAtivo',
        'cpValor'=>'vlAporte',
        'cpQtde'=>'qtde',
        'cpSubTotal'=>'subTotal',
        'cpData'=>'dtAporte',
        'cpTaxaRetorno'=>'taxaRetorno'
    ];

    public static function setParams(){
        parent::$url        = Redis::get('URL_MAIN') . self::$recurso . "/";
        parent::$arrCampos  = self::$arrCampos;
    }    

}