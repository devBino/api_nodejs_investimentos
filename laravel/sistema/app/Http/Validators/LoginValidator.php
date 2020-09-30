<?php
namespace App\Http\Validators;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Redis;
use App\Http\Repositories\Permissao;

class LoginValidator{

    public static function validarLogin(Request $request, $response){
        try{
            
            //caso erro ao buscar na API
            if( $response['erro'] ){
                return ['success'=>false,'message'=>'Erro ao buscar token na API...'];
            }

            if( !$response['response']['success'] ){
                return ['success'=>false,'message'=>'Erro ao buscar token na API...'];
            }

            $arrResponse = json_decode($response['response']['response']);

            //caso credenciais invalidas
            if( !$arrResponse->auth ){
                return ['success'=>false,'message'=>'Não foi possível obter o token com os dados informados, verifica as credencias de acesso...'];
            }

            Permissao::criar($request,$response['params'],$arrResponse->token);
            
            return true;

        }catch(Exception $e){
            return false;
        }
    }

}