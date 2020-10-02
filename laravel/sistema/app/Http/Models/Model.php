<?php
namespace App\Http\Models;

use App\Http\Repositories\ConsultaApi;
use App\Http\Repositories\LoginRepositorie;

/**
 * @author Fernando Bino
 * @see Classe responsável por intermediar as requisições para a Api NodeJs
 * prepara os parametros, e aciona App\Http\Repositories\ConsultaApi para consultar Api
 * 
 * Os metodos contidos aqui só devem ser chamados partindo das classes filhas
*/
class Model{

    protected static $url;
    protected static $params;
    protected static $metodo;

    public static function makeParams($paramsRequest,$arrCampos){
        
        $return = [];

        $ignoreKeys = ['_token'];

        foreach($paramsRequest as $key => $val){
            if( !in_array($key, $ignoreKeys) ){
                if( isset($arrCampos[$key]) && !is_null($val) ){
                    $return[ $arrCampos[$key] ] = $val;
                }
            }
        }

        return $return;
    }

    public static function prepareExecuteApi($url=null,$params=null,$metodo=null){
        self::$url      = $url;
        self::$params   = $params;
        self::$metodo   = $metodo;
    }

    public static function execute(){
        try{
            
            ConsultaApi::headers('x-access-token:' . LoginRepositorie::getTokenRedis() );
            ConsultaApi::setUrl( self::$url );

            if( !is_null(self::$params) ){
                ConsultaApi::setParams( self::$params );
            }

            if( !is_null(self::$metodo) ){
                ConsultaApi::setMetodo( self::$metodo );
            }

            $response = ConsultaApi::consultar();

            $dataReturn = json_decode($response['response']);

            if(!isset($dataReturn->data)){
                return ['response'=>[],'erro'=>true];    
            }

            return ['response'=>$dataReturn->data,'erro'=>false];
        }catch(Exception $e){
            return ['response'=>[],'erro'=>true];
        }
    }


}