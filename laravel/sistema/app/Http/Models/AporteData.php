<?php
namespace App\Http\Models;

use App\Http\Contracts\ApiRestCrud;

/**
 * @author Fernando Bino
 * @see Classe deve extenter a ModelData para estrategicamente preparar os parametros para chamada da Api
 * o metodo setParams() deve ser executado antes de chamar qualquer outro metodo da classe mae ModelData
*/
class AporteData extends ModelData{

    protected static $url       = "http://localhost:3000/aportes";
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
        parent::$url        = self::$url;
        parent::$arrCampos  = self::$arrCampos;
    }    

}