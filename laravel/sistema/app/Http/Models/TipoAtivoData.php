<?php
namespace App\Http\Models;

/**
 * @author Fernando Bino
 * @see Classe deve extenter a ModelData para estrategicamente preparar os parametros para chamada da Api
 * o metodo setParams() deve ser executado antes de chamar qualquer outro metodo da classe mae ModelData
*/
class TipoAtivoData extends ModelData{

    protected static $url       = "http://localhost:3000/tipoAtivos";
    protected static $arrCampos = ['cpNomeTipo'=>'nmTipo','id'=>'id'];

    public static function setParams(){
        parent::$url        = self::$url;
        parent::$arrCampos  = self::$arrCampos;
    }

}