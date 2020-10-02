<?php
namespace App\Http\Repositories;

use App\Http\Repositories\ConsultaApi;
use Illuminate\Support\Facades\Redis;

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
            ConsultaApi::headers("content-type:application/json");
            ConsultaApi::setMetodo("GET");
            
            $response = ConsultaApi::consultar();

            return ['response'=>$response,'params'=>self::$params,'erro'=>false];
        }catch(Exception $e){
            return ['response'=>[],'erro'=>true];
        }
    }

    public static function getTokenRedis(){
        try{
            $dadosSessao    = session()->get('autenticado');
            $dadosRedis     = unserialize(Redis::get($dadosSessao['usuario']."_token"));
            
            return $dadosRedis['token'];
        }catch(Exception $e){
            return null;
        }
    }

}