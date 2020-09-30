<?php
namespace App\Http\Repositories;

use App\Http\Repositories\ConsultaApi;

class LoginRepositorie{
    
    private static $params;

    public static function setParams($params){
        self::$params = $params;

        if( isset(self::$params['_token']) ){
            unset(self::$params['_token']);
        }
        
        self::$params['senha'] = sha1(self::$params['senha']);
    }

    public static function getToken(){

        try{
            $strParamsUrl = implode("/",self::$params);
            
            ConsultaApi::setUrl("http://localhost:3000/autenticacao/".$strParamsUrl);
            ConsultaApi::setMetodo("GET");
            
            $response = ConsultaApi::consultar();

            return ['response'=>$response,'params'=>self::$params,'success'=>true];
        }catch(Exception $e){
            return ['response'=>[],'success'=>true];
        }
    }

}