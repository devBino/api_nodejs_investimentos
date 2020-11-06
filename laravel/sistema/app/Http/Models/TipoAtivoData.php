<?php
namespace App\Http\Models;

use Illuminate\Support\Facades\Redis;

/**
 * @author Fernando Bino
 * @see Classe deve extenter a ModelData para estrategicamente preparar os parametros para chamada da Api
 * o metodo setParams() deve ser executado antes de chamar qualquer outro metodo da classe mae ModelData
*/
class TipoAtivoData extends ModelData{

    protected static $recurso       = "tipoAtivos";
    protected static $arrCampos = ['cpNomeTipo'=>'nmTipo','id'=>'id'];

    public static function setParams(){
        parent::$url        = Redis::get('URL_MAIN') . self::$recurso . "/";
        parent::$arrCampos  = self::$arrCampos;
    }

}