<?php

namespace App\Http\Repositories;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Redis;

class Permissao{

    public static function criar( Request $request, $params = [], $token ){
        
        try{
            //seta informações de sessão
            $dados = [];
            $dados['usuario']   = $params['usuario'];
            $dados['senha']     = $params['senha'];
            $dados['token']     = $token;
            $dados['permissao'] = "1";

            if( !$request->session()->has('autenticado') ){
                $request->session()->put('autenticado',$dados);
            }else{
                $request->session()->forget('autenticado');
                $request->session()->put('autenticado',$dados);
            }
            
            self::criarChavesSessionRedis($params,$dados);

            return true;
        }catch(Exception $e){
            return false;
        }

    }

    public static function destruir(){
        
        if( session()->has('autenticado') ){
            session()->forget('autenticado');
        }

    }

    public static function criarChavesSessionRedis( $params = [], $dados = [] ){
        //grava token no redis
        Redis::del( $params['usuario']."_token" );
        Redis::set( $params['usuario']."_token", serialize($dados));

        //define url servidor
        Redis::del('URL_MAIN');
        Redis::set('URL_MAIN','http://localhost:3000/');
    }


}