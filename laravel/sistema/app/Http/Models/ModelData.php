<?php
namespace App\Http\Models;

use App\Http\Contracts\ApiRestCrud;

/**
 * @see
 * Classe deve extender a Model e implementar a ApiRestCrud
 * ao extender a Model herda as operações de contato com Api
 * ao implementar a ApiRestCrud, define quais serão as operações
*/
class ModelData extends Model implements ApiRestCrud{

    protected static $url;
    protected static $arrCampos = [];
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