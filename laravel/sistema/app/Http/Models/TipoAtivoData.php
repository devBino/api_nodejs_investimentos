<?php
namespace App\Http\Models;

use App\Http\Contracts\ApiRestCrud;

/**
 * @author Fernando Bino
 * @see Classe deve extenter a Model para estrategicamente preparar os parametros para chamada da Api
 * Classe deve implementar ApiRestCrud, seguindo padrão previamente estabelecido
*/
class TipoAtivoData extends Model implements ApiRestCrud{

    protected static $url       = "http://localhost:3000/tipoAtivos";

    /**
     * $arrCampos => array onde as chaves são os campos vindos na requisição do front-end
     * e os valores das chaves são os campos que devem ir como parametros na chamada da Api
     * Rest NodeJs, o método makeParams() da classe Model (classe mãe) é responsável por
     * construir os parâmetros de acordo com o que veio do front-end, e prepará-los para
     * o backend
    */
    protected static $arrCampos = ['cpNomeTipo'=>'nmTipo','id'=>'id'];
    protected static $erro      = ['response'=>[],'erro'=>true];

    public static function listar(){
        try{

            self::prepareExecuteApi(self::$url);
            return self::execute();

        }catch(Exception $e){
            return self::$erro;
        }
    }

    public static function salvar($params){
        try{
            
            self::prepareExecuteApi(
                self::$url,
                self::makeParams($params,self::$arrCampos),
                "POST"
            );

            return self::execute();
            
        }catch(Exception $e){
            return self::$erro;
        }   
    }

    public static function alterar($params){
        try{
            
            self::prepareExecuteApi(
                self::$url,
                self::makeParams($params,self::$arrCampos),
                "PUT"
            );
            
            return self::execute();

        }catch(Exception $e){
            return self::$erro;
        }

    }

    public static function deletar($id){
        try{
            
            self::prepareExecuteApi(
                self::$url."/".$id,
                null,
                "DELETE"
            );
            
            return self::execute();

        }catch(Exception $e){
            return self::$erro;
        }
    }


}