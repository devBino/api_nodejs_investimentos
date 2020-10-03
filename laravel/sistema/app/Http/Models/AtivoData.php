<?php
namespace App\Http\Models;

use App\Http\Contracts\ApiRestCrud;

/**
 * @author Fernando Bino
 * @see Classe deve extenter a ModelData para estrategicamente preparar os parametros para chamada da Api
 * o metodo setParams() deve ser executado antes de chamar qualquer outro metodo da classe mae ModelData
*/
class AtivoData extends ModelData{

    protected static $url       = "http://localhost:3000/ativos";
    protected static $arrCampos = ['id'=>'id','cpNomeAtivo'=>'nmAtivo','cpValor'=>'vlAtivo','cpTipo'=>'cdTipo'];

    public static function setParams(){
        parent::$url        = self::$url;
        parent::$arrCampos  = self::$arrCampos;
    }    

}